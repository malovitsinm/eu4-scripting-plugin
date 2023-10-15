package com.malovtisinm.eu4script.language.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import com.malovtisinm.eu4script.data.AttributeValueType;
import com.malovtisinm.eu4script.data.repo.BuildingAttributeSpecRepository;
import com.malovtisinm.eu4script.language.psi.building.Eu4BuildingScriptFile;
import com.malovtisinm.eu4script.language.psi.core.Eu4ScriptAttribute;
import com.malovtisinm.eu4script.language.psi.core.Eu4ScriptIdentifier;
import com.malovtisinm.eu4script.language.psi.core.Eu4ScriptStatement;
import com.malovtisinm.eu4script.language.psi.core.Eu4ScriptValue;
import com.malovtisinm.eu4script.language.validator.PropertyNameValidator;
import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class BuildingAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof Eu4ScriptAttribute) {
            if (element.getContainingFile() instanceof Eu4BuildingScriptFile && element.getParent() instanceof Eu4ScriptStatement) {
                Eu4ScriptIdentifier id = ((Eu4ScriptAttribute) element).getIdentifier();
                Optional.ofNullable(((Eu4ScriptAttribute) element).getValue().getBlock()).ifPresent(
                        block -> {
                            List<Eu4ScriptAttribute> attributeList = block.getAttributeList();
                            List<Eu4ScriptAttribute> unknownAttributes = PropertyNameValidator.INSTANCE.getUnknownAttributes(attributeList);

                            handleUnknowns(holder, attributeList, unknownAttributes);
                            handleMissing(holder, id, attributeList);

                            List<Eu4ScriptAttribute> validAttributes = attributeList.stream()
                                    .filter(attribute -> !unknownAttributes.contains(attribute)).collect(Collectors.toList());

                            validateAttributeTypes(holder, validAttributes);
                        }
                );

            }
        }
    }

    private void validateAttributeTypes(@NotNull AnnotationHolder holder, List<Eu4ScriptAttribute> validAttributes) {
        String errorPattern = "Attribute [{0}] accepts only {1} values";
        validAttributes.forEach(
                attr -> {
                    AttributeValueType expectedType = BuildingAttributeSpecRepository.INSTANCE.repo.getSpecMap().get(attr.getName()).getValueType();
                    Eu4ScriptValue attrValue = attr.getValue();
                    if (expectedType.equals(AttributeValueType.NUMBER)) {
                        if (attrValue.getLiteral() == null || attrValue.getLiteral().getNumberLiteral() == null) {
                            holder.newAnnotation(
                                    HighlightSeverity.ERROR,
                                    MessageFormat.format(errorPattern, attr.getName(), "numeric"))
                                    .range(attr)
                                    .create();
                        }
                        return;
                    }
                    if (expectedType.equals(AttributeValueType.STRING)) {
                        if (attrValue.getLiteral() == null || attrValue.getLiteral().getStringLiteral() == null) {
                            holder.newAnnotation(
                                    HighlightSeverity.ERROR,
                                    MessageFormat.format(errorPattern, attr.getName(), "string"))
                                    .range(attr)
                                    .create();
                        }
                    }
                }
        );
    }

    private void handleMissing(@NotNull AnnotationHolder holder, Eu4ScriptIdentifier id, List<Eu4ScriptAttribute> attributeList) {
        String errorPattern = "Missing a required [{0}] attribute";
        PropertyNameValidator.INSTANCE
                .getMissingNames(attributeList)
                .forEach(name ->
                        holder.newAnnotation(HighlightSeverity.ERROR, MessageFormat.format(errorPattern, name))
                                .range(id)
                                .create());
    }

    private void handleUnknowns(@NotNull AnnotationHolder holder, List<Eu4ScriptAttribute> attributeList, List<Eu4ScriptAttribute> unknownAttributes) {
        String errorPattern = "Unknown attribute [{0}]";
        attributeList.stream()
                .filter(unknownAttributes::contains)
                .forEach(attr -> holder.newAnnotation(
                        HighlightSeverity.ERROR, MessageFormat.format(errorPattern, attr.getName()))
                        .range(attr)
                        .create());
    }


}

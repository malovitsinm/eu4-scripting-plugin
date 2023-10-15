package com.malovtisinm.eu4script.language.validator;

import com.malovtisinm.eu4script.data.PropertySpec;
import com.malovtisinm.eu4script.data.repo.BuildingAttributeSpecRepository;
import com.malovtisinm.eu4script.language.psi.core.Eu4ScriptAttribute;

import java.util.List;
import java.util.stream.Collectors;


public class PropertyNameValidator {

    public static PropertyNameValidator INSTANCE = new PropertyNameValidator();

    public List<Eu4ScriptAttribute> getUnknownAttributes(List<Eu4ScriptAttribute> attributes) {
        List<String> allNames = BuildingAttributeSpecRepository.INSTANCE.repo.getAllAvailableAttributeNames();
        return attributes.stream().filter(s -> !allNames.contains(s.getName())).collect(Collectors.toList());
    }

    public List<String> getMissingNames(List<Eu4ScriptAttribute> attributes) {
        List<String> mandatoryNames =  BuildingAttributeSpecRepository.INSTANCE.repo
                .getMandatoryAttributes().stream().map(PropertySpec::getName).collect(Collectors.toList());
        List<String> presentNames = attributes.stream().map(Eu4ScriptAttribute::getName).collect(Collectors.toList());
        return mandatoryNames.stream().filter(s -> !presentNames.contains(s)).collect(Collectors.toList());

    }

}

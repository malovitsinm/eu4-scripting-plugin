package com.malovtisinm.eu4script.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompositeAttributeSpec extends AttributeSpec {

    @Singular
    @JsonProperty
    List<PropertySpec> mandatoryAttributes;

    @Singular
    @JsonProperty
    List<PropertySpec> optionalAttributes;

    @JsonIgnore
    Map<String, PropertySpec> specMap;

    @Jacksonized
    @Builder
    public CompositeAttributeSpec(List<PropertySpec> mandatoryAttributes, List<PropertySpec> optionalAttributes) {
        this.mandatoryAttributes = mandatoryAttributes;
        this.optionalAttributes = optionalAttributes;
        this.specMap = Stream.of(this.mandatoryAttributes, this.optionalAttributes)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(PropertySpec::getName, s -> s));
    }

    public List<String> getAllAvailableAttributeNames() {
        return Stream.of(mandatoryAttributes, optionalAttributes)
                .flatMap(Collection::stream)
                .map(PropertySpec::getName)
                .collect(Collectors.toList());
    }

}

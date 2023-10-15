package com.malovtisinm.eu4script.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@EqualsAndHashCode(callSuper = true)
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertySpec extends AttributeSpec {

    @JsonProperty
    String name;

    @JsonProperty
    AttributeValueType valueType;
}

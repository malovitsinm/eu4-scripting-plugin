package com.malovtisinm.eu4script.data.repo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malovtisinm.eu4script.data.AttributeValueType;
import com.malovtisinm.eu4script.data.CompositeAttributeSpec;
import com.malovtisinm.eu4script.data.PropertySpec;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BuildingAttributeSpecRepository {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static BuildingAttributeSpecRepository INSTANCE = new BuildingAttributeSpecRepository();

    public CompositeAttributeSpec repo ;

    public BuildingAttributeSpecRepository() {
        try (InputStream is = BuildingAttributeSpecRepository.class.getClassLoader().getResourceAsStream("specs/building_spec.json")) {
            this.repo = mapper.readValue(is, CompositeAttributeSpec.class);
        } catch (IOException ignored) {

        }
    }

}

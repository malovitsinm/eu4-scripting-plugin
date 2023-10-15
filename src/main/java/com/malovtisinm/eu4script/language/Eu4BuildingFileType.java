package com.malovtisinm.eu4script.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class Eu4BuildingFileType extends LanguageFileType {

    public static final Eu4BuildingFileType INSTANCE = new Eu4BuildingFileType();

    private Eu4BuildingFileType() {
        super(Eu4BuildingScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Building File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Test EU4 building file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "testfile";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Eu4Icon.FILE;
    }

}

package com.malovtisinm.eu4script.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TestFileType extends LanguageFileType {

    public static final TestFileType INSTANCE = new TestFileType();

    private TestFileType() {
        super(Eu4ScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Test File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Test EU4 scripting file";
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

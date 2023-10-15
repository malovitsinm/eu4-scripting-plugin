package com.malovtisinm.eu4script.language.psi.core;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.malovtisinm.eu4script.language.Eu4ScriptLanguage;
import com.malovtisinm.eu4script.language.TestFileType;
import org.jetbrains.annotations.NotNull;

public class Eu4ScriptFile extends PsiFileBase {

    public Eu4ScriptFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, Eu4ScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return TestFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Testfile";
    }

}

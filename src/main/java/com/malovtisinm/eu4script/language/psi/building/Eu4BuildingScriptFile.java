package com.malovtisinm.eu4script.language.psi.building;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.malovtisinm.eu4script.language.Eu4BuildingFileType;
import com.malovtisinm.eu4script.language.Eu4BuildingScriptLanguage;
import com.malovtisinm.eu4script.language.Eu4ScriptLanguage;
import com.malovtisinm.eu4script.language.TestFileType;
import org.jetbrains.annotations.NotNull;

public class Eu4BuildingScriptFile extends PsiFileBase {

    public Eu4BuildingScriptFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, Eu4BuildingScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return Eu4BuildingFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Buildingfile";
    }

}

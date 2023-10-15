package com.malovtisinm.eu4script.language.parser;

import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.malovtisinm.eu4script.language.Eu4BuildingScriptLanguage;
import com.malovtisinm.eu4script.language.psi.building.Eu4BuildingScriptFile;
import org.jetbrains.annotations.NotNull;

public class Eu4BuildingParserDefinition extends Eu4ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(Eu4BuildingScriptLanguage.INSTANCE);

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new Eu4BuildingScriptFile(viewProvider);
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }
}

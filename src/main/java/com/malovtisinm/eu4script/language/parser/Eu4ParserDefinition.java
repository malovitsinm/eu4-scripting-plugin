package com.malovtisinm.eu4script.language.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.malovtisinm.eu4script.language.Eu4ScriptLanguage;
import com.malovtisinm.eu4script.language.Eu4ScriptLexerAdapter;
import com.malovtisinm.eu4script.language.psi.core.Eu4ScriptFile;
import com.malovtisinm.eu4script.language.psi.core.Eu4ScriptTokenSets;
import com.malovtisinm.eu4script.language.psi.core.Eu4Types;
import org.jetbrains.annotations.NotNull;

public class Eu4ParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(Eu4ScriptLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new Eu4ScriptLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return Eu4ScriptTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return Eu4ScriptTokenSets.STRINGS;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new Eu4ScriptParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new Eu4ScriptFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return Eu4Types.Factory.createElement(node);
    }

}
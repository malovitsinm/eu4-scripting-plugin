package com.malovtisinm.eu4script.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.malovtisinm.eu4script.language.psi.Eu4BuildingElement;
import org.jetbrains.annotations.NotNull;

public abstract class Eu4BuildingImpl extends ASTWrapperPsiElement implements Eu4BuildingElement {

    public Eu4BuildingImpl(@NotNull ASTNode node) {
        super(node);
    }
}

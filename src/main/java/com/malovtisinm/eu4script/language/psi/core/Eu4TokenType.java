package com.malovtisinm.eu4script.language.psi.core;

import com.intellij.psi.tree.IElementType;
import com.malovtisinm.eu4script.language.Eu4ScriptLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class Eu4TokenType extends IElementType {
    public Eu4TokenType(@NotNull @NonNls String debugName) {
        super(debugName, Eu4ScriptLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "EU4TokenType." + super.toString();
    }
}

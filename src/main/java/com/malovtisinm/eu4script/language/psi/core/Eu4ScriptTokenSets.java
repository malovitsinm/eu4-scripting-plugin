package com.malovtisinm.eu4script.language.psi.core;

import com.intellij.psi.tree.TokenSet;

public interface Eu4ScriptTokenSets {
    TokenSet IDENTIFIERS = TokenSet.create(Eu4Types.KEY);

    TokenSet COMMENTS = TokenSet.create(Eu4Types.COMMENT);
    TokenSet STRINGS = TokenSet.create(Eu4Types.STRING_LITERAL);
}

package com.malovtisinm.eu4script.language;

import com.intellij.lexer.FlexAdapter;

public class Eu4ScriptLexerAdapter extends FlexAdapter {

    public Eu4ScriptLexerAdapter() {
        super(new _Eu4ScriptLexer(null));
    }
}

package com.malovtisinm.eu4script.language;

import com.intellij.lang.Language;

public class Eu4ScriptLanguage extends Language {

    public static final Eu4ScriptLanguage INSTANCE = new Eu4ScriptLanguage();

    private Eu4ScriptLanguage() {
        super("EU4Script");
    }

    protected Eu4ScriptLanguage(String id) {
        super(id);
    }

}

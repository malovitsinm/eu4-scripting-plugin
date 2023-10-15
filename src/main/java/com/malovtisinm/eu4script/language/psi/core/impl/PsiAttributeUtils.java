package com.malovtisinm.eu4script.language.psi.core.impl;

import com.malovtisinm.eu4script.language.psi.core.Eu4ScriptAttribute;

public class PsiAttributeUtils {

    public static String getName(Eu4ScriptAttribute attribute) {
        return attribute.getIdentifier().getText();
    }
}

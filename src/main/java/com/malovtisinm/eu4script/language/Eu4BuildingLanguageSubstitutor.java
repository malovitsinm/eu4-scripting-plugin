package com.malovtisinm.eu4script.language;

import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.LanguageSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Eu4BuildingLanguageSubstitutor extends LanguageSubstitutor {

    @Override
    public @Nullable Language getLanguage(@NotNull VirtualFile file, @NotNull Project project) {
        if (file.getPath().contains("buildings"))
            return Eu4BuildingScriptLanguage.INSTANCE;
        return null;
    }
}

// This is a generated file. Not intended for manual editing.
package com.malovtisinm.eu4script.language.psi.core.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.malovtisinm.eu4script.language.psi.core.Eu4Types.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.malovtisinm.eu4script.language.psi.core.*;

public class Eu4ScriptBlockImpl extends ASTWrapperPsiElement implements Eu4ScriptBlock {

  public Eu4ScriptBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Eu4ScriptVisitor visitor) {
    visitor.visitBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Eu4ScriptVisitor) accept((Eu4ScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<Eu4ScriptAttribute> getAttributeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Eu4ScriptAttribute.class);
  }

}

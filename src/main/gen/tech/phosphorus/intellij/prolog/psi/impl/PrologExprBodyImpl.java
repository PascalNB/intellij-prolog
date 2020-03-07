// This is a generated file. Not intended for manual editing.
package tech.phosphorus.intellij.prolog.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.phosphorus.intellij.prolog.psi.PrologTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import tech.phosphorus.intellij.prolog.psi.*;

public class PrologExprBodyImpl extends ASTWrapperPsiElement implements PrologExprBody {

  public PrologExprBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrologVisitor visitor) {
    visitor.visitExprBody(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrologVisitor) accept((PrologVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PrologCommonVal> getCommonValList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrologCommonVal.class);
  }

  @Override
  @NotNull
  public List<PrologEquivBinary> getEquivBinaryList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrologEquivBinary.class);
  }

  @Override
  @Nullable
  public PrologLogicalNot getLogicalNot() {
    return findChildByClass(PrologLogicalNot.class);
  }

  @Override
  @NotNull
  public List<PrologLogicalOr> getLogicalOrList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrologLogicalOr.class);
  }

}

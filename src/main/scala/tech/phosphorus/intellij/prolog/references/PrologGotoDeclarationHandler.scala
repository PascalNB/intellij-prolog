package tech.phosphorus.intellij.prolog.references

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import tech.phosphorus.intellij.prolog.PrologLanguage
import tech.phosphorus.intellij.prolog.psi.PrologParameterListMixin
import tech.phosphorus.intellij.prolog.psi.impl.PrologRefPredicateIdImpl

class PrologGotoDeclarationHandler extends GotoDeclarationHandler{
  override def getGotoDeclarationTargets(psiElement: PsiElement, i: Int, editor: Editor): Array[PsiElement] = {
    if (psiElement.getLanguage == PrologLanguage.INSTANCE) {
      val id = psiElement.getParent
      return id match {
        // one step above predicate id gives its full declaration
        case pid: PrologRefPredicateIdImpl =>
          val parameters = pid.getParent.getLastChild
          if(parameters != null && parameters.isInstanceOf[PrologParameterListMixin]) {
            val params = parameters.asInstanceOf[PrologParameterListMixin].calculateParameters()
            println("resolved params " + params)
          }
          pid.multiResolve(false).map(_.getElement.getParent)
        case _ => Array()
      }
    }
    Array()
  }
}

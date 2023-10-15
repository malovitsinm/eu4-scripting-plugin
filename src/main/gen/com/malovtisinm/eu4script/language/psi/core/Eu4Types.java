// This is a generated file. Not intended for manual editing.
package com.malovtisinm.eu4script.language.psi.core;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.malovtisinm.eu4script.language.psi.core.impl.*;

public interface Eu4Types {

  IElementType ATTRIBUTE = new Eu4ElementType("ATTRIBUTE");
  IElementType BLOCK = new Eu4ElementType("BLOCK");
  IElementType BOOLEAN_LITERAL = new Eu4ElementType("BOOLEAN_LITERAL");
  IElementType EXPR = new Eu4ElementType("EXPR");
  IElementType IDENTIFIER = new Eu4ElementType("IDENTIFIER");
  IElementType LITERAL = new Eu4ElementType("LITERAL");
  IElementType NUMBER_LITERAL = new Eu4ElementType("NUMBER_LITERAL");
  IElementType OBJECT = new Eu4ElementType("OBJECT");
  IElementType PROPERTY = new Eu4ElementType("PROPERTY");
  IElementType STATEMENT = new Eu4ElementType("STATEMENT");
  IElementType STRING_LITERAL = new Eu4ElementType("STRING_LITERAL");
  IElementType VALUE = new Eu4ElementType("VALUE");

  IElementType ACCESSOR = new Eu4TokenType(".");
  IElementType COMMENT = new Eu4TokenType("COMMENT");
  IElementType DELIMETER = new Eu4TokenType("=");
  IElementType KEY = new Eu4TokenType("key");
  IElementType LBRACE = new Eu4TokenType("{");
  IElementType NO = new Eu4TokenType("no");
  IElementType NUMBER = new Eu4TokenType("number");
  IElementType RBRACE = new Eu4TokenType("}");
  IElementType STRING = new Eu4TokenType("string");
  IElementType YES = new Eu4TokenType("yes");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATTRIBUTE) {
        return new Eu4ScriptAttributeImpl(node);
      }
      else if (type == BLOCK) {
        return new Eu4ScriptBlockImpl(node);
      }
      else if (type == BOOLEAN_LITERAL) {
        return new Eu4ScriptBooleanLiteralImpl(node);
      }
      else if (type == EXPR) {
        return new Eu4ScriptExprImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new Eu4ScriptIdentifierImpl(node);
      }
      else if (type == LITERAL) {
        return new Eu4ScriptLiteralImpl(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new Eu4ScriptNumberLiteralImpl(node);
      }
      else if (type == OBJECT) {
        return new Eu4ScriptObjectImpl(node);
      }
      else if (type == PROPERTY) {
        return new Eu4ScriptPropertyImpl(node);
      }
      else if (type == STATEMENT) {
        return new Eu4ScriptStatementImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new Eu4ScriptStringLiteralImpl(node);
      }
      else if (type == VALUE) {
        return new Eu4ScriptValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

package com.malovtisinm.eu4script.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.malovtisinm.eu4script.language.psi.Eu4Types.*;

%%

%{
  public _Eu4ScriptLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _Eu4ScriptLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

NUMBER=[0-9]+(\.[0-9]*)?
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
PROPERTY=[a-z][a-z0-9|_]*
KEY=[a-z][a-z0-9|_]*

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "{"                { return LBRACE; }
  "}"                { return RBRACE; }
  "="                { return DELIMETER; }
  "."                { return ACCESSOR; }
  "COMMENT"          { return COMMENT; }

  {NUMBER}           { return NUMBER; }
  {STRING}           { return STRING; }
  {PROPERTY}         { return PROPERTY; }
  {KEY}              { return KEY; }

}

[^] { return BAD_CHARACTER; }

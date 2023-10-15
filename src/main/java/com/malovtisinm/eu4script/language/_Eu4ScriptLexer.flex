package com.malovtisinm.eu4script.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.malovtisinm.eu4script.language.psi.core.Eu4Types.*;

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

SHARP="#"
NUMBER=[-]?[0-9]+(\.[0-9]*)?
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
KEY=[a-zA-Z0-9|_]*

COMMENT={SHARP}.*{EOL}

%%
<YYINITIAL> {

  "{"                { return LBRACE; }
  "}"                { return RBRACE; }
  "="                { return DELIMETER; }
  "."                { return ACCESSOR; }
  "yes"              { return YES;}
  "no"               { return NO;}
  {NUMBER}           { return NUMBER; }
  {STRING}           { return STRING; }
  {KEY}              { return KEY; }

  {COMMENT}          { return COMMENT; }

}

  {WHITE_SPACE}      { return WHITE_SPACE; }


[^] { return BAD_CHARACTER; }

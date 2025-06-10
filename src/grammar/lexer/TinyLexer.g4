lexer grammar TinyLexer ;

@header {
    package grammar.lexer;
}

MAIN    : 'main'      ;

IF      :  'if'       ;
THEN    :  'then'     ;
ELIF    :  'elseif'   ;
ELSE    :  'else'     ;
END     :  'end'      ;

REPEAT  :  'repeat'   ;
UNTIL   :  'until'    ;

READ    :  'read'     ;
WRITE   :  'write'    ;

RETURN  :  'return'   ;
ENDL    :  'endl'     ;

INT     :  'int'      ;
FLOAT   :  'float'    ;
STRING  :  'string'   ;

BOOL
: 'true'
| 'false'
;


PLUS    : '+' ;
MINUS   : '-' ;
MUL     : '*' ;
DIV     : '/' ;
MOD     : '%' ;

ASSIGN: ':=' ;

EQ  : '='   ;
NEQ : '!='  ;
GT  : '>'   ;
LT  : '<'   ;
GEQ : '>='  ;
LEQ : '<='  ;

AND : '&&'  ;
OR  : '||'  ;
NOT : '!'   ;

SCOLON  : ';' ;
COMMA   : ',' ;
LBRAC   : '[' ;
RBRAC   : ']' ;
LCURL   : '{' ;
RCURL   : '}' ;
LPAR    : '(' ;
RPAR    : ')' ;

ID: (Letters | '_') (Letters | Digits | '_')* ;

INTEGER: Firstdig Digits* | '0' ;

REALNUMBER: INTEGER ('.' Digits+)? ;

STR: ["] ( ~["\r\n\\] | '\\' ~[\r\n] )* ["];

COMMENT: (SINGLE_COMMENT | MULTILINE_COMMENT) -> skip;

SINGLE_COMMENT: '//' (~[\r\n])* ;

MULTILINE_COMMENT: '/*' .*? '*/' ;

WS: [ \t\r\n] -> skip;

fragment Digits: [0-9] ;
fragment Firstdig: [1-9] ;
fragment Letters: [a-zA-Z] ;

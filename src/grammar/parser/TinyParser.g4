parser grammar TinyParser;

options { tokenVocab=TinyLexer; }

@header {
    package grammar.parser;
}

program
    : function* main                               #Prog
    ;

main
    : INT MAIN LPAR RPAR LCURL body (RETURN INTEGER SCOLON)? RCURL   #MainFunction
    ;

function
    : returnType ID LPAR paramList? RPAR LCURL body returnStatement RCURL  #FunctionDeclaration
    ;

returnType
    : dataType                                        #RetType
    ;

dataType
    : INT                                             #IntType
    | FLOAT                                           #FloatType
    | BOOL                                            #BoolType
    | STRING                                          #StringType
    ;

paramList
    : variableDeclaration (COMMA variableDeclaration)*   #ParameterList
    ;

variableDeclaration
    : dataType ID                                      #VarDeclaration
    ;

returnStatement
    : RETURN expr SCOLON                              #RetStatement
    ;

body
    : statement*                                       #BodyBlock
    ;

statement
    : readStatement SCOLON                            #ReadStmt
    | writeStatement SCOLON                           #WriteStmt
    | assignmentStatement SCOLON                      #AssignStmt
    | declarationStatement SCOLON                     #DeclStmt
    | functionCallStatement SCOLON                    #CallStmt
    | ifStatement                                     #IfStmt
    | repeatStatement                                 #RepeatStmt
    ;

readStatement
    : READ ID                                          #ReadStat
    ;

writeStatement
    : WRITE (expr | ENDL)                              #WriteStat
    ;

assignmentStatement
    : ID ASSIGN expr                                   #Assignment
    ;

declarationStatement
    : dataType (ID | assignmentStatement) (COMMA (ID | assignmentStatement))* #Declaration
    ;

functionCallStatement
    : ID LPAR argList? RPAR                            #FunctionCall
    ;

argList
    : expr (COMMA expr)*                     #Arguments
    ;

//funcArgs: functionCallStatement | ID | literals;

expr
    : NOT expr                          #NotExpr
    | expr (MUL | DIV | MOD) expr       #MulExpr
    | expr (PLUS | MINUS) expr          #AddExpr
    | expr (GT | LT | GEQ | LEQ) expr   #CondRelExpr
    | expr (EQ | NEQ) expr              #CondEQExpr
    | expr AND expr                     #LogicalANDExpr
    | expr OR expr                      #LogicalORExpr
    | term                              #TermExpr
    | LPAR expr RPAR                    #ParenExpr
    ;

term
    : ID                                #IdTerm
    | literals                          #LiteralTerm
    | functionCallStatement             #FunctionCallExpr
    ;

literals
    : INTEGER                                          #IntLiteral
    | REALNUMBER                                       #RealLiteral
    | STR                                              #StringLiteral
    | BOOL                                             #BoolLiteral
    ;

ifStatement
    : IF condition THEN body (ELIF condition THEN body)* (ELSE body)? END   #IfElseStatement
    ;

repeatStatement
    : REPEAT body UNTIL condition                      #RepeatStat
    ;

condition
    : expr                                             #Cond
    ;

grammar MineLang;

program: stat*
  EOF
  ;

pkgName: ID (DOT ID)*;
funcArgs: LB ID? (COMMA ID)* COMMA? RB;
callArgs: LB expr? (COMMA expr)* COMMA? RB;
block: START stat* END;

stat: expr callArgs #funcCallStat
  | FUNC ID funcArgs? block #funcDeclareStat
  | RETURN expr #returnStat
  | USING ID IN pkgName #usingStat
  | ID SET expr #varSetStat
  | IF expr block (ELIF expr block)* (ELSE block)? #ifelseStat
  | LOOP block #loopStat
  | CONTINUE #continueStat
  | BREAK #breakStat
  ;

expr: (INT | REAL | STRING | BOOL | NONE) #literalExpr
  | ID #varUseExpr
  | expr DOT ID #getExpr
  | expr callArgs #funcCallExpr
  | expr NOT #notExpr
  | <assoc=right> expr POWER expr #powerExpr
  | expr (MUTIPLY | DEVIDE | REMAIN) expr #mutiplyDevideRemainExpr
  | expr (PLUS | MINUS) expr #plusMinusExpr
  | expr (EQ | NEQ) expr #isEqExpr
  | expr (GTR | GTREQ | LWR | LWREQ) expr #compareExpr
  | LB expr RB #bracketExpr
  | FUNC funcArgs? block #lambdaFuncExpr
  ;

FUNC: 'func';
RETURN: 'return';
USING: 'using';
IN: 'in';
IF: 'if';
ELIF: 'else' ' '* 'if';
ELSE: 'else';
LOOP: 'loop';
BREAK: 'break';
CONTINUE: 'continue';
COMMA: ',';
LB: '(';
RB: ')';
LA: '[';
RA: ']';
START: '{';
END: '}';
DOT: '.';
EQ: '==';
NEQ: '!=';
SET: '=';
PLUS: '+';
MINUS: '-';
MUTIPLY: '*';
DEVIDE: '/';
POWER: '^';
REMAIN: '%';
NOT: '!';
GTR: '>';
GTREQ: '>=';
LWR: '<';
LWREQ: '<=';

fragment STRCHAR: ~["] | '\\"';
fragment INTEGER: [0-9]+;
fragment ESCAPECHAR: '\\'. ;
STRING: '"' (ESCAPECHAR | ~('"' | '\\'))* '"' | '\'' (ESCAPECHAR | ~('\'' | '\\'))* '\'';
INT: INTEGER;
REAL: INTEGER'.'INTEGER;
BOOL: 'true' | 'false';
NONE: 'none';

fragment IDStart: ~[0-9 @[\]\-+=()*&^%!~`?<>,.:;"'\\|！#【】{}：。“”‘’/？《》，、·￥…（）；\r\n];
fragment IDPart: ~[ @[\]\-+=()*&^%!~`?<>,.:;"'\\|！#【】{}：。“”‘’/？《》，、·￥…（）；\r\n];
ID: IDStart IDPart*;

WS: [ \n\r\t] -> channel(HIDDEN);
COMMENT: '//'~[\n]* -> channel(HIDDEN);
MUTICOMMENT: '/*'.*?'*/' -> channel(HIDDEN);
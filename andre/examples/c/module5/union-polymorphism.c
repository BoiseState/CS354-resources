

typedef enum {
    NODE_FACT_TOKEN,
    NODE_FACT_EXPR
} NodeType;

struct fact{
    NodeType n;
    union {
        Token *token;
        Expr *expr;
    } u;
};

// later, in the parser


Fact *parseFact(Parser *p) {

    Fact *f;

    switch(p->lookahead->type) {

        case TOKEN_NUM:
            f = create_fact_token(p->lookahead);
            match(p, TOKEN_NUM);
            return f;
        case TOKEN_ID:
            f = create_fact_token(p->lookahead);
            match(p, TOKEN_ID);
            return f;
        case TOKEN_LPAREN:
            match(p, TOKEN_LPAREN);
            f = create_fact_expr(parseExpr(p));
            match(p, TOKEN_RPAREN);
            return f;
        default:
            fprintf(stderr, "Syntax Violation! Was %s at position: %d\n", tokenTypeToString(p->lookahead->type), p->lex->current_pos);
            exit(-1);
    }
}


// example 2, union structs:

struct TreeStmt {
  TokenCode code;
  union {
    struct {
      TreeLoc loc;
      TreeBool bool;
    } u_assign;
    struct {
        TreeBool bool;
        TreeStmt ifStmt;
        TreeStmt elseStmt;
    } u_if;
    struct {
      TreeBool bool;
      TreeStmt stmt;
    } u_while;
    struct {
        TreeStmt stmt;
        TreeBool bool;
    } u_do;
    struct {
        TreeBlock block;
    } u_block;
    struct {
        TreeLoc loc;
    } u_read;
    struct {
        TreeBool bool;
    } u_write;
  } u;
};
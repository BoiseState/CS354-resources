package syntax;

import node.*;

/**
 * A recursive descent parser
 */
public class Parser {

    private Lexer lexer;
    private Token lookahead;

    /**
     * Parse an input program and return a node.Node that is the root of the
     * resulting parse tree.
     *
     * @param program String to be scanned and parsed
     * @return the Root node.Node of a parse tree
     * @throws SyntaxException - If there is a syntax error
     */
    public Node parse(String program) throws SyntaxException {
        scanner = new Lexer(program);
        lookahead = scanner.next(); //"prime the pump"
        Expr expr = parseExpr();
        match("EOF");
        return expr;
    }

    /**
     * TODO
     *
     * @return
     * @throws SyntaxException
     */
    private Expr parseExpr() throws SyntaxException {

        Term term = parseTerm();
        Addop addop = parseAddop();

        if (addop == null) {
            return new Expr(term);
        } else {
            Expr expr=parseExpr();
            expr.append(new Expr(term,addop,null));
            return expr;
        }
    }

    /**
     * TODO
     * @return
     * @throws SyntaxException
     */
    private Term parseTerm() throws SyntaxException {

    }

    /**
     * TODO
     * @return
     * @throws SyntaxException
     */
    private Fact parseFact() throws SyntaxException {

        Token current = lookahead;

        if (current.equalType(new Token("id"))) {
            match("id");
            //TODO: return a new node.NodeFact Subclass for this case

        } else if (current.equalType(new Token("num"))) {

            //TODO: What tokens to match and what to return?
        } else {

            //TODO: What tokens to match and what to return?
        }
    }

    /**
     * Parses an addop nonterminal and returns it.
     * @return a node.Node that represent an addop
     * @throws SyntaxException if an invalid terminal is discovered
     */
    private NodeAddop parseAddop() throws SyntaxException {
        Token addop = lookahead;
        if (addop.equalType("+")) {
            match("+");
            return new NodeAddop(scanner.getPosition(), addop);

        } else if (addop.equalType("-")) {
            match("-");
            return new NodeAddop(scanner.getPosition(), addop);

        } else {
            return null;
        }
    }

    /**
     * TODO
     * @return
     * @throws SyntaxException
     */
    private NodeMulop parseMulop() throws SyntaxException {

    }

    private void match(String s) throws SyntaxException {
        if (lookahead.equalType(s)) {
            lookahead = scanner.next();
        } else {
            throw new SyntaxException(scanner.getPosition(), new Token(s), lookahead);
        }
    }
}

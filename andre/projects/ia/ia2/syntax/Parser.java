package syntax;

import node.*;

/**
 * A recursive descent parser
 */
public class Parser {

    private Lexer lexer;

    /**
     * Parse an input program and return a node.Node that is the root of the
     * resulting parse tree.
     *
     * @param program String to be scanned and parsed
     * @return the Root node.Node of a parse tree
     * @throws SyntaxException - If there is a syntax error
     */
    public Node parse(String program) throws SyntaxException {
        lexer = new Lexer(program);
        lexer.next(); //"prime the pump"
        return parseExpr();
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

        Token current = lexer.getCurrent();

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
    private Addop parseAddop() throws SyntaxException {
        Token addop = lexer.getCurrent();
        if (addop.equalType(new Token("+"))) {
            match("+");
            return new Addop(lexer.getPosition(), addop);

        } else if (addop.equalType(new Token("-"))) {
            match("-");
            return new Addop(lexer.getPosition(), addop);

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
        lexer.match(new Token(s));
    }
}

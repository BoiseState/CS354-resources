/**
 * A recursive descent parser
 */
public class Parser {

    private Scanner scanner;

    /**
     * Parse an input program and return a Node that is the root of the
     * resulting parse tree.
     *
     * @param program String to be scanned and parsed
     * @return the Root Node of a parse tree
     * @throws SyntaxException - If there is a syntax error
     */
    public Node parse(String program) throws SyntaxException {
        scanner = new Scanner(program);
        scanner.next(); //"prime the pump"
        return parseExpr();
    }

    /**
     * TODO
     *
     * @return
     * @throws SyntaxException
     */
    private NodeExpr parseExpr() throws SyntaxException {

        NodeTerm term = parseTerm();
        NodeAddop addop = parseAddop();

        if (addop == null) {
            return new NodeExpr(term);
        } else {
            NodeExpr expr = parseExpr();
            return new NodeExpr(term, addop, expr);
        }
    }

    /**
     * TODO
     * @return
     * @throws SyntaxException
     */
    private NodeTerm parseTerm() throws SyntaxException {

    }

    /**
     * TODO
     * @return
     * @throws SyntaxException
     */
    private NodeFact parseFact() throws SyntaxException {

        Token current = scanner.getCurrent();

        if (current.equalType(new Token("id"))) {
            match("id");
            //TODO: return a new NodeFact Subclass for this case

        } else if (current.equalType(new Token("num"))) {

            //TODO: What tokens to match and what to return?
        } else {

            //TODO: What tokens to match and what to return?
        }
    }

    /**
     * Parses an addop nonterminal and returns it.
     * @return a Node that represent an addop
     * @throws SyntaxException if an invalid terminal is discovered
     */
    private NodeAddop parseAddop() throws SyntaxException {
        Token addop = scanner.getCurrent();
        if (addop.equalType(new Token("+"))) {
            match("+");
            return new NodeAddop(scanner.getPosition(), addop);

        } else if (addop.equalType(new Token("-"))) {
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
        scanner.match(new Token(s));
    }
}

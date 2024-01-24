import java.util.*;

/**
 * Scanner for programming language
 */
public class Scanner {

    private String program;      // source program being interpreted
    private int position;        // index of next char in program
    private Token currentToken;       // current (most recently scanned token)


    private Set<String> whitespace = new HashSet<>();
    private Set<String> letters = new HashSet<>();
    private Set<String> keywords = new HashSet<>();


    /**
     * Creates a new scanner
     *
     * @param program - the program text to scan
     */
    public Scanner(String program) {
        this.program = program;
        position = 0;
        currentToken = null;
        initWhitespace(whitespace);
        initLetters(letters);
        initKeywords(keywords);
    }

    private void initKeywords(Set<String> keywords2) {
        //.... no keywords yet
    }

    private void initLetters(Set<String> s) {
        fill(s, 'A', 'Z');
        fill(s, 'a', 'z');
    }

    private void fill(Set<String> s, char lo, char hi) {
        for (char c = lo; c <= hi; c++) {
            s.add(c + "");
        }
    }

    private void initWhitespace(Set<String> s) {
        s.add(" ");
        s.add("\n");
        s.add("\t");
    }

    private void advance() {
        this.position++;
    }

    private String posAsString() {
        return program.charAt(position) + "";
    }

    private Token nextKwID() {

        int old = this.position;
        advance();

        while (hasChar() && letters.contains(posAsString())) {
            advance();
        }

        String lexeme = program.substring(old, position);

        if (keywords.contains(lexeme))
            return new Token(lexeme, lexeme);
        else
            return new Token("id", lexeme);
    }


    /**
     * Determines the kind of the next token (e.g., "id") and calls the
     * appropriate method to scan the token's lexeme (e.g., "foo").
     *
     * @return boolean indicating if there are more tokens to scan.
     */
    public boolean next() {
        if (!hasChar())
            return false;

        while (hasChar() && whitespace.contains(posAsString())) {
            advance();
        }

        String c = posAsString();

        if (letters.contains(c)) {
            currentToken = nextKwID();
        }
        //	rest here!


        else {
            System.err.println("illegal character at position "+ position);
            position++;
            return next();
        }

        return true;
    }

    /**
     * Determines if the current position of the scanner is in the bounds of the
     * program
     * @return true if there are more characters in program
     */
    public boolean hasChar() {
        return position < program.length();
    }

    /**
     * Scan's the next lexeme if the current token is the expected token.
     * @param t - the expected token
     * @throws SyntaxException - if current token is not the expected token
     */
    public void match(Token t) throws SyntaxException {
        if (!t.equalType(getCurrent())) {
            throw new SyntaxException(position, t, getCurrent());
        }
        next();
    }

    public Token getCurrent() throws SyntaxException {
        if (currentToken == null) {
            throw new SyntaxException(position, new Token("ANY"), new Token("EMPTY"));
        }
        return currentToken;
    }

    public int getPosition() {
        return position;
    }
}
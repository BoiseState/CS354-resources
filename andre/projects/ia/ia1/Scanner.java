import java.util.*;

/**
 * Scanner for programming language
 */
public class Scanner {

    private String program;      // source program being interpreted
    private int position;        // index of next char in program
    private Token current;       // current (most recently scanned token)


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
        current = null;
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

    // handy string-processing methods

    public boolean hasNext() {
        return position >= program.length();
    }

    private void many(Set<String> s) {
        while (!hasNext() && s.contains(program.charAt(position) + ""))
            position++;
    }

    private void past(char c) {
        while (!hasNext() && c != program.charAt(position))
            position++;
        if (!hasNext() && c == program.charAt(position))
            position++;
    }


    /**
     * Determines the kind of the next token (e.g., "id") and calls the
     * appropriate method to scan the token's lexeme (e.g., "foo").
     *
     * @return boolean indicating if there are more tokens to scan.
     */
    public boolean next() {
        if (hasNext())
            return false;
        many(whitespace);
        String c = program.charAt(position) + "";

        if (letters.contains(c)) {
            current = nextKwID();
        }
        //	else if ...


        else {
            System.err.println("illegal character at position "+ position);
            position++;
            return next();
        }

        return true;
    }

    private Token nextKwID() {
        int old = position;
        many(letters);
        String lexeme = program.substring(old, position);
        return new Token((keywords.contains(lexeme) ? lexeme : "id"), lexeme);
    }

    /**
     * Scan's the next lexeme if the current token is the expected token.
     * @param t - the expected token
     * @throws SyntaxException - if current token is not the expected token
     */
    public void match(Token t) throws SyntaxException {
        if (!t.equals(getCurrent())) {
            throw new SyntaxException(position, t, getCurrent());
        }
        next();
    }

    public Token getCurrent() throws SyntaxException {
        if (current == null) {
            throw new SyntaxException(position, new Token("ANY"), new Token("EMPTY"));
        }
        return current;
    }

    public int getPosition() {
        return position;
    }
}
package syntax;

import java.util.*;

/**
 * Lexical Analyzer for CS354 programming language
 */
public class Lexer {

    private String program;      // source program being interpreted
    private int position;        // index of next char in program


    private Set<String> whitespace = new HashSet<>();
    private Set<String> letters = new HashSet<>();
    private Set<String> keywords = new HashSet<>();


    /**
     * Creates a new lexical analyzer
     *
     * @param program - the program text to scan
     */
    public Lexer(String program) {
        this.program = program;
        position = 0;
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

    private String peek() {
        if (hasChar()) {
            return program.charAt(position) + "";
        } else {
            return null;
        }
    }

    private Token nextKwID() {

        int old = this.position;
        advance();

        while (hasChar() && letters.contains(peek())) {
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
     * @return the scanned token.
     */
    public Token next() {

        while (hasChar() && whitespace.contains(peek())) {
            advance();
        }

        if (!hasChar()) {
            return new Token("EOF");
        } else if (hasChar() && letters.contains(peek())) {
            return nextKwID();
        }
        //	rest here!
        else {
            System.err.println("illegal character at position "+ position);
            position++;
            return next();
        }
    }

    /**
     * Determines if the current position of the lexer is in the bounds of the
     * program
     * @return true if there are more characters in program
     */
    public boolean hasChar() {
        return position < program.length();
    }

    /**
     * Getter for position of the lexer in the program
     * @return index of the current position of the scanner
     */
    public int getPosition() {
        return position;
    }
}
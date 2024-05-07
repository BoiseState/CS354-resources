package syntax;

/**
 * A Token for a programming language
 */
public class Token {

    private String token;
    private String lexeme;

    public Token(String token, String lexeme) {
        this.token = token;
        this.lexeme = lexeme;
    }

    public Token(String token) {
        this(token, token);
    }

    public String getToken() {
        return token;
    }

    public String getLexeme() {
        return lexeme;
    }

    public boolean equalType(Token t) {
        return this.token.equals(t.token);
    }

    public boolean equalType(String s) {
        return this.token.equals(s);
    }

    @Override
    public boolean equals(Object o) {
        Token t = null;
        if (o instanceof Token) {
            t = (Token) o;
        } else {
            return false;
        }
        return token.equals(t.getToken()) && lexeme.equals(t.getLexeme());
    }

    public String toString() {
        return "<" + getToken() + "," + getLexeme() + ">";
    }

}

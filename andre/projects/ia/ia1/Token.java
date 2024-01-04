// This class models a token, which has two parts:
// 1) the token itself (e.g., "id" or "+")
// 2) the token's lexeme (e.g., "foo")

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

    public String tok() {
        return token;
    }

    public String lex() {
        return lexeme;
    }


    @Override
    public boolean equals(Object o) {
        Token t = null;
        if (o instanceof Token) {
            t = (Token) o;
        }
        return token.equals(t.token);
    }

    public String toString() {
        return "<" + tok() + "," + lex() + ">";
    }

}

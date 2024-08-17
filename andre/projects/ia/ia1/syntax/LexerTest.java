package syntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for syntax.Lexer
 *
 * Uses Junit5.
 */
public class LexerTest {

    /**
     * Simply creates a 'program' that has only one token. When scanned,
     * the test checks to see that the current token is of the correct type.
     *
     * Try more than one Token in a different test case!
     * @throws SyntaxException - This suppresses the need for a try/catch block.
     */
    @Test
    public void test() throws SyntaxException{

        String prg = "4";
        Lexer lexer = new Lexer(prg);
        assertEquals(new Token("num", "4"), lexer.next());

        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }


    /**
     * Tests that the lexer can recognize an identifier
     *
     * @throws SyntaxException
     */
    @Test
    public void testOneIdentifier() throws SyntaxException{

        String prg = "x";
        Lexer lexer = new Lexer(prg);
        assertEquals(new Token("id", "x"), lexer.next());

        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }


    /**
     * Tests that the lexer can recognize an operator (the semicolon)
     * @throws SyntaxException
     */
    @Test
    public void testOneOperator() throws SyntaxException{

        String prg = ";";
        Lexer lexer = new Lexer(prg);

        assertEquals(new Token(";", ";"), lexer.next());

        assertEquals(new Token("EOF", "EOF"), lexer.next());
    }
}

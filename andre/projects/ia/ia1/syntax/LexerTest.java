package syntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for syntax.Scanner
 *
 * Uses Junit5.
 */
public class LexerTest {

    /**
     * Simply creates a 'program' that has only one token. When scanned,
     * the test checks to see that the current token is of the correct type.
     *
     * Try more than one syntax.Token in a different test case!
     * @throws SyntaxException - This suppresses the need for a try/catch block.
     */
    @Test
    public void test() throws SyntaxException{

        String prg = "4";
        Lexer lexer = new Lexer(prg);
        assertTrue(lexer.next());
        assertEquals(new Token("num", "4"), lexer.getCurrent());

        assertFalse(lexer.next());
        assertEquals(new Token("EOF", "EOF"), lexer.getCurrent());
    }


    /**
     * Tests that the scanner can recognize an identifier
     *
     * @throws SyntaxException
     */
    @Test
    public void testOneIdentifier() throws SyntaxException{

        String prg = "x";
        Lexer lexer = new Lexer(prg);

        assertTrue(lexer.next());
        assertEquals(new Token("id", "x"), lexer.getCurrent());

        assertFalse(lexer.next());
        assertEquals(new Token("EOF", "EOF"), lexer.getCurrent());
    }


    /**
     * Tests that the scanner can recognize an operator (the semicolon)
     * @throws SyntaxException
     */
    @Test
    public void testOneOperator() throws SyntaxException{

        String prg = ";";
        Lexer lexer = new Lexer(prg);

        assertTrue(lexer.next());
        assertEquals(new Token(";", ";"), lexer.getCurrent());

        assertFalse(lexer.next());
        assertEquals(new Token("EOF", "EOF"), lexer.getCurrent());
    }
}

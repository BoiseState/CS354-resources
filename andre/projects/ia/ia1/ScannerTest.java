import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Scanner
 *
 * Uses Junit5.
 */
public class ScannerTest {

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
        Scanner scanner = new Scanner(prg);
        assertTrue(scanner.next());
        assertEquals(new Token("num", "4"), scanner.getCurrent());

        assertFalse(scanner.next());
    }


    /**
     * Tests that the scanner can recognize an identifier
     *
     * @throws SyntaxException
     */
    @Test
    public void testOneIdentifier() throws SyntaxException{

        String prg = "x";
        Scanner scanner = new Scanner(prg);

        assertTrue(scanner.next());
        assertEquals(new Token("id", "x"), scanner.getCurrent());

        assertFalse(scanner.next());
    }


    /**
     * Tests that the scanner can recognize an operator (the semicolon)
     * @throws SyntaxException
     */
    @Test
    public void testOneOperator() throws SyntaxException{

        String prg = ";";
        Scanner scanner = new Scanner(prg);

        assertTrue(scanner.next());
        assertEquals(new Token(";", ";"), scanner.getCurrent());

        assertFalse(scanner.next());
    }
}

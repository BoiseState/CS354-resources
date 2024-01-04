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
     * Try more tokens in a different test case!
     * @throws SyntaxException - This suppresses the need for a try/catch block.
     */
    @Test
    public void test() throws SyntaxException{

        String prg = "4";
        Scanner scanner = new Scanner(prg);
        assertTrue(scanner.next());
        assertEquals(new Token("num"), scanner.getCurrent());

        assertFalse(scanner.next());
    }
}

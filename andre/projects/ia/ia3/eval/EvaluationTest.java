package eval;

import node.*;
import syntax.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * System tests for the semantic actions of the programming language.
 */
class EvaluationTest {

    private Parser parser;
    private Environment env;


    @BeforeEach
    void setUp() {

        parser = new Parser();
        env = new Environment();
    }

    @Test
    void testAssignment() throws SyntaxException, EvalException{
        String prg = "x = 1; wr x";

        double evaluation = parser.parse(prg).eval(env);
        assertEquals(1, evaluation);
    }

    @Test
    void testEvalError() throws SyntaxException {

        String prg = "wr x";
        Node parseTree = parser.parse(prg);

        assertThrows(EvalException.class, () -> {
            parseTree.eval(env);
        });
    }

    @Test
    void testAssociation() throws SyntaxException, EvalException{
        String prg = "wr 10 - 4 - 3";

        double evaluation = parser.parse(prg).eval(env);
        assertEquals(3, evaluation);
    }

    @Test
    void testPrecedence() throws SyntaxException, EvalException{
        String prg = "wr 6 / (10 - 8)";

        double evaluation = parser.parse(prg).eval(env);
        assertEquals(3, evaluation);
    }
}

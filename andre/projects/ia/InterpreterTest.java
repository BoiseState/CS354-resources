import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    private Parser parser;
    private Environment env;

    private final String testFilename = "test";

    @BeforeEach
    void setUp() {
        System.setProperty("Code", testFilename);

        parser = new Parser();
        env = new Environment();
    }

    @AfterEach
    void tearDown() {

        File prg = new File(testFilename);
        File sourceFile = new File(testFilename + ".c");

        prg.delete();
        sourceFile.delete();
    }

    @Test
    public void testMinus() throws SyntaxException, EvalException, IOException {
        String prg = "x=1-2;";
        Integer exp = -1;

        Node node = parser.parse(prg);
        assertEquals(node.eval(env), exp);

        new Code(node.code(), env);

        BufferedReader br  = compileAndRun();

        String output = br.readLine();

        assertEquals(exp.toString(), output);

    }

    @Test
    public void testTwo() throws SyntaxException, EvalException, IOException {

        String[] prgs = {
                "x = 1 + 2;",
                "y = x + 3;"
        };

        Integer[] exps = {
                3,
                6
        };

        String code = "";

        for (int i = 0; i < prgs.length; i++) {
            Node node = parser.parse(prgs[i]);
            assertEquals(node.eval(env), exps[i]);
            code += node.code();
        }

        new Code(code, env);

        BufferedReader output = compileAndRun();

        for (int i = 0; i < prgs.length; i++) {
            assertEquals(exps[i].toString(), output.readLine());
        }
    }

    private BufferedReader compileAndRun() {
        File dir = new File("./");
        String cSourceFile = testFilename + ".c";
        try {
            Process pCompile = Runtime.getRuntime().exec("gcc -Wall " + cSourceFile + " -o " + testFilename, null, dir);
            pCompile.waitFor();

            if (pCompile.exitValue() != 0) {
                System.err.println("Compilation Failed");

                BufferedReader br = new BufferedReader(new InputStreamReader(pCompile.getErrorStream()));
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.err.println(line);
                }

                fail();
            }


            Process pRun = Runtime.getRuntime().exec("./" +  testFilename, null, dir);

            BufferedReader br = new BufferedReader(new InputStreamReader(pRun.getInputStream()));

            return br;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}





















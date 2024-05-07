import eval.Environment;
import eval.EvalException;
import syntax.Parser;
import syntax.SyntaxException;

import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * A simple REPL for the interpreter
 */
public class Interpreter {

    private static final String EXIT_CMD = ""; //TODO: add your own command
    private static final String CLEAR_CMD = ""; //TODO: add your own command
    private static final String PROMPT = ""; //TODO: add your own command

    private static void repl() {

        Parser parser = new Parser();
        Environment env = new Environment();

        /*
         * begin interactive interpreter
         */
        java.util.Scanner scan = new java.util.Scanner(System.in);

        System.out.print(PROMPT);

        String line;
        while (scan.hasNext()) {

            try {
                line = scan.nextLine();
                switch (line) {
                    case EXIT_CMD:
                        System.out.println(""); //TODO, add you own comment!
                        System.exit(0);
                    case CLEAR_CMD:
                        System.out.println("Clearing environment..."); //TODO, add you own comment!
                        env = new Environment();
                        break;
                    default:
                        parser.parse(line).eval(env);
                        break;
                }
            } catch (SyntaxException | EvalException e) {
                System.out.println(PROMPT + e);
            }

            System.out.print(PROMPT);
        }
        scan.close();

    }

    private static void file(String filename) {

        try {
            String prg = Files.readString(Paths.get(filename));

            Parser parser = new Parser();
            Environment env = new Environment();

            parser.parse(prg).eval(env);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printUsage() {
        System.out.println("java Interpreter [-f file]");
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            repl();
        } else if (args.length == 2) {

            if (args[0].equals("-f")) {
                file(args[1]);
            }

        } else {
            printUsage();
            System.exit(-1);
        }
    }
}


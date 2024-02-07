/**
 * A simple REPL for your interpreter
 */
public class Interpreter {

    private static final String EXIT_CMD = ""; //TODO!
    private static final String CLEAR_CMD = " "; //TODO!
    private static final String PROMPT = ""; //TODO!

    public static void main(String[] args) {

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
                        System.out.println(""); //TODO!
                        System.exit(0);
                    case CLEAR_CMD:
                        System.out.println(""); //TODO
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
}


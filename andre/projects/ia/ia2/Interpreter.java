/* 
* This is the main class/method for the interpreter.
* Each command-line argument is a complete program,
* which is scanned, parsed, and evaluated.
* All evaluations share the same environment,
* so they can share variables.
*/
public class Interpreter {
    public static void main(String[] args) 
    {
        Parser parser=new Parser();
        for (String stmt: args)
	    try 
            {
		System.out.println(parser.parse(stmt).toString());
		
	    } catch (SyntaxException e) {
	    	e.printStackTrace();
	    	System.err.println(e);
	    }
    }

}

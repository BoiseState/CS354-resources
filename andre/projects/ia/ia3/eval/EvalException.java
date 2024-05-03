package eval;// (C) 2013 Jim Buffenbarger
// All rights reserved.

/**
 * A runtime exception
 * @author jim Buffenbarger
 */
public class EvalException extends Exception {

    private int pos;
    private String msg;

    public EvalException(int pos, String msg) {
	this.pos=pos;
	this.msg=msg;
    }

    public String toString() {
	return "eval error"
	    +", pos="+pos
	    +", "+msg;
    }

}

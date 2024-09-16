package node;

import syntax.*;

/**
 * TODO:
 */
public class Addop extends Node {

    protected Token addop;

    public Addop(int position, Token addop) {

        this.position = position;
        this.addop = addop;
    }
}

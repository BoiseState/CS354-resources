package node;

import java.lang.reflect.Field;

/**
 *
 */
public abstract class Node {

    protected int position = 0;

    protected static int indent = 0;

    /**
     * From <a href="http://www.javapractices.com/topic/TopicAction.do?Id=55">...</a>
     * Using reflection to recursively print each member of each subclass in the tree.
     * @return a string of parenthesised tree nodes.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(this.getClass().getName());

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        //print field names paired with their values
        for (Field field : fields) {
            result.append("\n");
            indent++;
            for (int i = 0; i < indent; i++) {
                result.append("──");
            }
            try {
                result.append(" " + field.getName());
                result.append(": ");
                //requires access to private field:
                result.append(field.get(this));
            } catch (IllegalAccessException ex) {
                System.out.println(ex);
            }
            indent--;
        }

        return result.toString();
    }
}

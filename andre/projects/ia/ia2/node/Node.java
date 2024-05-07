package node;

import java.lang.reflect.Field;

/**
 * TODO:
 */
public abstract class Node {

    protected int position = 0;

    /**
     * From <a href="http://www.javapractices.com/topic/TopicAction.do?Id=55">...</a>
     * Using reflection to recursively print each member of each subclass in the tree.
     * @return a string of parenthesised tree nodes.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(this.getClass().getName());
        result.append(" (");

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        //print field names paired with their values
        for (Field field : fields) {
            result.append(" ");
            try {
                result.append(field.getName());
                result.append(": ");
                //requires access to private field:
                result.append(field.get(this));
            } catch (IllegalAccessException ex) {
                System.out.println(ex);
            }
        }
        result.append(" )");

        return result.toString();
    }
}

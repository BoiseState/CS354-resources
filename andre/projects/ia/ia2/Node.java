import java.lang.reflect.Field;

// This class, and its subclasses,
// collectively model parse-tree nodes.
// Each kind of node can be eval()-uated.

public abstract class Node {

    public int pos=0;
    
    
    public String toString() {
    	  StringBuilder result = new StringBuilder();

    	  result.append( this.getClass().getName() );
    	  result.append( " ( " );

    	  //determine fields declared in this class only (no fields of superclass)
    	  Field[] fields = this.getClass().getDeclaredFields();

    	  //print field names paired with their values
    	  for ( Field field : fields  ) {
    	    result.append("  ");
    	    try {
    	      result.append( field.getName() );
    	      result.append(": ");
    	      //requires access to private field:
    	      result.append( field.get(this) );
    	    } catch ( IllegalAccessException ex ) {
    	      System.out.println(ex);
    	    }
    	  }
    	  result.append(" ) ");

    	  return result.toString();
    	}
    
    


}

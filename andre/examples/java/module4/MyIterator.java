
import java.util.Iterator;
import java.util.ArrayList;


public class MyIterator {

	public static void main(String[] args) {

		ArrayList<Integer> collection = new ArrayList<>();

		for (int i = 0; i < 10; i++ ) {
			collection.add(i);
		}

		Iterator<Integer> it = collection.iterator(); 

		while (it.hasNext()) {

			System.out.println(it.next());
		}
	}

}

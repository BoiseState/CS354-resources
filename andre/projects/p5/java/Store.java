import java.util.HashMap;
import java.util.Set;

public class Store {

    private HashMap<String, Integer> map;

    public Store() {
        map = new HashMap<>();
    }

    /**
     * Insert a key into the Store.
     * If the key is already in the store, its value is incremented,
     * indicating the frequency that the key has been added to the store.
     *
     * @param key - the key to insert
     *
     *     If called in this succession:
     *     "bhietsch"
     *     "ottwiz"
     *     "ottwiz"
     *
     *     The map will contain:
     *     "bhietsch" 1
     *     "ottwiz"   2
     *
     */
    public void addToStore(String key) {

        if (map.containsKey(key)) {
            Integer num = map.get(key);
            map.replace(key, num + 1);
        } else {
            map.put(key, 1);
        }
    }

    /**
     * Transform the Store into a
     * @return a String the contains each value, in the following format
     *
     *
     *     If the map contains:
     *     "bhietsch" 1
     *     "ottwiz"   2
     *
     *     The string produced will be:
     *     "bhietsch:1
     *     ottwiz:2
     *     "
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Set<String> keys = map.keySet();

        for (String key : keys) {
            Integer value = map.get(key);
            sb.append(key).append(":").append(value).append("\n");
        }
        return sb.toString();
    }
}

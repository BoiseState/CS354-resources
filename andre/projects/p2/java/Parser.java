import java.io.File;

public class Parser {

    private Store store;
    private int numberOfFeaturesChecked;

    /**
     *
     * @param filename - a file with data that is assumed to be valid JSON
     * @param store -
     */
    public Parser(String filename, Store store) {
        File file = new File(filename);
        this.store = store;
        this.numberOfFeaturesChecked = 0;
    }

    /**
     * The parse method recursively traverses the JSON found in file,
     * and if it finds a specific tag,
     *
     * For example, if the input JSON is
     * {
     * "type": "FeatureCollection",
     * "features": [
     * {
     *   "type": "Feature",
     *   "id": "relation/6023246",
     *   "properties": {
     *     "timestamp": "2022-09-20T01:21:58Z",
     *     "version": "14",
     *     "changeset": "126400845",
     *     "user": "bhietsch",
     *     "uid": "5390272",
     *     "boundary": "protected_area",
     *     "name": "Boise National Forest",
     *     "operator": "United States Forest Service",
     *     "operator:short": "USFS",
     *     "operator:type": "public",
     *     "operator:wikidata": "Q1891156",
     *     "operator:wikipedia": "en:United States Forest Service",
     *     "ownership": "national",
     *     "protect_class": "6",
     *     "protected": "perpetuity",
     *     "protection_title": "National Forest",
     *     "type": "boundary",
     *     "id": "relation/6023246"
     *   }
     *  },
     *  {
     *   "type": "Feature",
     *   "id": "relation/15486139",
     *   "properties": {
     *     "timestamp": "2023-02-16T22:24:11Z",
     *     "version": "1",
     *     "changeset": "132650868",
     *     "user": "ottwiz",
     *     "uid": "3087157",
     *     "natural": "wood",
     *     "type": "multipolygon",
     *     "id": "relation/15486139"
     *   }
     *  ]
     * }
     *
     *     and tag is "user"
     *     Parser will add to the store
     *     "bhietsch"
     *     "ottwiz"
     *
     */
    public void parse(String tag) {
        /*
            TODO:
         */
    }

    /**
     * Returns an internal count of the number of features checked during parse()
     */
    @Override
    public String toString() {
        return "Feature Count: " + numberOfFeaturesChecked;
    }
}

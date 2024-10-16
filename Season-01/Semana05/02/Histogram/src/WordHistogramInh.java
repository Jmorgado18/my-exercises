import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordHistogramInh extends HashMap<String, Integer> implements Iterable<String> {
    private String STRING;
    private int counter = 1;

    private String[] words;

    public WordHistogramInh(String STRING) {
        words = STRING.split(" ");


        for (String word : words) {
            if (containsKey(word)) {
                replace(word, get(word) + 1);
            } else {
                put(word, 1);
            }

        }

    }


    @Override
    public Iterator<String> iterator() {
        return keySet().iterator();
    }

}



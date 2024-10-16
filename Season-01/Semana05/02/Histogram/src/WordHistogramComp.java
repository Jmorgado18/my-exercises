import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WordHistogramComp implements Iterable<String> {
    private String STRING;
    private int counter = 1;
    private HashMap<String, Integer> histogram;
    private String[] words;

    public WordHistogramComp(String STRING) {
        words=STRING.split(" ");

        this.histogram = new HashMap<>();
        for (String word : words) {
            if (this.histogram.containsKey(word)) {
                this.histogram.replace(word,histogram.get(word)+1);
            }
            else {
                this.histogram.put(word, 1);
            }

        }

    }

    public int get(String string) {
        return this.histogram.get(string);

    }

    @Override
    public Iterator iterator() {
        return this.histogram.keySet().iterator();
    }
    public int size(){
        return this.histogram.size();
    }
}

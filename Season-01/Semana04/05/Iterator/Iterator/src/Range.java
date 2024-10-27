import java.util.Iterator;

public class Range implements Iterable<Integer> {
    private int start;
    private int end;
    private boolean [] removeNr;


    public Range(int start, int end) {
        this.start = start;
        this.end = end;

    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyLitleLiterator(this.start, this.end);
    }

    public void remove(int i){
        for (int j = start; j < end; j++) {
            
        }
    }


}

import java.util.Iterator;

public class MyLitleLiterator implements Iterator<Integer> {

    private int current;
    private int end;

    public MyLitleLiterator(int start, int end) {
        this.current= start;
        this.end = end;
    }
   @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }


}

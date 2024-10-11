import java.util.Iterator;

public class MyLitleLiterator implements Iterator<Integer> {


    private int end;
    private int count;

    public MyLitleLiterator(int start, int end) {

        this.end = end;
        this.count = start;
    }

    @Override
    public boolean hasNext() {

        return count < end;
    }

    @Override
    public Integer next() {

        count++;
        return count;
    }


}

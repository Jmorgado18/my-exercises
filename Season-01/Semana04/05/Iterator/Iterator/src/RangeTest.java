import java.util.Iterator;

public class RangeTest {
    public static void main(String[] args) {
        Range r = new Range(-6, 5);
        System.out.println(("---USING ITERATOR---"));
        Iterator<Integer> it = r.iterator();

        /*
        while (it.hasNext()){
        int i = it.next();
        if (i == 1 || i == 2 || i == 3) {
        it.remove();
        }
        }
         */
        for (Integer i : r) {
            System.out.println("Iterated : " + i);
        }


    }


}

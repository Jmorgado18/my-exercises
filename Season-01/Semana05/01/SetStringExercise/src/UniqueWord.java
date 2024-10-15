import java.io.ObjectStreamException;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class UniqueWord implements Iterable<String> {

    private TreeSet<String> seti;

    public UniqueWord(String string){
        this.seti=new TreeSet<>(List.of(string.split(" ")));

    }

@Override
    public Iterator iterator() {
        return seti.iterator();
    }
}

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BruinArrayListIterator<E> implements Iterator<E> {

    private final BruinArrayList<E> list;
    private int index = 0;

    public BruinArrayListIterator(BruinArrayList<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return list.get(index++);
    }
}
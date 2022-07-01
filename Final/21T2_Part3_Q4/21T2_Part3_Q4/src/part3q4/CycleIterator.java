package part3q4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CycleIterator<E> implements Iterator<E> {
    private Cycle<E> myCycle;

    @Override
    public boolean hasNext() {
        if (myCycle.isEmpty())  {
//            throw NoSuchElementException;
            return false;
        }
        return true;
    }

    @Override
    public E next() {
        if (myCycle.isEmpty()) {
            return null;
        }

        return null;
    }
 
}

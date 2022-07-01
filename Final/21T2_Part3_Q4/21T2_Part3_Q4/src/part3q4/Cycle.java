package part3q4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cycle<E> implements Iterable<E>{
    /** 
     * finite sequence of elements which will be repeated in the cycle infinitely
     */
    private final ArrayList<E> sublist;

    public Cycle(List<E> initialSublist) {
        sublist = new ArrayList<>(initialSublist);
    }

    /**
     * return the size of the cycle - infinity if 1 or more elements, otherwise 0
     */
    public double size(){
        if (isEmpty()) {
            return 0;
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    /**
     * return whether the cycle is empty
     */
    public boolean isEmpty() {
        return sublist.isEmpty();
    }

    /**
     * return whether the cycle contains this object
     */
    public boolean contains(Object o) {
        return sublist.contains(o);
    }

    /**
     * add element to the cycle
     */
    public boolean add(E e) {
        return sublist.add(e);
    }

    /**
     * remove first instance of the input value
     */
    public boolean remove(Object o) {
        return sublist.remove(o);
    }

    public String toString() {
        return getClass().getSimpleName() + " sublist=" + sublist;
    }

    /**
     * create and return iterator for the cycle (infinitely repeating)
     */
    @Override
    public Iterator<E> iterator() {
        return sublist.listIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Cycle<E> other = (Cycle<E>) o;
        if (this.size() != other.size()) {
            return false;
        }
        for (Object i : other) {
            if (!i.equals(other)) {
                return false;
            }
        }

        return true;
    }
}

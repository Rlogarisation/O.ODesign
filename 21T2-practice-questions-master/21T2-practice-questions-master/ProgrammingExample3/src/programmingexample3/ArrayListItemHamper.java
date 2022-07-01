package programmingexample3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A hamper implemented using an ArrayList.
 *
 * @author Matthew Perry
 *
 * @invariant for all c in counts, c.getCount() > 0
 *
 * @param <E>
 */
public class ArrayListItemHamper<E extends Item> implements Hamper<E> {

    private ArrayList<Count<E>> counts;

    /**
     * Create a new empty hamper.
     */
    public ArrayListItemHamper() {
        this.counts = new ArrayList<Count<E>>();
    }

    private Count<E> getCount(Object o) {
        for (Count<E> c : counts)
            if (c.getElement().equals(o))
                return c;
        return null;
    }

    @Override
    public void add(E e) {
        add(e,1);
    }

    @Override
    public void add(E e, int n) {
        Count<E> c = getCount(e);
        if (c != null) {
            c.incrementCount(n);
        } else if (n > 0) {
            counts.add(new Count<E>(e, n));
        }
    }

    @Override
    public void remove(E e) {
        remove(e, 1);
    }

    @Override
    public void remove(E e, int n) {
        Count<E> c = getCount(e);
        // Do nothing if no e found.
        if (c == null) {
            return;
        }
        // If there is more e than we need to remove
        if (count(c) > n) {
            c.decrementCount(n);
        }
        else {
            counts.remove(c);
        }
    }


    @Override
    public int count(Object o) {
        Count<E> c = getCount(o);
        if (c != null)
            return c.getCount();
        return 0;
    }

    @Override
    public int size() {
        int counter = 0;
        while (counts.get(counter) != null) {
            counter++;
        }
        return counter;
    }

    @Override
    public Hamper<E> sum(Hamper<? extends E> hamper) {
        // I need to create a new Hamper array for the sum.
        Hamper<E> sumOfHamper = new ArrayListItemHamper<>();
        // add our hamper to sumOfHapmer.
        for (Count<E> i : counts)  {
            sumOfHamper.add(i.getElement(), i.getCount());
        }
        // add given hamper to sumOfHamper.
        var HamperItem = hamper.iterator();
        while (HamperItem.hasNext()) {
            var c = HamperItem.next();
            sumOfHamper.add(c.getElement(), c.getCount());
        }

        return sumOfHamper;
    }

    @Override
    public Iterator<Count<E>> iterator() {
        return counts.iterator();
    }

    /**
     * For this method, hampers should be the same class to be equal (ignore the generic type component).
     * For example, a CreativeHamper cannot be equal to a FruitHamper,
     * And a FruitHamper cannot be equal to an ArrayListItemHamper<Fruit>,
     * However an ArrayListItemHamper<Fruit> can be equal to a ArrayListItemHamper<Item>
     * if they both only contain fruit.
     * HINT: use getclass() to compare objects.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        ArrayListItemHamper<?> other = (ArrayListItemHamper<?>) o;
        if (this.size() != other.size()) {
            return false;
        }



        return true;
    }

    /**
	 * 
	 * @return price of the hamper - for ArrayListItemHamper,
     * this should be the sum of the prices of items
     * with each price multiplied by the number of times that item occurs
	 */
	@Override
    public int getPrice() {
        int sum = 0;
        for (Count<E> i : counts) {
            E myObj = i.getElement();
            sum += myObj.getPrice() * i.getCount();
        }
        return sum;
    }

    @Override
    public String toString(){
        return counts.toString();
    }
}

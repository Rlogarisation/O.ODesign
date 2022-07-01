package part3q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class TestCycle {
    /** Run the main method to run five sets of tests.
     * 
     *  Incremental testing: select only one test method, 
     *  comment out other test methods, and run it.
     * 
     *  Batch testing: you can also run all the test methods 
     *  together, if you wish.
     */

    public static void main(String[] args) {
        simpleTest();
        simpleEqualsTest();
        testEmptyCycleEquals();
        equalsTestShiftRight();
        equalsTestShiftLeft();
        equalsTestRepeatingCycle();
        testIteratorOneValue();
        testIteratorTwoValues();
        testIteratorEmptyCycle();
    }

    public static void simpleTest() {
        // this test should pass, as long as you don't change the methods given to you. This test is worth very little marks, as it works when given to you.
        // cycle 1
        Cycle<String> cycle1 = new Cycle<>(new ArrayList<>());

        assertEquals(0.0, cycle1.size());
        assertTrue(cycle1.isEmpty());

        cycle1.add("Apple");
        cycle1.add("Banana");
        cycle1.add("Pear");

        assertEquals(Double.POSITIVE_INFINITY, cycle1.size());
        assertFalse(cycle1.isEmpty());

        cycle1.add("Apricot");
        cycle1.add("Pineapple");

        assertEquals(Double.POSITIVE_INFINITY, cycle1.size());
        assertFalse(cycle1.isEmpty());

        // cycle 2
        Cycle<String> cycle2 = new Cycle<>(new ArrayList<>(Arrays.asList("Apple", "Banana", "Pear")));

        assertTrue(cycle2.contains("Apple"));
        assertFalse(cycle2.isEmpty());

        cycle2.remove("Apple");

        assertFalse(cycle2.contains("Apple"));
        assertFalse(cycle2.isEmpty());

        cycle2.add("Apple");
        cycle2.add("Apple");

        cycle2.remove("Apple");

        assertTrue(cycle2.contains("Apple"));
        assertFalse(cycle2.isEmpty());

        cycle2.remove("Apple");
        cycle2.remove("Banana");
        cycle2.remove("Pear");
        assertEquals(0.0, cycle2.size());
        assertTrue(cycle2.isEmpty());

        // cycle 3
        Cycle<String> cycle3 = new Cycle<>(new ArrayList<>());

        assertEquals(0.0, cycle3.size());
        assertTrue(cycle3.isEmpty());

        cycle3.add("Apple");

        assertEquals(Double.POSITIVE_INFINITY, cycle3.size());
        assertFalse(cycle3.isEmpty());

        cycle3.remove("Apple");
        assertEquals(0.0, cycle3.size());
        assertTrue(cycle3.isEmpty());

        assertEquals("Cycle sublist=[Apple, Banana, Pear, Apricot, Pineapple]", cycle1.toString());
    }

    public static void simpleEqualsTest() {
        Cycle<String> cycle1 = new Cycle<>(new ArrayList<>(Arrays.asList("Apple", "Banana", "Pear")));
        Cycle<String> cycle2 = new Cycle<>(new ArrayList<>(Arrays.asList("Apple", "Banana", "Pear")));
        assertEquals(cycle1, cycle2);

        cycle1.add("Mango");
        assertNotEquals(cycle1, cycle2);
    }

    public static void testEmptyCycleEquals() {
        Cycle<String> cycle1 = new Cycle<>(new ArrayList<>());
        Cycle<String> cycle2 = new Cycle<>(new ArrayList<>());
        assertEquals(cycle1, cycle2);
        assertEquals(cycle2, cycle2);

        cycle2.add("Apple");
        assertNotEquals(cycle1, cycle2);
        assertEquals(cycle2, cycle2);
    }

    public static void equalsTestShiftRight() {
        Cycle<String> cycle1 = new Cycle<>(new ArrayList<>(Arrays.asList("Apple", "Banana", "Pear")));
        Cycle<String> cycle2 = new Cycle<>(new ArrayList<>(Arrays.asList("Pear", "Apple", "Banana")));
        assertEquals(cycle1, cycle2);

        cycle2.add("Mango");
        assertNotEquals(cycle1, cycle2);
    }

    public static void equalsTestShiftLeft() {
        Cycle<String> cycle1 = new Cycle<>(new ArrayList<>(Arrays.asList("Apple", "Banana", "Pear")));
        Cycle<String> cycle2 = new Cycle<>(new ArrayList<>(Arrays.asList("Banana", "Pear", "Apple")));
        assertEquals(cycle1, cycle2);

        cycle2.add("Mango");
        assertNotEquals(cycle1, cycle2);

        Cycle<String> cycle3 = new Cycle<>(new ArrayList<>(Arrays.asList("Apple", "Banana", "Apricot")));
        Cycle<String> cycle4 = new Cycle<>(new ArrayList<>(Arrays.asList("Apple", "Apricot", "Banana")));
        assertNotEquals(cycle3, cycle4);

    }

    public static void equalsTestRepeatingCycle() {
        Cycle<String> cycle1 = new Cycle<>(new ArrayList<>(Arrays.asList("Apple", "Banana", "Apple", "Banana")));
        Cycle<String> cycle2 = new Cycle<>(new ArrayList<>(Arrays.asList("Apple", "Banana")));
        assertEquals(cycle1, cycle2);

        Cycle<String> cycle3 = new Cycle<>(new ArrayList<>(Arrays.asList("Apple", "Banana", "Apple", "Banana")));
        Cycle<String> cycle4 = new Cycle<>(new ArrayList<>(Arrays.asList("Banana")));
        assertNotEquals(cycle3, cycle4);
    }

    public static void testIteratorOneValue() {
        Cycle<String> cycle = new Cycle<>(new ArrayList<>(Arrays.asList("Apple")));
        Iterator<String> iterator = cycle.iterator();
        for (int i = 0; i < 100; i++) {
            assertEquals("Apple", iterator.next());
        }
    }

    public static void testIteratorTwoValues() {
        Cycle<String> cycle = new Cycle<>(new ArrayList<>(Arrays.asList("Apple", "Banana")));
        Iterator<String> iterator = cycle.iterator();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                assertEquals("Apple", iterator.next());
            } else {
                assertEquals("Banana", iterator.next());
            }
        }
    }

    public static void testIteratorEmptyCycle() {
        Cycle<String> cycle = new Cycle<>(new ArrayList<>());
        Iterator<String> iterator = cycle.iterator();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    private static<E extends Throwable, R> void assertThrows(Class<E> exception, Supplier<R> executable) {
        try {
            executable.get();
        }
        catch (Throwable actualException) {
            if (!exception.isInstance(actualException)) {
                throw new RuntimeException("Was expecting exception " + exception.getSimpleName() + " but got " + actualException.getClass().getSimpleName() + " with message " + actualException.getMessage());
            } else {
                return;
            }
        }

        throw new RuntimeException("Was expecting exception " + exception.getSimpleName() + " but no exception was thrown");
    }

    private static<T extends Number, K extends Number> void assertEquals(T a, K b) {
        // loss of precision is fine for the cycles we'll be testing.
        if (Double.compare(a.doubleValue(), b.doubleValue()) != 0) {
            throw new RuntimeException("Was expecting " + a.toString() + " = " + b.toString() + " but they are not equal");
        }
    }

    private static void assertEquals(Object a, Object b) {
        if (!a.equals(b)) {
            throw new RuntimeException("Was expecting cycle [" + a.toString() + "] = [" + b.toString() + "] but .equals() returned false");
        }
    }

    private static void assertNotEquals(Object a, Object b) {
        if (a.equals(b)) {
            throw new RuntimeException("Was expecting cycle [" + a.toString() + "] != [" + b.toString() + "] but .equals() returned true");
        }
    }

    private static void assertTrue(boolean b) {
        if (!b) {
            throw new RuntimeException("Was expecting true got false");
        }
    }

    private static void assertFalse(boolean b) {
        if (b) {
            throw new RuntimeException("Was expecting false got true");
        }
    }
}

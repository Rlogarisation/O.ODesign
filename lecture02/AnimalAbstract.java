/**
 * Data abstraction is the process of hiding certain details 
 * and showing only essential information to the user.
 * it is not possible to create an object of the Animal class:
 * Animal myObj = new Animal(); // will generate an error
 */

/**
 * The advantage of Abstract class is :
 * In each sub-class,
 * we could define different animal sound for different sub-class animals.
 * And print/other operation all animal sounds out with one command.
 */

// Abstract class
abstract class AnimalAbstract {
    // Abstract method (does not have a body)
    public abstract void animalSound();
    // Regular method
    public void sleep() {
        System.out.println("Zzz");
    }
}
  
  // Subclass (inherit from Animal)
class Pig extends AnimalAbstract {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
}
  
class Main {
    public static void main(String[] args) {
        Pig myPig = new Pig(); // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
    }
}

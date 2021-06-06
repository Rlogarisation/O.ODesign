public class Animal { // Superclass (parent)
    public void soundOfAnimal() {
        System.out.println("The animals make a sound.");
    }
}

// Usage of extends see Vehicle.java.
public class Dog extends Animal { // Subclass (child)
    public void dogSound() {
        super.soundOfAnimal();
        System.out.println("The dog will bark!!!");
    }
}

public class Main {
    public static void main(String[] args) {
        var myDog = new Dog();
        myDog.dogSound();
    }
}

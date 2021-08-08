[TOC]

------

# Summary of COMP2511

## Week01: Introduction to OOP

### Key Concepts

- Abstraction
  - Abstract class: focus on the common properties and behaviours of objects.
- Encapsulation
  - Hiding the object's attribute by implementing private attributions, and access these attributions through getter and setter methods, in order to keep data safe, increase the usability, and reduce dependencies between classes(loose coupling, strong cohesion).
- Inheritance
  - Relationship between class with more general concept(parent) and more specialised class(child).
  - "is-a" type relationship.
  - new classes are created from the existing classes by absorbing their attributes and behaviours.
  - More methods can be added in sub-classes, and the inherited method can be over-ridden in sub-classes.
  - Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance.
- Composition
  - "has-a" relationship.
  - Class object has an object of another class to store its state or do its work. e.g. Rectangle and line.
  - Prefer composition over inheritance.

### Lecture Sample Code

1. Circle.java -> simpliest version without any getter or setter.

2. CircleWithGetter.java -> Circle with getter and setter.

3. Hello folder -> Demonstrated basic usage and way to complie.

4. Vehicle.java -> Subclasses (implemented by extend)

5. Animal.java -> Superclass or parent (implemented by super).

6. Static.java -> explain the usage of static, and difference between use static and no using it.

7. Private.java -> The private keyword is an access modifier used for attributes, methods and constructors, making them only accessible within the declared class.

8. Protected.java -> The protected keyword is an access modifier used for attributes, methods and constructors, making them accessible in the same package and subclasses.

   * Most restricted -> Less restricted: 

   * Private(Same class only) -> default(same package only)->Protected(Same packages or subclasses) -> Public(all other classes)

9. CircleSuper folder -> Way to compare two different input objects.

   ```java
   // Object obj basically takes into any type of input, 
   // and proceed in the function.
   @Override
   public boolean equals(Object obj) {
       if(obj == null) { return false; }
       // Comparing two address at this line,
       // If two addresses are equal,
       // then it must return true.
       // Otherwise keep proceed to check whether they're equal.
       if(obj == this) { return true; }
   
       // Does it mean the name of the class? e.g Circle?
       // Yes.
       if(this.getClass() != obj.getClass()){
           return false;
       }
   
       // Object cannot changed adaptively to current class.
       // Hence we need to specify the class.
       Circle other = (Circle) obj;
   
       // Then finally compare the key values in the class.
       if(this.x == other.x && this.y == other.y && this.r == other.r){
           return true;
       }
       else {
           return false;
       }
   }
   ```

   

10. Iterating array.

    ```java
    int array[] = {1, 2, 3, 4, 5};
    for (int elem : array) {
      result += elem;
    }
    ```

    

------

## Week 02: Introduction to OOP(Cont.)

### Key Concepts

 * Method forwarding
   * It uses methods from quoted class, to define some of the new method. (detailed in GraphicalCircle2.java)
 * Super classes
   * Every class has a superclass, by default, the superclass is class Object.
   * That is why we need to use overriding method for toString(), equals(), and hasCode() etc.
 * Single inheritance
   * Java only allows a new class can extend only one superclass, to avoid potential collision with different super functions.
 * Interfaces
   * Variables must be static and final in interface.
   * A class can implement more than 1 interface, and extend 1 superclass in the same time. 

### Questions

- What is the difference between Method forwarding and inheritance other than "has-a" "is-a" relationship? Why method forwarding is prefered in most cases? 

  The lecturer stated: "the advantage is that we are only forwarding the function we need, rather than extending everything. I don't care if someone remove the other function tomorrow" , "and we could also modify on the base of this."

- What is package?

  A package in Java is used to group related classes. Think of it as **a folder in a file directory**. We use packages to avoid name conflicts, and to write a better maintainable code.

### Lecture Sample Code

1. Shapes/Circle.java: Super class.

2. Shapes/GraphicalCircle.java: super class with **is-a** relationship, GraphicalCircle **is-a** Circle.

   ```java
   @Override
   public boolean equals(Object obj) {
   
       if(super.equals(obj) == false) { return false; } 
   
       GraphicalCircle other = (GraphicalCircle) obj;
   
       if(other.outline.equals(this.outline) && 
          other.fill.equals(this.fill)) {
           return true;
       }
       else{
           return false;
       }
   }
   ```

3. Shapes/GraphicalCircle2.java: **Has-a** relationship, a GraphicalCircle has a Circle.

   ```java
    // here's the math circle
    Circle c;
    // The new graphics variables go here
    Color outline, fill;
   
    // Very simple constructor
    public GraphicalCircle2() {
     c = new Circle();
     this.outline = Color.black;
     this.fill = Color.white;
    }
   
    // Another simple constructor
    public GraphicalCircle2(int x, int y, int r, 
          Color o, Color f) {
     c = new Circle(x, y, r);
     this.outline = o;
     this.fill = f;
    }
   ```

   But worth mention the we need to method forwarding for the function we need only.

   ```java
   public double area() {
     return c.area(); // Using the function in c from Circle().
   }
   
   public double circumference() {
     return c.circumference();
   }
   ```

   

4. AnimalAbstract.java : 

   Introduces abstract classes and methods. Abstraction classes can only be used thro extend. 

   The advantage of Abstract class is : 

   In each sub-class, we could define different animal sound for different sub-class animals.

   And print/other operation all animal sounds out with one command.

   

5. This explain the significance of Abstract. The area of different shape/ sub-classes can be sum up in one line.

   ```java
   // create an array to hold shapes
     Shape[] shapes = new Shape[4];    
     shapes[0] = new Circle(4, 6, 2);
     shapes[1] = new Rectangle(1.0, 3.0);
     shapes[2] = new Rectangle(4.0, 2.0);
     shapes[3] = new GraphicalCircle(1, 1, 6, 
            Color.green, Color.yellow);
   
     double total_area = 0;
   
     for(int i = 0; i < shapes.length; i++) {
      
      // Compute the area of the shapes using
      // polymorphism (behaviour) below.
      
      total_area += shapes[i].area();    
       }
   ```

6. Another way to achieve abstraction in Java, is with interfaces.

   An interface is a completely "**abstract class**" that is used to group related methods with empty bodies:

   In simply words, it is equivalent to .h file in c.

   ```java
   // Interface
   interface Animal {
     public void animalSound(); // interface method (does not have a body)
     public void sleep(); // interface method (does not have a body)
   }
   
   // Pig "implements" the Animal interface
   class Pig implements Animal {
     public void animalSound() {
       // The body of animalSound() is provided here
       System.out.println("The pig says: wee wee");
     }
     public void sleep() {
       // The body of sleep() is provided here
       System.out.println("Zzz");
     }
   }
   
   class Main {
     public static void main(String[] args) {
       Pig myPig = new Pig();  // Create a Pig object
       myPig.animalSound();
       myPig.sleep();
     }
   }
   ```

7. instanceof is type comparison function.

   ```java
   // instanceof will match objects of types Circle and its subclasses under circle like GraphicalCircle.
   // if shapes[i] has type GraphicalCircle, then this statement still true.
   if(shapes[i] instanceof Circle ) {
     count_circle++;
   }
   
   // the following will only match Circle ONLY.
   if(shapes[i].getClass() == Circle.class){
     onlyCircleClass_count++;
   }
   ```

8. Shapes/Shape.java is a abstract file, equivalent to .h.

9. Shapes/TestCircle.java is main file.

10. ShapesInterface/ introduced interfaces and implementations.

11. ArrayList:

    The `ArrayList` class is a resizable [array](https://www.w3schools.com/java/java_arrays.asp), which can be found in the `java.util` package.

    The difference between a built-in array and an `ArrayList` in Java, is that the size of an array cannot be modified (if you want to add or remove elements to/from an array, you have to create a new one). While elements can be added and removed from an `ArrayList` whenever you want.

    ```java
    import java.util.ArrayList;
    
    public class Main {
      public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        cars.set(0, "Benz");
        cars.remove(0);
        // Same as: System.out.println(cars);
        for (int i = 0; i < cars.size(); i++) {
          System.out.println(cars.get(i));
        }
      }
    }
    ```

12. SampleInheritance/ folder

------

## Week 03: Design Principles

### Key Concepts

* Association: represents "uses" relationship between two or more objects in which the objects have their own life-times and there is no "ownership".
  * Aggregation: A specialised form of association between two or more objects in which objects have their own life cycle but there is ownership as well.
  * Composition: A specialised form of aggregation in which if the parent object is destroyed, the child objects ceases to exist.
* Loose coupling, high cohesion.
  * loose coupling: allows components to be used and modified independently of each other.
  * high cohesion: much easier to maintain and less frequently changed and have higher probability of reusability.
* Design principle #1
  * Law of Demeter: Talk only to your friend
  * Classes should know about and interact with as few classes as possible
  * Helps us to design “loosely coupled” systems so that changes to one part of the system does not cascade to other parts of the system
* Design Principle #2
  * LSP (Liskov Substitution Principle): subtypes must be substitutable for their base types
  * Inheritance and LSP indicate that any method on Board should be able to use on a Board3D, and that Board3D can stand in for Board without any problems, so the above example clearly violates LSP

### Lecture Sample Code

1. /demeter/example: Different ways of invoking a method.
2. /demeter/car: bad design in classA, calling fri of fri of fri. But rather write another method for direct calling.
3. Lsp/: square should not extends rectangle, since the definition is different, and incorrect behaviour if we are calling setWidth() for square etc.
4. MyAssociation/: customer aggregation with cart, and cart composition with items in cart. Customer will still exist if cart is destroyed, but all items inside cart will disappeared.
5. refactoringOrg/: demonstrated all different methods of refracting.

## lecture 04

Everything this is about how to avoid switch statement by using strategies 

1. /PatternStrategyOk/car/ (car2+car2Test) => switch statement exist == bad design, violated open and close relationship.

   In improve this, we think "Engine" or "Brake" don't neccessary to be String, should be a class or instance with certain properties.

2. Hence, in /PatternStrategyOk/car/car.java. We create class BrakeStrategy, create an interface called BrakeStratygy.java, and create each brake type as class and implement the interface.

   Also we can create specified car as class, and extend car class, and call super with brake class and engine class.

3. /PatternStrategyOk/cart/cart.java, simlar example as car discussed above.

4. /HFDP_Strategy_State/ State/ Gumball: Bad design example with switch statement.

5. /HFDP_Strategy_State/ State/ gumballState: Good example, "State" becomes interface, all methods are contained in state.

6. /PatternObserver/Weather: If there is any change in temperature, the program should alert all observer.

   We have Thermometer and Hydrometer under interface Subject, and DisplayUSA and DisplayAus under interface Observer.

   However, this is a issue when updating either temperture or humidity, we have to distinguish the into argument/object is which type.

7. /WeatherV2: This problem is solved by implementing interfaces for both specified objects and observers.


## Lecture 05

1. /PatternComposite discussed typesafe and uniformity. The interface will not have add or remove methods for leaf node in typesafe composite, but the uniformity will implement in interface, and do nothing in leaf node function.
2. /HFDP_Composite used uniformity, and illustrated the way to print out specified menu item by using instanceof.
3. /myDbC explained the Exception, try...catch...finally. Finally will always be executed, useful for closing the file when a error occured.
4. /Dbc exceptions for different cases, and provide different corresponding meaningful message


## Lecture 07

1. /MyCollection1: demo how to sort the collection via different factor.

## Lecture08

1. Decorator pattern: coffee example
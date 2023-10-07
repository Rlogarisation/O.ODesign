[TOC]

------

# Summary of COMP2511

## Week01: Introduction to OOP

### Key Concepts

- 4 Pillars of OOP
  - Abstraction
    - Abstract class: focus on the common properties and behaviours of objects.
    - E.g. When we think of creating different car brands(BMW, Audi etc), we will put all commonalities into class Car, which rules out methods such as Steering system, entertainment system, engine system etc.
  - Inheritance
    - Relationship between class with more general concept(parent) and more specialised class(child).
    - "is-a" type relationship.
    - new classes are created from the existing classes by absorbing their attributes and behaviours.
    - More methods can be added in sub-classes, and the inherited method can be over-ridden in sub-classes.
    - Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance.
  - Encapsulation
    - Hiding the object's attribute by implementing private attributions, and access these attributions through getter and setter methods, in order to keep data safe, increase the usability, and reduce dependencies between classes(loose coupling, strong cohesion).
    - e.g. A capsule which is mixed of several medicines. The medicines are hidden data to the end user.
  - Polymorphism
    - Polymorphism is the ability to perform many things in many ways, such as same name with different method signature.
    - Static or Compile-time Polymorphism: when the compiler is able to determine the actual function:
      ```java
      public class Car{ 
            
          public void speed() { 
          } 
            
          public void speed(String accelerator) { 
          } 
            
          public int speed(String accelerator, int speedUp) { 
              return carSpeed; 
          } 
      }
      ```
    - Dynamic or Run-time Polymorphism: which can be achieved by method overloading:
    ```java
    class DeliveryBoy { 
  
    public void deliver() { 
        System.out.println("Delivering Item"); 
    } 
  
    public static void main(String[] args) { 
        DeliveryBoy deliveryBoy = getDeliveryBoy(); 
        deliveryBoy.deliver(); 
    } 
  
    private static DeliveryBoy getDeliveryBoy() { 
        Random random = new Random(); 
        int number = random.nextInt(5); 
        return number % 2 == 0 ? new Postman() : new FoodDeliveryBoy(); 
    } 
    } 
      
    class Postman extends DeliveryBoy { 
        @Override
        public void deliver() { 
            System.out.println("Delivering Letters"); 
        } 
    } 
      
    class FoodDeliveryBoy extends DeliveryBoy { 
        @Override
        public void deliver() { 
            System.out.println("Delivering Food"); 
        } 
    }
    ```
- Relationship
  - Inheritance (is-a relationship)
    ```java
    public class GraphicalCircle extends Circle {
      Color outline, fill;
      public GraphicalCircle() 
        // GraphicalCircle is-a Circle.
        // GraphicalCircle inherits all the variables and methods of its superclass Circle.
        super();
        this.outline = Color.black;
        this.fill = Color.white;
        x = 70;
      }
    }
    ```
  - Association (has-a relationship)
    - A class object has an object of another class to store its state or do its
work, e.g. Rectangle and line.
      ```java
      public class GraphicalCircle2 {
        Circle c;
        Color outline, fill;

        // Has-a relationship
        // a GraphicalCircle has a (mathematical) Circle.
        // Prefer composition over inheritance due to best practice and its flexibility.
        // Method forwarding: uses methods from the class Circle (area and circumference) to define some of the new methods.
        public GraphicalCircle2() {
          c = new Circle();
          this.outline = Color.black;
          this.fill = Color.white;
        }

        public GraphicalCircle2(int x, int y, int r, 
                    Color o, Color f) {
          c = new Circle(x, y, r);
          this.outline = o;
          this.fill = f;
        }
      }
      ```
    - Represents "uses" relationship between two or more objects in which the objects have their own life-times and there is no "ownership".
      * Aggregation: A specialised form of association between two or more objects in which objects have their own life cycle but there is ownership as well, e.g. A House has an occupant.
      * Composition: A specialised form of aggregation in which if the parent object is destroyed, the child objects ceases to exist, e.g. A House has a Room.




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
- Interface vs Abstract
  - Abstract: represents a type of object
    - which is a class that cannot be instantiated and can contain both abstract and non-abstract methods.
    - Some methods can be implemented, while others are left abstract, meaning that they have no implementation and must be overridden by concrete subclasses.
    - A class can inherit from only one abstract class via extends, since abstract class represents a type of object.
    - Abstract classes can have access modifiers such as public, protected, and private for their methods and properties, as well as member variables.
  - Interface: represents a set of behaviours
    - Which is a contract that specifies a set of methods that a class must implement.
    - All methods in an interface are by default abstract and must be implemented by any class that implements the interface.
    - A class can implement multiple interfaces via implements since which represents a set of behaviours.
    - Interfaces can only have public access, and variables must be static and final in interface
* Method forwarding
  * It uses methods from quoted class, to define some of the new method. (detailed in GraphicalCircle2.java)
* Super classes
  * Every class has a superclass, by default, the superclass is class Object.
  * That is why we need to use overriding method for toString(), equals(), and hasCode() etc.
* Single inheritance
  * Java only allows a new class can extend only one superclass, to avoid potential collision with different super functions.
- Method Overriding and Method Overloading
  - Overriding: When a class defines a method using the same name, return type,
and by the number, type, and position of its arguments as a method in its superclass, the method in the class overrides the method in the superclass.
  - Overloading: Defining methods with the same name and different argument or return types is called method overloading.


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

## Design Patterns

* Behavioural pattern
  * Strategy pattern
  * State pattern
  * Observer pattern
  * Iterator pattern
  * Template pattern
  * Visitor pattern
* Structural pattern
  * Composite pattern
  * Decorator pattern
  * Adapter pattern
* Creational pattern 
  * Factory method
  * Abstract factory
  * Builder pattern
  * Singleton pattern

## lecture 04: Design principles(cont.)

### Key Concept

* Design principle #3
  * Identify aspects of your code that varies and “encapsulate” and separate it from code that stays the same, so that it won’t affect your real code.
* Design Principle #4
  * Program to a an interface, not to an implementation.
* Design Principle #5
  * Favour composition over inheritance
* Strategy Pattern
  * Define a family of algorithms, encapsulate each one, and make them interchangeable
  * A class defines many behaviours, and these appears as multiple conditional statements (e.g., if or switch). Instead, move each conditional branch into their own concrete strategy class
  * attack strategy for each enemy in our group project.
* State Pattern
  * put different states into different classes, and consequential behaviours as method in interface.
  * Similar to strategy pattern, but intention is different. Strategy pattern encapsulates algorithm, state pattern encapsulates the behaviours for each state. 
* Observer Pattern
  * This allows the Subject and its Observers to be at different levels of abstractions in a system.
  * Allows dynamic registration and deregistration.
  * Call notify function in set function, since the variable is changed.

### Lecture Sample Code

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

------

## Week 05: Composite Pattern, Design by Contrast, and Exception

### Key Concept

* Composite Pattern
  * Aim is to be able to manipulate a single instance of the object just as we would manipulate a group of them.
  * For example, calculating size of a file should be same as a directory.
  * Tree structures are normally used to represent part-whole hierarchies.  A multiway tree structure  stores a collection of say Components at each node (children below), to store Leaf objects and Composite (subtree) objects. 
  * Type Safety vs Uniformity
    * Design for Type Safety: only define child-related operations in the Composite class. i.e. no getChild() in leaf.
    * Design for Uniformity: include all child-related operations in the Component interface. i.e. Even has getChild() in leaf.
* Design by Contract
  * Design by contract: At the design time, responsibilities are clearly assigned to different software elements, clearly documented and enforced during the development using unit testing and/or language support.
    * Pre-condition - what does the contract expect? (input range etc.)
    * Post-condition - what does the contract guarantee? (return correct and expected value type etc.)
    * Invariant - what does the contract maintain? (Some values must satisfy constraints, before and after the execution (say of the method). For example: a value of mark remains between zero and 100.)
  * Defensive programming: Tries to address unforeseen circumstances, in order to ensure the continuing functionality of the software element. For example, it makes the software behave in a predictable manner despite unexpected inputs or user actions.
  * Preconditions may be **weakened** (relaxed) in a subclass, but it must comply with the inherited contract.
  * Post-conditions may be **strengthened** (more restricted) in a subclass, but it must comply with the inherited contract. 
* Exception(try...catch...finally)
  * Checked exception: All classes that inherit from class Exception but not directly or indirectly from class RuntimeException are considered to be checked exceptions. 
  * Unchecked exception: All classes that are subclasses of RuntimeException (typically caused by defects in your program’s code) or Error (typically ‘system’ issues) are unchecked exceptions. 

### Lecture Sample Code

1. /PatternComposite discussed typesafe and uniformity. The interface will not have add or remove methods for leaf node in typesafe composite, but the uniformity will implement in interface, and do nothing in leaf node function.
2. /HFDP_Composite used uniformity, and illustrated the way to print out specified menu item by using instanceof.
3. /myDbC explained the Exception, try...catch...finally. Finally will always be executed, useful for closing the file when a error occured.
4. /Dbc exceptions for different cases, and provide different corresponding meaningful message

------

## Week 07: Generics, Collections, and Iterator Pattern

### Key Concept

* Generics
  * Generics enable types (classes and interfaces) to be parameters when defining: classes, interfaces and methods. (Specify the type of object is going to create)
  * Removes casting and offers stronger type checks at compile time, and adds stability to your code by making more of your bugs detectable at compile time.
* Collection
  * A collections framework is a unified architecture for representing and manipulating  collections. A collection is simply an object that groups multiple elements into a single unit. 
  * e.g. List is collection for ArrayList, LinkedList and etc.
* Iterator Pattern
  * **Iterator** is a behavioural design pattern that lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).
* Code Smell
  * Long method
  * Large class
  * Long parameter list
  * Data clumps
    * Different parts of the code contain identical groups of variables e.g., fields in many classes, parameters in many method signatures
  * Refused bequest
    * A subclass uses only some of the methods and properties inherited from its parents
  * Duplicate code
  * Feature envy
    * A method that is more interested in a class other than the one it actually is
    * Invokes several methods on another object to calculate some value
  * Divergent change
    * One class is changed in different ways for different reasons
  * Shot gun surgery
    * A small change in the code forces lots of little changes to different classes
  * Data class
    * Classes that just have attributes with setters and getters and no behaviour
    * One of the goals of OO design is to put behaviour where the data is
  * Lazy class
    * Classes that aren’t doing much to justify their existence (maintenance overhead)
  * Switch statement

### Lecture Sample Code

1. /MyCollection1: demo how to sort the collection via different factor.

------

## Week 08: Decorator, Adapter, and Template Pattern

### Key Concept

* Decorator pattern
  * Decorator design patterns allow us to selectively add functionality to an object (not the class) at runtime, based on the requirements.
* Adapter pattern
  * Convert the interface of a class into another interface clients expect.  Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
  * The adapter pattern is often used to make existing classes (APIs) work with a client class  without modifying their source code.
* Template pattern
  * Template Method is a behavioural design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.
  * The Template Method pattern suggests that you break down an algorithm into a series of steps, turn these steps into methods, and put a series of calls to these methods inside a single template method.
* Template versus Strategy pattern
  * Template Method works at the class level, so it’s static.  
  * Strategy works on the object level, letting you switch behaviours at runtime. 
  * Template Method is based on inheritance: it lets you alter parts of an algorithm by extending those parts in subclasses.  
  * Strategy is based on composition: you can alter parts of the object’s behaviour by  supplying it with different strategies that correspond to that behaviour at runtime. 

------

## Week 09: Creational Patterns and Visitor Pattern

### Key Concept

* Factory method

  * Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

  * The Factory Method pattern suggests that you replace direct object construction calls (using the `new` operator) with calls to a special *factory* method

  * The special factory method is a static method and will return (new something()), or can be used as instance method as well.

  * Usage: for creating different types of satellite in assignment. Client only need to call this to get a specified satellite without knowing the underlying logic.

    ```java
    Satellite mySatelliteA = SatelliteFactory.newSatellite(satelliteType);
    ```

* Abstract factory pattern

  * Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.
  * For example, interface for furniture with methods of createChair() or createTable() etc, then subclasses are different style of furniture.

* Builder pattern

  * Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.
  * The Builder pattern suggests that you extract the object construction code out of its own class and move it to separate objects called *builders*.
  * The pattern organizes object construction into a set of steps (`buildWalls`, `buildDoor`, etc.). To create an object, you execute a series of these steps on a builder object. The important part is that you don’t need to call all of the steps. You can call only those steps that are necessary for producing a particular configuration of an object.
  * For example, imagine a builder that builds everything from wood and glass, a second one that builds everything with stone and iron and a third one that uses gold and diamonds. By calling the same set of steps, you get a regular house from the first builder, a small castle from the second and a palace from the third. However, this would only work if the client code that calls the building steps is able to interact with builders using a common interface.
  * You can go further and extract a series of calls to the builder steps you use to construct a product into a separate class called *director*. The director class defines the order in which to execute the building steps, while the builder provides the implementation for those steps.
  * Relationship with other patterns
    * Many designs start by using Factory Method (less complicated and more customizable via subclasses) and evolve toward Abstract Factory, or Builder (more flexible, but more complicated).
    * Builder focuses on constructing complex objects step by step. 
    * Abstract Factory specializes in creating families of related objects
    * Abstract Factory returns the product immediately, whereas Builder lets you run some additional construction steps before fetching the product.

* Singleton pattern

  * **Singleton** is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.
  * Make the default constructor private, to prevent other objects from using the `new` operator with the Singleton class.
  * Create a static creation method that acts as a constructor. Under the hood, this method calls the private constructor to create an object and saves it in a static field. All following calls to this method return the cached object.
  * You can be sure that a class has only a single instance.
  * You gain a global access point to that instance.
  * The singleton object is initialized only when it’s requested for the first time.

* Visitor pattern

  * **Visitor** is a behavioral design pattern that lets you separate algorithms from the objects on which they operate.
  * The Visitor pattern suggests that you place the new behavior into a separate class called *visitor*, instead of trying to integrate it into existing classes. The original object that had to perform the behavior is now passed to one of the visitor’s methods as an argument, providing the method access to all necessary data contained within the object.




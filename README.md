# Content and Review Order

## Lecture 01

1. Circle.java -> simpliest version without any getter or setter.

2. CircleWithGetter.java -> Circle with getter and setter.

3. Hello folder -> Demonstrated basic usage and way to complie.

4. Vehicle.java -> Subclasses (implemented by extend)

5. Animal.java -> Superclass or parent (implemented by super).

6. Static.java -> explain the usage of static, and difference between use static and no using it.

7. Private.java -> The private keyword is an access modifier used for attributes, methods and constructors, making them only accessible within the declared class.

8. Protected.java -> The protected keyword is an access modifier used for attributes, methods and constructors, making them accessible in the same package and subclasses.

Note:

Most restricted -> Less restricted:

Private(Same class only) -> Protected(Same packages or subclasses) -> Public(all other classes)



9. CircleSuper folder -> main function in Test1.java

10. Iterating array.

    ```java
    int array[] = {1, 2, 3, 4, 5};
    for (int elem : array) {
      result += elem;
    }
    ```

    

## Lecture 02

### Questions:

- What is the difference between Method forwarding and inheritance other than "has-a" "is-a" relationship? Does the extending class have impact on the super class? Why method forwarding is prefered in most cases? 

  The lecturer stated: "the advantage is that we are only forwarding the function we need, rather than extending everything. I don't care if someone remove the other function tomorrow" , "and we could also modify on the base of this." <u>But inheritance could also be modified, right?</u>

- What is package?

  A package in Java is used to group related classes. Think of it as **a folder in a file directory**. We use packages to avoid name conflicts, and to write a better maintainable code.



### Review order

1. Shapes/Circle.java: Super class.

2. Shapes/GraphicalCircle.java: super class with **is-a** relationship, GraphicalCircle **is-a** Circle.

   

   <u>Below is how to repeat calling by using super in is-a relationship</u>

   ```java
   public class GraphicalCircle extends Circle {
   
   	Color outline, fill;
   
     public GraphicalCircle() {
         // First call no-arg constructor from the super class Circle
         super();
         //Set additional values for this sub-class
         //Color is the package.
         this.outline = Color.black;
         this.fill = Color.white;
         x = 70;
       }
     public GraphicalCircle(int x, int y, int r, Color o, Color f) {
   		super(x, y, r); // call 3-arg constructor from Circle
   		this.outline = o;
   		this.fill = f;
   	}
   ```

   so the super() will call this function only in Circle class:

   ```java
   public Circle(){
   		this.x = 1;
   		this.y = 1;
   		this.r = 1;
   
   		count_circle++; 
   		count_shapes++;
   	}
   ```

   

   <u>How to update the @override function</u>

   originally in super:

   ```java
   @Override
       public boolean equals(Object obj) {
   
           if(obj == null ) { return false;}
           if(this.getClass() != obj.getClass()){
               return false;
           }
   
           Circle other = (Circle) obj;
           if(other.x == this.x && other.y == this.y && other.r == this.r){
               return true;
           }
           else{
               return false;
           }
   ```

   then to update @Override due to extra variables.

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

   similar with @override method:

   ```java
   @Override
   public boolean equals(Object obj) {
   
     if(obj == null ) { return false;}
     if(this.getClass() != obj.getClass()){
       return false;
     }
   
     GraphicalCircle2 other = (GraphicalCircle2) obj;
     if( this.c.equals(other.c) && 
        other.fill.equals(this.fill)  && 
        other.outline.equals(this.outline)  ){
   
       return true;
     }
     else{
       return false;
     }
   }
   ```

   But worth mention the method forwarding for same functions since we don't have extend here.

   ```java
   public double area() {
     return c.area(); // Using the function in c from Circle().
   }
   
   public double circumference() {
     return c.circumference();
   }
   ```

   

2. AnimalAbstract.java : 

   Introduces abstract classes and methods. Abstraction classes can only be used thro extend. 

   The advantage of Abstract class is : 

   In each sub-class, we could define different animal sound for different sub-class animals.

   And print/other operation all animal sounds out with one command.

   ```java
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
   
   ```

   

3. This explain the significance of Abstract. The area of different shape/ sub-classes can be sum up in one line.

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

4. Another way to achieve abstraction in Java, is with interfaces.

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

5. instanceof is type comparison function.

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

6. Shapes/Shape.java is a abstract file, equivalent to .h.

7. Shapes/TestCircle.java is main file.

8. ShapesInterface/ introduced interfaces and implementations.

9. ArrayList:

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

10. SampleInheritance/ folder

## Lecture 03
1. /demeter/example: good and correct design.
2. /demeter/car: bad design in class A, calling fri of fri of fri.


## lecture 04

### Everything this is about how to avoid switch statement by using strategies 

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

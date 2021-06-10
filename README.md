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

## Lecture 02

### Questions:

- What is the difference between Method forwarding and inheritance other than "has-a" "is-a" relationship? Does the extending class have impact on the super class? Why method forwarding is prefered in most cases?

- What is package?

  A package in Java is used to group related classes. Think of it as **a folder in a file directory**. We use packages to avoid name conflicts, and to write a better maintainable code.



### Review order:

1. Shapes folder

   1. Circle.java: Super class.

   2. GraphicalCircle.java: super class with **is-a** relationship, GraphicalCircle **is-a** Circle.

      

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

      and super(x,y,r) is similar:

      ```java
      public Circle(int x, int y, int r){
      		// First call the constructor Circle(int x, int y)
      		// from this class
      		this(x,y);   
      		
      		// Now set r
      		this.setR(r);
      
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

   3. GraphicalCircle2.java: **Has-a** relationship, a GraphicalCircle has a Circle.

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

      

2. AnimalAbstract.java : 

   Introduces abstract classes and methods. Abstraction classes can only be used thro extend. 

   The advantage of Abstract class is : 

   In each sub-class, we could define different animal sound for different sub-class animals.

   And print/other operation all animal sounds out with one command.

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

   
public class Test1 {
    
    public static void main(String[] args) {
        
        Circle c1 = new Circle();

        System.out.println( "c1 area: "+ c1.getArea() );

        Circle c2 = new Circle(2, 5, 8);
        System.out.println( c2.getArea() );

        System.out.println( Circle.no_circles );

        System.out.println( c2 );

        Circle c3 = new Circle(2, 5, 8);
        /**
         * If c1 is located at memory 0x3000, c2 at 0x5000, c3 at 0x7000
         * letting c1 = c2, so the memory address for both c1 and c2 are 0x5000
         * The system will lose track to the memory of c1,
         * Then system will do dumping process to get rid of c1.
         * 
         * When we compare c2 and c3 by ==, we are comparing their memory address,
         * and of course this will be return false.
         * However, when we compare c2 and c3 by using equals(),
         * we are only comparing values and types,
         * hence will return true.a
         */
        c1 = c2;
        System.out.println("revised, c1 area: "+ c1.getArea() );

        System.out.println( c2 == c3 ); 
        System.out.println( c2.equals(c3) ); 



    }


}
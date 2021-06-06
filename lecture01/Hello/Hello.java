import java.util.Scanner;

public class Hello {

    public static boolean isLeap(int year){

        return ( (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

    }

    public static void main(String[] args) {
        
        System.out.println("Hello World!");

        int counter = 0;

        // ?
        for(String str : args){
            System.out.println(++counter + " :: " + str);
        }

        System.out.println(args.length);

        int year = 2000;

        System.out.println( "Is a leap year? " + year + " : " + isLeap(year));

        Scanner in = new Scanner(System.in);
        String str2 = in.next();
        
        System.out.println(" >>> " + str2.toUpperCase());
        in.close();



    }
    
}

/*

z5206267@corelli:~/COMP2511/lecture01/HelloWorld/src$ javac Hello.java 
z5206267@corelli:~/COMP2511/lecture01/HelloWorld/src$ java Hello
Hello World!
0
Is a leap year? 2000 : true
ye
 >>> YE

z5206267@corelli:~/COMP2511/lecture01/HelloWorld/src$ java Hello adb adbds asdnsf
Hello World!
1 :: adb
2 :: adbds
3 :: asdnsf
3
Is a leap year? 2000 : true
as
 >>> AS
*/
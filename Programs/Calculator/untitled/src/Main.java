import java.util.Scanner;
import java.util.logging.ConsoleHandler;

public class Main extends CalculatorFunctions {
    public static void main(String args[]){
        int input = 0;
        int num1 = 0;
        int num2 = 0;

        do {
            System.out.println("What would you like to execute? ");
            System.out.println("1. [+]");
            System.out.println("2. [-]");
            System.out.println("3. [/]");
            System.out.println("4. [*]");
            System.out.println("5. Exit");

            Scanner sc = new Scanner(System.in);
            System.out.println("input: ");
            input = sc.nextInt();

            if(input < 5 && input > 0){
                System.out.println("num1: ");
                num1 = sc.nextInt();

                System.out.println("num2: ");
                num2 = sc.nextInt();
            }

            if(input == 1) System.out.println(Add(num1, num2));
            else if(input == 2) System.out.println(Sub(num1, num2));
            else if(input == 3) System.out.println(Divide(num1, num2));
            else if(input == 4) System.out.println(Multiply(num1, num2));
            else if(input == 5) System.out.println("Program closed.");
            else System.out.println("Invalid Input");

        }while(input != 5);
    }
}

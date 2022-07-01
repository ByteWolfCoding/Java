import java.util.*;

public class CalculatorFunctions {

    public static double Add(double num1, double num2){
        return Math.round((num1 + num2) * 100.0) / 100.0;
    }

    public static double Sub(double num1, double num2){
        return Math.round((num1 - num2) * 100.0) / 100.0;
    }

    public static double Multiply(double num1, double num2) {
        return Math.round((num1 * num2) * 100.0) / 100.0;
    }

    public static double Divide(double num1, double num2) {
        if(num2 == 0){
            System.out.println("CANNOT DIVIDE BY 0");
            return -1;
        }
        return ((num1 / num2) * 100.0) / 100.0;
    }
}

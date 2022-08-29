import java.beans.Expression;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\tMy Calculator\n");
        System.out.print("Enter your expression: ");
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
        System.out.println("Result: " + Main.calc(expression));
    }
    public static String calc(String input) {
        String output = "";
        int result = 0;
        int a, b;
        boolean romeSystem = false;
        RomeNumber romeNumber[] = RomeNumber.values();
        String [] strings =  input.split(" ");
        if (strings.length != 3){
            System.out.println("Wrong expression!");
            throw new IllegalArgumentException();
        }
        else {
            if (check(romeNumber, strings[0]) && check(romeNumber, strings[2])) {
                romeSystem = true;
                a = RomeNumber.valueOf(strings[0]).getNumber();
                b = RomeNumber.valueOf(strings[2]).getNumber();
            } else {
                    a = Integer.parseInt(strings[0]);
                    b = Integer.parseInt(strings[2]);
            }
            if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
                switch (strings[1]) {
                    case ("+") -> result = a + b;
                    case ("-") -> result = a - b;
                    case ("*") -> result = a * b;
                    case ("/") -> result = a / b;
                    default -> {
                        System.out.println("Undefined operation");
                        throw new UnsupportedOperationException();
                    }
                }
            } else {
                System.out.println("Number out of limits");
                throw new IllegalArgumentException();
            }
        }
        if (romeSystem && result <= 0) throw new ArithmeticException();
        if (romeSystem)
        {
            return inToRoman(result);
        }
        output += result;
        return output;
    }
    public static boolean check(RomeNumber arr[], String str){
        for (RomeNumber element: arr){
            if(str.equals(element.toString())){
                return true;
            }
        }
        return false;
    }
    public static String inToRoman(int n) {

        if( n <= 0) {
            throw new IllegalArgumentException();
        }

        String res = "";

        final RomeNumberTemplate[] values = RomeNumberTemplate.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (n >= values[i].number) {
                res += values[i];
                n -= values[i].number;
            }
        }
        return res.toString();
    }
}
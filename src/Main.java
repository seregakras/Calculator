import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\tMy Calculator\n");
        System.out.print("Enter your expression: ");
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
        System.out.println(Main.calc(expression));
    }
    public static String calc(String input){
        String output = "";
        int result = 0;
        String [] strings =  input.split(" ");
        if (strings.length != 3){
            System.out.println("Wrong expression!");
        }
        else {
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[2]);
            if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
                switch (strings[1]) {
                    case ("+"):
                        result = a + b;
                        break;
                    case ("-"):
                        result = a - b;
                        break;
                    case ("*"):
                        result = a * b;
                        break;
                    case ("/"):
                        result = a / b;
                        break;
                    default:
                        System.out.println("Undefined operation");
                }
            } else {
                System.out.println("Number out of limits");
            }
        }
        output = result + "";
        return output;
    }
}
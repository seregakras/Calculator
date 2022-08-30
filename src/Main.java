import java.util.Scanner;

public class Main {
    public static void main(String[] args) {            // основная программа
        System.out.println("\tMy Calculator\n");
        System.out.print("Enter your expression: ");
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
        System.out.println(Main.calc(expression));
    }
    public static String calc(String input) {           // метод калькулятор
        String output = "";
        int result;
        int a, b;
        boolean romeSystem = false;
        RomeNumber [] romeNumber = RomeNumber.values();      // преобразование перечисления интервала римских цифр от I до X в массив
        String [] strings =  input.split(" ");        // разбиение входной строки на части (операнды и оператор)
        if (strings.length != 3){                           // проверка правильности входящей строки
            throw new IllegalArgumentException("Wrong expression!");
        }
        else {
            if (check(romeNumber, strings[0]) && check(romeNumber, strings[2])) {   // проверка входящей строки на римскую систему и написание обоих операндов в данной системе
                romeSystem = true;
                a = RomeNumber.valueOf(strings[0]).getNumber();         // преобразование в арабскую систему
                b = RomeNumber.valueOf(strings[2]).getNumber();
            } else {
                    a = Integer.parseInt(strings[0]);           // преобразование операндов из строк в целые числа
                    b = Integer.parseInt(strings[2]);
            }
            if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {       // проверка интервала операндов от 1 до 10
                switch (strings[1]) {
                    case ("+") -> result = a + b;               // определение оператора и соответвующее вычисление
                    case ("-") -> result = a - b;
                    case ("*") -> result = a * b;
                    case ("/") -> result = a / b;
                    default -> throw new UnsupportedOperationException("Undefined operation");
                }
            } else {
                throw new IllegalArgumentException("Number out of limits");
            }
        }
        if (romeSystem && result <= 0) throw new ArithmeticException("Wrong result in rome system");     // проверка результата на положительный диапазон, если система римская
        else if (romeSystem)
        {
            return inToRoman(result);       // преобразование результата в римскую систему и его возвращение
        }
        output += result;
        return output;      // возвращение результата в арабской системе
    }
    public static boolean check(RomeNumber [] arr, String str){      // метод проверки соответствия строки одному из элементов перечислений интервала римских цифр от I до X
        for (RomeNumber element: arr){
            if(str.equals(element.toString())){
                return true;
            }
        }
        return false;
    }
    public static String inToRoman(int n) {     // метод преобразования целого числа в римскую систему

        if( n <= 0) {
            throw new IllegalArgumentException();
        }

        StringBuilder res = new StringBuilder();

        RomeNumberTemplate[] values = RomeNumberTemplate.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (n >= values[i].number) {
                res.append(values[i]);
                n -= values[i].number;
            }
        }
        return res.toString();
    }
}
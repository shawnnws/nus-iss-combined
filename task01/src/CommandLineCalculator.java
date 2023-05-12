import java.io.Console;

public class CommandLineCalculator {
    public static void main(String[] args) {

        Console cons = System.console();
        String userInput = "";
        String $last = "0";
        double result;
        double firstNum;
        double secondNum;
        System.out.println("Welcome.");

        while (!userInput.equals("exit")) {
            userInput = cons.readLine();

            if (userInput.equals("exit")) {
                System.out.println("Bye bye");
                return;
            }

            String[] input = userInput.split(" ");
            String operation = input[1];

            if (input[0].equals("$last")) {
                firstNum = Double.parseDouble($last);
                secondNum = Double.parseDouble(input[2]);
            }
            else if (input[2].equals("$last")) {
                firstNum = Double.parseDouble(input[0]);
                secondNum = Double.parseDouble($last);
            }
            else {
                firstNum = Double.parseDouble(input[0]);
                secondNum = Double.parseDouble(input[2]);
            }

            switch (operation) {
                case "+":
                    result = firstNum + secondNum;
                    $last = String.valueOf(result);
                    System.out.println($last);
                    break;
                case "-":
                    result = firstNum - secondNum;
                    $last = String.valueOf(result);
                    System.out.println($last);
                    break;
                case "*":
                    result = firstNum * secondNum;
                    $last = String.valueOf(result);
                    System.out.println($last);
                    break;
                case "/":
                    result = firstNum / secondNum;
                    $last = String.valueOf(result);
                    System.out.println($last);
                    break;
            }
        }
    }
}

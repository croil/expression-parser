import exceptions.ParsingException;
import parser.ExpressionParser;
import parser.Parser;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Parser parser = new ExpressionParser();
        System.out.print("Enter the expression you want to evaluate: ");
        String expression = scanner.nextLine();
        System.out.print("Enter the value of the variables x, y, z or any numbers if there are no variables: ");
        int[] vars = new int[3];
        try {
            vars = Stream.generate(scanner::nextInt).limit(3).mapToInt(i -> i).toArray();
        } catch (InputMismatchException ex) {
            System.err.println("Error when entering the value of variables, substituted values x = 0, y = 0, z = 0");
            Arrays.fill(vars, 0);
        }
        int result;
        try {
            result = parser.parse(expression).evaluate(vars[0], vars[1], vars[2]);
            System.out.printf("The answer is: %s for x = %s, y = %s, z = %s%n", result, vars[0], vars[1], vars[2]);
        } catch (ParsingException ex) {
            System.err.println("Error parsing data: " + ex.getMessage());
        }
    }
}

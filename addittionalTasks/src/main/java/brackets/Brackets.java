package brackets;

import java.util.Scanner;

public class Brackets {

    private String input;

    public Brackets(String input) {
        this.input = input;
    }

    boolean isCorrect() {
        String string = selectBrackets(input);
        if ((string.length() % 2) != 0) {
            return false;
        }
        while (string.contains("()") || string.contains("[]") || string.contains("{}")) {
            string = string.replaceAll("\\(\\)", "")
                    .replaceAll("\\[\\]", "")
                    .replaceAll("\\{\\}", "");
        }
        return (string.length() == 0);
    }

    private String selectBrackets (String input) {
        char[] chars = input.toCharArray();
        StringBuilder stringWithBrackets = new StringBuilder();

        for (char c : chars ) {
            if ((c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')')){
                stringWithBrackets.append(c);
            }
        }
        return stringWithBrackets.toString();
    }

    public static void main(String[] args) {

        System.out.println("Input expression with brackets to check if they are correctly written in an expression");
        System.out.println("Example: \n '{abc{[](abc)}}}}' , {[(])} , [abc] abc){a}a  - is not correct\n" +
                " '{{{abc{[](abc)}}}}' , '{([()])}' , '[abc] (abc){a}a' - is correct");

        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        Brackets brackets = new Brackets(input);

        if (brackets.isCorrect()) {
            System.out.println("\n" + input + " input is correct");
        }
        else System.out.println("\n" + input + " input is not correct");
    }

}

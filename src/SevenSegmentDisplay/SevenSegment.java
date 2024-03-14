package SevenSegmentDisplay;

import java.util.InputMismatchException;

public class SevenSegment {
    public static void validate(String number) {
        if (!number.matches("\\d+")) {
            throw new InvalidNumberException("Input contains non-numeric characters.");
        }
        if (number.length() != 8) {
            throw new InvalidNumberException("Input length must be 8 characters.");
        }
        if (number.matches(".*[a-zA-Z].*")) {
            throw new InvalidNumberException("Input contains alphabetic characters.");
        }
    }

    public static String firstMethod(String word) {
        if (word.charAt(0) == '1')
            return "# # # #";
        if (word.charAt(0) == '0')
            return "          ";
        return word;
    }

    public static String secondMethod(String word) {
        if (word.charAt(6) == '1')
            return "# # # #";
        if (word.charAt(6) == '0')
            return "          ";
        return word;
    }

    public static String thirdMethod(String word) {
        if (word.charAt(3) == '1')
            return "# # # #";
        if (word.charAt(3) == '0')
            return "          ";
        return word;
    }

    public static String fourthMethod(String word) {
        if (word.charAt(1) == '1' && word.charAt(5) == '1')
            return "#       #";
        if (word.charAt(1) == '1' && word.charAt(5) == '0')
            return "#         ";
        if (word.charAt(1) == '0' && word.charAt(5) == '1')
            return "          #";
        if (word.charAt(1) == '0' && word.charAt(5) == '0')
            return "            ";
        return "";
    }

    public static String fifthMethod(String word) {
        if (word.charAt(2) == '1' && word.charAt(4) == '1')
            return "#       #";
        if (word.charAt(2) == '1' && word.charAt(4) == '0')
            return "#           ";
        if (word.charAt(2) == '0' && word.charAt(4) == '1')
            return "             #";
        if (word.charAt(1) == '0' && word.charAt(5) == '0')
            return "              ";
        return "";
    }

    public static String segments(String numbers) {
        try {
            validate(numbers);

            String segmentPattern = firstMethod(numbers) + "\n" +
                    fifthMethod((numbers) + "\n" +
                    thirdMethod((numbers) + "\n" +
                    fourthMethod((numbers) + "\n" +
                    secondMethod(numbers))));

            System.out.println(segmentPattern);

        } catch (InvalidNumberException invalidNumberException) {
            System.out.println("Invalid number.");
        } catch (InputMismatchException exception) {
            System.out.println("Wrong set of characters");
        }
        return null;
    }

    public static String display(String numbers) {
        try {
            validate(numbers);

            if (numbers.charAt(7) == '1') {
                return segments(numbers);
            } else {
                return "OFF";
            }
        } catch (InvalidNumberException invalidNumberException) {
            System.out.println("Invalid number.");
        } catch (InputMismatchException exception) {
            System.out.println("Wrong set of characters");
        }
        return null;
    }
}

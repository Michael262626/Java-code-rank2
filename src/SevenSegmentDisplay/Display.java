package SevenSegmentDisplay;

import java.util.Scanner;

import static SevenSegmentDisplay.SevenSegment.display;

public class Display {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a digit 1 or 0: ");
        String digit = scanner.next();
        System.out.println(display(digit));
    }
}

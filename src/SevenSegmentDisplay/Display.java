package SevenSegmentDisplay;

import java.util.Scanner;

import static SevenSegmentDisplay.SevenSegment.display;

public class Display {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a digit 1 or 0: ");
        int digit = scanner.nextInt();
        System.out.println(display(String.valueOf(digit)));
    }
}

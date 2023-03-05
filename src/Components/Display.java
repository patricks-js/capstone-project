package Components;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {
    private int validValue(String message, int validValue) {
        Scanner scanner = new Scanner(System.in);
        int value;
        boolean valid = false;
        do {
            System.out.print(message);
            value = scanner.nextInt();
            if (validValue >= 0) {
                valid = true;
            } else {
                System.out.println("Invalid value. Try again.");
            }
        } while (!valid);
        return value;
    }

    private int validValues(String message, int[] validValues) {
        Scanner scanner = new Scanner(System.in);
        int value;
        boolean valid = false;
        do {
            System.out.print(message);
            value = scanner.nextInt();
            for (int validValue : validValues) {
                if (value == validValue) {
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                System.out.println("Invalid value. Try again.\n");
            }
        } while (!valid);
        return value;
    }

    public ArrayList<Integer> menu() {
        ArrayList<Integer> values = new ArrayList<Integer>();

        values.add(validValues("Enter the width of th grid [10, 20, 40, 80]: ", new int[]{10, 20, 40, 80}));
        values.add(validValues("Enter the height of th grid [10, 20, 40]: ", new int[]{10, 20, 40}));
        values.add(validValue("Enter the max generations (0 = infinity): ", 0));
        values.add(validValues("Enter the fps [250, 1000]: ", new int[]{250, 1000}));

        return values;
    }

    public String getFirstGeneration() {
        Scanner scanner = new Scanner(System.in);
        String value;
        boolean valid = false;
        do {
            System.out.print("Enter the first generation (#, 0, 1): ");
            value = scanner.nextLine();
            String validChar = "#01";
            valid = true;
            for (int i = 0; i < value.length(); i++) {
                if (!validChar.contains(value.substring(i, i+1))) {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                System.out.println("Invalid value. Try again.");
            }
        } while (!valid);
        return value;
    }

    public void playGOL(ArrayList<Integer> values, String firstGeneration) throws InterruptedException {
        Grid newGrid = new Grid(values, firstGeneration);
        newGrid.showGrid();
    }
}

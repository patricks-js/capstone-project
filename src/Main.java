import Components.Display;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * W = 10
     * H = 10
     * G = 500
     * S = 1000
     * P = "##10101#1#01" // A # sinaliza a coluna e o numero é a cell
     * */
    public int validValue(String message, int validValue) {
        Scanner scanner = new Scanner(System.in);
        int value;
        boolean valid = false;
        do {
            System.out.print(message);
            value = scanner.nextInt();
            if (validValue >= 0) {
                valid = true;
            } else {
                System.out.println("Valor inválido. Tente novamente.");
            }
        } while (!valid);
        return value;
    }
    public int validValues(String message, int[] validValues) {
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
                System.out.println("Valor inválido. Tente novamente.");
            }
        } while (!valid);
        return value;
    }
    public ArrayList<Integer> menu() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);

        values.add(validValues("Enter the width of th grid [10, 20, 40, 80]: ", new int[]{10, 20, 40, 80}));
        values.add(validValues("Enter the width of th grid [10, 20, 40]: ", new int[]{10, 20, 40}));
        values.add(validValue("Enter the max generations (0 = infinity): ", 0));
        values.add(validValues("Enter the fps [250, 1000]: ", new int[]{10, 20, 40}));
        System.out.print("Enter the first generation: (default: 'rnd'): ");

        return values;
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        Display newGame = new Display(10,10,10, 1000, "##10101#1#01");
        newGame.playGOL();
        String firstGen = input.nextLine();
    }
}

package Components;

import java.util.ArrayList;

public class Display {
    private int validValue(int value, int validValue) {
        boolean valid = false;
        do {
            if (validValue >= 0) {
                valid = true;
            } else {
                System.err.println("Missing width arguments");
                System.exit(1);
            }
        } while (!valid);
        return value;
    }

    private int validValues(int value, int[] validValues) {
        boolean valid = false;
        do {
            for (int validValue : validValues) {
                if (value == validValue) {
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                System.err.println("Missing width arguments");
                System.exit(1);
            }
        } while (!valid);
        return value;
    }

    public ArrayList<Integer> menu(int w, int h, int g, int s) {
        ArrayList<Integer> values = new ArrayList<>();

        values.add(validValues(w, new int[]{10, 20, 40, 80}));
        values.add(validValues(h, new int[]{10, 20, 40}));
        values.add(validValue(g, 0));
        values.add(validValues(s, new int[]{250, 1000}));

        return values;
    }

    public String getFirstGeneration(String value) {
        boolean valid = false;
        do {
            String validChar = "#01";
            valid = true;
            for (int i = 0; i < value.length(); i++) {
                if (!validChar.contains(value.substring(i, i+1))) {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                System.err.println("Missing width arguments");
                System.exit(1);
            }
        } while (!valid);
        return value;
    }

    public void playGOL(ArrayList<Integer> values, String firstGeneration) throws InterruptedException {
        Grid newGrid = new Grid(values, firstGeneration);
        newGrid.showGrid();
    }
}

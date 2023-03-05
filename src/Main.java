import Components.Display;

import java.util.ArrayList;

public class Main {
    /**
     * W = 10
     * H = 10
     * G = 500
     * S = 1000
     * P = "##10101#1#01" // A # sinaliza a coluna e o numero é a cell
     * */
    public static void main(String[] args) throws InterruptedException {
        Display newGame = new Display();

        ArrayList<Integer> values = newGame.menu();
        String firstGeneration = newGame.getFirstGeneration();

        newGame.playGOL(values, firstGeneration);
    }
}

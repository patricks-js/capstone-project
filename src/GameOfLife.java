import Components.Display;

import java.util.ArrayList;

public class GameOfLife {
    /**
     * W = 10
     * H = 10
     * G = 500
     * S = 1000
     * P = "##10101#1#01" // A # sinaliza a coluna e o numero é a cell
     * */
    public static void main(String[] args) throws InterruptedException {

        int w = Integer.parseInt(args[0]);
        int h = Integer.parseInt(args[1]);
        int maxGen = Integer.parseInt(args[2]);
        int fps = Integer.parseInt(args[3]);
        String firstGen = args[4];

        System.out.print(w);
        System.out.print(h);
        System.out.print(maxGen);
        System.out.print(fps);
        System.out.print(firstGen);

        Display newGame = new Display();

        ArrayList<Integer> values = newGame.menu();
        String firstGeneration = newGame.getFirstGeneration();

        newGame.playGOL(values, firstGeneration);
    }
}

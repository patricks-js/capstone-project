import Components.Display;

import java.util.ArrayList;

public class GameOfLife {
    public static void main(String[] args) throws InterruptedException {
        int w = Integer.parseInt(args[0]);
        int h = Integer.parseInt(args[1]);
        int maxGen = Integer.parseInt(args[2]);
        int fps = Integer.parseInt(args[3]);
        String firstGen = args[4];

        Display newGame = new Display();

        ArrayList<Integer> values = newGame.menu(w, h, maxGen, fps);
        String firstGeneration = newGame.getFirstGeneration(firstGen);

        newGame.playGOL(values, firstGeneration);
    }
}

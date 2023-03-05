package Components;

import java.util.ArrayList;

public class Grid {
    private int width;
    private int height;
    private int generations;
    private int fps;
    private String firstGeneration;

    private Cell[][] firstGen;

    public Grid(ArrayList<Integer> values, String firstGeneration) {
        this.width = values.get(0);
        this.height = values.get(1);
        this.generations = values.get(2);
        this.fps = values.get(3);
        this.firstGeneration = firstGeneration;
        this.firstGen = new Cell[this.width + 2][this.height + 2];
    }

    private void drawGrid(int currentGen) {
        Generation generations = new Generation(this.firstGeneration);
        String[][] matrixToDraw = new String[this.height][this.width];

        if(currentGen == 0) {
            this.firstGen = generations.getFirstGen(this.width + 2, this.height + 2);
            generations.drawGen(matrixToDraw, firstGen, this.width, this.height);
        } else {
            this.firstGen = generations.updateGen(this.firstGen);
            generations.drawGen(matrixToDraw, this.firstGen, this.width, this.height);
        }

        for(String[] row : matrixToDraw) {
            for(int item = 0; item < row.length; item++) {
                System.out.print(row[item] + "\t");
            }
            System.out.println();
        }
    }

    public void showGrid() throws InterruptedException {
        int currentGeneration = 0;

        while(generations > currentGeneration) {
            String status = "\nGrid [" + this.height + "]" + "[" + this.width + "]" + " Generation: [" + (currentGeneration + 1) + "/" + this.generations + "]" + " FPS: [" + this.fps + "]";
            System.out.println(status);
            this.drawGrid(currentGeneration);
            currentGeneration += 1;
            Thread.sleep(this.fps);
        }
    }
}

package Components;

import java.util.ArrayList;

public class Grid {
    private int width;
    private int height;
    private int generations;
    private int fps;
    private String firstGeneration;
    private Cell[][] currentGen;

    public Grid(ArrayList<Integer> values, String firstGeneration) {
        this.width = values.get(0);
        this.height = values.get(1);
        this.generations = values.get(2);
        this.fps = values.get(3);
        this.firstGeneration = firstGeneration;
        this.currentGen = new Cell[this.width + 2][this.height + 2];
    }

    private void drawGrid(int currentGen) {
        Generation generations = new Generation(this.firstGeneration);
        String[][] matrixToDraw = new String[this.height][this.width];

        if(currentGen == 0) {
            this.currentGen = generations.getFirstGen(this.width + 2, this.height + 2);
            generations.drawGen(matrixToDraw, this.currentGen, this.width, this.height);
        } else {
            this.currentGen = generations.updateGen(this.currentGen);
            generations.drawGen(matrixToDraw, this.currentGen, this.width, this.height);
        }

        for(String[] row : matrixToDraw) {
            for (String cell : row) {
                System.out.print(cell + "\t");
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

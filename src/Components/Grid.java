package Components;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;

public class Grid {
    private int width;
    private int height;
    private int generations;
    private int fps;
    private String firstGeneration;

    public Grid(ArrayList<Integer> values, String firstGeneration) {
        this.width = values.get(0);
        this.height = values.get(1);
        this.generations = values.get(2);
        this.fps = values.get(3);
        this.firstGeneration = firstGeneration;
    }
    private void drawGrid() {
        int[][] matrix = new int[this.height][this.width];

        for(int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    public void showGrid() throws InterruptedException {
        int currentGeneration = 0;

        while(generations > currentGeneration) {
            currentGeneration += 1;
            String status = "Grid [" + this.height + "]" + "[" + this.width + "]" + " Generation: [" + currentGeneration + "/" + this.generations + "]" + " FPS: [" + this.fps + "]";
            System.out.println(status);
            this.drawGrid();
            Thread.sleep(this.fps);
        }
    }
}

package Components;

import java.util.Arrays;

public class Grid {
    private int rowSize;
    private int colSize;
    private int[][] matrix;

    public Grid(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
    }

    public void drawGrid() {
        for(int[] row : this.matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}

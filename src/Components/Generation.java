package Components;

import java.util.ArrayList;
import java.util.List;

public class Generation {
    private String firstGen;

    public Generation(String firstGen) {
        this.firstGen = firstGen;
    }

    public Cell[][] getFirstGen(int height, int width) {
        Cell[][] firstGen = new Cell[height][width];
        String[] chars = this.firstGen.split("");

        int indexPos = 0;

        for (int line = 1; line < height; line++) {
            for(int item = 1; item < width; item++) {
                switch (chars[indexPos]) {
                    case "#" -> {
                        line++;
                        item = 0;
                    }
                    case "1" -> firstGen[line][item] = new Cell(true);
                }
                if(indexPos == chars.length - 1) break;
                else indexPos++;
            }
            if(indexPos == chars.length - 1) break;
        }

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(firstGen[i][j] == null) {
                    firstGen[i][j] = new Cell(false);
                }
            }
        }

        return firstGen;
    }

    public void drawGen(String[][] matrixToDraw, Cell[][] matrixCell, int width, int height) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                matrixToDraw[i][j] = matrixCell[i + 1][j + 1].isAlive() ? "&" : ".";
            }
        }
    }

    private int getAliveNeighbors(Cell[][] matrix, int line, int item) {
        int neighborsCounter = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int newX = line + i;
                int newY = item + j;

                if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length) {
                    if (matrix[newX][newY] != null && matrix[newX][newY].isAlive()) {
                        neighborsCounter++;
                    }
                }
            }
        }

        return neighborsCounter;
    }

    private boolean isToRevive(Cell[][] matrix, int line, int item) {
        int aliveNeighbors = this.getAliveNeighbors(matrix, line, item);

        return aliveNeighbors == 3;
    }

    private boolean isToDie(Cell[][] matrix, int line, int item) {
        int aliveNeighbors = this.getAliveNeighbors(matrix, line, item);

        return aliveNeighbors < 2 || aliveNeighbors > 3;
    }

    private void getAliveCells(Cell[][] matrix, int line, int item) {
        if(matrix[line][item].isAlive()) {
            System.out.println("Alive in position: " + line + " " + item);
        }
    }

    public List<List<Integer>> getReviveCells(Cell[][] matrix) {
        List<List<Integer>> toRevive = new ArrayList<>();

        for (int line = 1; line < matrix.length - 1; line++) {
            for (int item = 1; item < matrix[line].length - 1; item++) {
                if(!matrix[line][item].isAlive()) {
                    if(isToRevive(matrix, line, item)) {
                        List<Integer> cellsPos = new ArrayList<>();
                        cellsPos.add(line);
                        cellsPos.add(item);
                        toRevive.add(cellsPos);
                    }
                }
            }
        }

        return toRevive;
    }

    public List<List<Integer>> getDieCells(Cell[][] matrix) {
        List<List<Integer>> toDie = new ArrayList<>();

        for (int line = 1; line < matrix.length - 1; line++) {
            for (int item = 1; item < matrix[line].length - 1; item++) {
                if(matrix[line][item].isAlive()) {
                    if(isToDie(matrix, line, item)) {
                        List<Integer> cellsPos = new ArrayList<>();
                        cellsPos.add(line);
                        cellsPos.add(item);
                        toDie.add(cellsPos);
                    }
                }
            }
        }

        return toDie;
    }

    public Cell[][] updateGen(Cell[][] matrixCell) {
        List<List<Integer>> cellToRevive = this.getReviveCells(matrixCell);

        List<List<Integer>> cellToDie = this.getDieCells(matrixCell);

        for(List<Integer> cellPos : cellToRevive) {
            matrixCell[cellPos.get(0)][cellPos.get(1)].setAlive(true);
        }

        for(List<Integer> cellPos : cellToDie) {
            matrixCell[cellPos.get(0)][cellPos.get(1)].setAlive(false);
        }

        return matrixCell;
    }
}

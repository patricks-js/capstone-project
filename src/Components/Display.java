package Components;

public class Display {
    private int width;
    private int height;
    private int generations;
    private int fps;
    private String firstGeneration;

    public Display(int width,int height, int generations, int fps, String firstGeneration) {
        this.width = width;
        this.height = height;
        this.generations = generations;
        this.fps = fps;
        this.firstGeneration = firstGeneration;
    }

    public void playGOL() throws InterruptedException {
        int currentGeneration = 0;
        Grid newGrid = new Grid(this.height, this.width);

        while(generations > currentGeneration) {
            currentGeneration += 1;
            String status = "Grid [" + this.height + "]" + "[" + this.width + "]" + " Generation: [" + currentGeneration + "/" + this.generations + "]" + " FPS: [" + this.fps + "]";
            System.out.println(status);
            newGrid.drawGrid();
            Thread.sleep(this.fps);
        }
    }

    public void menu() {

    }
}

package src;

public class BrickFactory {
    private Brick[][] bricks;
    private Brick brick;
    private int col;
    private int row;

    public BrickFactory(int col, int row) {
        this.col = col;
        this.row = row;
        createBricks();
    }
    public void createBricks() {
        bricks = new Brick[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                bricks[i][j] = new Brick((Background.PADDING * 9) + (65 * i), (j * Background.CELLSIZE + (j *5)) + (Background.PADDING * 4)+30);

            }
            }
    }
    public int getCol(){
        return col;
    }
    public int getRow(){
        return row;
    }
    public Brick[][] getBricks() {
        return bricks;
    }

}






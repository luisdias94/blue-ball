package src;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Brick {
    private Rectangle brick;
    private int col;
    private int row;
    private boolean inGame = true;
    public Brick(int col, int row) {
        brick = new Rectangle(col,row,Background.CELLSIZE*2, Background.CELLSIZE);
        brick.setColor(randomColor());
        brick.fill();
        this.col = col;
        this.row = row;
    }

    public boolean getInGame() {return inGame;}
    public int getX() {return brick.getX();}
    public int getY(){return brick.getY();}
    public int getHeight() {return brick.getHeight();}
    public int getWidth(){return brick.getWidth();}
    public void delete(){brick.delete();}
    public void removeBrick(){inGame = false;}
    private Color randomColor() {
        int num = (int) (Math.random() * 6);
        switch (num) {
            case 0:
                return Color.GREEN;
            case 1:
                return Color.BLACK;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.RED;
            case 4:
                return Color.MAGENTA;
            case 5:
                return Color.PINK;
        }
        return null;
    }
}


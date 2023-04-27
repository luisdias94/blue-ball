package src;

import org.academiadecodigo.simplegraphics.pictures.Picture;
public class Background {
    public static final int PADDING = 10;
    public static final int CELLSIZE = 30;
    private Picture background;
    private Picture live1;
    private Picture live2;
    private Picture live3;

    public Background(){
        background = new Picture(PADDING,PADDING, "fundo.png");
        background.draw();
        live1 = new Picture(PADDING+10,PADDING+10, "ball_15x15.png");
        live1.draw();
        live2 = new Picture(PADDING+30,PADDING+10, "ball_15x15.png");
        live2.draw();
        live3 = new Picture(PADDING+50,PADDING+10, "ball_15x15.png");
        live3.draw();
    }

    public int getX(){
        return this.background.getX();
    }
    public int getY(){
        return this.background.getY();
    }
    public int getMaxX(){return background.getMaxX();}
    public int getMaxY(){return background.getMaxY();}
    public int getWidth() {return background.getWidth();}
    public int getHeight() {return background.getHeight();}
    public int maxCol(){return (background.getMaxX() - PADDING)/CELLSIZE;}
    public int maxRow(){return (background.getMaxY() - PADDING)/CELLSIZE;}
    public void deleteLive1(){
        live1.delete();
    }
    public void deleteLive2(){
        live2.delete();
    }
    public void deleteLive3(){
        live3.delete();
    }
}



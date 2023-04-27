package src;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Paddle {
    private Picture paddle;
    private Background pic;
    public static final int positionX = 330;
    public static final int positionY = 640;


    public Paddle(Background pic) {
        this.pic = pic;
        paddle = new Picture(positionX, (positionY - pic.getX()-Background.PADDING), "paddle.png");
        paddle.draw();
    }

    public void moveRight() {
        if (paddle.getMaxX() < pic.getMaxX()- Background.PADDING ) {
            paddle.translate(Background.PADDING, 0);
        }
    }

    public void moveLeft() {
        if (paddle.getX() > Background.PADDING) {
            paddle.translate(-Background.PADDING, 0);
        }
    }
    public int getWidth() {
        return paddle.getWidth();
    }
    public int getX(){return paddle.getX();}
    public int getY(){return paddle.getY();}
    public void deletePaddle(){
        paddle.delete();
    }

}


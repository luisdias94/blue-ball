package src;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball {
    private Picture ball;
    private Paddle paddle;
    public Ball(Paddle paddle){
        ball = new Picture(390, paddle.getY() - Background.PADDING , "ball_15x15.png");
        ball.draw();
    }

    public int getX(){
        return ball.getX();
    }
    public int getY(){
        return ball.getY();
    }

    public int getWidth(){
        return ball.getWidth();
    }
    public int getHeight(){
       return ball.getHeight();
    }
    public void delete(){
        ball.delete();
    }

    public void translate(double dx, double dy){
        ball.translate(dx,dy);
    }
}

package src;

public class Main {
    public static void main(String[] args) {

        Background pic = new Background();
        Paddle paddle = new Paddle(pic);
        Ball ball = new Ball(paddle);
        BrickFactory bf = new BrickFactory(10, 3);
        Brick [][] bricks = bf.getBricks();
        Game game = new Game(pic,paddle,ball, bricks, bf);




    }
}

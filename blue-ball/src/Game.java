package src;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    private Ball ball;
    private Brick[][] bricks;
    private Brick brick;
    private Paddle paddle;
    private Background pic;
    private BrickFactory bf;
    private PaddleHandler paddleHandler;
    private KeyboardManager keyboardManager;
    private Direction direction;
    private boolean inPlay = false;
    private int points = 0;
    private int lives = 3;

    public Game(Background pic, Paddle paddle, Ball ball, Brick[][] bricks, BrickFactory bf) {
        this.pic = pic;
        this.paddle = paddle;
        this.ball = ball;
        this.bricks = bricks;
        this.bf = bf;
        paddleHandler = new PaddleHandler(pic, paddle, this);
        keyboardManager.initKeyEvents(paddleHandler);
        moving();
    }

    public void moving() {
        moveRandomDirection();
        while (!inPlay && lives > 0) {
            if ((ball.getY() > pic.getHeight())) {
                inPlay = false;
                lives--;
                System.out.println("YOU HAVE:  " + lives + " LIVES ALREADY!");
                resetGame();
            }
            boolean collBricks = collisionBricks();
            boolean collPaddle = collisionPaddle();
            boolean collWalls = collisionWall();
            if (!collBricks || !collPaddle || !collWalls) {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                switch (direction) {
                    case DOWN_RIGHT:
                        moveDownRight();
                        break;
                    case DOWN_LEFT:
                        moveDownLeft();
                        break;
                    case UP_RIGHT:
                        moveUpRight();
                        break;
                    case UP_LEFT:
                        moveUpLeft();
                        break;
                }
            }
        }
        endGame();
    }

    public boolean collisionBricks() {
        for (int i = 0; i < bf.getCol(); i++) {
            for (int j = 0; j < bf.getRow(); j++) {
                if (!bricks[i][j].getInGame()) {
                    continue;
                }
                boolean collisionW = ((ball.getX() + ball.getWidth() >= bricks[i][j].getX()) && (ball.getX() <= bricks[i][j].getX() + bricks[i][j].getWidth()));
                boolean collisionH = ((ball.getY() + ball.getHeight() >= bricks[i][j].getY()) && (ball.getY() <= bricks[i][j].getY() + bricks[i][j].getHeight()));
                if (collisionW && collisionH) {
                    bricks[i][j].delete();
                    bricks[i][j].removeBrick();
                    points += 25;
                    System.out.println(points);
                    switch (direction) {
                        case UP_LEFT:
                            if (ball.getY() == bricks[i][j].getY() + bricks[i][j].getHeight()) {
                                direction = Direction.DOWN_LEFT;
                                break;
                            }
                            direction = Direction.UP_RIGHT;
                            break;
                        case UP_RIGHT:
                            if ((ball.getY() == bricks[i][j].getY() + bricks[i][j].getHeight())) {
                                direction = Direction.DOWN_RIGHT;
                                break;
                            }
                            direction = Direction.UP_LEFT;
                            break;
                        case DOWN_RIGHT:
                            if ((ball.getY() + ball.getHeight() == bricks[i][j].getY())) {
                                direction = Direction.UP_RIGHT;
                                break;
                            }
                            direction = Direction.DOWN_LEFT;
                            break;
                        case DOWN_LEFT:
                            if (ball.getY() + ball.getHeight() == bricks[i][j].getY()) {
                                direction = Direction.UP_LEFT;
                                break;
                            }
                            direction = Direction.DOWN_RIGHT;
                            break;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean collisionPaddle() {
        if (ball.getY() + ball.getHeight() == paddle.getY() + Background.PADDING && (ball.getX() + ball.getWidth() > paddle.getX() && ball.getX() < paddle.getX() + paddle.getWidth())) {
            switch (direction) {
                case DOWN_LEFT:
                    direction = Direction.UP_LEFT;
                    break;
                case DOWN_RIGHT:
                    direction = Direction.UP_RIGHT;
                    break;
            }
            return true;
        }
        return false;
    }

    public boolean collisionWall() {
        if (ball.getX() <= pic.getX() || ball.getX() + ball.getWidth() >= pic.getWidth() + Background.PADDING) {

            switch (direction) {
                case DOWN_LEFT:
                    direction = Direction.DOWN_RIGHT;
                    break;
                case DOWN_RIGHT:
                    direction = Direction.DOWN_LEFT;
                    break;
                case UP_LEFT:
                    direction = Direction.UP_RIGHT;
                    break;
                case UP_RIGHT:
                    direction = Direction.UP_LEFT;
                    break;
            }
            return true;
        }
        if (ball.getY() <= Background.PADDING) {
            switch (direction) {
                case UP_RIGHT:
                    direction = Direction.DOWN_RIGHT;
                    break;
                case UP_LEFT:
                    direction = Direction.DOWN_LEFT;
                    break;
            }
            return true;
        }
        return false;
    }

    private void moveUpRight() {
        ball.translate(1, -1);
        direction = Direction.UP_RIGHT;
    }

    private void moveUpLeft() {
        ball.translate(-1, -1);
        direction = Direction.UP_LEFT;
    }

    private void moveDownRight() {
        ball.translate(1, 1);
        direction = Direction.DOWN_RIGHT;
    }

    private void moveDownLeft() {
        ball.translate(-1, 1);
        direction = Direction.DOWN_LEFT;
    }

    private void moveRandomDirection() {
        int direc = (int) (Math.random() * 2);
        switch (direc) {
            case 0:
                direction = direction.UP_LEFT;
                break;
            case 1:
                direction = direction.UP_RIGHT;
                break;
        }
    }

    private void resetGame() {
        if (lives == 0) {
                endGame();
            }
            if (lives == 1) {
                pic.deleteLive2();
                moveRandomDirection();
            } else if (lives == 2) {
                pic.deleteLive3();
                moveRandomDirection();
            }
    }

    private void endGame() {
        Picture gameOver = new Picture(200, 250, "Game-Over.png");
        gameOver.draw();
        ball.delete();
        paddle.deletePaddle();
        pic.deleteLive3();
        pic.deleteLive2();
        pic.deleteLive1();
    }

}
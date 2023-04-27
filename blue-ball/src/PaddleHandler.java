package src;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

    public class PaddleHandler implements KeyboardHandler {
        private Background pic;
        private Paddle paddle;
        private Game game;
        public PaddleHandler(Background pic, Paddle paddle, Game game) {
            this.pic = pic;
            this.paddle = paddle;
            this.game = game;
        }
        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_LEFT:
                    paddle.moveLeft();
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    paddle.moveRight();
                    break;
                case KeyboardEvent.KEY_Q:
                    System.exit(0);
                    break;
                case KeyboardEvent.KEY_SPACE:
                    game.moving();
                    break;
            }
        }
        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
    }



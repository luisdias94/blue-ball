package src;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardManager {
    public static void initKeyEvents(KeyboardHandler handler){
        Keyboard kb = new Keyboard(handler);
        for(Key k : Key.values()){
            KeyboardEvent event = new KeyboardEvent();
            event.setKeyboardEventType(k.type);
            event.setKey(k.keyNum);
            kb.addEventListener(event);
        }
    }
    private enum Key{
        LEFT_PRESS(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED),
        RIGHT_PRESS(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED),
        Q_PRESS(KeyboardEvent.KEY_Q, KeyboardEventType.KEY_PRESSED);
        //SPACE_PRESS(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);

        public final int keyNum;
        public final KeyboardEventType type;


        Key(int keyNum, KeyboardEventType type) {
            this.keyNum = keyNum;
            this.type = type;
        }
    }
}

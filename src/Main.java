import java.awt.*;
public class Main {
    public static void main(String[] args) {
    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    MyFrame frame = new MyFrame();
    manager.addKeyEventDispatcher(frame);
    while (true) {
        frame.repaint();
    }    }
}
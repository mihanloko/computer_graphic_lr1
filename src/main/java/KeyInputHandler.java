import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//todo решить какие клавиши использовать и реализовать
public class KeyInputHandler extends KeyAdapter {
    private final int A = 65;
    private final int S = 83;
    private final int D = 68;
    private final int Q = 81;
    private final int W = 87;
    private final int E = 69;
    private final int ONE = 49;
    private final int TWO = 49;
    private final int THREE = 49;
    private final int FOUR = 49;
    private Mods mod = Mods.Translation;
    private final Main main;

    public KeyInputHandler(Main main) {
        this.main = main;
    }


    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode + " " + e.getKeyChar());
        switch (mod) {
            case Dilation: {

            }
            case Rotation: {

            }
            case Reflection: {

            }
            case Translation: {

            }
        }

    }
}
/*
65 a
83 s
68 d
81 q
87 w
69 e
 */
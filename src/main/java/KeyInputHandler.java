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
    private final int TWO = 50;
    private final int THREE = 51;
    private final int FOUR = 52;
    private final Main main;

    public KeyInputHandler(Main main) {
        this.main = main;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int keyCode = e.getKeyCode();
        System.out.println(keyCode + " " + e.getKeyChar());
        switch (keyCode) {
            case A:
                main.setAPressed(true);
                break;
            case S:
                main.setSPressed(true);
                break;
            case D:
                main.setDPressed(true);
                break;
            case Q:
                main.setQPressed(true);
                break;
            case W:
                main.setWPressed(true);
                break;
            case E:
                main.setEPressed(true);
                break;
            case ONE:
                main.setMod(Mods.Translation.getNum());
                break;
            case TWO:
                main.setMod(Mods.Dilation.getNum());
                break;
            case THREE:
                main.setMod(Mods.Rotation.getNum());
                break;
            case FOUR:
                main.setMod(Mods.Reflection.getNum());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case A:
                main.setAPressed(false);
                break;
            case S:
                main.setSPressed(false);
                break;
            case D:
                main.setDPressed(false);
                break;
            case Q:
                main.setQPressed(false);
                break;
            case W:
                main.setWPressed(false);
                break;
            case E:
                main.setEPressed(false);
                break;
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
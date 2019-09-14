import Picture.Edge;
import Picture.Picture;
import Picture.Point;

import Transformers.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;

public class Main extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    //вещи для потока
    private boolean running;
    private static final int SCREEN_WIDTH = 1000;
    private static final int SCREEN_HEIGHT = 700;

    private Transformer currentTransformer;

    //переменные
    private LinkedList<Point> allPoints = new LinkedList<>();
    private Picture picture = new Picture();
    private Projection projection = new Projection();
    private ArrayList<Transformer> mods;
    private boolean isAPressed = false;
    private boolean isSPressed = false;
    private boolean isDPressed = false;
    private boolean isQPressed = false;
    private boolean isWPressed = false;
    private boolean isEPressed = false;

    private Edge OX, OY, OZ;
    private int lengthOfAxis = 400;

    private final int delay = 20;
    private int x = 100, y = 100;
    private double factor = 1.05;


    //старт игры
    private void start() {
        running = true;
        new Thread(this).start();
    }

    //сам процесс игры
    public void run() {
        long lastTime = System.currentTimeMillis();
        long delta;
        init();
        //рендер
//        render();

        while (running) {
            delta = System.currentTimeMillis() - lastTime;
            if (delta >= delay) {
                if (currentTransformer instanceof Custom) {

                    ((Custom) currentTransformer).setup(factor, x, y);
                    for (int i = 0; i < 10; i++) {
                        currentTransformer.transform(allPoints, Directions.OZPlus);
                        render();
                        waiting();
                    }
                    ((Custom) currentTransformer).setup(1.0 / factor, x, y);
                    for (int i = 0; i < 10; i++) {
                        currentTransformer.transform(allPoints, Directions.OZPlus);
                        render();
                        waiting();
                    }
                    currentTransformer = mods.get(Mods.Translation.getNum());
                }
                else {
                    lastTime = System.currentTimeMillis();
                    render();
                    update();
                }
            }
        }
    }

    //иницализация
    private void init() {
        mods = new ArrayList<>(5);
        mods.add(new Translation());
        mods.add(new Dilation());
        mods.add(new Rotation());
        mods.add(new Reflection());
        mods.add(new Custom());
        currentTransformer = mods.get(Mods.Translation.getNum());

        OX = new Edge(new Point(0, 0, 0), new Point(lengthOfAxis, 0, 0));
        OY = new Edge(new Point(0, 0, 0), new Point(0, lengthOfAxis, 0));
        OZ = new Edge(new Point(0, 0, 0), new Point(0, 0, lengthOfAxis));

        addKeyListener(new KeyInputHandler(this));


        allPoints.add(new Point(0, 0, 0));
        allPoints.add(new Point(0, 200, 0));
        allPoints.add(new Point(40, 200, 0));
        allPoints.add(new Point(100, 100, 0));
        allPoints.add(new Point(160, 200, 0));
        allPoints.add(new Point(200, 200, 0));
        allPoints.add(new Point(200, 0, 0));
        allPoints.add(new Point(180, 0, 0));
        allPoints.add(new Point(180, 180, 0));
        allPoints.add(new Point(160, 180, 0));
        allPoints.add(new Point(110, 80, 0));
        allPoints.add(new Point(90, 80, 0));
        allPoints.add(new Point(40, 180, 0));
        allPoints.add(new Point(20, 180, 0));
        allPoints.add(new Point(20, 0, 0));

        allPoints.add(new Point(0, 0, -30));
        allPoints.add(new Point(0, 200, -30));
        allPoints.add(new Point(40, 200, -30));
        allPoints.add(new Point(100, 100, -30));
        allPoints.add(new Point(160, 200, -30));
        allPoints.add(new Point(200, 200, -30));
        allPoints.add(new Point(200, 0, -30));
        allPoints.add(new Point(180, 0, -30));
        allPoints.add(new Point(180, 180, -30));
        allPoints.add(new Point(160, 180, -30));
        allPoints.add(new Point(110, 80, -30));
        allPoints.add(new Point(90, 80, -30));
        allPoints.add(new Point(40, 180, -30));
        allPoints.add(new Point(20, 180, -30));
        allPoints.add(new Point(20, 0, -30));



        for (int i = 0; i < 14; i++) {
            picture.addEdge(allPoints.get(i), allPoints.get(i + 1));
            picture.addEdge(allPoints.get(i + 15), allPoints.get(i + 1 + 15));
            picture.addEdge(allPoints.get(i), allPoints.get(i + 15));
        }
        picture.addEdge(allPoints.get(0), allPoints.get(14));
        picture.addEdge(allPoints.get(15), allPoints.get(29));
        picture.addEdge(allPoints.get(14), allPoints.get(29));
    }

    //вывод изображения
    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            requestFocus();
            bs = getBufferStrategy();
        }
        //bs = getBufferStrategy();
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        for (Edge edge : picture.getEdges()) {
            drawEdge(projection.projectionOfEdge(edge), g2d);
        }

        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        drawEdge(OX, g2d);
        drawEdge(OY, g2d);
        drawEdge(projection.projectionOfEdge(OZ), g2d);

        g2d.dispose();
        g.dispose();
        bs.show();

    }

    private void drawEdge(Edge edge, Graphics2D graphics2D) {
        int ax = (int) edge.getA().getCoordinates()[0],
                ay = (int) edge.getA().getCoordinates()[1],
                bx = (int) edge.getB().getCoordinates()[0],
                by = (int) edge.getB().getCoordinates()[1];
        int middleX = getWidth() / 2;
        int middleY = getHeight() / 2;
        /*System.out.println(
                (middleX + ax) + " " +
                        (middleY - ay) + " " +
                        (middleX + bx) + " " +
                        (middleY - by));*/
        graphics2D.drawLine(
                middleX + ax,
                middleY - ay,
                middleX + bx,
                middleY - by);
    }

    //обновление дистанции и ускорения
    private void update() {
        if (isAPressed) {
            currentTransformer.transform(allPoints, Directions.OXMinus);
        }
        if (isSPressed) {
            currentTransformer.transform(allPoints, Directions.OYMinus);
        }
        if (isDPressed) {
            currentTransformer.transform(allPoints, Directions.OXPlus);

        }
        if (isQPressed) {
            currentTransformer.transform(allPoints, Directions.OZMinus);

        }
        if (isWPressed) {
            currentTransformer.transform(allPoints, Directions.OYPlus);

        }
        if (isEPressed) {
            currentTransformer.transform(allPoints, Directions.OZPlus);

        }

        if (currentTransformer instanceof Reflection) {
            setAPressed(false);
            setSPressed(false);
            setDPressed(false);
            setQPressed(false);
            setWPressed(false);
            setEPressed(false);
        }
    }

    private void waiting() {
        long lastTime = System.currentTimeMillis();
        long delta;
        delta = System.currentTimeMillis() - lastTime;
        while (delta <= delay) {
            delta = System.currentTimeMillis() - lastTime;
        }
    }

    public void setMod(int mod) {
        currentTransformer = mods.get(mod);
    }

    public void setAPressed(boolean flag) {
        isAPressed = flag;
    }
    public void setSPressed(boolean flag) {
        isSPressed = flag;
    }
    public void setDPressed(boolean flag) {
        isDPressed = flag;
    }
    public void setQPressed(boolean flag) {
        isQPressed = flag;
    }
    public void setWPressed(boolean flag) {
        isWPressed = flag;
    }
    public void setEPressed(boolean flag) {
        isEPressed = flag;
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();
    }


}
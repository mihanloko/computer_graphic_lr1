import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    //вещи для потока
    private boolean running;
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;

    private Mods mod = Mods.Translation;

    //переменные
    private LinkedList<Point> allPoints = new LinkedList<>();
    private Picture picture = new Picture();
    private Projection projection = new Projection();

    private double magic = 0.0628319;
    private int delay = 10 * 2;

    private double x = 200, y = 200;

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
                lastTime = System.currentTimeMillis();
                render();
                update();

            }
        }
    }

    //иницализация
    private void init() {
        addKeyListener(new KeyInputHandler(this));

        //todo нормальное составить изображение
        allPoints.add(new Point(0, 0, 0));
        allPoints.add(new Point(0, 200, 0));
        allPoints.add(new Point(200, 200, 0));
        allPoints.add(new Point(200, 0, 0));
        allPoints.add(new Point(0, 0, 200));
        allPoints.add(new Point(0, 200, 200));
        allPoints.add(new Point(200, 200, 200));
        allPoints.add(new Point(200, 0, 200));

        picture.addEdge(allPoints.get(0), allPoints.get(1));
        picture.addEdge(allPoints.get(1), allPoints.get(2));
        picture.addEdge(allPoints.get(2), allPoints.get(3));
        picture.addEdge(allPoints.get(3), allPoints.get(0));

        picture.addEdge(allPoints.get(4), allPoints.get(5));
        picture.addEdge(allPoints.get(5), allPoints.get(6));
        picture.addEdge(allPoints.get(6), allPoints.get(7));
        picture.addEdge(allPoints.get(7), allPoints.get(4));

        picture.addEdge(allPoints.get(0), allPoints.get(4));
        picture.addEdge(allPoints.get(1), allPoints.get(5));
        picture.addEdge(allPoints.get(2), allPoints.get(6));
        picture.addEdge(allPoints.get(3), allPoints.get(7));


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

        for (Edge edge: picture.getEdges()) {
            drawEdge(projection.projectionOfEdge(edge), g2d);
        }

        g2d.dispose();
        g.dispose();
        bs.show();


    }

    private void drawEdge(Edge edge, Graphics2D graphics2D) {
        int ax = (int)edge.getA().getCoordinates()[0],
                ay = (int)edge.getA().getCoordinates()[1],
                bx = (int)edge.getB().getCoordinates()[0],
                by = (int)edge.getB().getCoordinates()[1];
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

    //обработка событий мыши
//    private class MouseInputListener extends MouseAdapter {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            if (menu) {
//                if (e.getY() <= 200 + image.getHeight(null) && e.getY() >= 200) {
//                    if (e.getX() <= 250 && e.getX() >= 150) {
//                        menu = !menu;
//                        mod = new StandardMode();
//                        myDistance = 0;
//                        enemyDistance = 0;
//                        myCar.increaseY(-myCar.getY() + HEIGHT - myCar.getHeight());
//                        leftPressed = rightPressed = upPressed = false;
//                        boost = 0;
//                    } else if (e.getX() >= 250 && e.getX() <= 350) {
//                        menu = !menu;
//                        mod = new SpecialMode();
//                        myDistance = 0;
//                        enemyDistance = 0;
//                        myCar.increaseY(-myCar.getY() + 400);
//                        leftPressed = rightPressed = upPressed = false;
//                        boost = 0;
//                    } else if (e.getX() >= 350 && e.getX() <= 450) {
//                        mod = new RiderMode();
//                        menu = !menu;
//                        myDistance = 0;
//                        enemyDistance = 0;
//                        myCar.increaseY(-myCar.getY() + 400);
//                        leftPressed = rightPressed = upPressed = false;
//                        boost = 0;
//                    } else if (e.getX() >= 450 && e.getX() <= 550) {
//                        mod = new NightMode();
//                        menu = !menu;
//                        myDistance = 0;
//                        enemyDistance = 0;
//                        myCar.increaseY(-myCar.getY() + HEIGHT - myCar.getHeight() + 10);
//                        leftPressed = rightPressed = upPressed = false;
//                        boost = 0;
//                        Night = true;
//                    } else if (e.getX() >= 550 && e.getX() <= 650) {
//                        mod = new IceMode();
//                        menu = !menu;
//                        myDistance = 0;
//                        enemyDistance = 0;
//                        myCar.increaseY(-myCar.getY() + 400);
//                        leftPressed = rightPressed = upPressed = false;
//                        boost = 0;
//                    }
//                }
//            }
//        }
//    }
//
//    //обработка событий клавиатуры
//    private class KeyInputHandler extends KeyAdapter {
//        public void keyPressed(KeyEvent e) {
//            if (!menu) {
//                if (e.getKeyCode() == KeyEvent.VK_LEFT)
//                    leftPressed = true;
//                if (e.getKeyCode() == KeyEvent.VK_RIGHT)
//                    rightPressed = true;
//                if (e.getKeyCode() == KeyEvent.VK_UP) {
//                    upPressed = true;
//                    startOfBoost = System.currentTimeMillis();
//                }
//            }
//        }
//
//        public void keyReleased(KeyEvent e) {
//            if (!menu) {
//                if (e.getKeyCode() == KeyEvent.VK_LEFT)
//                    leftPressed = false;
//                if (e.getKeyCode() == KeyEvent.VK_RIGHT)
//                    rightPressed = false;
//                if (e.getKeyCode() == KeyEvent.VK_UP) {
//                    upPressed = false;
//                    startOfBoost = System.currentTimeMillis();
//                }
//            }
//        }
//    }
}
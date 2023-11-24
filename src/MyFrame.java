import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

public class MyFrame extends JFrame implements KeyEventDispatcher, MouseListener {
    ArrayList<Blocks> korabl = new ArrayList<Blocks>();
    int colvoblokovvkorable = 9;
    Random r = new Random();

    public MyFrame() {
        korabl.add(new Blocks(940, 540, 0));
        korabl.add(new Blocks(920, 540, 0));
        korabl.add(new Blocks(960, 540, 0));
        korabl.add(new Blocks(940, 520, 1));
        korabl.add(new Blocks(940, 560, 1));
        korabl.add(new Blocks(960, 560, 0));
        korabl.add(new Blocks(920, 520, 1));
        korabl.add(new Blocks(920, 560, 0));
        korabl.add(new Blocks(960, 520, 1));
        setSize(1930, 1080);
        addMouseListener((MouseListener) this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    @Override
    public void paint(Graphics g) {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(2);
            bufferStrategy = getBufferStrategy();
        }
        g = bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());
        for (int i = 0; i < colvoblokovvkorable; i = i + 1) {
            korabl.get(i).paint(g);
        }
        ;
        System.out.println(colvoblokovvkorable);
        g.dispose();
        bufferStrategy.show();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int min = 40;
        int ux = e.getX() - (e.getX() % 20);
        int uy = e.getY() - (e.getY() % 20);
        if ((e.getX() % 20) > 10) {
            ux = e.getX() - (e.getX() % 20) + 20;
        }
        ;
        if ((e.getY() % 20) > 10) {
            uy = e.getY() - (e.getY() % 20) + 20;
        }
        for (int i = 0; i < colvoblokovvkorable; i = i + 1) {
            if (((Math.abs(ux - korabl.get(i).x)) + (Math.abs(uy - korabl.get(i).y))) < min) {
                min = ((Math.abs(ux - korabl.get(i).x)) + (Math.abs(uy - korabl.get(i).y)));
            }

        }

        if (min == 20) {
            korabl.add(new Blocks(ux, uy, r.nextInt(2)));
            colvoblokovvkorable = colvoblokovvkorable + 1;
            System.out.println(ux + " " + uy);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        return false;
    }
}
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
    int zw = 0;
    int zs = 0;
    int za = 0;
    int zd = 0;
    double gr_verh = -1000;
    double gr_nizh = 2080;
    double gr_lev = -1000;
    double gr_prav = 2920;
    int pause = 0;
    double m = 0;
    double n = -13;
    int kolvo_vragov = 3;
    int f = 0;
    int k;
    int l;
    int p;
    ArrayList<Blocks> vragi = new ArrayList<Blocks>();
    ArrayList<Bullet> bullets_vragov = new ArrayList<Bullet>();
    ArrayList<Bullet> bullets_korablya = new ArrayList<Bullet>();
    int kolvo_bullets_korablya;
    int kolvo_bullets_vragov;
    int oput = 0;
    int max_shkala = 100;
    int shkala = 0;
    int vub = -1;
    ArrayList<Integer> vub_bloki = new ArrayList<Integer>();


    public MyFrame() {
        korabl.add(new Blocks(930, 540, 0, 0, 0, 0, 0, 200, 1));
        korabl.add(new Blocks(900, 540, 0, 0, 0, 0, 0, 200, 1));
        korabl.add(new Blocks(960, 540, 0, 0, 0, 0, 0, 200, 1));
        korabl.add(new Blocks(930, 510, 1, 0, 0, 0, 0, 200, 1));
        korabl.add(new Blocks(930, 570, 1, 0, 0, 0, 0, 200, 1));
        korabl.add(new Blocks(960, 570, 0, 0, 0, 0, 0, 200, 1));
        korabl.add(new Blocks(900, 510, 1, 0, 0, 0, 0, 200, 1));
        korabl.add(new Blocks(900, 570, 0, 0, 0, 0, 0, 200, 1));
        korabl.add(new Blocks(960, 510, 1, 0, 0, 0, 0, 200, 1));
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
        if (f == 0) {
            vragi.add(new Blocks(r.nextInt(1930), r.nextInt(1080), r.nextInt(2), 1, 1, 0, 0, 200, 1));
            vragi.add(new Blocks(r.nextInt(1930), r.nextInt(1080), r.nextInt(2), -1, 1, 0, 0, 200, 1));
            vragi.add(new Blocks(r.nextInt(1930), r.nextInt(1080), r.nextInt(2), -1, -1, 0, 0, 200, 1));
            f = 1;

        }
        for (int i = 0; i < kolvo_vragov; i = i + 1) { //получение опыта
            if ((vragi.get(i).hp < 1) && (vragi.get(i).zhisn == 1)) {
                shkala = shkala + 10;
                vragi.get(i).zhisn = 0;
            }
        }
        if (shkala > max_shkala - 1) {   //получение опыта 2.0
            oput = oput + 1;
            shkala = shkala - max_shkala;
            max_shkala = max_shkala + 10;
        }
        if (pause == 0) {          //движение корабля
            if ((zw == 1) && (gr_verh < 540)) {
                gr_verh = gr_verh + 0.6;
                gr_nizh = gr_nizh + 0.6;
                for (int i = 0; i < kolvo_vragov; i = i + 1) {
                    vragi.get(i).y = vragi.get(i).y + 0.6;
                }
                for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) {
                    bullets_vragov.get(i).y = bullets_vragov.get(i).y + 0.6;
                }
                for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) {
                    bullets_korablya.get(i).y = bullets_korablya.get(i).y + 0.6;
                }
            }
            if ((zs == 1) && (gr_nizh > 540)) {
                gr_nizh = gr_nizh - 0.6;
                gr_verh = gr_verh - 0.6;
                for (int i = 0; i < kolvo_vragov; i = i + 1) {
                    vragi.get(i).y = vragi.get(i).y - 0.6;
                }
                for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) {
                    bullets_vragov.get(i).y = bullets_vragov.get(i).y - 0.6;
                }
                for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) {
                    bullets_korablya.get(i).y = bullets_korablya.get(i).y - 0.6;
                }
            }
            if ((za == 1) && (gr_lev < 930)) {
                gr_lev = gr_lev + 0.6;
                gr_prav = gr_prav + 0.6;
                for (int i = 0; i < kolvo_vragov; i = i + 1) {
                    vragi.get(i).x = vragi.get(i).x + 0.6;
                }
                for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) {
                    bullets_vragov.get(i).x = bullets_vragov.get(i).x + 0.6;
                }
                for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) {
                    bullets_korablya.get(i).x = bullets_korablya.get(i).x + 0.6;
                }
            }
            if ((zd == 1) && (gr_prav > 930)) {
                gr_lev = gr_lev - 0.6;
                gr_prav = gr_prav - 0.6;
                for (int i = 0; i < kolvo_vragov; i = i + 1) {
                    vragi.get(i).x = vragi.get(i).x - 0.6;
                }
                for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) {
                    bullets_vragov.get(i).x = bullets_vragov.get(i).x - 0.6;
                }
                for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) {
                    bullets_korablya.get(i).x = bullets_korablya.get(i).x - 0.6;
                }
            }
        }
        if (pause == 0) {              //счетчик выстрелов
            for (int i = 0; i < kolvo_vragov; i = i + 1) {
                vragi.get(i).vremya2 = vragi.get(i).vremya2 + 0.01;
            }
            for (int i = 0; i < colvoblokovvkorable; i = i + 1) {
                korabl.get(i).vremya2 = korabl.get(i).vremya2 + 0.01;
            }
        }
        for (int i = 0; i < kolvo_vragov; i = i + 1) {//проверка выстрелов врагов
            if (vragi.get(i).hp > 0) {
                if ((vragi.get(i).x > 100) && (vragi.get(i).x < 1930) && (vragi.get(i).y > 0) && (vragi.get(i).y < 980)) {
                    if ((vragi.get(i).vremya2 > vragi.get(i).vremya1 + 3) && (vragi.get(i).tipblocka == 0)) {
                        double m = 1 * (930 - vragi.get(i).x) / Math.sqrt((930 - vragi.get(i).x) * (930 - vragi.get(i).x) + (540 - vragi.get(i).y) * (540 - vragi.get(i).y));
                        double n = 1 * (540 - vragi.get(i).y) / Math.sqrt((930 - vragi.get(i).x) * (930 - vragi.get(i).x) + (540 - vragi.get(i).y) * (540 - vragi.get(i).y));
                        bullets_vragov.add(new Bullet(vragi.get(i).x, vragi.get(i).y, 1, vragi.get(i).tipblocka, m, n));
                        kolvo_bullets_vragov = kolvo_bullets_vragov + 1;
                        vragi.get(i).vremya1 = vragi.get(i).vremya2;
                    }
                    if ((vragi.get(i).vremya2 > vragi.get(i).vremya1 + 5) && (vragi.get(i).tipblocka == 1)) {
                        double m = 0.7 * (930 - vragi.get(i).x) / Math.sqrt((930 - vragi.get(i).x) * (930 - vragi.get(i).x) + (540 - vragi.get(i).y) * (540 - vragi.get(i).y));
                        double n = 0.7 * (540 - vragi.get(i).y) / Math.sqrt((930 - vragi.get(i).x) * (930 - vragi.get(i).x) + (540 - vragi.get(i).y) * (540 - vragi.get(i).y));
                        bullets_vragov.add(new Bullet(vragi.get(i).x, vragi.get(i).y, 1, vragi.get(i).tipblocka, m, n));
                        kolvo_bullets_vragov = kolvo_bullets_vragov + 1;
                        vragi.get(i).vremya1 = vragi.get(i).vremya2;
                    }
                }
            }
        }
        for (int i = 0; i < colvoblokovvkorable; i = i + 1) {   //проверка выстрелов корабля
            if (korabl.get(i).hp > 0) {
                if ((korabl.get(i).vremya2 > korabl.get(i).vremya1 + 3) && (korabl.get(i).tipblocka == 0)) {
                    bullets_korablya.add(new Bullet(korabl.get(i).x, korabl.get(i).y, 1, korabl.get(i).tipblocka, m / 13, n / 13));
                    kolvo_bullets_korablya = kolvo_bullets_korablya + 1;
                    korabl.get(i).vremya1 = korabl.get(i).vremya2;
                }
                if ((korabl.get(i).vremya2 > korabl.get(i).vremya1 + 5) && (korabl.get(i).tipblocka == 1)) {
                    bullets_korablya.add(new Bullet(korabl.get(i).x, korabl.get(i).y, 1, korabl.get(i).tipblocka, 7 * m / 130, 7 * n / 130));
                    kolvo_bullets_korablya = kolvo_bullets_korablya + 1;
                    korabl.get(i).vremya1 = korabl.get(i).vremya2;
                }
            }
        }
        if (pause == 0) {    //движение врагов
            for (int i = 0; i < kolvo_vragov; i = i + 1) {
                if ((vragi.get(i).x > -30) && (vragi.get(i).x < 1930) && (vragi.get(i).y > -30) && (vragi.get(i).y < 1100)) {
                    double m = 0.4 * (930 - vragi.get(i).x) / Math.sqrt((930 - vragi.get(i).x) * (930 - vragi.get(i).x) + (540 - vragi.get(i).y) * (540 - vragi.get(i).y));
                    double n = 0.4 * (540 - vragi.get(i).y) / Math.sqrt((930 - vragi.get(i).x) * (930 - vragi.get(i).x) + (540 - vragi.get(i).y) * (540 - vragi.get(i).y));
                    vragi.get(i).x = vragi.get(i).x + m;
                    vragi.get(i).y = vragi.get(i).y + n;
                } else {
                    vragi.get(i).x = vragi.get(i).x - (vragi.get(i).scor_x) * 0.4;
                    vragi.get(i).y = vragi.get(i).y - (vragi.get(i).scor_y) * 0.4;
                }
            }
        }
        if (pause == 0) {   //движение всех пуль
            for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) {
                bullets_vragov.get(i).x = bullets_vragov.get(i).x + bullets_vragov.get(i).m;
                bullets_vragov.get(i).y = bullets_vragov.get(i).y + bullets_vragov.get(i).n;
            }
            for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) {
                bullets_korablya.get(i).x = bullets_korablya.get(i).x + bullets_korablya.get(i).m;
                bullets_korablya.get(i).y = bullets_korablya.get(i).y + bullets_korablya.get(i).n;
            }
        }
        for (int i = 0; i < kolvo_vragov; i = i + 1) { //движение врагов вне зоны видимости
            if (vragi.get(i).x < gr_lev) {
                vragi.get(i).scor_x = -1;
            }
            if (vragi.get(i).x > gr_prav) {
                vragi.get(i).scor_x = 1;
            }
            if (vragi.get(i).y < gr_verh) {
                vragi.get(i).scor_y = -1;
            }
            if (vragi.get(i).y > gr_nizh) {
                vragi.get(i).scor_y = 1;
            }
        }
        for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) { //проверка повреждений корабля
            if (bullets_vragov.get(i).zaryad == 1) {
                for (int j = 0; j < colvoblokovvkorable; j = j + 1) {
                    if ((bullets_vragov.get(i).zaryad == 1) && (korabl.get(j).hp > 0) && (Math.abs(bullets_vragov.get(i).x - korabl.get(j).x) < 16) && (Math.abs(bullets_vragov.get(i).y - korabl.get(j).y) < 16)) {
                        bullets_vragov.get(i).zaryad = 0;
                        if (bullets_vragov.get(i).tipblocka == 0) {
                            korabl.get(j).hp = korabl.get(j).hp - 10;
                        }
                        if (bullets_vragov.get(i).tipblocka == 1) {
                            korabl.get(j).hp = korabl.get(j).hp - 20;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) { //проверка повреждений корабля
            if (bullets_korablya.get(i).zaryad == 1) {
                for (int j = 0; j < kolvo_vragov; j = j + 1) {
                    if ((bullets_korablya.get(i).zaryad == 1) && (vragi.get(j).hp > 0) && (Math.abs(bullets_korablya.get(i).x - vragi.get(j).x) < 16) && (Math.abs(bullets_korablya.get(i).y - vragi.get(j).y) < 16)) {
                        bullets_korablya.get(i).zaryad = 0;
                        if (bullets_korablya.get(i).tipblocka == 0) {
                            vragi.get(j).hp = vragi.get(j).hp - 10;
                        }
                        if (bullets_korablya.get(i).tipblocka == 1) {
                            vragi.get(j).hp = vragi.get(j).hp - 20;
                        }
                    }
                }
            }
        }
        if (pause == 0) {
            for (int i = 0; i < kolvo_vragov; i = i + 1) { //отрисовка врагов которые смотрят на тебя
                if (vragi.get(i).hp > 0) {
                    if ((vragi.get(i).x > -30) && (vragi.get(i).x < 1930) && (vragi.get(i).y > -30) && (vragi.get(i).y < 1100)) {
                        double m = 13 * (930 - vragi.get(i).x) / Math.sqrt((930 - vragi.get(i).x) * (930 - vragi.get(i).x) + (540 - vragi.get(i).y) * (540 - vragi.get(i).y));
                        double n = 13 * (540 - vragi.get(i).y) / Math.sqrt((930 - vragi.get(i).x) * (930 - vragi.get(i).x) + (540 - vragi.get(i).y) * (540 - vragi.get(i).y));
                        vragi.get(i).paint(g, m, n);
                    }
                }
            }
        }
        if (pause == 2) {
            g.drawRect(90,90,500,900);
            g.drawRect(640,90,500,900);
            g.drawRect(1190,90,500,900);
            if(k == 0){
                g.drawOval(100,290,480,480);
            }
            if( k == 1){
                g.drawRect(110,110,460,860);
            }
            if(l == 0){
                g.drawOval(650,290,480,480);
            }
            if( l == 1){
                g.drawRect(660,110,460,860);
            }
            if(k == 0){
                g.drawOval(1200,290,480,480);
            }
            if( k == 1){
                g.drawRect(1210,110,460,860);
            }
        }
        if (pause < 2) {
            for (int i = 0; i < colvoblokovvkorable; i = i + 1) {
                korabl.get(i).paint(g, m, n);
            }
        }
        if (pause == 0) {
            for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) {
                bullets_vragov.get(i).paint(g);
            }
            for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) {
                bullets_korablya.get(i).paint(g);
            }
        }
        g.drawLine((int) gr_lev, (int) gr_nizh, (int) gr_lev, (int) gr_verh);
        g.drawLine((int) gr_lev, (int) gr_nizh, (int) gr_prav, (int) gr_nizh);
        g.drawLine((int) gr_prav, (int) gr_nizh, (int) gr_prav, (int) gr_verh);
        g.drawLine((int) gr_prav, (int) gr_verh, (int) gr_lev, (int) gr_verh);
        Color cr2 = new Color(255, 255, 255);
        g.setColor(cr2);
        g.fillRect(500, 650, max_shkala, 10);
        Color e = new Color(58, 246, 6);
        g.setColor(e);
        g.fillRect(500, 650, shkala, 10);
        Color cr1 = new Color(0, 0, 0);
        g.setColor(cr1);
        g.drawRect(500, 650, max_shkala, 10);
        g.drawString("Exp." + oput, 500, 640);
        g.dispose();
        bufferStrategy.show();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (pause == 0) {
            m = 13 * (e.getX() - 930) / Math.sqrt((e.getX() - 930) * (e.getX() - 930) + (e.getY() - 540) * (e.getY() - 540));
            n = 13 * (e.getY() - 540) / Math.sqrt((e.getX() - 930) * (e.getX() - 930) + (e.getY() - 540) * (e.getY() - 540));
        }
        if (pause == 2) {
            if((e.getX()<590)&&(e.getX()>90)&&(e.getY()>90)&&(e.getY()<990)){
                vub = vub + 1;
                vub_bloki.add(k);
                pause = 1;
            }
            if((e.getX()<1140)&&(e.getX()>640)&&(e.getY()>90)&&(e.getY()<990)){
                vub = vub + 1;
                vub_bloki.add(l);
                pause = 1;
            }
            if((e.getX()<1690)&&(e.getX()>1190)&&(e.getY()>90)&&(e.getY()<990)){
                vub = vub + 1;
                vub_bloki.add(p);
                pause = 1;
            }
        }
        if (pause == 1) {
            int min = 60;
            int ux = e.getX() - (e.getX() % 30);
            int uy = e.getY() - (e.getY() % 30);
            if ((e.getX() % 30) > 15) {
                ux = e.getX() - (e.getX() % 30) + 30;
            }
            ;
            if ((e.getY() % 30) > 15) {
                uy = e.getY() - (e.getY() % 30) + 30;
            }
            for (int i = 0; i < colvoblokovvkorable; i = i + 1) {
                if ((((Math.abs(ux - korabl.get(i).x)) + (Math.abs(uy - korabl.get(i).y))) < min) && (korabl.get(i).hp > 0)) {
                    min = ((Math.abs(ux - (int) korabl.get(i).x)) + (Math.abs(uy - (int) korabl.get(i).y)));
                }

            }

            if ((min < 35) && (min > 0)) {
                korabl.add(new Blocks(ux, uy, vub_bloki.get(vub), 0, 0, 0, 0, 200, 1));
                colvoblokovvkorable = colvoblokovvkorable + 1;
                oput = oput - 1;
                pause = 0;
            }
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
        if ((e.getKeyCode() == KeyEvent.VK_ENTER) && (e.getID() == KeyEvent.KEY_PRESSED) && (oput > 0)) {
            if (pause == 0) {
                pause = 2;
                za = 0;
                zw = 0;
                zs = 0;
                zd = 0;
                k = r.nextInt(2);
                l = r.nextInt(2);
                p = r.nextInt(2);
            }
        }
        if ((pause == 0) && (e.getKeyCode() == KeyEvent.VK_SPACE) && (e.getID() == KeyEvent.KEY_PRESSED)) {
            vragi.add(new Blocks(r.nextInt(1500), r.nextInt(1000), r.nextInt((2)), r.nextInt((3)) - 1, r.nextInt(3) - 1, 0, 0, 200, 1));
            kolvo_vragov = kolvo_vragov + 1;
        }
        if ((pause == 0) && (e.getID() == KeyEvent.KEY_PRESSED) && (e.getKeyCode() == 87)) {
            zw = 1;
        }
        if ((pause == 0) && (e.getID() == KeyEvent.KEY_RELEASED) && (e.getKeyCode() == 87)) {
            zw = 0;
        }
        if ((pause == 0) && (e.getID() == KeyEvent.KEY_PRESSED) && (e.getKeyCode() == 83)) {
            zs = 1;
        }
        if ((pause == 0) && (e.getID() == KeyEvent.KEY_RELEASED) && (e.getKeyCode() == 83)) {
            zs = 0;
        }
        if ((pause == 0) && (e.getID() == KeyEvent.KEY_PRESSED) && (e.getKeyCode() == 65)) {
            za = 1;
        }
        if ((pause == 0) && (e.getID() == KeyEvent.KEY_RELEASED) && (e.getKeyCode() == 65)) {
            za = 0;
        }
        if ((pause == 0) && (e.getID() == KeyEvent.KEY_PRESSED) && (e.getKeyCode() == 68)) {
            zd = 1;
        }
        if ((pause == 0) && (e.getID() == KeyEvent.KEY_RELEASED) && (e.getKeyCode() == 68)) {
            zd = 0;
        }
        return false;
    }
}
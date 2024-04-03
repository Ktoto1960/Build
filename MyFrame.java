import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    int oput = 1;
    int max_shkala = 100;
    int shkala = 0;
    int vub = -1;
    int monetu = 0;
    ArrayList<Integer> vub_bloki = new ArrayList<Integer>();
    double uscor;
    int ul1 = 0;
    int ul2 = 0;
    int ul3 = 0;
    int cena_ul1 = 20;
    int cena_ul2 = 20;
    int cena_ul3 = 20;
    BufferedImage image = ImageIO.read(new File("data 2\\cos.jpg"));
    BufferedImage image2 = ImageIO.read(new File("data 3 special\\kol.jpg"));
    Double time_1 = (double) 0;
    Double time_2 = (double) 0;
    ArrayList<Blocks> boss = new ArrayList<Blocks>();
    double do_bossa = 0;

    public MyFrame() throws IOException {
        korabl.add(new Blocks(930, 540, 3, 0, 0, 0, 1.3, 1200, 1));
        korabl.add(new Blocks(900, 540, 0, 0, 0, 0, 4.57, 200, 1));
        korabl.add(new Blocks(960, 540, 0, 0, 0, 0, 2.68, 200, 1));
        korabl.add(new Blocks(930, 510, 1, 0, 0, 0, 0.93, 200, 1));
        korabl.add(new Blocks(930, 570, 2, 0, 0, 0, 0, 200, 1));
        korabl.add(new Blocks(960, 570, 0, 0, 0, 0, 3.78, 200, 1));
        korabl.add(new Blocks(900, 510, 1, 0, 0, 0, 2.45, 200, 1));
        korabl.add(new Blocks(900, 570, 0, 0, 0, 0, 0, 200, 1));
        korabl.add(new Blocks(960, 510, 1, 0, 0, 0, 0, 200, 1));

        boss.add(new Blocks(930, 540, 3, 0, 0, 0, 1.3, 1200, 1));
        boss.add(new Blocks(900, 540, 1, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(960, 540, 1, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(930, 510, 1, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(930, 570, 1, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(960, 570, 1, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(900, 510, 1, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(900, 570, 1, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(960, 510, 1, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(900, 480, 2, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(930, 480, 2, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(960, 480, 2, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(900, 600, 2, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(930, 600, 2, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(960, 600, 2, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(870, 510, 2, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(870, 540, 2, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(870, 570, 2, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(990, 510, 2, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(990, 540, 2, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(990, 570, 2, 0, 0, 0, 1.3, 200, 1));
        boss.add(new Blocks(990, 600, 3, 0, 0, 0, 1.3, 1200, 1));
        boss.add(new Blocks(870, 600, 3, 0, 0, 0, 1.3, 1200, 1));
        boss.add(new Blocks(990, 480, 3, 0, 0, 0, 1.3, 1200, 1));
        boss.add(new Blocks(870, 480, 3, 0, 0, 0, 1.3, 1200, 1));
        setSize(1930, 1080);
        addMouseListener((MouseListener) this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private static BufferedImage resize(BufferedImage img, int width, int height) {

        double scalex = (double) width / img.getWidth();
        double scaley = (double) height / img.getHeight();
        double scale = Math.min(scalex, scaley);

        int w = (int) (img.getWidth() * scale);
        int h = (int) (img.getHeight() * scale);

        Image tmp = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);

        BufferedImage resized = new BufferedImage(w, h, img.getType());
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return resized;
    }
    BufferedImage image1 = resize(image, 10000, 4720);
    @Override
    public void paint(Graphics g) {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(2);
            bufferStrategy = getBufferStrategy();
        }
        g = bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());
        if((pause !=4)&&(pause!=5)) {if (f == 0) {
            vragi.add(new Blocks(r.nextInt(1930), r.nextInt(1080), r.nextInt(2), 1, 1, 0, 0, 200, 1));
            vragi.add(new Blocks(r.nextInt(1930), r.nextInt(1080), r.nextInt(2), -1, 1, 0, 0, 200, 1));
            vragi.add(new Blocks(r.nextInt(1930), r.nextInt(1080), r.nextInt(2), -1, -1, 0, 0, 200, 1));
            f = 1;

        }
        if(pause == 0){                  //спавн врагов
            time_2 = time_2 + 0.01;
            do_bossa = do_bossa + 1;
        }
        if(time_2 > time_1 + 3){
            time_1 = time_2;
            int dx = 500;
            int dy = 500;
            for(int i = 0; i < 20; i = i + 1){
                if((dx > -5)&&(dx < 1935)){
                    dx = r.nextInt(3910) + (int)gr_lev + 5;
                }
            }
            for(int i = 0; i < 20; i = i + 1){
                if((dy > -5)&&(dy < 1085)){
                    dy = r.nextInt(3070) + (int)gr_verh + 5;
                }
            }
            if(((dx <= -5) || (dx>=1085))&&((dy<=-5) || (dy>=1085))){
            vragi.add(new Blocks(dx, dy, r.nextInt((2)), r.nextInt((3)) - 1, r.nextInt(3) - 1, 0, 0, 200, 1));
            kolvo_vragov = kolvo_vragov + 1;}
        }
        for (int i = 0; i < kolvo_vragov; i = i + 1) { //получение опыта и монет
            if ((vragi.get(i).hp < 1) && (vragi.get(i).zhisn == 1)) {
                shkala = shkala + 10;
                vragi.get(i).zhisn = 0;
                monetu = monetu + 2;
            }
        }
        if (shkala > max_shkala - 1) {   //получение опыта 2.0
            oput = oput + 1;
            shkala = shkala - max_shkala;
            max_shkala = max_shkala + 10;
        }
        double t = 0;
        for (int i = 0; i < colvoblokovvkorable; i = i + 1) {                 //ускорение
            if ((korabl.get(i).hp > 0) && (korabl.get(i).tipblocka == 2)) {
                t = t + 0.05;
            }
        }
        uscor = t + ul3*0.015 +0.3 ;
        if (pause == 0) {          //движение корабля
            if ((zw == 1) && (gr_verh < 540)) {
                gr_verh = gr_verh + 0.6 + uscor;
                gr_nizh = gr_nizh + 0.6 + uscor;
                for (int i = 0; i < kolvo_vragov; i = i + 1) {
                    vragi.get(i).y = vragi.get(i).y + 0.6 + uscor;
                }
                for (int i = 0; i < 25; i = i + 1) {
                    boss.get(i).y = boss.get(i).y + 0.6 + uscor;
                }
                for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) {
                    bullets_vragov.get(i).y = bullets_vragov.get(i).y + 0.6 + uscor;

                }
                for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) {
                    bullets_korablya.get(i).y = bullets_korablya.get(i).y + 0.6 + uscor;

                }

            }
            if ((zs == 1) && (gr_nizh > 540)) {
                gr_nizh = gr_nizh - 0.6 - uscor;

                gr_verh = gr_verh - 0.6 - uscor;

                for (int i = 0; i < kolvo_vragov; i = i + 1) {
                    vragi.get(i).y = vragi.get(i).y - 0.6 - uscor;

                }
                for (int i = 0; i < 25; i = i + 1) {
                    boss.get(i).y = boss.get(i).y - 0.6 - uscor;

                }
                for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) {
                    bullets_vragov.get(i).y = bullets_vragov.get(i).y - 0.6 - uscor;

                }
                for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) {
                    bullets_korablya.get(i).y = bullets_korablya.get(i).y - 0.6 - uscor;

                }
            }
            if ((za == 1) && (gr_lev < 930)) {
                gr_lev = gr_lev + 0.6 + uscor;
                gr_prav = gr_prav + 0.6 + uscor;
                for (int i = 0; i < kolvo_vragov; i = i + 1) {
                    vragi.get(i).x = vragi.get(i).x + 0.6 + uscor;

                }
                for (int i = 0; i < 25; i = i + 1) {
                    boss.get(i).x = boss.get(i).x + 0.6 + uscor;

                }
                for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) {
                    bullets_vragov.get(i).x = bullets_vragov.get(i).x + 0.6 + uscor;
                    ;
                }
                for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) {
                    bullets_korablya.get(i).x = bullets_korablya.get(i).x + 0.6 + uscor;
                    ;
                }
            }
            if ((zd == 1) && (gr_prav > 930)) {
                gr_lev = gr_lev - 0.6 - uscor;
                ;
                gr_prav = gr_prav - 0.6 - uscor;
                ;
                for (int i = 0; i < kolvo_vragov; i = i + 1) {
                    vragi.get(i).x = vragi.get(i).x - 0.6 - uscor;

                }
                for (int i = 0; i < 25; i = i + 1) {
                    boss.get(i).x = boss.get(i).x - 0.6 - uscor;

                }
                for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) {
                    bullets_vragov.get(i).x = bullets_vragov.get(i).x - 0.6 - uscor;
                    ;
                }
                for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) {
                    bullets_korablya.get(i).x = bullets_korablya.get(i).x - 0.6 - uscor;
                    ;
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
        if( (pause == 0)&&(do_bossa > 200)) {              //счетчик выстрелов
            for (int i = 0; i < 25; i = i + 1) {
                boss.get(i).vremya2 = boss.get(i).vremya2 + 0.01;
            }
        }
        for (int i = 0; i < kolvo_vragov; i = i + 1) {//проверка выстрелов врагов
            if (vragi.get(i).hp > 0) {
                if ((vragi.get(i).x > 100) && (vragi.get(i).x < 1930) && (vragi.get(i).y > 0) && (vragi.get(i).y < 980)) {
                    if ((vragi.get(i).vremya2 > vragi.get(i).vremya1 + 3) && (vragi.get(i).tipblocka == 0)) {
                        double blx = 999999999;
                        int num = -4;
                        for(int j = 0;j < colvoblokovvkorable; j = j + 1){
                            if((vragi.get(i).x - korabl.get(j).x)*(vragi.get(i).x - korabl.get(j).x) + (vragi.get(i).y - korabl.get(j).y)*(vragi.get(i).y - korabl.get(j).y) < blx){
                                num = j;
                                blx = (vragi.get(i).x - korabl.get(j).x)*(vragi.get(i).x - korabl.get(j).x) + (vragi.get(i).y - korabl.get(j).y)*(vragi.get(i).y - korabl.get(j).y);
                            }
                        }

                        double m = 1 * (korabl.get(num).x - vragi.get(i).x) / Math.sqrt((korabl.get(num).x - vragi.get(i).x) * (korabl.get(num).x - vragi.get(i).x) + (korabl.get(num).y - vragi.get(i).y) * (korabl.get(num).y - vragi.get(i).y));
                        double n = 1 * (korabl.get(num).y - vragi.get(i).y) / Math.sqrt((korabl.get(num).x - vragi.get(i).x) * (korabl.get(num).x - vragi.get(i).x) + (korabl.get(num).y - vragi.get(i).y) * (korabl.get(num).y - vragi.get(i).y));
                        bullets_vragov.add(new Bullet(vragi.get(i).x, vragi.get(i).y, 1, vragi.get(i).tipblocka, m, n));
                        kolvo_bullets_vragov = kolvo_bullets_vragov + 1;
                        vragi.get(i).vremya1 = vragi.get(i).vremya2;
                    }
                    if ((vragi.get(i).vremya2 > vragi.get(i).vremya1 + 5) && (vragi.get(i).tipblocka == 1)) {
                        double blx = 999999999;
                        int num = -4;
                        for(int j = 0;j < colvoblokovvkorable; j = j + 1){
                            if((vragi.get(i).x - korabl.get(j).x)*(vragi.get(i).x - korabl.get(j).x) + (vragi.get(i).y - korabl.get(j).y)*(vragi.get(i).y - korabl.get(j).y) < blx){
                                num = j;
                                blx = (vragi.get(i).x - korabl.get(j).x)*(vragi.get(i).x - korabl.get(j).x) + (vragi.get(i).y - korabl.get(j).y)*(vragi.get(i).y - korabl.get(j).y);
                            }
                        }
                        double m = 0.7 * (korabl.get(num).x - vragi.get(i).x) / Math.sqrt((korabl.get(num).x - vragi.get(i).x) * (korabl.get(num).x - vragi.get(i).x) + (korabl.get(num).y - vragi.get(i).y) * (korabl.get(num).y - vragi.get(i).y));
                        double n = 0.7 * (korabl.get(num).y - vragi.get(i).y) / Math.sqrt((korabl.get(num).x - vragi.get(i).x) * (korabl.get(num).x - vragi.get(i).x) + (korabl.get(num).y - vragi.get(i).y) * (korabl.get(num).y - vragi.get(i).y));
                        bullets_vragov.add(new Bullet(vragi.get(i).x, vragi.get(i).y, 1, vragi.get(i).tipblocka, m, n));
                        kolvo_bullets_vragov = kolvo_bullets_vragov + 1;
                        vragi.get(i).vremya1 = vragi.get(i).vremya2;
                    }
                }
            }
        }
        if(do_bossa > 200){ for (int i = 0; i < 25; i = i + 1) {//проверка выстрелов босса
            if (boss.get(i).hp > 0) {
                if ((boss.get(i).x > 100) && (boss.get(i).x < 1930) && (boss.get(i).y > 0) && (boss.get(i).y < 980)) {
                    if ((boss.get(i).vremya2 > boss.get(i).vremya1 + 3) && (boss.get(i).tipblocka == 0)) {
                        double blx = 999999999;
                        int num = -4;
                        for(int j = 0;j < colvoblokovvkorable; j = j + 1){
                            if((boss.get(i).x - korabl.get(j).x)*(boss.get(i).x - korabl.get(j).x) + (boss.get(i).y - korabl.get(j).y)*(boss.get(i).y - korabl.get(j).y) < blx){
                                num = j;
                                blx = (boss.get(i).x - korabl.get(j).x)*(boss.get(i).x - korabl.get(j).x) + (boss.get(i).y - korabl.get(j).y)*(boss.get(i).y - korabl.get(j).y);
                            }
                        }

                        double m = 1 * (korabl.get(num).x - boss.get(i).x) / Math.sqrt((korabl.get(num).x - boss.get(i).x) * (korabl.get(num).x - boss.get(i).x) + (korabl.get(num).y - boss.get(i).y) * (korabl.get(num).y - boss.get(i).y));
                        double n = 1 * (korabl.get(num).y - boss.get(i).y) / Math.sqrt((korabl.get(num).x - boss.get(i).x) * (korabl.get(num).x - boss.get(i).x) + (korabl.get(num).y - boss.get(i).y) * (korabl.get(num).y - boss.get(i).y));
                        bullets_vragov.add(new Bullet(boss.get(i).x, boss.get(i).y, 1, boss.get(i).tipblocka, m, n));
                        kolvo_bullets_vragov = kolvo_bullets_vragov + 1;
                        boss.get(i).vremya1 = boss.get(i).vremya2;
                    }
                    if ((boss.get(i).vremya2 > boss.get(i).vremya1 + 5) && (boss.get(i).tipblocka == 1)) {
                        double blx = 999999999;
                        int num = -4;
                        for(int j = 0;j < colvoblokovvkorable; j = j + 1){
                            if((boss.get(i).x - korabl.get(j).x)*(boss.get(i).x - korabl.get(j).x) + (boss.get(i).y - korabl.get(j).y)*(boss.get(i).y - korabl.get(j).y) < blx){
                                num = j;
                                blx = (boss.get(i).x - korabl.get(j).x)*(boss.get(i).x - korabl.get(j).x) + (boss.get(i).y - korabl.get(j).y)*(boss.get(i).y - korabl.get(j).y);
                            }
                        }
                        double m = 0.7 * (korabl.get(num).x - boss.get(i).x) / Math.sqrt((korabl.get(num).x - boss.get(i).x) * (korabl.get(num).x - boss.get(i).x) + (korabl.get(num).y - boss.get(i).y) * (korabl.get(num).y - boss.get(i).y));
                        double n = 0.7 * (korabl.get(num).y - boss.get(i).y) / Math.sqrt((korabl.get(num).x - boss.get(i).x) * (korabl.get(num).x - boss.get(i).x) + (korabl.get(num).y - boss.get(i).y) * (korabl.get(num).y - boss.get(i).y));
                        bullets_vragov.add(new Bullet(boss.get(i).x, boss.get(i).y, 1, boss.get(i).tipblocka, m, n));
                        kolvo_bullets_vragov = kolvo_bullets_vragov + 1;
                        boss.get(i).vremya1 = boss.get(i).vremya2;
                    }
                }
            }
        }}
        for (int i = 0; i < colvoblokovvkorable; i = i + 1) {   //проверка выстрелов корабля
            if ((korabl.get(i).hp > 0) && (korabl.get(i).tipblocka < 2)) {
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
        if ((pause == 0)&&(do_bossa>200)) {    //движение босса


                    double m = 0.4 * (930 - boss.get(1).x) / Math.sqrt((930 - boss.get(1).x) * (930 - boss.get(1).x) + (540 - boss.get(1).y) * (540 - boss.get(1).y));
                    double n = 0.4 * (540 - boss.get(1).y) / Math.sqrt((930 - boss.get(1).x) * (930 - boss.get(1).x) + (540 - boss.get(1).y) * (540 - boss.get(1).y));
                    for(int i = 0;i<25;i = i + 1) {
                        boss.get(i).x = boss.get(i).x + m;
                        boss.get(i).y = boss.get(i).y + n;
                    }

        }
        if (pause == 0) {   //движение всех пуль
            for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) {
                bullets_vragov.get(i).x = bullets_vragov.get(i).x + 7 * bullets_vragov.get(i).m;
                bullets_vragov.get(i).y = bullets_vragov.get(i).y + 7 * bullets_vragov.get(i).n;
            }
            for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) {
                bullets_korablya.get(i).x = bullets_korablya.get(i).x + 7 * bullets_korablya.get(i).m;
                bullets_korablya.get(i).y = bullets_korablya.get(i).y + 7 * bullets_korablya.get(i).n;
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
        for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) { //проверка повреждений корабля щита
            if (bullets_vragov.get(i).zaryad == 1) {
                for (int j = 0; j < colvoblokovvkorable; j = j + 1) {
                    if ((bullets_vragov.get(i).zaryad == 1) && (korabl.get(j).hp > 200) && (korabl.get(j).tipblocka == 3) && ((bullets_vragov.get(i).x - korabl.get(j).x) * (bullets_vragov.get(i).x - korabl.get(j).x) + (bullets_vragov.get(i).y - korabl.get(j).y) * (bullets_vragov.get(i).y - korabl.get(j).y) < 5626)) {
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
        if (do_bossa> 200){for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) { //проверка повреждений щитов босса
            if (bullets_korablya.get(i).zaryad == 1) {
                for (int j = 0; j < 25; j = j + 1) {
                    if ((bullets_korablya.get(i).zaryad == 1) && (boss.get(j).hp > 200) && (boss.get(j).tipblocka == 3) && ((bullets_korablya.get(i).x - boss.get(j).x) * (bullets_korablya.get(i).x - boss.get(j).x) + (bullets_korablya.get(i).y - boss.get(j).y) * (bullets_korablya.get(i).y - boss.get(j).y) < 5626)) {
                        bullets_korablya.get(i).zaryad = 0;
                        if (bullets_korablya.get(i).tipblocka == 0) {
                            boss.get(j).hp = boss.get(j).hp - 10;
                        }
                        if (bullets_korablya.get(i).tipblocka == 1) {
                            boss.get(j).hp = boss.get(j).hp - 20;
                        }
                    }
                }
            }
        }}
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
        for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) { //проверка повреждений врагов
            if ((bullets_korablya.get(i).zaryad == 1) && (bullets_korablya.get(i).x > -5) && (bullets_korablya.get(i).x < 1935) && (bullets_korablya.get(i).y > -5) && (bullets_korablya.get(i).y < 1085)) {
                for (int j = 0; j < kolvo_vragov; j = j + 1) {
                    if ((bullets_korablya.get(i).zaryad == 1) && (vragi.get(j).hp > 0) && (Math.abs(bullets_korablya.get(i).x - vragi.get(j).x) < 16) && (Math.abs(bullets_korablya.get(i).y - vragi.get(j).y) < 16)) {
                        bullets_korablya.get(i).zaryad = 0;
                        if (bullets_korablya.get(i).tipblocka == 0) {
                            vragi.get(j).hp = vragi.get(j).hp - 10 - ul1*2;
                        }
                        if (bullets_korablya.get(i).tipblocka == 1) {
                            vragi.get(j).hp = vragi.get(j).hp - 15 - ul2*2;
                        }
                    }
                }
            }
        }
        if(do_bossa> 200){for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) { //проверка повреждений босса
            if ((bullets_korablya.get(i).zaryad == 1) && (bullets_korablya.get(i).x > -5) && (bullets_korablya.get(i).x < 1935) && (bullets_korablya.get(i).y > -5) && (bullets_korablya.get(i).y < 1085)) {
                for (int j = 0; j < 25; j = j + 1) {
                    if ((bullets_korablya.get(i).zaryad == 1) && (boss.get(j).hp > 0) && (Math.abs(bullets_korablya.get(i).x - boss.get(j).x) < 16) && (Math.abs(bullets_korablya.get(i).y - boss.get(j).y) < 16)) {
                        bullets_korablya.get(i).zaryad = 0;
                        if (bullets_korablya.get(i).tipblocka == 0) {
                            boss.get(j).hp = boss.get(j).hp - 100 - ul1*2;
                        }
                        if (bullets_korablya.get(i).tipblocka == 1) {
                            boss.get(j).hp = boss.get(j).hp - 150 - ul2*2;
                        }
                    }
                }
            }
        }}
        if(pause == 0){                       //отрисовка космоса
             g.drawImage(image1,(int) gr_lev - 1000, (int)gr_verh - 1000, null);
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
        if ((pause == 0)&&(do_bossa>200)) {
            for (int i = 0; i < 25; i = i + 1) { //отрисовка босса
                if (boss.get(i).hp > 0) {
                    if ((boss.get(i).x > -30) && (boss.get(i).x < 1930) && (boss.get(i).y > -30) && (boss.get(i).y < 1100)) {
                        double m = 13 * (930 - boss.get(i).x) / Math.sqrt((930 - boss.get(i).x) * (930 - boss.get(i).x) + (540 - boss.get(i).y) * (540 - boss.get(i).y));
                        double n = 13 * (540 - boss.get(i).y) / Math.sqrt((930 - boss.get(i).x) * (930 - boss.get(i).x) + (540 - boss.get(i).y) * (540 - boss.get(i).y));
                        boss.get(i).paint(g, m, n);
                    }
                }
            }
        }

        if (pause == 2) {    //отрисовка выбора
            g.drawRect(90, 200, 510, 510);
            g.drawRect(640, 200, 510, 510);
            g.drawRect(1190, 200, 510, 510);
            if (k == 0) {
                Color cher = new Color(0,0,0);
                g.setColor(new Color(253, 249, 249));
                g.fillRect((int) 345 - 255, (int) 455 - 255, 510, 510);
                g.setColor(new Color(104, 243, 248));
                g.fillOval((int) 345 - 221, (int) 455 + 34, 26*17, 10*17);
                g.setColor(new Color(3, 139, 213));
                g.drawOval((int)345 - 13*17, (int) 455 + 2*17, 26*17, 10*17);
                g.setColor(cher);
                g.drawLine((int)345, (int) 455 + 7*17,(int)345,  (int) 455 - 11*17 );
                g.setColor(new Color(36, 217, 252));
                g.fillOval((int) 345 - 10*17, (int) 455 -2*17, 20*17, 7*17);
                g.setColor(new Color(1, 125, 190));
                g.drawOval((int) 345 - 10*17, (int) 455 -2*17, 20*17, 7*17);
                g.setColor(cher);
                g.drawLine((int)345, (int) (455 + 1.5*17),(int)345,  (int) 455 - 11*17 );
                g.setColor(new Color(1, 188, 229));
                g.fillOval((int) 345 - 7*17, (int) 455 -6*17, 14*17, 4*17);
                g.setColor(new Color(4, 76, 169));
                g.drawOval((int) 345 - 7*17, (int) 455 -6*17, 14*17, 4*17);
                g.setColor(cher);
                g.drawLine((int)345, (int) (455 -4*17),(int)345,  (int) 455 - 11*17 );
                g.setColor(new Color(4, 188, 194));
                g.fillOval((int) 345 - 4*17, (int) 455 -10*17, 8*17, 2*17);
                g.setColor(new Color(3, 47, 161));
                g.drawOval((int) 345 - 4*17, (int) 455 -10*17, 8*17, 2*17);
                g.setColor(cher);
                g.drawLine(345,(int) 455 -9*17, 345, (int) 455 - 11*17 );
                g.setColor(new Color(1,1,1));
                g.drawRect((int) 345 - 15*17, (int) 455 - 15*17, 30*17, 30*17);

            }
            if (k == 1) {
                g.setColor(new Color(0,0,0));
                g.drawRect(90, 200, 510,510);
                g.setColor(new Color(255,255,255));
                g.fillRect(100,210,490,490);
                g.setColor(new Color(239, 197, 92));
                g.fillRect(200, 230, 290,450);
                g.setColor(new Color(217, 155, 5));
                g.drawRect(200, 230, 290,450);
            }
            if (k == 2) {
                g.setColor(new Color(120, 120, 120));
                g.fillRect((int) 345 - 15*17, (int) 455 - 15*17, 30*17, 30*17);
                int ypoints[] = {(int) 455 - 13*17,(int) 455 + 2*17, (int) 455, (int) 455 + 12*17, (int) 455 - 5*17, (int) 455-1*17 };
                int xpoints[] ={(int) 345, (int) 345 - 5*17, (int) 345 + 1*17, (int) 345, (int) 345 +5*17, (int) 345 - 1*17};
                g.setColor(new Color(255, 182, 0));
                g.fillPolygon(xpoints, ypoints, 6);
                g.setColor(new Color(1,1,1));
                g.drawPolygon(xpoints, ypoints, 6);
                g.drawRect(345-255, 200, 510,510);
            }
            if (k == 3) {
                g.setColor(new Color(97, 233, 239, 126));
                g.fillOval(90, 200, 510, 510);
                    g.setColor(new Color(78, 174, 245));
                    g.drawOval(90, 200, 510, 510);

            }
            if (l == 0) {
                Color cher = new Color(0,0,0);
                g.setColor(new Color(253, 249, 249));
                g.fillRect((int) 895 - 255, (int) 455 - 255, 510, 510);
                g.setColor(new Color(104, 243, 248));
                g.fillOval((int) 895 - 221, (int) 455 + 34, 26*17, 10*17);
                g.setColor(new Color(3, 139, 213));
                g.drawOval((int) 895 - 13*17, (int) 455 + 2*17, 26*17, 10*17);
                g.setColor(cher);
                g.drawLine((int)895, (int) 455 + 7*17,(int)895,  (int) 455 - 11*17 );
                g.setColor(new Color(36, 217, 252));
                g.fillOval((int) 895 - 10*17, (int) 455 -2*17, 20*17, 7*17);
                g.setColor(new Color(1, 125, 190));
                g.drawOval((int) 895 - 10*17, (int) 455 -2*17, 20*17, 7*17);
                g.setColor(cher);
                g.drawLine((int)895, (int) (455 + 1.5*17),(int)895,  (int) 455 - 11*17 );
                g.setColor(new Color(1, 188, 229));
                g.fillOval((int) 895 - 7*17, (int) 455 -6*17, 14*17, 4*17);
                g.setColor(new Color(4, 76, 169));
                g.drawOval((int) 895 - 7*17, (int) 455 -6*17, 14*17, 4*17);
                g.setColor(cher);
                g.drawLine((int)895, (int) (455 -4*17),(int)895,  (int) 455 - 11*17 );
                g.setColor(new Color(4, 188, 194));
                g.fillOval((int) 895 - 4*17, (int) 455 -10*17, 8*17, 2*17);
                g.setColor(new Color(3, 47, 161));
                g.drawOval((int) 895 - 4*17, (int) 455 -10*17, 8*17, 2*17);
                g.setColor(cher);
                g.drawLine(895,(int) 455 -9*17, 895, (int) 455 - 11*17 );
                g.setColor(new Color(1,1,1));
                g.drawRect((int) 895 - 15*17, (int) 455 - 15*17, 30*17, 30*17);
            }
            if (l == 1) {
                g.setColor(new Color(0,0,0));
                g.drawRect(640, 200, 510,510);
                g.setColor(new Color(255,255,255));
                g.fillRect(650,210,490,490);
                g.setColor(new Color(239, 197, 92));
                g.fillRect(750, 230, 290,450);
                g.setColor(new Color(217, 155, 5));
                g.drawRect(750, 230, 290,450);
            }
            if (l == 2) {
                g.setColor(new Color(120, 120, 120));
                g.fillRect((int) 895 - 15*17, (int) 455 - 15*17, 30*17, 30*17);
                int ypoints[] = {(int) 455 - 13*17,(int) 455 + 2*17, (int) 455, (int) 455 + 12*17, (int) 455 - 5*17, (int) 455-1*17 };
                int xpoints[] ={(int) 895, (int) 895 - 5*17, (int) 895 + 1*17, (int) 895, (int) 895 +5*17, (int) 895- 1*17};
                g.setColor(new Color(255, 182, 0));
                g.fillPolygon(xpoints, ypoints, 6);
                g.setColor(new Color(1,1,1));
                g.drawPolygon(xpoints, ypoints, 6);
                g.drawRect(895-255, 200, 510,510);
            }
            if (l == 3) {
                g.setColor(new Color(97, 233, 239, 126));
                g.fillOval(640, 200, 510, 510);
                g.setColor(new Color(78, 174, 245));
                g.drawOval(640, 200, 510, 510);

            }
            if (p == 0) {
                Color cher = new Color(0,0,0);
                g.setColor(new Color(253, 249, 249));
                g.fillRect((int) 1445 - 255, (int) 455 - 255, 510, 510);
                g.setColor(new Color(104, 243, 248));
                g.fillOval((int)1445 - 221, (int) 455 + 34, 26*17, 10*17);
                g.setColor(new Color(3, 139, 213));
                g.drawOval((int)1445 - 13*17, (int) 455 + 2*17, 26*17, 10*17);
                g.setColor(cher);
                g.drawLine((int)1445, (int) 455 + 7*17,(int)1445,  (int) 455 - 11*17 );
                g.setColor(new Color(36, 217, 252));
                g.fillOval((int) 1445 - 10*17, (int) 455 -2*17, 20*17, 7*17);
                g.setColor(new Color(1, 125, 190));
                g.drawOval((int) 1445 - 10*17, (int) 455 -2*17, 20*17, 7*17);
                g.setColor(cher);
                g.drawLine((int)1445, (int) (455 + 1.5*17),(int)1445,  (int) 455 - 11*17 );
                g.setColor(new Color(1, 188, 229));
                g.fillOval((int) 1445 - 7*17, (int) 455 -6*17, 14*17, 4*17);
                g.setColor(new Color(4, 76, 169));
                g.drawOval((int) 1445 - 7*17, (int) 455 -6*17, 14*17, 4*17);
                g.setColor(cher);
                g.drawLine((int)1445, (int) (455 -4*17),(int)1445,  (int) 455 - 11*17 );
                g.setColor(new Color(4, 188, 194));
                g.fillOval((int) 1445 - 4*17, (int) 455 -10*17, 8*17, 2*17);
                g.setColor(new Color(3, 47, 161));
                g.drawOval((int) 1445 - 4*17, (int) 455 -10*17, 8*17, 2*17);
                g.setColor(cher);
                g.drawLine(1445,(int) 455 -9*17, 1445, (int) 455 - 11*17 );
                g.setColor(new Color(1,1,1));
                g.drawRect((int) 1445 - 15*17, (int) 455 - 15*17, 30*17, 30*17);

            }
            if (p == 1) {
                g.setColor(new Color(0,0,0));
                g.drawRect(1190, 200, 510,510);
                g.setColor(new Color(255,255,255));
                g.fillRect(1200,210,490,490);
                g.setColor(new Color(239, 197, 92));
                g.fillRect(1300, 230, 290,450);
                g.setColor(new Color(217, 155, 5));
                g.drawRect(1300, 230, 290,450);
            }
            if (p == 2) {
                g.setColor(new Color(120, 120, 120));
                g.fillRect((int) 1445 - 15*17, (int) 455 - 15*17, 30*17, 30*17);
                int ypoints[] = {(int) 455 - 13*17,(int) 455 + 2*17, (int) 455, (int) 455 + 12*17, (int) 455 - 5*17, (int) 455-1*17 };
                int xpoints[] ={(int) 1445, (int) 1445 - 5*17, (int) 1445 + 1*17, (int) 1445, (int) 1445 +5*17, (int) 1445- 1*17};
                g.setColor(new Color(255, 182, 0));
                g.fillPolygon(xpoints, ypoints, 6);
                g.setColor(new Color(1,1,1));
                g.drawPolygon(xpoints, ypoints, 6);
                g.drawRect(1445-255, 200, 510,510);
            }
            if (p == 3) {
                g.setColor(new Color(97, 233, 239, 126));
                g.fillOval(1190, 200, 510, 510);
                g.setColor(new Color(78, 174, 245));
                g.drawOval(1190, 200, 510, 510);

            }
        }
        //if(pause == 1){
         //   g.drawImage(image2, 0,0,1920,1080,null);
        //}
        if (pause < 2) {                                       //отрисовка корабля
            for (int i = 0; i < colvoblokovvkorable; i = i + 1) {
                korabl.get(i).paint(g, m, n);
            }
        }
        if (pause < 2) {                                       //отрисовка корабля
            for (int i = 0; i < colvoblokovvkorable; i = i + 1) {
                if(korabl.get(i).tipblocka == 3){
                korabl.get(i).paint(g, m, n);}
            }
        }
        if (pause == 0) {                                      //отрисовка пуль
            for (int i = 0; i < kolvo_bullets_vragov; i = i + 1) {
                if ((bullets_vragov.get(i).x > -5) && (bullets_vragov.get(i).x < 1935) && (bullets_vragov.get(i).y > -5) && (bullets_vragov.get(i).y < 1085)) {
                    bullets_vragov.get(i).paint(g);
                }
            }
            for (int i = 0; i < kolvo_bullets_korablya; i = i + 1) {
                if ((bullets_korablya.get(i).x > -5) && (bullets_korablya.get(i).x < 1935) && (bullets_korablya.get(i).y > -5) && (bullets_korablya.get(i).y < 1085)) {
                    bullets_korablya.get(i).paint(g);
                }
            }
        }
        //g.drawLine((int) gr_lev, (int) gr_nizh, (int) gr_lev, (int) gr_verh);
       // g.drawLine((int) gr_lev, (int) gr_nizh, (int) gr_prav, (int) gr_nizh);
        //g.drawLine((int) gr_prav, (int) gr_nizh, (int) gr_prav, (int) gr_verh);
       // g.drawLine((int) gr_prav, (int) gr_verh, (int) gr_lev, (int) gr_verh);
        Color cr2 = new Color(255, 255, 255);             //отрисовка
        g.setColor(cr2);
        g.fillRect(100, 80, max_shkala, 10);
        Color e = new Color(241, 19, 229, 255);
        g.setColor(e);
        g.fillRect(100, 80, shkala, 10);
        Color cr1 = new Color(0, 0, 0);
        g.setColor(cr1);
        g.drawRect(100, 80, max_shkala, 10);
        g.setColor(new Color(205, 125, 0));
        g.drawString("Опыт " + oput, 100, 70);
        g.drawString("Деньги " + monetu, 240, 70);
        g.setColor(new Color(239, 197, 92));
        g.fillRect(300, 70, 50,50);
        g.setColor(cr1);
        g.drawRect(300, 70, 50,50);
        g.setColor(new Color(255,255,255));
        g.fillRect(305,75,40,40);
        g.setColor(new Color(239, 197, 92));
        g.fillRect(315, 80, 20,30);
        g.setColor(new Color(217, 155, 5));
        g.drawRect(315, 80, 20,30);
        g.setColor(cr1);
        g.drawRect(360, 70, 50,50);
        g.drawRect(420, 70, 50,50);
        g.setColor(new Color(120, 120, 120));
        g.fillRect((int) 445 - 25, (int) 95 - 25, 50, 50);
        int ypoints[] = {(int) 95 - 21,(int) 95 + 3, (int) 95, (int) 95 + 20, (int) 95 - 8, (int) 95 -1 };
        int xpoints[] ={(int) 445, (int) 445 - 8, (int) 445 + 1, (int) 445, (int) 445 +8, (int) 445 - 1};
        g.setColor(new Color(255, 182, 0));
        g.fillPolygon(xpoints, ypoints, 6);
        g.setColor(new Color(1,1,1));
        g.drawPolygon(xpoints, ypoints, 6);
        g.setColor(new Color(1,1,1));

        g.setColor(new Color(255, 255, 255));
        g.fillRect(360, 70, 50,50);
        g.setColor(new Color(104, 243, 248));
        Color cher = new Color(1,1,1);
        g.fillOval(385 - 13, (int) 95 + 2, 26, 10);
        g.setColor(new Color(3, 139, 213));
        g.drawOval(385 - 13, (int) 95 + 2, 26, 10);
        g.setColor(cher);
        g.drawLine(385, 95 + 7,385,  95 - 12 );
        g.setColor(new Color(36, 217, 252));
        g.fillOval(385 - 10, 95 -2, 20, 7);
        g.setColor(new Color(1, 125, 190));
        g.drawOval(385- 10, 95 -2, 20, 7);
        g.setColor(cher);
        g.drawLine(385, (int) (95 + 1.5),385,  (int) 95 - 12 );
        g.setColor(new Color(1, 188, 229));
        g.fillOval(385 - 7, (int) 95 -6, 14, 4);
        g.setColor(new Color(4, 76, 169));
        g.drawOval(385- 7, (int) 95 -6, 14, 4);
        g.setColor(cher);
        g.drawLine(385, (int) (95 -4),385,  (int) 95- 12 );
        g.setColor(new Color(4, 188, 194));
        g.fillOval(385 - 4, (int) 95 -10, 8, 2);
        g.setColor(new Color(3, 47, 161));
        g.drawOval(385 - 4, (int) 95 -10, 8, 2);
        g.setColor(cher);

        if(monetu < cena_ul1){
            g.setColor(new Color(203, 8, 8));
        }
        else{
            g.setColor(new Color(26, 255, 3));
        }
        g.drawString(" Цена: " + cena_ul1, 300, 145);
        if(monetu < cena_ul2){
            g.setColor(new Color(203, 8, 8));
        }
        else{
            g.setColor(new Color(26, 255, 3));
        }
        g.drawString(" Цена: " + cena_ul2, 360, 145);
        if(monetu < cena_ul3){
            g.setColor(new Color(203, 8, 8));
        }
        else{
            g.setColor(new Color(26, 255, 3));
        }
        g.drawString(" Цена: " + cena_ul3, 420, 145);
        g.setColor(cher);
        Color bel = new Color(255,255,255);
        g.setColor(bel);
        g.fillRect(318, 120, 14, 14);
        g.setColor(cher);
        g.drawRect(318, 120, 14, 14);
        g.drawString("Z", 322, 132);
        g.setColor(bel);
        g.fillRect(378, 120, 14, 14);
        g.setColor(cher);
        g.drawRect(378, 120, 14, 14);
        g.setColor(bel);
        g.fillRect(438, 120, 14, 14);
        g.setColor(cher);
        g.drawRect(438, 120, 14, 14);
        g.drawString("X", 382, 132);
        g.drawString("C", 442, 132);
       // g.setColor(new Color(238, 33, 33));
       // g.drawString("время"+ do_bossa, 400,400);
         g.setColor(new Color(250, 250, 250));
            if(do_bossa < 200){g.fillRect(860, 1040, 200,100);}
         if(do_bossa < 200){
             g.setColor(new Color(208, (int)(200 - do_bossa), (int)(200 - do_bossa)));
             g.fillRect(860, 1040, (int)do_bossa,100);
         }
         int yxt = 0;
         for(int i = 0;i < colvoblokovvkorable; i = i + 1){
             if (korabl.get(i).zhisn == 1){
                 yxt = yxt + 1;
             }
         }
         int zxt = 0;
            for(int i = 0;i < 25; i = i + 1){
                if (boss.get(i).zhisn == 1){
                    zxt = zxt + 1;
                }
            }
            if(yxt == 0){
                pause = 4;
            }
            if(zxt ==0){
                pause = 5;
            }
        }
        if(pause == 4){
            g.setColor(new Color(187, 7, 7));
            g.drawString("You lose", 600,600);
        }
        if(pause == 4){
            g.setColor(new Color(77, 213, 23));
            g.drawString("You win", 600,600);
        }
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
            if ((e.getX() < 601) && (e.getX() > 90) && (e.getY() > 200) && (e.getY() < 710)) {
                vub = vub + 1;
                vub_bloki.add(k);
                pause = 1;
            }
            if ((e.getX() < 1150) && (e.getX() > 640) && (e.getY() > 200) && (e.getY() < 710)) {
                vub = vub + 1;
                vub_bloki.add(l);
                pause = 1;
            }
            if ((e.getX() < 1700) && (e.getX() > 1190) && (e.getY() > 200) && (e.getY() < 710)) {
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
                if (vub_bloki.get(vub) == 3) {
                    korabl.add(new Blocks(ux, uy, vub_bloki.get(vub), 0, 0, 0, 0, 1200, 1));
                } else {
                    korabl.add(new Blocks(ux, uy, vub_bloki.get(vub), 0, 0, 0, 0, 200, 1));
                }
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
                k = r.nextInt(4);
                l = r.nextInt(4);
                p = r.nextInt(4);
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
        if((pause == 0)&& (e.getID() == KeyEvent.KEY_PRESSED) && (e.getKeyCode() == 90)&&(monetu >= cena_ul1)){
            monetu = monetu - cena_ul1;
            cena_ul1 = cena_ul1 + 10;
            ul1 = ul1 + 1;
        }
        if((pause == 0)&& (e.getID() == KeyEvent.KEY_PRESSED) && (e.getKeyCode() == 88)&&(monetu >= cena_ul2)){
            monetu = monetu - cena_ul2;
            cena_ul2 = cena_ul2 + 10;
            ul2 = ul2 + 1;
        }
        if((pause == 0)&& (e.getID() == KeyEvent.KEY_PRESSED) && (e.getKeyCode() == 67)&&(monetu >= cena_ul3)){
            monetu = monetu - cena_ul3;
            cena_ul3 = cena_ul3 + 10;
            ul1 = ul1 + 1;
        }
        return false;
    }
}
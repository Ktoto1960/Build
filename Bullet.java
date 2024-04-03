import java.awt.*;

public class Bullet {
    double x;
    double y;
    int zaryad;
    int tipblocka;
    double m;
    double n;

    Bullet(double x, double y, int zaryad, int tipblocka, double m, double n) {
        this.x = x;
        this.y = y;
        this.zaryad = zaryad;
        this.tipblocka = tipblocka;
        this.m = m;
        this.n = n;
    }

    void paint(Graphics g) {
        if(this.zaryad == 1) {
            if (this.tipblocka == 0) {
                g.setColor(new Color(107, 129, 243));
                g.fillOval((int) (this.x - 2.5), (int) (this.y - 2.5), 5, 5);
                g.setColor(new Color(82, 110, 255));
                g.drawOval((int) (this.x - 2.5), (int) (this.y - 2.5), 5, 5);
                g.setColor(new Color(1,1,1));
            }
            if (this.tipblocka == 1) {
                g.setColor(new Color(243, 186, 45));
                g.fillOval((int) (this.x - 3.5), (int) (this.y - 3.5), 7, 7);
                g.setColor(new Color(255, 140, 68));
                g.drawOval((int) (this.x - 3.5), (int) (this.y - 3.5), 7, 7);
                g.setColor(new Color(1,1,1));
            }
        }
    }
}



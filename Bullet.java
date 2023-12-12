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
                g.drawOval((int) (this.x - 2.5), (int) (this.y - 2.5), 5, 5);
            }
            if (this.tipblocka == 1) {
                g.drawOval((int) (this.x - 3.5), (int) (this.y - 3.5), 7, 7);
            }
        }
    }
}





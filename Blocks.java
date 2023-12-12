import java.awt.*;

public class Blocks {
    double scor_x;
    double scor_y;
    double y;
    double x;
    double m;
    double n;
    int tipblocka;
    double vremya1;
    double vremya2;
    int hp;
    int zhisn;
    public Blocks(double x, double y, int tipblocka, double scor_x, double scor_y, double vremya1, double vremya2, int hp, int zhisn) {
        this.x = x;
        this.y = y;
        this.tipblocka = tipblocka;
        this.scor_x = scor_x;
        this.scor_y = scor_y;
        this.vremya1 = vremya1;
        this.vremya2 = vremya2;
        this.hp = hp;
        this.zhisn = zhisn;
    }

    void paint(Graphics g, double m, double n) {
        if (this.hp > 0) {
            Color cr = new Color(206, 17, 17);
            g.setColor(cr);
            g.fillRect((int)this.x-15, (int)this.y+10, (int)(30*this.hp/200), 5);
            g.setColor(new Color(0, 0, 0));
            g.drawRect((int) this.x - 15, (int) this.y - 15, 30, 30);
            if (this.tipblocka == 0) {
                g.drawOval((int) this.x - 13, (int) this.y - 13, 26, 26);
            }
            if (this.tipblocka == 1) {
                g.drawRect((int) this.x - 12, (int) this.y - 12, 24, 24);
                g.drawLine((int) this.x - (int) m - (int) (n / 2) + (int) (m / 2), (int) this.y - (int) n + (int) (m / 2) + (int) (n / 2), (int) this.x - (int) m + (int) (n / 2) + (int) (m / 2), (int) this.y - (int) n - (int) (m / 2) + (int) (n / 2));
                g.drawLine((int) this.x - (int) m - (int) (n / 2) + (int) (m / 2), (int) this.y - (int) n + (int) (m / 2) + (int) (n / 2), (int) this.x + (int) (m / 2) - (int) (n / 2) + (int) (m / 2), (int) this.y + (int) (n / 2) + (int) (m / 2) + (int) (n / 2));
                g.drawLine((int) this.x + (int) (m / 2) - (int) (n / 2) + (int) (m / 2), (int) this.y + (int) (n / 2) + (int) (m / 2) + (int) (n / 2), (int) this.x + (int) (m / 2) + (int) (n / 2) + (int) (m / 2), (int) this.y + (int) (n / 2) - (int) (m / 2) + (int) (n / 2));
                g.drawLine((int) this.x - (int) (m) + (int) (n / 2) + (int) (m / 2), (int) this.y - (int) (n) - (int) (m / 2) + (int) (n / 2), (int) this.x + (int) (m / 2) + (int) (n / 2) + (int) (m / 2), (int) this.y + (int) (n / 2) - (int) (m / 2) + (int) (n / 2));
            }

        }
    }
}


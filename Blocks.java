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
            Color cr = new Color(206, 17, 17, 171);
            Color gold = new Color(248, 206, 0, 255);
            Color cher = new Color(1,1,1);
            g.setColor(cr);
            g.setColor(new Color(0, 0, 0));
            g.drawRect((int) this.x - 15, (int) this.y - 15, 30, 30);
            if (this.tipblocka == 0) {
                g.setColor(new Color(253, 249, 249));
                g.fillRect((int) this.x - 15, (int) this.y - 15, 30, 30);
                g.setColor(new Color(104, 243, 248));
                g.fillOval((int) this.x - 13, (int) this.y + 2, 26, 10);
                g.setColor(new Color(3, 139, 213));
                g.drawOval((int) this.x - 13, (int) this.y + 2, 26, 10);
                g.setColor(cher);
                g.drawLine((int)this.x, (int) this.y + 7,(int)this.x,  (int) this.y - 11 );
                g.setColor(new Color(36, 217, 252));
                g.fillOval((int) this.x - 10, (int) this.y -2, 20, 7);
                g.setColor(new Color(1, 125, 190));
                g.drawOval((int) this.x - 10, (int) this.y -2, 20, 7);
                g.setColor(cher);
                g.drawLine((int)this.x, (int) (this.y + 1.5),(int)this.x,  (int) this.y - 11 );
                g.setColor(new Color(1, 188, 229));
                g.fillOval((int) this.x - 7, (int) this.y -6, 14, 4);
                g.setColor(new Color(4, 76, 169));
                g.drawOval((int) this.x - 7, (int) this.y -6, 14, 4);
                g.setColor(cher);
                g.drawLine((int)this.x, (int) (this.y -4),(int)this.x,  (int) this.y - 11 );
                g.setColor(new Color(4, 188, 194));
                g.fillOval((int) this.x - 4, (int) this.y -10, 8, 2);
                g.setColor(new Color(3, 47, 161));
                g.drawOval((int) this.x - 4, (int) this.y -10, 8, 2);
                g.setColor(cr);
                g.drawLine((int)this.x, (int)this.y - 9, (int)this.x, (int)this.y - 11);
                g.fillRect((int) this.x - 13, (int) this.y + 10, (int) (26 * this.hp / 200), 3);
                g.setColor(new Color(1,1,1));
                g.drawRect((int) this.x - 15, (int) this.y - 15, 30, 30);
            }
            if (this.tipblocka == 1) {
                g.setColor(gold);
                g.fillRect((int) this.x-15,(int) this.y-15, 30,30);
                g.setColor(new Color(255,255,255));
                g.fillRect((int) this.x - 12, (int) this.y - 12, 24, 24);
                g.drawRect((int) this.x - 12, (int) this.y - 12, 24, 24);
                int xpoints[] = {(int) this.x - (int) m - (int) (n / 2) + (int) (m / 2),(int) this.x - (int) m + (int) (n / 2) + (int) (m / 2), (int) this.x + (int) (m / 2) + (int) (n / 2) + (int) (m / 2), (int) this.x + (int) (m / 2) - (int) (n / 2) + (int) (m / 2)};
                int ypoints[] = {(int) this.y - (int) n + (int) (m / 2) + (int) (n / 2),(int) this.y - (int) n - (int) (m / 2) + (int) (n / 2) , (int) this.y + (int) (n / 2) - (int) (m / 2) + (int) (n / 2), (int) this.y + (int) (n / 2) + (int) (m / 2) + (int) (n / 2) };
                int nd = 4;
                Color zxc = new Color(255, 226, 81, 161);
                g.setColor(cr);
                g.fillRect((int) this.x - 13, (int) this.y + 10, (int) (26 * this.hp / 200), 3);
                g.setColor(new Color(1,1,1));
                g.drawRect((int) this.x - 15, (int) this.y - 15, 30, 30);
                g.setColor(zxc);
                g.fillPolygon(xpoints, ypoints, nd);
                g.setColor(new Color(1,1,1));
                g.drawLine((int) this.x - (int) m - (int) (n / 2) + (int) (m / 2), (int) this.y - (int) n + (int) (m / 2) + (int) (n / 2), (int) this.x - (int) m + (int) (n / 2) + (int) (m / 2), (int) this.y - (int) n - (int) (m / 2) + (int) (n / 2));
                g.drawLine((int) this.x - (int) m - (int) (n / 2) + (int) (m / 2), (int) this.y - (int) n + (int) (m / 2) + (int) (n / 2), (int) this.x + (int) (m / 2) - (int) (n / 2) + (int) (m / 2), (int) this.y + (int) (n / 2) + (int) (m / 2) + (int) (n / 2));
                g.drawLine((int) this.x + (int) (m / 2) - (int) (n / 2) + (int) (m / 2), (int) this.y + (int) (n / 2) + (int) (m / 2) + (int) (n / 2), (int) this.x + (int) (m / 2) + (int) (n / 2) + (int) (m / 2), (int) this.y + (int) (n / 2) - (int) (m / 2) + (int) (n / 2));
                g.drawLine((int) this.x - (int) (m) + (int) (n / 2) + (int) (m / 2), (int) this.y - (int) (n) - (int) (m / 2) + (int) (n / 2), (int) this.x + (int) (m / 2) + (int) (n / 2) + (int) (m / 2), (int) this.y + (int) (n / 2) - (int) (m / 2) + (int) (n / 2));
            }
            if (this.tipblocka == 2) {
                g.setColor(new Color(120, 120, 120));
                g.fillRect((int) this.x - 15, (int) this.y - 15, 30, 30);
                int ypoints[] = {(int) this.y - 13,(int) this.y + 2, (int) this.y, (int) this.y + 12, (int) this.y - 5, (int) this.y -1 };
                int xpoints[] ={(int) this.x, (int) this.x - 5, (int) this.x + 1, (int) this.x, (int) this.x +5, (int) this.x - 1};
                g.setColor(new Color(255, 182, 0));
                g.fillPolygon(xpoints, ypoints, 6);
                g.setColor(new Color(1,1,1));
                g.drawPolygon(xpoints, ypoints, 6);
                        g.setColor(new Color(1,1,1));

                g.setColor(cr);
                g.fillRect((int) this.x - 13, (int) this.y + 10, (int) (26 * this.hp / 200), 3);
                g.setColor(new Color(1,1,1));
                g.drawRect((int) this.x - 15, (int) this.y - 15, 30, 30);
            }
            if (this.tipblocka == 3) {


                if(this.hp > 900){
                    g.setColor(new Color(97, 233, 239, 126));
                    g.fillOval((int) this.x - 75, (int) this.y - 75, 150, 150);
                }
                if((this.hp > 600)&&(this.hp <= 900)){
                    g.setColor(new Color(92, 242, 255, 89));
                    g.fillOval((int) this.x - 75, (int) this.y - 75, 150, 150);
                }
                if((this.hp > 200)&&(this.hp <= 600)){
                    g.setColor(new Color(129, 231, 239, 94));
                    g.fillOval((int) this.x - 75, (int) this.y - 75, 150, 150);
                }
                if(this.hp > 200) {
                    g.setColor(new Color(78, 174, 245));
                    g.drawOval((int) this.x - 75, (int) this.y - 75, 150, 150);
                }
                g.setColor(cr);
                g.fillRect((int) this.x - 13, (int) this.y + 10, (int) (26 * this.hp / 1200), 3);
                g.setColor(new Color(1,1,1));
                g.drawRect((int) this.x - 15, (int) this.y - 15, 30, 30);
            }

        }
    }
}
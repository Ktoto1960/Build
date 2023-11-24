import java.awt.*;

public class Blocks {
    int y;
    int x;
    int tipblocka;
    public Blocks(int x, int y, int tipblocka){
        this.x = x;
        this.y = y;
        this.tipblocka = tipblocka;
    }
    void paint(Graphics g){
        g.drawRect(this.x-10, this.y-10,20, 20);
        if(this.tipblocka == 0){
            g.drawOval(this.x-8, this.y-8, 16, 16);
            }
        if(this.tipblocka == 1){
            g.drawRect(this.x-8, this.y-8, 16, 16);        }
    }
}


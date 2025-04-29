package aharon.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LineTool implements Tool {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    private Color color = Color.MAGENTA;

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void pressed(BufferedImage image, Graphics2D g, int x, int y) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x;
        this.y2 = y;
        g.drawLine(x, y, x, y);
    }

    @Override
    public void dragged(Graphics2D g, int x, int y) {
        this.x2 = x;
        this.y2 = y;
    }

    @Override
    public void preview(Graphics2D g) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void released(Graphics2D g, int x, int y) {
        g.drawLine(this.x1, this.y1, x, y);
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}


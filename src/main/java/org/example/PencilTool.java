package org.example;

import java.awt.*;

public class PencilTool implements Tool {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void pressed(Graphics g, int x, int y) {     // pass x and y and save it - then draw the one point
        this.x = x;
        this.y = y;
        g.drawLine(x, y, x, y);
    }

    @Override
    public void dragged(Graphics g, int x, int y) {
        g.drawLine(this.x, this.y, x, y);
        this.x = x;
        this.y = y;
    }

    @Override
    public void released(Graphics g, int x, int y) {

    }

    @Override
    public void preview(Graphics g) {
    }

    @Override
    public void setColor(Color color) {

    }
}

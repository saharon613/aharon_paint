package org.example;

import java.awt.*;

public class PencilTool implements Tool {

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x;
    private int y;

    @Override
    public void pressed(Graphics g, int x, int y) {     // pass x and y and save it - then draw the one point
        this.x = x;
        this.y = y;
        g.drawLine(x,y,x,y);
    }

    @Override
    public void dragged(Graphics g, int x, int y) {    // pass x and y, and draw a line from the thisx, thisy to the
        g.drawLine(this.x, this.y, x, y);              // current mouse location
        this.x = x;                                    // this here and for y allows for them to be reset when
        this.y = y;                                     // theres a new press
    }

    @Override
    public void released(Graphics g, int x, int y) {

    }

    @Override
    public void preview(Graphics g) {
    }
}

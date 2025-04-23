package org.example;

import java.awt.*;

// interface defines methods that a class must implement

public interface Tool {
    void pressed(Graphics g, int x, int y);

    void dragged(Graphics g, int x, int y);

    /**
     * draws a preview of the tools operation if released is called
     *
     * @param g the Graphics to draw the preview on
     *
     */

    void preview(Graphics g);

    void released(Graphics g, int x, int y);

    /**
     * @param color the color the tool will use */

    void setColor(Color color);
}

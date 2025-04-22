package org.example;

import java.awt.*;

// interface defines methods that a class must implement

public interface Tool {
    void pressed(Graphics g, int x, int y);

    void dragged(Graphics g, int x, int y);

    /**
     * draws a preview of the tools operation if released is called
     *
     * @param g
     */

    void preview(Graphics g);

    void released(Graphics g, int x, int y);
}

package org.example;

import java.awt.*;

// interface defines methods that a class must implement
public interface Tool
{
    void pressed(Graphics g, int x, int y);
    void dragged(Graphics g, int x, int y);
    void released(Graphics g, int x, int y);
}

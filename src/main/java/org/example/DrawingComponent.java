package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * this class draws the BufferedImage to the screen
 */
public class DrawingComponent extends JComponent {

    private final BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);

    private int oldx = -1;
    private int oldy = -1;
    private Color currentColor = Color.MAGENTA;
    private Point startPoint;
    private Point endPoint;

    private Tool tool;

    public DrawingComponent() {
        // set the image to be all white - white background
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    @Override

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);                // this clears the super one so that you can override it w/ your own

        g.drawImage(image, 0, 0, null);
        if (tool != null && tool instanceof LineTool) {
            tool.preview(g);
        }

        if (startPoint != null && endPoint != null) {
            g.setColor(currentColor);
            g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
    }

    public void drawFromMouse(int x, int y, Color currentColor) {
        Graphics g = image.getGraphics();
        g.setColor(currentColor);
        tool.dragged(g, x, y);
        repaint();

//        if (oldx != -1 && oldy != -1) {
//            g.drawLine(oldx, oldy, x, y);
//        }
//        oldx = x;
//        oldy = y;
//
//        repaint();
    }

    public void newClick() {
        oldx = -1;
        oldy = -1;
        repaint();
    }

    public void setStartPoint(Point startPoint, Color currentColor) {
        this.startPoint = startPoint;
        endPoint = startPoint;
        this.currentColor = currentColor;
        repaint();
    }

    public void followMouseLine(Point currentPoint, Color currentColor) {
        endPoint = currentPoint;
        this.currentColor = currentColor;
        repaint();
    }

    public void drawLineFromMouse(Point firstPoint, Point secondPoint, Color currentColor) {
        if (startPoint != null && endPoint != null) {
            Graphics g = image.getGraphics();
            g.setColor(currentColor);
            g.drawLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
        }
        startPoint = null;
        endPoint = null;
        repaint();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
}


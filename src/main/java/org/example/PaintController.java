package org.example;

import java.awt.*;
import java.awt.event.MouseEvent;

public class PaintController {

    private Tool tool;
    private final DrawingComponent canvas;
    private Color currentColor = Color.MAGENTA;

    public PaintController(DrawingComponent canvas) {
        this.canvas = canvas;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
        canvas.setTool(tool);

        if (tool instanceof LineTool) {
            ((LineTool) tool).setColor(currentColor);
        }
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;

        if (tool instanceof LineTool) {
            ((LineTool) tool).setColor(color);
        }
    }

    public void mousePressed(MouseEvent event) {
        if (tool != null) {
            Graphics g = canvas.getImage().getGraphics();
            g.setColor(currentColor);
            tool.pressed(g, event.getX(), event.getY());
            canvas.repaint();
        }
    }

    public void mouseDragged(MouseEvent event) {
        if (tool != null) {
            Graphics g = canvas.getImage().getGraphics();
            g.setColor(currentColor);
            tool.dragged(g, event.getX(), event.getY());
            canvas.repaint();
        }
    }

    public void mouseReleased(MouseEvent event) {
        if (tool != null) {
            Graphics g = canvas.getImage().getGraphics();
            g.setColor(currentColor);
            tool.released(g, event.getX(), event.getY());
            canvas.repaint();
        }
    }
}


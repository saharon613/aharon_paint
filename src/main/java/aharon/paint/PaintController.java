package aharon.paint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

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
        tool.setColor(currentColor);
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
        if (tool != null) {
            tool.setColor(currentColor);
        }
    }

    public void mousePressed(MouseEvent event) {
        if (tool != null) {
            BufferedImage image = canvas.getImage();
            Graphics2D g = (Graphics2D) image.getGraphics();
            g.setColor(currentColor);
            tool.pressed(image, g, event.getX(), event.getY());
            canvas.repaint();
        }
    }

    public void mouseDragged(MouseEvent event) {
        if (tool != null) {
            Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
            g.setColor(currentColor);
            tool.dragged(g, event.getX(), event.getY());
            canvas.repaint();
        }
    }

    public void mouseReleased(MouseEvent event) {
        if (tool != null) {
            Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
            g.setColor(currentColor);
            tool.released(g, event.getX(), event.getY());
            canvas.repaint();
        }
    }
}


package aharon.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * this class draws the BufferedImage to the screen
 */
public class DrawingComponent extends JComponent {

    private final BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);

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
        if (tool != null) {
            tool.preview(g);
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
}

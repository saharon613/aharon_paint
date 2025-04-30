package aharon.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

// interface defines methods that a class must implement

public interface Tool {
    void pressed(BufferedImage image, Graphics2D g, int x, int y);

    void dragged(Graphics2D g, int x, int y);

    /**
     * draws a preview of the tools operation if released is called
     *
     * @param g the Graphics to draw the preview on
     */

    void preview(Graphics2D g);

    void released(Graphics2D g, int x, int y);

    /**
     * @param color the color the tool will use
     */

    void setColor(Color color);
}

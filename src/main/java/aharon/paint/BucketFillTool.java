package aharon.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BucketFillTool implements Tool {
    private Color fillColor = Color.MAGENTA;

    @Override
    public void pressed(BufferedImage image, Graphics2D g, int x, int y) {
        int targetRGB = image.getRGB(x, y);
        int fillRGB = fillColor.getRGB();

        if (targetRGB == fillRGB) return;

        floodFillRecursive(image, x, y, targetRGB, fillRGB);
        g.drawImage(image, 0, 0, null);
    }

    private void floodFillRecursive(BufferedImage image, int x, int y, int targetRGB, int fillRGB) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Out of bounds
        if (x < 0 || x >= width || y < 0 || y >= height) return;

        // If the pixel is not the target color, return
        if (image.getRGB(x, y) != targetRGB) return;

        // Fill the pixel
        image.setRGB(x, y, fillRGB);

        // Recursively fill all four directions
        floodFillRecursive(image, x + 1, y, targetRGB, fillRGB); // Right
        floodFillRecursive(image, x - 1, y, targetRGB, fillRGB); // Left
        floodFillRecursive(image, x, y + 1, targetRGB, fillRGB); // Down
        floodFillRecursive(image, x, y - 1, targetRGB, fillRGB); // Up
    }

    @Override public void dragged(Graphics2D g, int x, int y) {}
    @Override public void preview(Graphics2D g) {}
    @Override public void released(Graphics2D g, int x, int y) {}
    @Override public void setColor(Color color) {
        this.fillColor = color;
    }
}


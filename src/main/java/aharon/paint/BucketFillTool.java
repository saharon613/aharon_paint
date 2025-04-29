package aharon.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BucketFillTool implements Tool {
    private Color fillColor = Color.MAGENTA;

    @Override
    public void pressed(BufferedImage image, Graphics2D g, int x, int y) {
        int pixelColor = image.getRGB(x, y);
        int newColor = fillColor.getRGB();

        if (pixelColor == newColor) { return; }

        floodFillRecursive(image, x, y, pixelColor, newColor);
        g.drawImage(image, 0, 0, null);
    }

    private void floodFillRecursive(BufferedImage image, int x, int y, int pixelColor, int newColor) {
        int width = image.getWidth();
        int height = image.getHeight();

        if (x < 0 || x >= width || y < 0 || y >= height) { return; }

        if (image.getRGB(x, y) != pixelColor) { return; }

        image.setRGB(x, y, newColor);

        floodFillRecursive(image, x + 1, y, pixelColor, newColor); // Right
        floodFillRecursive(image, x - 1, y, pixelColor, newColor); // Left
        floodFillRecursive(image, x, y + 1, pixelColor, newColor); // Down
        floodFillRecursive(image, x, y - 1, pixelColor, newColor); // Up
    }

    @Override public void dragged(Graphics2D g, int x, int y) {}

    @Override public void preview(Graphics2D g) {}

    @Override public void released(Graphics2D g, int x, int y) {}

    @Override public void setColor(Color color) {
        this.fillColor = color;
    }
}


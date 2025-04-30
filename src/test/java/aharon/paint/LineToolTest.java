package aharon.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LineToolTest {
    private Graphics2D g = mock();
    BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);

    @Test
    void pressed() {
        LineTool tool = new LineTool();
        // when
        tool.pressed(image, g, 50, 100);

        // then
        assertEquals(50, tool.getX());
        assertEquals(100, tool.getY());
        verify(g).drawLine(50, 100, 50, 100);    // draws a dot
    }

    @Test
    void dragged() {
        LineTool tool = new LineTool();
        tool.pressed(image, g, 50, 100);

        // when
        tool.dragged(g, 200, 150);

        // then
        assertEquals(200, tool.getX2());
        assertEquals(150, tool.getY2());
    }

    @Test
    void preview() {

        // given
        LineTool tool = new LineTool();
        tool.setColor(Color.RED);
        tool.pressed(image, g, 10, 20);
        tool.dragged(g, 100, 200);

        // when
        tool.preview(g);

        // then
        verify(g).setColor(Color.RED);
        verify(g).drawLine(10, 20, 100, 200);
    }

    @Test
    void released() {

        // given
        LineTool tool = new LineTool();
        tool.pressed(image, g, 10, 20);

        // when
        tool.released(g, 150, 250);

        // then
        verify(g).drawLine(10, 20, 150, 250);

        assertEquals(0, tool.getX());
        assertEquals(0, tool.getY());
        assertEquals(0, tool.getX2());
        assertEquals(0, tool.getY2());
    }
}
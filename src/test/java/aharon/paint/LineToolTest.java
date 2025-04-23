package aharon.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LineToolTest {
    private Graphics g = mock();

    @Test
    void pressed() {
        LineTool tool = new LineTool();
        // when
        tool.pressed(g, 50, 100);

        // then
        assertEquals(50, tool.getX());
        assertEquals(100, tool.getY());
        verify(g).drawLine(50, 100, 50, 100);    // draws a dot
    }

    @Test
    void dragged() {
        LineTool tool = new LineTool();
        tool.pressed(g, 50, 100);

        // when
        tool.dragged(g, 200, 150);

        // then
        assertEquals(200, tool.getX2());
        assertEquals(150, tool.getY2());
    }

    @Test
    void preview() {
        LineTool tool = new LineTool();

        // Set up internal state (assuming public setters or directly setting fields)
        tool.setColor(Color.RED);
        tool.pressed(g, 10, 20);
        tool.dragged(g, 100, 200);

        tool.preview(g);

        verify(g).setColor(Color.RED);
        verify(g).drawLine(10, 20, 100, 200);
    }

    @Test
    void released() {
        LineTool tool = new LineTool();

        tool.pressed(g, 10, 20);
        tool.released(g, 150, 250);  // final mouse release at (150, 250)

        verify(g).drawLine(10, 20, 150, 250);

        assertEquals(0, tool.getX());
        assertEquals(0, tool.getY());
        assertEquals(0, tool.getX2());
        assertEquals(0, tool.getY2());
    }
}
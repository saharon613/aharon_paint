package aharon.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PencilToolTest {

    private Graphics2D g = mock();
    BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);

    @Test
    void pressed() {
        // given
        PencilTool penTool = new PencilTool();

        // when
        penTool.pressed(image, g, 50, 100);

        // then
        assertEquals(50, penTool.getX());
        assertEquals(100, penTool.getY());
        verify(g).drawLine(50, 100, 50, 100);    // draws a dot
    }

    @Test
    void dragged() {
        // given
        PencilTool penTool = new PencilTool();
        penTool.pressed(image, g, 50, 100);

        // when
        penTool.dragged(g, 200, 150);

        // then
        assertEquals(200, penTool.getX());
        assertEquals(150, penTool.getY());
        verify(g).drawLine(50, 100, 200, 150);  // draws a line to the two points
    }

    @Test
    void released() {
        // given
        PencilTool penTool = new PencilTool();

        // when
        penTool.released(g, 100, 200);

        // then
        verifyNoMoreInteractions(g);
    }
}
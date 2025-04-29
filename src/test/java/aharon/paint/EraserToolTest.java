package aharon.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EraserToolTest {
    private Graphics2D g = mock();
    BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);

    @Test
    void pressed() {

        // given
        EraserTool tool = new EraserTool();

        // when
        tool.pressed(image, g, 50, 100);

        // then
        verify(g).setColor(Color.WHITE);
        verify(g).setStroke(any(BasicStroke.class));
        verify(g).draw(any(Line2D.Float.class));
    }

    @Test
    void dragged() {

        // given
        EraserTool tool = new EraserTool();

        // when
        tool.dragged(g, 100, 200);

        // then
        verify(g).setColor(Color.WHITE);
        verify(g, atLeastOnce()).setStroke(any(BasicStroke.class));
        verify(g, atLeastOnce()).draw(any(Line2D.Float.class));
    }

    @Test
    void preview() {
    }

    @Test
    void released() {
    }
}
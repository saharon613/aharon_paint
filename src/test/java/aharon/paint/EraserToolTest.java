package aharon.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class EraserToolTest {
    private Graphics g = mock();

    @Test
    void pressed() {
        EraserTool tool = new EraserTool();
        tool.pressed(g, 50, 100);

        verify(g).setColor(Color.WHITE);
        verify(g).fillRect(50, 100, 10, 10);
    }

    @Test
    void dragged() {
        EraserTool tool = new EraserTool();

        tool.dragged(g, 100, 200);

        verify(g).setColor(Color.WHITE);
        verify(g).fillRect(95, 195, 10, 10);
    }

    @Test
    void preview() {
    }

    @Test
    void released() {
    }
}
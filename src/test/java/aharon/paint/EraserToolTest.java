package aharon.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class EraserToolTest {
    private Graphics g = mock();

    @Test
    void pressed() {

        // given
        EraserTool tool = new EraserTool();

        // when
        tool.pressed(g, 50, 100);

        // then
        verify(g).setColor(Color.WHITE);
        verify(g).fillRect(45, 95, 10, 10);
    }

    @Test
    void dragged() {

        // given
        EraserTool tool = new EraserTool();

        // when
        tool.dragged(g, 100, 200);

        // then
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
package aharon.paint;

import java.awt.*;

public class EraserTool implements Tool {
    private int x;
    private int y;

    @Override
    public void pressed(Graphics g, int x, int y) {
        this.x = x;
        this.y = y;
        g.setColor(Color.WHITE);
        g.fillRect(x - 5, y - 5, 10, 10);
    }

    @Override
    public void dragged(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        g.fillRect(x - 5, y - 5, 10, 10);
        this.x = x;                                    // this here and for y allows for them to be reset when
        this.y = y;
    }

    @Override
    public void preview(Graphics g) {

    }

    @Override
    public void released(Graphics g, int x, int y) {

    }

    @Override
    public void setColor(Color color) {

    }

}


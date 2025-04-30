package aharon.paint;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class EraserTool implements Tool {
    private int x;
    private int y;
    private float thickness = 10.0f;

    @Override
    public void pressed(BufferedImage image, Graphics2D g, int x, int y) {
        this.x = x;
        this.y = y;
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.draw(new Line2D.Float(x, y, x, y));
    }

    @Override
    public void dragged(Graphics2D g, int x, int y) {
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.draw(new Line2D.Float(this.x, this.y, x, y));
        this.x = x;                                    // this here and for y allows for them to be reset when
        this.y = y;
    }

    @Override
    public void preview(Graphics2D g) {

    }

    @Override
    public void released(Graphics2D g, int x, int y) {

    }

    @Override
    public void setColor(Color color) {

    }

}


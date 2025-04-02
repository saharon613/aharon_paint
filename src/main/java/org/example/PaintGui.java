package org.example;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class PaintGui extends JFrame {

    private final DrawingComponent canvas = new DrawingComponent();
    private PencilTool pencilTool = new PencilTool();
    private final JButton paintButton = new JButton("Paint");
    private final JColorChooser colorChooser = new JColorChooser();
    private final JButton lineButton = new JButton("Line");
    private boolean paintBol;
    private boolean lineBol;
    private Point startPoint;
    private Color currentColor = Color.MAGENTA;

    public PaintGui() {
        setTitle("Paint");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        AbstractColorChooserPanel[] panels = {colorChooser.getChooserPanels()[0]};
        colorChooser.setChooserPanels(panels);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(getWidth(), 110));
        colorChooser.setPreferredSize(new Dimension(70, 110));
        colorChooser.setPreviewPanel(new JPanel());

        northPanel.add(paintButton, BorderLayout.WEST);
        northPanel.add(colorChooser, BorderLayout.CENTER);
        northPanel.add(lineButton, BorderLayout.EAST);
        add(northPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent event) { // where the mouse is currently within the component
                if (paintBol) {
                    lineBol = false;
                    Graphics g = canvas.getImage().getGraphics();
                    g.setColor(currentColor);
                    pencilTool.dragged(g, event.getX(), event.getY());
                    canvas.repaint();
                }
//                if (paintBol) {
//                    canvas.drawFromMouse(event.getX(), event.getY(), currentColor);
//                }
//                if (lineBol) {
//                    canvas.followMouseLine(event.getPoint(), currentColor);
//                }
            }

            @Override
            public void mouseMoved(MouseEvent event) {

            }
        });

        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent event) {

            }

            @Override
            public void mousePressed(MouseEvent event) {
                if (paintBol) {
                    lineBol = false;
                    Graphics g = canvas.getImage().getGraphics();
                    g.setColor(currentColor);
                    pencilTool.pressed(g, event.getX(), event.getY());
                    canvas.repaint();
                }
//                if (lineBol) {
//                    paintBol = false;
//                    startPoint = event.getPoint();
//                    canvas.setStartPoint(startPoint, currentColor);
//                }
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                if (paintBol) {
                    lineBol = false;
                    Graphics g = canvas.getImage().getGraphics();
                    g.setColor(currentColor);
                    pencilTool.released(g, event.getX(), event.getY());
                    canvas.repaint();
                }
//                canvas.newClick();
//                if (lineBol && !paintBol) {
//                    Point endPoint = event.getPoint();
//                    canvas.drawLineFromMouse(startPoint, endPoint, currentColor);
//                }
            }

            @Override
            public void mouseEntered(MouseEvent event) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        paintButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                paintBol = true;
                lineBol = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentColor = colorChooser.getColor(); // Update the current color
            }
        });

        lineButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                lineBol = true;
                paintBol = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        PaintGui frame = new PaintGui();
        frame.setVisible(true);
    }
}

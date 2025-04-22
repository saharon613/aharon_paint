package org.example;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class PaintGui extends JFrame {

    private final DrawingComponent canvas = new DrawingComponent();
    private Tool tool = null;
    private final JButton paintButton = new JButton("Paint");
    private final JColorChooser colorChooser = new JColorChooser();
    private final JButton lineButton = new JButton("Line");
    private final JButton eraserButton = new JButton("Eraser");
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

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(155, 110));

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(getWidth(), 110));
        colorChooser.setPreferredSize(new Dimension(70, 110));
        colorChooser.setPreviewPanel(new JPanel());

        leftPanel.add(paintButton, BorderLayout.WEST);
        leftPanel.add(eraserButton, BorderLayout.EAST);
        northPanel.add(colorChooser, BorderLayout.CENTER);
        northPanel.add(lineButton, BorderLayout.EAST);
        northPanel.add(leftPanel, BorderLayout.WEST);
        add(northPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        canvas.setTool(tool);

        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent event) { // where the mouse is currently within the component
                if (tool != null) {
                    lineBol = false;
                    Graphics g = canvas.getImage().getGraphics();
                    g.setColor(currentColor);
                    tool.dragged(g, event.getX(), event.getY());
                    canvas.repaint();
                }

                if (tool instanceof LineTool) {
                    ((LineTool) tool).setColor(currentColor);
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
                //if (paintBol) {
                    lineBol = false;
                    Graphics g = canvas.getImage().getGraphics();
                    g.setColor(currentColor);
                    tool.pressed(g, event.getX(), event.getY());
                    canvas.repaint();
                //}
//                if (lineBol) {
//                    paintBol = false;
//                    startPoint = event.getPoint();
//                    canvas.setStartPoint(startPoint, currentColor);
//                }
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                //if (paintBol) {
                    lineBol = false;
                    Graphics g = canvas.getImage().getGraphics();
                    g.setColor(currentColor);
                    tool.released(g, event.getX(), event.getY());
                    canvas.repaint();
                //}
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
                tool = new PencilTool();
                canvas.setTool(tool);
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
                tool = new LineTool();
                canvas.setTool(tool);
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

        eraserButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                tool = new EraserTool();
                canvas.setTool(tool);
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

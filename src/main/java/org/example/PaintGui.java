package org.example;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class PaintGui extends JFrame {

    private final DrawingComponent canvas = new DrawingComponent();
    private final PaintController controller = new PaintController(canvas);
    private final JButton paintButton = new JButton("Paint");
    private final JColorChooser colorChooser = new JColorChooser();
    private final JButton lineButton = new JButton("Line");
    private final JButton eraserButton = new JButton("Eraser");

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

        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent event) { // where the mouse is currently within the component
                controller.mouseDragged(event);
            }

            @Override
            public void mouseMoved(MouseEvent event) {}
        });

        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent event) {}

            @Override
            public void mousePressed(MouseEvent event)
            { controller.mousePressed(event);
            }

            @Override
            public void mouseReleased(MouseEvent event)
            { controller.mouseReleased(event);
            }

            @Override
            public void mouseEntered(MouseEvent event) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        paintButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e)
            { controller.setTool(new PencilTool());
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                controller.setCurrentColor(colorChooser.getColor());
            }
        });

        lineButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e)
            { controller.setTool(new LineTool());
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        eraserButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e)
            { controller.setTool(new EraserTool());
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    public static void main(String[] args) {
        PaintGui frame = new PaintGui();
        frame.setVisible(true);
    }
}


package org.example;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class PaintGui extends JFrame {

    private final DrawingComponent canvas = new DrawingComponent();
    private final JButton paintButton = new JButton("Paint");
    private final JColorChooser colorChooser = new JColorChooser();
    private final JButton lineButton = new JButton("Line");
    private boolean paintBol;
    private Color currentColor = Color.MAGENTA;

    public PaintGui() {
        setTitle("Paint");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        AbstractColorChooserPanel[] panels = { colorChooser.getChooserPanels()[0] };
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
                if (paintBol)
                { canvas.drawFromMouse(event.getX(), event.getY(), currentColor); }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent event) {

            }

            @Override
            public void mouseReleased(MouseEvent event) {
                canvas.newClick();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        paintButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                paintBol = true;
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
    }

    public static void main(String[] args) {
        PaintGui frame = new PaintGui();
        frame.setVisible(true);
    }
}
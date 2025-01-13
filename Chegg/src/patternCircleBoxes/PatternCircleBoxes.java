package patternCircleBoxes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PatternCircleBoxes {
	public static void main(String[] args) {
        new PatternCircleBoxes();
    }

    public PatternCircleBoxes() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    public class TestPane extends JPanel {

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            int x = getWidth() / 2;
            int y = getHeight() / 2;
//          paintCircleAt(g2d, Math.min(x, y), y, y, Color.BLACK, Color.YELLOW);
//          paintCirclesIn(g2d, 5, Math.min(x, y), x, y, Color.BLACK, Color.YELLOW);
            paintCirclesInSquare(g2d, 5, 0, 0, getWidth() - 1, getHeight() - 1, Color.BLACK, Color.GREEN, Color.BLACK, Color.YELLOW);
            g2d.dispose();
        }

        public void paintCirclesInSquare(Graphics2D g2d, int count, int x, int y, int width, int height, Color squareStroke, Color squareFill, Color circleStroke, Color circleFill) {
            int centerX = x + (width / 2);
            int centerY = y + (height / 2);
            int radius = Math.min(centerX, centerY);
            Rectangle2D box = new Rectangle2D.Double(x, y, width, height);
            g2d.setColor(squareFill);
            g2d.fill(box);
            g2d.setColor(squareStroke);
            g2d.draw(box);

            paintCirclesIn(g2d, count, radius, centerX, centerY, circleStroke, circleFill);

            g2d.drawLine(centerX, y, centerX, y + height);
            g2d.drawLine(x, centerY, x + width, centerY);
        }

        public void paintCirclesIn(Graphics2D g2d, int count, int radius, int centerX, int centerY, Color stroke, Color fill) {

            System.out.println(radius + "; " + centerX + "; " + centerY);

            int delta = radius / count;
            int innerRadius = radius;
            for (int index = 0; index < count; index++, innerRadius -= delta) {
                paintCircleAt(g2d, innerRadius, centerX, centerY, stroke, fill);
            }

        }

        public void paintCircleAt(Graphics2D g2d, int radius, int centerX, int centerY, Color stroke, Color fill) {
            Ellipse2D.Double circle = new Ellipse2D.Double(centerX - radius, centerY - radius, radius * 2, radius * 2);
            g2d.setColor(fill);
            g2d.fill(circle);
            g2d.setColor(stroke);
            g2d.draw(circle);
        }

    }
}

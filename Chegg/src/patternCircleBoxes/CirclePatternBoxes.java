package patternCircleBoxes;

import java.awt.*;
public class CirclePatternBoxes {
	public static final int WIDTH=400;
    public static final int HEIGHT=400;

    public static void main (String[] args) {
        DrawingPanel panel = new DrawingPanel(WIDTH,HEIGHT);
        Graphics g = panel.getGraphics ();

        panel.setBackground(new Color(0, 255, 255 ) );

        int x = 0;
        int y = 0;
        int size = 100;
        int rows = 5;
        int numSquares = 1;

        drawManySquares ( g, numSquares, x, y, size, rows );

        x = 10;
        y = 120;
        size = 24;
        rows = 4;
        numSquares = 4;

        drawManySquares( g, numSquares, x, y, size, rows );

        x = 150;
        y = 20;
        size = 40;
        rows = 6;
        numSquares = 5;

        drawManySquares( g, numSquares, x, y, size, rows );

        x = 130;
        y = 275;
        size = 36;
        rows = 3;
        numSquares = 3;

        drawManySquares( g, numSquares, x, y, size, rows );
    }

    public static void drawManySquares( Graphics g, int numSquares, int x, int y, int size, int rows ) {
        for ( int i = 0; i < numSquares; i++ ) {
            for ( int j = 0; j < numSquares; j++ ) {
                drawOneSquare( g, x + i * size, y + j * size, size, rows );
            }
        }
    }

    public static void drawOneSquare( Graphics g, int x, int y, int size, int rows ) {
        g.setColor ( Color.GREEN);
        g.fillRect(x , y, size, size);

        g.setColor ( Color.YELLOW);
        g.fillOval ( x, y, size, size);

        g.setColor ( Color.BLACK);
        g.drawLine(size / 2, x, size / 2, size);
        g.setColor ( Color.BLACK);
        g.drawLine(x, size / 2, size, size / 2);

        for (int i = 0; i <= rows; i = i + 1) {
            g.setColor ( Color.BLACK);
            g.drawOval(x + (i* (size/rows)), y+ (i*(size/rows)), size - (i*(size/rows +10   )) , size - (i*(size/rows +10)));
        }
    }
}

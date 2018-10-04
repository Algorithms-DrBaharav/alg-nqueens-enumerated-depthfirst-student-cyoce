
// NO NEED to change anything here!
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * 
 * 
 *   We will keep things NOT too flexible here,
 *   so as to make the design and code simpler.
 * 
 *  Things will be in fixed-location on screen.
 *  This is called Absolute-positioning (as compared to using layouts)
 *  http://docs.oracle.com/javase/tutorial/uiswing/layout/none.html
 *  All the definition are grouped below
 *  The graphic tries to follow the look of:
 *  http://www.bitstorm.org/gameoflife/ 
 * 
 *   Display is just for drawing the board
 * 
 */
//@SuppressWarnings("serial")
public class Display extends JComponent {

    int frameWidth, frameHeight;

    private final static int CELL_SIDE_PIXELS = 20;
    
    private final int Cell_Top_X ;
    private final int Cell_Top_Y ;

    private final static Color COLOR_QUEEN = Color.RED;
    private final static Color COLOR_EMPTY_B = Color.BLUE;
    private final static Color COLOR_EMPTY_W = Color.YELLOW;
    private final static Color COLOR_GRID = Color.WHITE;

    private int[][] board ;
    private int N;
    
    //String imageFileName = "queen_18x18.jpg";
    String imageFileName = "Chess_tile_ql_18x18.png";
    private ImageIcon image = new ImageIcon(imageFileName);

    public Display(int frameWidth, int frameHeight, int n) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        N = n ; 
        
        board = new int[N][N];
        // initializing some value for later on.
        Cell_Top_X = ( frameWidth - N*CELL_SIDE_PIXELS )/2;
        Cell_Top_Y = ( frameHeight - N*CELL_SIDE_PIXELS )/2;
    }

    public void drawBoard(int[][] b) {
        for (int ii = 0; ii < N; ++ii) {
            for (int jj = 0; jj < N; ++jj) {
                board[ii][jj] = b[ii][jj];
            }
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        drawGrid(g2);
        drawCells(g2);

    }

    private void drawGrid(Graphics2D g2) {
        g2.setColor(COLOR_GRID);

        int x1 = Cell_Top_X;
        int x2 = Cell_Top_X + N * CELL_SIDE_PIXELS;
        int y1, y2;

        for (int ii = 0; ii <= N ; ii++) {
            y1 = Cell_Top_Y + ii * CELL_SIDE_PIXELS;
            g2.drawLine(x1, y1, x2, y1);
        }

        y1 = Cell_Top_Y;
        y2 = Cell_Top_Y + N * CELL_SIDE_PIXELS;
        for (int jj = 0; jj <= N ; jj++) {
            x1 = Cell_Top_X + jj * CELL_SIDE_PIXELS;
            g2.drawLine(x1, y1, x1, y2);
        }

    }

    private void drawCells(Graphics2D g2) {

        for (int ii = 0; ii < N; ii++) {
            int ytop = Cell_Top_Y + ii * CELL_SIDE_PIXELS;

            for (int jj = 0; jj < N; jj++) {

                int xleft = Cell_Top_X + jj * CELL_SIDE_PIXELS;

                Color c = ((ii - jj) % 2 == 0) ? COLOR_EMPTY_B : COLOR_EMPTY_W;
                g2.setColor(c);
                g2.fillRect(xleft + 1, ytop + 1, CELL_SIDE_PIXELS - 2, CELL_SIDE_PIXELS - 2);

                if (board[ii][jj] == 1) {
                    JLabel label = new JLabel();
                    label.setBounds(xleft + 1, ytop + 1, CELL_SIDE_PIXELS - 2, CELL_SIDE_PIXELS - 2);
                    label.setIcon(image);
                    add(label);
                }

            }
        }

    }

}

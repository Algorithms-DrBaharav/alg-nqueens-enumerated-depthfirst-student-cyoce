
/**
 *
 * @author Dr. Baharav
 * 
 * 
 * 
 * 
 * Homework: Print ALL viable boards. How many are there?
 * 
 */

import javax.swing.JFrame;

public class MainNQ {

    
    public static void main(String[] args) {
        
        int N = 12;
        SolverNxN s1 = new SolverNxN(N);
        int[][] b2 = s1.solve();
        
        
        final int DISPLAY_WIDTH = 600 ;
	final int DISPLAY_HEIGHT = 600 ;
		
	JFrame frame = new JFrame();
		
	frame.setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
        frame.setTitle("" + N +"-Queens");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//frame.setLayout(null); // we are using absolute location
		
	Display display = new Display(DISPLAY_WIDTH, DISPLAY_HEIGHT, N);

        display.drawBoard(b2);
	frame.add(display);				
	frame.setVisible(true);
        
    }
    
}


/**
 * Solves 8-Queens problem
 * 
 * How to place 8-queens on a chess board such that none can capture another.
 * 
 * Some notes about implementation:
 *   b is one dimensional array, element b[i] represents the queens at location
 *    (row=b[i], col=i).
 * 
 * The function solve() return the board for display.
 * 
 * @author Dr. Baharav
 */
public class SolverNxN {

    
    // Board representation
    private int N;

    // Initialize all to empty
    public SolverNxN(int n) {
        N=n;
    }

    /**
     * 
     * @return int[][] - Board - 2D array, with 1 representing a queen, and 0 
     * represents NO queen (aka empty square)
     * 
     */
    public int[][] solve() {
        
        // do something

        // return a nice board
        return b2board();
    }
    
    
    
    /*
    
    UTILITY methods below
    
    */
    

    //  Convert into a 2D representation.
    //  Used to communicate out. For display. Simple 8x8 array
    //      bDisplay[ii][jj] is square [ii][jj] on the board.
    //      content of cell: 1 is Queen present, 0 is empty cell.

    private int[][] b2board() {
        int[][]br = new int[N][N];
        for (int ii = 0; ii < N; ++ii) 
            for (int jj = 0; jj < N; ++jj) 
                br[ii][jj] = 0;
            
        
        for (int ii = 0; ii < N; ++ii)
            if (ii==4)
                br[N-1][ii] = 1;
            else    
                br[ii][ii] = 1;

        // Just if you want intermediate printouts, see how it works
        printBoard(br);
        
        return br;
    }

    
    private void printBoard(int[][] b) {
        System.out.println("Board");

        for (int cc = 0; cc < N; ++cc) 
            System.out.print("+-");
        System.out.println("+");

        for (int rr = 0; rr < N; ++rr) {
            for (int cc = 0; cc < N; ++cc) {
                if (b[rr][cc] == 1)
                    System.out.format("|*");
                else
                    System.out.format("| ");                    
            }
            System.out.println("|");
        
            for (int cc = 0; cc < N; ++cc) 
                System.out.print("+-");
            System.out.println("+");
        }

    }

}

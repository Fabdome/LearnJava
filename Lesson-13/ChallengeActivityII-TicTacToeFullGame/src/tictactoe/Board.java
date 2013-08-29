package tictactoe;

/**
 * Tic-Tac-Toe Board
 * @author mafudge
 */
public class Board {
    
    private Marker[][] board;
    
    /**
     * Initializes a new Tic-Tac-Toe board (which is a 2-d array 
     * of Markers (X, O, or EMPTY)
     */
    public Board(){
        board = new Marker[3][3];
        this.Clear();
    }
    
    /**
     * Initializes a new Tic-Tac-Toe board using the given array 
     * @param board the 2d array for the board
     */
    public Board(Marker[][] board) {
        this.board = board;
    }
    
    /**
     * Erases the board, called with the constructor of the class.
     */
    public final void Clear() {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                board[i][j] = Marker.EMPTY;
            }
        }
    }
    
    /**
     * Draws the current state of the board to System.out
     */
    public void Draw() {
        System.out.printf("\n  0 1 2\n");
        for (int i=0;i<3;i++) {
            System.out.printf("%d ",i);
            for (int j=0;j<3;j++) {
                if (j<2) {
                    System.out.printf("%c|",board[i][j].toChar());
                } else {
                    System.out.printf("%c",board[i][j].toChar());                
                }
            }
            System.out.printf("\n");
            if (i<2) System.out.printf("  -+-+-\n");
        }
        System.out.println();
    }
    
    /**
     * Places the marker on the board at position row and column
     * @param marker the marker to place (X or O)
     * @param row the row (0, 1 or 2)
     * @param column the column (0,1 or 2)
     * @return true if the marker was placed
     */
    public boolean Place(Marker marker, int row, int column) {
        if (this.board[row][column] == Marker.EMPTY) {
            this.board[row][column] = marker;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Returns the marker of the winner Marker.Empty implies no winner
     * @return the winning marker
     */
    public boolean Winner(Marker marker) {
        boolean rowWinner = false;
        boolean colWinner = false;
        boolean angleWinner = false;
        
        // TODO: Check three in a row (rowWinner)
        rowWinner = (board[0][0] == marker && board[0][1] == marker && board[0][2] == marker) ||
                    (board[1][0] == marker && board[1][1] == marker && board[1][2] == marker) ||
                    (board[2][0] == marker && board[2][1] == marker && board[2][2] == marker);
        
        // TODO: Check three in a column (colWinner)
        colWinner = (board[0][0] == marker && board[1][0] == marker && board[2][0] == marker) ||
                    (board[0][1] == marker && board[1][1] == marker && board[2][1] == marker) ||
                    (board[0][2] == marker && board[1][2] == marker && board[2][2] == marker);

        
        // TODO: Check the angles (angleWinner)
        angleWinner = (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) ||
                      (board[2][0] == marker && board[1][1] == marker && board[0][2] == marker);                            
                

        // We have a winner if we have a row, column or angle winner
        return rowWinner || colWinner || angleWinner;
        
    }
    
    /**
     * Detects when the board is full (no more Marker.EMPTY on the board)
     * @return true when full, false otherwise
     */
    public boolean Full() {
        // TODO: Implement this method

    }
 
}
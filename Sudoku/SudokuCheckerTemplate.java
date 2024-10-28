public class SudokuCheckerTemplate {

    //this function should call the other "helper" functions! 
    //it may help to fill this out first, as a way to understand the "flow" and relation of methods
    public static boolean isValidSudoku(int[][] board) {
        
    }
     //helper function to check if an array contains unique non-zero values
    //this is again, me being extra...
    //I'd expect to see some kind of double for loop. 
    //For example, for each int 1-9, loop through the array and count how many times you see that int
    //if any int is seen more than once, then u have a problem!
    private static boolean isUnique(int[] array) {
        
    }

    // Checks if all rows are valid
    //rows are easy to extract from a 2d array
    //you should use isUnique!
    private static boolean checkRows(int[][] board) {
        
    }


    //we have to manually "pull" the data for each column, because of how a 2d array is stored
    //luckily, we know there are always 9 values, so we can do some "hardcoding"
    //ask your LA what hardcoding is!

    /*
    challenge: write a separate function to extract the column data.
    input: 2d array for the board, a variable n for the column number
    output: 1d array containing all the values from that column
    */
    //you should use isUnique!
    private static boolean checkColumns(int[][] board) {
        
    }

    //a 9x9 array has 9 subgrids of 3x3 size, and they must be checked.
    //implemented for you. 
    private static boolean checkSubgrids(int[][] board) {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!checkSubgrid(board, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    //yeah this method is kind of tricky! 
    //implemented for you.
    private static boolean checkSubgrid(int[][] board, int startRow, int startCol) {
        int[] nums = new int[9];
        int index = 0;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                nums[index++] = board[row][col];
            }
        }
        return isUnique(nums);
    }

   
    //ensure that the grid does not have any 0s, or any improper values!
    private static boolean isFullyFilled(int[][] board) {
    
    }



    
    public static void main(String[] args) {
        int[][] board1 = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        int[][] board2 = {
            {5, 3, 4, 6, 7, 8, 9, 9, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        
        //board one is valid, board 2 is invalid!
        System.out.println("Board one's validity: " + isValidSudoku(board1));
        System.out.println("Board two's validity: " + isValidSudoku(board2));

    }
}

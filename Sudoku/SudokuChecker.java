public class SudokuChecker {

    public static boolean isValidSudoku(int[][] board) {
        return checkRows(board) && checkColumns(board) && checkSubgrids(board) && isFullyFilled(board);
        //this is me being a bit of a smartass,, I'd expect normal people to do something like
        /*
            if(checkRows(board) == false || checkColumns(board) == false || checkSubgrids(board) == false || isFullyFilled(board) == false) 
                return false;
            return true;
         */
    }

    // Checks if all rows are valid
    //rows are easy to extract from a 2d array
    private static boolean checkRows(int[][] board) {
        for (int row = 0; row < 9; row++) {
            if (!isUnique(board[row])) {
                return false;
            }
        }
        //if we checked every row, and none were bad, then they must be all good!
        return true;
    }


    //we have to manually "pull" the data for each column, because of how a 2d array is stored
    //luckily, we know there are always 9 values, so we can do some "hardcoding"
    //ask your LA what hardcoding is!

    /*
    challenge: write a separate function to extract the column data.
    input: 2d array for the board, a variable n for the column number
    output: 1d array containing all the values from that column
    */
    private static boolean checkColumns(int[][] board) {
        for (int row = 0; row < 9; row++) {
            int[] column = {
                board[row][0],
                board[row][1],
                board[row][2],
                board[row][3],
                board[row][4],
                board[row][5],
                board[row][6],
                board[row][7],
                board[row][8],
            };
            if (!isUnique(column)) {
                return false;
            }
        }
        //if we checked every column, and none were bad, then they must be all good!
        return true;
    }

    //a 9x9 array has 9 subgrids of 3x3 size! this is just part of the rules of sudoku.
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
    //challenge: write out < 5 sentences explaining how this method works. 
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

    //helper function to check if an array contains unique non-zero values
    //this is again, me being extra...
    //I'd expect to see some kind of double for loop. 
    //For example, for each int 1-9, loop through the array and count how many times you see that int
    //if any int is seen more than once, then u have a problem!
    private static boolean isUnique(int[] array) {
        boolean[] seen = new boolean[9];
        for (int num : array) {
            if (num != 0) {
                if (seen[num - 1]) {
                    return false; 
                }
                seen[num - 1] = true;
            }
        }
        return true;
    }

    private static boolean isFullyFilled(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0 || (board[row][col] < 1 && board[row][col] > 9)) {
                    return false; 
                }
            }
        }
        return true;
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
        
        System.out.println("Board one's validity: " + isValidSudoku(board1));
        System.out.println("Board two's validity: " + isValidSudoku(board2));

    }
}

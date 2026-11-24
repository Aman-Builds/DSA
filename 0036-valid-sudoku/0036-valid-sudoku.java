
import java.util.*;

class Solution {

    // Validate a 3x3 box

    // this function whether a particular box is valid by traversing 
    public boolean valid(char[][] board, int sr, int er, int sc, int ec) {

        Set<Character> st1 = new HashSet<>();

        // We use HashSet because it stores only unique characters.
        // If a number already exists, it means we have a duplicate.


          // trab
        for (int i = sr; i <= er; i++) {

            for (int j = sc; j <= ec; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                if (st1.contains(board[i][j])) {
                    return false;
                }
                 // Add the current number to Set
                // So that we can detect it if it appears again
                st1.add(board[i][j]);
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        // Validate rows
        for (int row = 0; row < 9; row++) {

            Set<Character> st = new HashSet<>();

            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    continue;
                }

                if (st.contains(board[row][col])) {
                    return false;
                }

                st.add(board[row][col]);
            }
        }

        // Validate columns
        for (int col = 0; col < 9; col++) {

            Set<Character> st = new HashSet<>();

            for (int row = 0; row < 9; row++) {

                if (board[row][col] == '.') {
                    continue;
                }

                if (st.contains(board[row][col])) {
                    return false;
                }

                st.add(board[row][col]);
            }
        }

        // Validate 3x3 boxes

        // sr represents starting row of each 3x3 box
        // We increment by 3 because every box has 3 rows
        for (int sr = 0; sr < 9; sr += 3) {

            int er = sr + 2;


            // sc represents starting column of each 3x3 box
            // We increment by 3 because every box has 3 columns
            for (int sc = 0; sc < 9; sc += 3) {

                int ec = sc + 2;

                // Call our valid() function to check this 3x3 box
                // If even one box is invalid, the entire Sudoku is invalid
                if (!valid(board, sr, er, sc, ec)) {
                    return false;
                }
            }
        }

        return true;
    }
}

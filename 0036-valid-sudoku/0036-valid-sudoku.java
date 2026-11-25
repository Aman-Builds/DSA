class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String>st = new HashSet<>() ;
        for(int i = 0 ; i < 9 ; i++)
        {
            for(int j = 0 ; j <9 ; j++)
            {
                if(board[i][j] == '.')
                continue ;
            
            char num = board[i][j] ;
            
            //Create a unique key for the current number in its row
            String row = num + "_row_" + i ;

            //Create a unique key for the current number in its column
            String column = num + "_col_" + j ;


            // Create a unique key for the current number in its 3x3 box
            String box = num + "_box_" + (i/3) + "_" + (j/3) ;

            // If any key already exists, we have a duplicate
                if (st.contains(row) ||
                    st.contains(column) ||
                    st.contains(box)) {

                    return false;
                }

                // Store all three keys in the HashSet
                st.add(row);
                st.add(column);
                st.add(box);

            }

        }
         return true ;
    }
    /*
    class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {

        bool row[9][9] = {0};
        bool col[9][9] = {0};
        bool box[9][9] = {0};

        for(int i = 0; i < 9; i++) {

            for(int j = 0; j < 9; j++) {

                if(board[i][j] == '.')
                    continue;

                int digit = board[i][j] - '0' - 1;

                int boxIndex = (i/3)*3 + (j/3);

                if(row[i][digit] || col[j][digit] || box[boxIndex][digit])
                    return false;

                row[i][digit] = true;
                col[j][digit] = true;
                box[boxIndex][digit] = true;
            }
        }

        return true;
    }
};
    */
};

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

            String row = num + "_row_" + i ;
            String column = num + "_col_" + j ;
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

}
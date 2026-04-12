package recursion.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution s =new Solution();
        List<List<String>> op=s.solveNQueens(4);
        for(List<String> curr:op){
            for(String cs:curr){
                System.out.println(cs);
            }
            System.out.println();
        }
    }
}


final class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        // board to build solution
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        dfs(0, 0, 0, 0, n, board, result);
        return result;
    }

    /*
     * row       → current row
     * cols      → columns occupied
     * diag      → main diagonal (\)
     * antiDiag  → anti-diagonal (/)
     */
    private void dfs(int row, int cols, int diag, int antiDiag,
                     int n, char[][] board, List<List<String>> result) {

        // ✅ base case: all queens placed
        if (row == n) {
            result.add(construct(board));
            return;
        }

        // 🔥 get all available positions
        int available = ~(cols | diag | antiDiag) & ((1 << n) - 1);

        while (available != 0) {

            // 🧠 pick rightmost available position
            int pos = available & (-available);

            // remove that position
            available = available & (available - 1);

            // 🧠 get column index from bit
            int col = Integer.numberOfTrailingZeros(pos);

            // place queen
            board[row][col] = 'Q';

            // recurse with updated masks
            dfs(
                    row + 1,
                    cols | pos,
                    (diag | pos) << 1,
                    (antiDiag | pos) >> 1,
                    n,
                    board,
                    result
            );

            // backtrack
            board[row][col] = '.';
        }
    }

    // convert board to required format
    private List<String> construct(char[][] board) {
        List<String> curr = new ArrayList<>();
        for (char[] row : board) {
            curr.add(new String(row));
        }
        return curr;
    }
}

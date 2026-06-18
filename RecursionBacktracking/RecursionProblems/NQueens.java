package RecursionBacktracking.RecursionProblems;

import java.util.*;

public class NQueens {

    class Solution1 {

        List<List<String>> res;

        public List<String> construct(boolean[][] board, int n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            return ans;
        }

        public void dfs(int r, boolean[][] board, boolean[] viscol, boolean[] mainDiag, boolean[] antiDiag, int n) {
            if (r == n) {
                res.add(construct(board, n));
                return;
            }
            for (int c = 0; c < n; c++) {
                int ld = (c - r) + (n - 1), rd = c + r;
                if (!viscol[c] && !mainDiag[ld] && !antiDiag[rd]) {

                    viscol[c] = mainDiag[ld] = antiDiag[rd] = board[r][c] = true;
                    dfs(r + 1, board, viscol, mainDiag, antiDiag, n);
                    viscol[c] = mainDiag[ld] = antiDiag[rd] = board[r][c] = false;
                }

            }
        }

        public List<List<String>> solveNQueens(int n) {
            boolean[][] board = new boolean[n][n];
            res = new ArrayList<>();
            boolean[] viscol = new boolean[n];
            boolean[] mainDiag = new boolean[2 * n - 1];
            boolean[] antiDiag = new boolean[2 * n - 1];

            dfs(0, board, viscol, mainDiag, antiDiag, n);
            return res;

        }
    }

    class Solution2 {

        List<List<String>> res;

        public List<String> construct(boolean[][] board, int n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            return ans;
        }

        public void dfs(int r, boolean[][] board, boolean[] viscol, boolean[] mainDiag, boolean[] antiDiag, int n) {
            if (r == n) {
                res.add(construct(board, n));
                return;
            }
            for (int c = 0; c < n; c++) {
                int ld = (c - r) + (n - 1), rd = c + r;
                if (!viscol[c] && !mainDiag[ld] && !antiDiag[rd]) {

                    viscol[c] = mainDiag[ld] = antiDiag[rd] = board[r][c] = true;
                    dfs(r + 1, board, viscol, mainDiag, antiDiag, n);
                    viscol[c] = mainDiag[ld] = antiDiag[rd] = board[r][c] = false;
                }

            }
        }

        public List<List<String>> solveNQueens(int n) {
            boolean[][] board = new boolean[n][n];
            res = new ArrayList<>();
            boolean[] viscol = new boolean[n];
            boolean[] mainDiag = new boolean[2 * n - 1];
            boolean[] antiDiag = new boolean[2 * n - 1];

            dfs(0, board, viscol, mainDiag, antiDiag, n);
            return res;

        }
    }

    class Solution3 {

        public boolean checkKthBit(int num, int k) {
            int mask = 1 << k;
            return (num & mask) != 0;
        }

        public List<String> construct(boolean[][] board, int n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }

                }
                temp.add(sb.toString());
            }
            return temp;
        }

        public void solve(boolean[][] board, int row, int n, int viscol, int leftD, int rightD, List<List<String>> ans) {
            //
            if (row == n) {
                ans.add(construct(board, n));
                return;
            }

            for (int col = 0; col < n; col++) {
                int l = (col - row) + (n - 1);
                int r = (col + row);
                if (!checkKthBit(viscol, col) && !checkKthBit(leftD, l) && !checkKthBit(rightD, r)) {
                    viscol = viscol | (1 << col);
                    leftD = leftD | (1 << l);
                    rightD = rightD | (1 << r);
                    board[row][col] = true;
                    solve(board, row + 1, n, viscol, leftD, rightD, ans);
                    board[row][col] = false;
                    viscol = viscol & ~(1 << col);
                    leftD = leftD & ~(1 << l);
                    rightD = rightD & ~(1 << r);
                }
            }
        }

        public List<List<String>> solveNQueens(int n) {
            boolean[][] board = new boolean[n][n];
            List<List<String>> ans = new ArrayList<>();
            int viscol = 0, leftD = 0, rightD = 0;
            solve(board, 0, n, viscol, leftD, rightD, ans);
            return ans;
        }
    }
}

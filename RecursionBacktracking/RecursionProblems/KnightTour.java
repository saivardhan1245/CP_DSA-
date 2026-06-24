//package RecursionBacktracking.RecursionProblems;

public class KnightTour {

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ",\t");
            }
            System.out.println();
        }
    }

    public static void fillKnights(int r, int c, int[][] mat, int cs) {

        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] != 0) {
            return;
        }
        mat[r][c] = cs;
        if (cs == 25) {
            printBoard(mat);
            mat[r][c] = 0;
            return;
        }

        fillKnights(r - 2, c + 1, mat, cs + 1);
        fillKnights(r + 2, c + 1, mat, cs + 1);
        fillKnights(r - 2, c - 1, mat, cs + 1);
        fillKnights(r + 2, c - 1, mat, cs + 1);
        fillKnights(r - 1, c + 2, mat, cs + 1);
        fillKnights(r + 1, c + 2, mat, cs + 1);
        fillKnights(r - 1, c - 2, mat, cs + 1);
        fillKnights(r + 1, c - 2, mat, cs + 1);
        mat[r][c] = 0;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];

        int cs = 1, r = 0, c = 0;
        fillKnights(r, c, matrix, cs);
    }
}

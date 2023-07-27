import java.util.*;
public class n_queen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Board : ");

        int n = sc.nextInt();
        char[] arr = new char[n];
        Arrays.fill(arr, '.');
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) board[i] = arr;
        if (! solve(board, 0, n)) {
            System.out.println("Solution does not exist");
            return;
        }
        printQueen(board, n);
        
    }
    
    // solve the queen
    private static boolean solve(char[][] board, int col, int n) {
        if (col >= n) return true;
        for (int row = 0; row < n; row++) {
            if (isSafe(board, col, row, n)) {
                board[row][col] = 'Q';
                if (solve(board, col+1, n) == true) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    // check if the queen are in t
    private static boolean isSafe(char[][] board, int col, int row, int n) {
        int dupRow = row;
        int dupCol = col;

        //check upper diagonal on left side
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        // check left side of the curent row
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        col = dupCol;
        row = dupRow;
        // check lower diagonal on left side
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }

    private static void printQueen(char[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }
    }
}
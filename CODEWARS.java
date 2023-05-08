import java.util.ArrayList;
public class CODEWARS {
    public static void main(String[] args) {
        int result = 0;
        int[][] board = new int[3][3];
        board = new int[][]{{0, 0, 1}, {0, 1, 2}, {2, 1, 0}};
        result = isSolved(board);
        System.out.println(result);//-1
        /*int[][] board = new int[3][3];
        board = new int[][]{{1, 1, 1}, {0, 2, 2}, {0, 0, 0}};
        result = isSolved(board);
        System.out.println(result);//1*/
        /*int[][] board = new int[3][3];
        board = new int[][]{{1, 1, 2}, {0, 2, 0}, {2, 1, 1}};
        result = isSolved(board);
        System.out.println(result);//2*/
        /*int[][] board = new int[3][3];
        board = new int[][]{{1, 2, 1}, {1, 1, 2}, {2, 1, 2}};
        result = isSolved(board);
        System.out.println(result);//0*/
        /*[[0, 0, 1],
           [0, 1, 2],
           [2, 1, 0]]
         */
    }
    public static int isSolved(int[][] board) {
        int result = 0;
        boolean zeroFound = false;
        ArrayList<int[]> lines = new ArrayList<>();
        lines.add(new int[] { board[0][0], board[0][1], board[0][2]});//1 row
        lines.add(new int[] { board[1][0], board[1][1], board[1][2]});//2 row
        lines.add(new int[] { board[2][0], board[2][1], board[2][2]});//3 row
        lines.add(new int[] { board[0][0], board[1][0], board[2][0]});//1 column
        lines.add(new int[] { board[0][1], board[1][1], board[2][1]});//2 column
        lines.add(new int[] { board[0][2], board[1][2], board[2][2]});//3 column
        lines.add(new int[] { board[0][0], board[1][1], board[2][2]});//1 diagonal
        lines.add(new int[] { board[2][0], board[1][1], board[0][2]});//2 diagonal

        for (int[] line : lines) {
            boolean allOnes = true;
            boolean allTwos = true;
            boolean hasZero = false;
            for (int symbol : line) {
                if (symbol != 1) {
                    allOnes = false;
                } if (symbol != 2) {
                    allTwos = false;
                } if (symbol == 0) {
                    hasZero = true;
                }
            }
            if (allOnes) {
                return 1;
            } else if (allTwos) {
                return 2;
            } else if (hasZero) {
                zeroFound = true;
            }
        }
        return zeroFound ? -1 : 0;
    }
}
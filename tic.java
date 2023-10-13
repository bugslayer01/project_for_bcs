
/* help taken from :-
*stackoverflow in function win "i was not having trouble checking it dioganly ,
* i figgureg it out later but used code from stackover flow"
*/


import java.util.*;
public class ttt {
    static char[][] board = new char[3][3]; static char cp='X';

    public static void main(String[] args) 
    {
        initializ());
        print();

        boolean gw = false;

        while (!gw) {
            int[] move = move();
            int row = move[0];
            int col = move[1];

            if (movevalid(row, col)) {
                makemove(row, col);
                print();
                gw =checkWin(row, col);
                if (gw) {
                    System.out.println("Player "+cp + " wins!");
                } else if (full()) {
                    System.out.println("It's a draw!");
                    break;
                } else {
                    cp = (cp == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }

    private static void initializ() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void print() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("************");
            }
        }
    }

    private static int[] move() {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];

        System.out.print("Player " + cp + ", enter your move , first enter row and then add coloum");
        move[0] = scanner.nextInt();
        move[1] = scanner.nextInt();

        return move;
    }

    private static boolean movevalid(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }
        return board[row][col] == ' ';
    }

    private static void makemove(int row, int col) {
        board[row][col] = cp;
    }

    private static boolean win(int row, int col) {
        // Check row, column, and diagonals for a win manually and there is some error in it 
        //return (board[row][0] == cp && board[row][1] == cp && board[row][2] == cp)
          //      || (board[0][col] == cp && board[0][col] == cp && board[2][col] == cp)
            //    || (row == col && board[0][0] == cp && board[1][1] == cp && board[2][2] == cp)
            //    || (row + col == 2 && board[0][2] == cp && board[1][1] == cp && board[2][0] == cp);

// code from stackoverflow and w3 schools a.k.a  not my code
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == cp && board[i][1] == cp && board[i][2] == cp) {
                return true;
            }
            if (board[0][i] == cp && board[1][i] == cp && board[2][i] == cp) {
                return true;    }

    private static boolean full() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

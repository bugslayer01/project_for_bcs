//PLEASE READ
/* help taken from :-
*1)stackoverflow in function win "i was  having trouble checking  'win' it dioganly ,
* i figgureg it out later but used code from stackoverflow"
* 2)w3 school, way to return a array fron function
* 
*this game was build using 1d array  2D array and function
*
*i tried my best to keep code as clean as possible if u have truble in reading my code 
*please ask me about its working
*
*
*\\\\\\\\\\\\ beautification of code done using https://techiedelight.com/tools/java \\\\\\\\\\
*/ 

// sometimes there is missallignment in "|" seprating each line so jplease bear with it
import java.util.*;
public class ttt {
    static char[][] board = new char[3][3]; static char cp='X';

    public static void main(String[] args) 
    {
        initializ();
        print();

        boolean gw = false;

        while (!gw) {
            int[] move = move();
            int r = move[0];
            int c = move[1];

            if (movevalid(r,c)) {
                 makemove(r,c);
                print();
                 gw =win(r,c);
                if (gw) {
                    System.out.println("Player "+cp +" wins");
                } else if (full()) {
                     System.out.println("draw");
                    break;
                } else {
                    cp = (cp=='X')?'O':'X';// just to switch turns
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    static void initializ() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                 board[i][j] = ' ';
            }
        }
    }

    static void print() {
        System.out.println("  0    1    2");
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

    static int[] move() {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];

        System.out.print("Player " + cp + ", enter your move , first enter r and then add coum");
         move[0] = scanner.nextInt();
        move[1] = scanner.nextInt();

    return move;
    }

    static boolean movevalid(int r, int c) {
        if (r < 0 || r >= 3 || c < 0 || c >= 3) {
            return false;
        }
        return board[r][c] == ' ';
    }

    static void makemove(int r, int c) {
        board[r][c] = cp;
    }

    static boolean win(int r, int c) { 
    
    //\\\\\\\\\\\\\\\\\\\MY CODE HAVE SOME ERROR\\\\\\\\\\\\\\\\\\\\\\\\\\
        // Check r,, and diagonals for a win manually and there is some error in it 
        //return (board[r][0] == cp && board[r][1] == cp && board[r][2] == cp)
          //      || (board[0][c] == cp && board[0][c] == cp && board[2][c] == cp)
            //    || (r == c && board[0][0] == cp && board[1][1] == cp && board[2][2] == cp)
            //    || (r + c == 2 && board[0][2] == cp && board[1][1] == cp && board[2][0] == cp);

               //  below code from stackoverflow and w3 schools a.k.a  not my code
         // Check the current row
      if (board[r][0] == cp && board[r][1] == cp && board[r][2] == cp) {
        return true;
     }

      // Check the current column
       if (board[0][c] == cp && board[1][c] == cp && board[2][c] == cp) {
        return true;
       }

       // Check the main diagonal 
       if (r == c && board[0][0] == cp && board[1][1] == cp && board[2][2] == cp) {
        return true;
         }

        // Check the secondary diagonal (top-right to bottom-left)
      if (r + c == 2 && board[0][2] == cp && board[1][1] == cp && board[2][0] == cp) {
        return true;
     }
    
     // If none of the above conditions are met, there's no win yet.
     return false;
    }
    static boolean full() {
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

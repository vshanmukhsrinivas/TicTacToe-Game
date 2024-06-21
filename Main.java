import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        char[][] board = {{' ',' ',' '},
                          {' ',' ',' '},
                          {' ',' ',' '}};
        printBoard(board);

        while (true) {
            playerTurn(board, sc);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);

            computerTurn(board);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);
        }
        sc.close();
    }

    private static boolean isGameFinished(char[][] board) {

        if (hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println("You Won!");
            return true;
        }

        if (hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.println("Computer Won!");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }
    private static boolean hasContestantWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
                (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
                (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||

                (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
                (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
                (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||

                (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
                (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
            return true;
        }
        return false;
    }

    private static boolean isValidMove(char[][] board,int position)
    {
        switch(position)
        {
            case 1:
                return board[0][0]==' ';
            case 2:
                return board[0][1]==' ';
            case 3:
                return board[0][2]==' ';
            case 4:
                return board[1][0]==' ';
            case 5:
                return board[1][1]==' ';
            case 6:
                return board[1][2]==' ';
            case 7:
                return board[2][0]==' ';
            case 8:
                return board[2][1]==' ';
            case 9:
                return board[2][2]==' ';
            default:
                System.out.println("Enter a valid move :(");
                return false;
        }
    }
    private static void computerTurn(char[][] board) {
        Random rand= new Random();
        int computerChoice;
        while(true)
        {
            computerChoice=rand.nextInt(9)+1;
            if(isValidMove(board,computerChoice))
            {
                break;
            }
        }
        System.out.println("Computer choose " + computerChoice);
        placeMove(board,computerChoice,'O');
    }

    private static void playerTurn(char[][] board, Scanner sc)
    {
        int playerChoice;
        while(true)
        {
            System.out.println("Please choose a place to play from 1-9");
            playerChoice= sc.nextInt();
            if(isValidMove(board,playerChoice))
            {
                break;
            }
            else
            {
                System.out.println(playerChoice + "is not a valid move");
            }


        }


        placeMove(board, playerChoice,'X');
    }

    private static void placeMove(char[][] board, int choice,char symbol) {
        switch(choice)
        {
            case 1:
                board[0][0]=symbol;
                break;
             case 2:
                board[0][1]=symbol;
                break;
             case 3:
                board[0][2]=symbol;
                break;
             case 4:
                board[1][0]=symbol;
                break;
             case 5:
                board[1][1]=symbol;
                break;
             case 6:
                board[1][2]=symbol;
                break;
             case 7:
                board[2][0]=symbol;
                break;
             case 8:
                board[2][1]=symbol;
                break;
             case 9:
                board[2][2]=symbol;
                break;
            default:
                System.out.println("Enter a valid number from 1-9");

        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("-+-+-+-+-");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("-+-+-+-+-");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
}
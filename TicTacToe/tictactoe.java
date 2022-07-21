/** Created by Samiyanur Islam on 09/26/2020
 * Program description: Tic Tac Toe Game
 * All rights reserved to Samiyanur Islam
*/
import java.util.Scanner;
public class tictactoe
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ',' ',' '}};
        gameBoard(board);
        while (true)
        {
            player1Turn(board, scanner);
            if (checkIfGamesOver(board) )
            {
                break;
            }
            player2Turn(board, scanner);
            if (checkIfGamesOver(board) )
            {
                break;
            }
            gameBoard(board);
        }
        scanner.close();
    }
    public static void gameBoard( char[][] board)
    {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("- - -");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("- - -");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
    public static void move( char[][] board, String position, char symbol)
    {
        switch (position) {
            case "1" -> board[0][0] = symbol;
            case "2" -> board[0][1] = symbol;
            case "3" -> board[0][2] = symbol;
            case "4" -> board[1][0] = symbol;
            case "5" -> board[1][1] = symbol;
            case "6" -> board[1][2] = symbol;
            case "7" -> board[2][0] = symbol;
            case "8" -> board[2][1] = symbol;
            case "9" -> board[2][2] = symbol;
            default -> System.out.println(":(");
        }
    }
    private static void player1Turn(char[][] board, Scanner scanner) {
        String userInput;
        while (true) {
            System.out.println("Player 1 enter where you like to place your symbol? (1-9)");
            userInput = scanner.nextLine();
            if (invalidMove(board, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        move(board, userInput, 'X');
    }
    private static void player2Turn(char[][] board, Scanner scanner) {
        String userInput2;
        while (true) {
            System.out.println("Player 2 enter where you like to place your symbol? (1-9)");
            userInput2 = scanner.nextLine();
            if (invalidMove(board, userInput2)) {
                break;
            } else {
                System.out.println(userInput2 + " is not a valid move.");
            }
        }
        move(board, userInput2, 'O');
    }
    private static boolean checkIfGamesOver(char[][] board)
    {
        if (checkWinning(board, 'X'))
        {
            gameBoard(board);
            System.out.println("Congrats to Player 1!! Player 2 better luck next time.");
            return true;
        }
        if (checkWinning(board, 'O'))
        {
            gameBoard(board);
            System.out.println("Congrats to Player 2!! Player 1 better luck next time.");
            return true;
        }
        for (char[] lol : board)
        {
            for (char lmao : lol) {
                if (lmao == ' ') {
                    return false;
                }
            }
        }
        gameBoard(board);
        System.out.println("Issa Tie lol!");
        return true;
    }
    private static boolean invalidMove(char[][] board, String placement) {
        return switch (placement) {
            case "1" -> (board[0][0] == ' ');
            case "2" -> (board[0][1] == ' ');
            case "3" -> (board[0][2] == ' ');
            case "4" -> (board[1][0] == ' ');
            case "5" -> (board[1][1] == ' ');
            case "6" -> (board[1][2] == ' ');
            case "7" -> (board[2][0] == ' ');
            case "8" -> (board[2][1] == ' ');
            case "9" -> (board[2][2] == ' ');
            default -> false; };
    }
    private static boolean checkWinning(char[][] board, char symbol)
    {
        return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }
}
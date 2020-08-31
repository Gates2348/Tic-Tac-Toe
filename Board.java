import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.math.*;

public class Board {
    static boolean endGame;

    static String[][] board = {
            {" ", "|", " ", "|", " "},
            {"-", "+", "-", "+", "-"},
            {" ", "|", " ", "|", " "},
            {"-", "+", "-", "+", "-"},
            {" ", "|", " ", "|", " "}
    };

    static String[][] sample = {
            {"1", "|", "2", "|", "3"}, // 0 2 4
            {"-", "+", "-", "+", "-"}, // SKIP
            {"4", "|", "5", "|", "6"}, //10 12 14
            {"-", "+", "-", "+", "-"}, // SKIP
            {"7", "|", "8", "|", "9"}  // 21 23 24
    };


    public static void main(String[] args) {
        Board TicBoard = new Board();

        TicBoard.welcome();
        do{
            TicBoard.playGame();
            System.out.println();
            System.out.println("CPU selected");
            TicBoard.cpuTurn();
            System.out.println();
            TicBoard.winner();
        }while(!endGame);


    }

    public void printboard() {
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }
    public void printSample(){
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 5;j++){
                System.out.print(sample[i][j]);
            }
            System.out.println();

        }
    }
    public void welcome() {
        System.out.println("Welcome to tic-tac-toe a classic strategy game.");
        System.out.println("The board will be setup as follows: ");
        /// Add sample Board
        printSample();
        System.out.println();
        System.out.println();


    }
    public void playGame() {
        String position = "Please enter a number between 1-9 that hasn't been taken by your opponent: ";
        System.out.println(position);
        Scanner scan = new Scanner(System.in);
        String placement = scan.next();

        if (Integer.parseInt(placement) < 1 || Integer.parseInt(placement) > 9) {
            System.out.println("Not a valid entry.....");
            playGame();
        } else {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (sample[i][j].contains(placement)) {
                        if (board[i][j] == "O") {
                            playGame();
                        } else {
                            board[i][j] = "X";
                        }
                    }
                }
            }
        }
    }
    public void cpuTurn(){
        Random rand = new Random();
        int max = 9;
        int min = 1;
        int x = rand.nextInt(max);
        while(x > max || x < min){
            x = rand.nextInt(max);
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (sample[i][j].contains(Integer.toString(x)) && board[i][j] != "X") {
                        board[i][j] = "O";
                    }
                }
            }
        printboard();
        }
    public void winner(){
        if(board[0][0] == "X" && board[2][0] == "X" && board[4][0] == "X" //Across Row 0
                || board[0][2] == "X" && board[2][2] == "X" && board[2][4] == "X" //Across Row 2
                || board[4][0] == "X" && board[4][2] == "X" && board[4][4] == "X" // Across Row 4
                || board[0][0] == "X" && board[0][2] == "X" && board[0][4] == "X" // Down Column 0
                || board[2][0] == "X" && board[2][2] == "X" && board[2][4] == "X" // Down Column 2
                || board[0][4] == "X" && board[2][4] == "X" && board[4][4] == "X" // Down Column 4
                || board[0][0] == "X" && board[2][2] == "X" && board[4][4] == "X" // Diagonal top left bottom right
                || board[4][4] == "X" && board[2][2] == "X" && board[0][0] == "X") // Diagonal top Right to bottom left
        {
            System.out.println("Your are the winner!!");
            endGame = true;
        }else if(board[0][0] == "O" && board[2][0] == "O" && board[4][0] == "O" //Across Row 0
                || board[0][2] == "O" && board[2][2] == "O" && board[2][4] == "O" //Across Row 2
                || board[4][0] == "O" && board[4][2] == "O" && board[4][4] == "O" // Across Row 4
                || board[0][0] == "O" && board[0][2] == "O" && board[0][4] == "O" // Down Column 0
                || board[2][0] == "O" && board[2][2] == "O" && board[2][4] == "O" // Down Column 2
                || board[4][0] == "O" && board[4][2] == "O" && board[4][4] == "O" // Down Column 4
                || board[0][0] == "O" && board[2][2] == "O" && board[4][4] == "O" // Diagonal top left bottom right
                || board[4][4] == "O" && board[2][2] == "O" && board[0][0] == "O")
        {
            System.out.println("You have lost the game!!");
            endGame = true;
        }
    }






}

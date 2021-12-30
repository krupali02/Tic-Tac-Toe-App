package eecs1022.lab8.tictactoe.model;

import android.telephony.mbms.StreamingServiceInfo;

public class Game {

    // p1 EQUALS X
    // p2 EQUALS O

    private String p1;
    private String p2;
    private int count;

    private char [][] board = {{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};

    private boolean error = false;
    private  boolean winner = false;
    private  boolean tieBool = false;
    private  String status;
    private  String win;
    private  String tieStatement;
    private  char stat;

    // initial input names from the players
    public Game (String p1, String p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
//
//    public Game() {
//
//    }

    public String getCurrentPlayer() {
        // when the 'tie' method is true, return null
        if (tie() == true) {
            return null;
        }

        // if a winner does not exist, continue the game by returning the respective players
       else if (winner == false) {
         if (count%2 == 0) {
            return p1;
        } else
            return p2;}

       // in the case of a winner, return null
        return null; 
    }

    // STATUS STATEMENT that will be returned
    public String getStatus() {
        // if error statement does exist, return the error statement
        if (error == true) {
            error = false; // reassign the error boolean variable to be false, so that the if statement is only
            // satisfied when another error occurs
            return status;
        }

        // if winner does exist, return the statement that declares the winner
        else if (winner == true) {
            return win;
        }

        // if tie does exist, return the statement that declares the tie between the two players
        else if (tieBool == true) {
            return tieStatement;
        }

        // no error, winner or tie, return the name of the player who is playing (continue playing the game)
        else {
        return getCurrentPlayer() + "'s turn to play...";
        }
    }

    // return the game board
    public char[][] getBoard() {
        return board;
    }

    public String gameBoard() {
    String boardShow = "";
        for (int i = 0; i < 3; i++) {
            boardShow += "\n";
            for (int j = 0; j < 3; j++) {
                boardShow +=  board[i][j] + " ";
            }
        }
        return boardShow;
    }

    public void setWhoPlaysFirst(char stat) {
        this.stat = stat;
        // due to the counter, if the input is an 'x', then the counter will declare an even number
        if (stat == 'x') {
            count = 2;
        }

        // else if the input is an 'o', the counter will declare an odd number
        else if(stat == 'o'){
            count = 1;
        }
    }

    public void move(int row, int col) {

        // ERROR STATEMENTS
        if (winner == true) {
            error = true;
            status = "Error: game is already over with a winner.";
        }

        else if (tie() == true) {
            error = true;
            status = "Error: game is already over with a tie.";
        }
        else if (!(1<=row && row<=3)) {
            error = true;
            status = "Error: row "+row+" is invalid.";
        }

        else if (!(1<=col && col<=3)) {
            error = true;
            status = "Error: col " + col + " is invalid.";
        }

        else if (board[row-1][col-1] != '_') {
            error = true;
            status = "Error: slot @ (" + row + ", " + col + ") is already occupied.";
        }

        // UPDATING THE GAME BOARD
        else if (count%2 == 0) {
            board[row-1][col-1] = 'x';
            count ++;
        }

        else if (count%2 == 1) {
            board[row-1][col-1] = 'o';
            count ++;
        }

        // DECLARING THE WINNER FOR PLAYER X
        //diagonal from left to right
        if (board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x') {
            winner = true;
            win = "Game is over with "+ p1 +" being the winner.";
        }
        //top row horizontal
        else if (board[0][0] == 'x' && board[0][1] == 'x' && board[0][2] == 'x') {
            winner = true;
            win = "Game is over with "+ p1 +" being the winner.";
        }
        // middle row horizontal
        else if (board[1][0] == 'x' && board[1][1] == 'x' && board[1][2] == 'x') {
            winner = true;
            win = "Game is over with "+ p1 +" being the winner.";
        }
        // bottom row horizontal
        else if (board[2][0] == 'x' && board[2][1] == 'x' && board[2][2] == 'x') {
            winner = true;
            win = "Game is over with "+ p1 +" being the winner.";
        }
        // left col vertical
        else if (board[0][0] == 'x' && board[1][0] == 'x' && board[2][0] == 'x') {
            winner = true;
            win = "Game is over with "+ p1 +" being the winner.";
        }
        // middle col vertical
        else if (board[0][1] == 'x' && board[1][1] == 'x' && board[2][1] == 'x') {
            winner = true;
            win = "Game is over with "+ p1 +" being the winner.";
        }
        // right col vertical
        else if (board[0][2] == 'x' && board[1][2] == 'x' && board[2][2] == 'x') {
            winner = true;
            win = "Game is over with "+ p1 +" being the winner.";
        }
        // diagonal from right to left
        else if (board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x') {
            winner = true;
            win = "Game is over with "+ p1 +" being the winner.";
        }

        // DECLARING THE WINNER FOR PLAYER O
        else if (board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o') {
            winner = true;
            win = "Game is over with "+ p2 +" being the winner.";
        }
        else if (board[0][0] == 'o' && board[0][1] == 'o' && board[0][2] == 'o') {
            winner = true;
            win = "Game is over with "+ p2 +" being the winner.";
        }

        else if (board[1][0] == 'o' && board[1][1] == 'o' && board[1][2] == 'o') {
            winner = true;
            win = "Game is over with "+ p2 +" being the winner.";
        }

        else if (board[2][0] == 'o' && board[2][1] == 'o' && board[2][2] == 'o') {
            winner = true;
            win = "Game is over with "+ p2 +" being the winner.";
        }

        else if (board[0][0] == 'o' && board[1][0] == 'o' && board[2][0] == 'o') {
            winner = true;
            win = "Game is over with "+ p2 +" being the winner.";
        }

        else if (board[0][1] == 'o' && board[1][1] == 'o' && board[2][1] == 'o') {
            winner = true;
            win = "Game is over with "+ p2 +" being the winner.";
        }

        else if (board[0][2] == 'o' && board[1][2] == 'o' && board[2][2] == 'o') {
            winner = true;
            win = "Game is over with "+ p2 +" being the winner.";
        }

        else if (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o') {
            winner = true;
            win = "Game is over with "+ p2 +" being the winner.";
        }

        // DECLARING TIE
        else if (tie() == true) { // tie DOES exist
            tieBool = true;
            tieStatement = "Game is over with a tie between "+p1+" and "+p2+".";
        }
    }

    // tie method returns whether a tie exists or not
    public boolean tie () {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    // if every element in the 2D array is '_', this indicated that there are empty spots in the array
                    // that can potentially be filled by the players
                    // the nested for-loop helps check every element in the 2D array
                   return false;
                }
            }
        }
        // tie does exist because the if-condition was not satisfied, thus returning true
       return true;
    }
}

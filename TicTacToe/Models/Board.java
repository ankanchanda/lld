package lld.TicTacToe.Models;

public class Board {
    
    private int size;
    PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board =  new PlayingPiece[size][size];
    }

    public boolean isPositionValid(int row, int column){
        if(board[row][column] != null) return false;
        return true;
    }

    public void blockCell(int row, int column, Player player){
        board[row][column] = player.getPlayingPiece();
    }

    public void printBoard(){
        for (int i = 0; i < size; i++) {
            System.out.println(" ----------------------");
            System.out.print(" | ");
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                   System.out.print(board[i][j].getPieceType().name() + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println(" ----------------------");
    }

    public boolean areFreeCellsAvailable(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] == null) return true;
            }
        }
        return false;
    }

    public boolean isAnyRowCompletelyFilledWithGivenPlayingPiece(PlayingPiece playingPiece){
        for(int i=0; i<size; i++){
            boolean isRowMatchingWithPlayingPiece = true;
            for(int j=0; j<size; j++){
                if(board[i][j] != playingPiece){
                    isRowMatchingWithPlayingPiece = false;
                    break;
                }
            }
            if(isRowMatchingWithPlayingPiece) return true;
        }

        return false;
    }

    public boolean isAnyColumnCompletelyFilledWithGivenPlayingPiece(PlayingPiece playingPiece){

        for(int i=0; i<size; i++){
            boolean isColumnMatchingWithPlayingPiece = true;
            for(int j=0; j<size; j++){
                if(board[j][i] != playingPiece){
                    isColumnMatchingWithPlayingPiece = false;
                    break;
                }
            }
            if(isColumnMatchingWithPlayingPiece) return true;
        }

        return false;
    }

    public boolean isAnyDiagonalCompletelyFilledWithGivenPlayingPiece(PlayingPiece piece){
        boolean diagonalCompletelyFilled = true;
        boolean antiDiagonalCompletelyFilled = true;
        for(int i=0; i<size; i++){
            if(board[i][i] != piece){
                diagonalCompletelyFilled = false;
            }
            if(board[i][size - i - 1] != piece){
                antiDiagonalCompletelyFilled = false;
            }
        }

        return diagonalCompletelyFilled | antiDiagonalCompletelyFilled;
    }
}

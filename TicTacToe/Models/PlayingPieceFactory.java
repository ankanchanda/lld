package lld.TicTacToe.Models;

public class PlayingPieceFactory {
    
    public static PlayingPiece getPlayingPiece(String pieceType){
        if(pieceType.equals("X")){
            return new PlayingPieceX();
        }
        else if(pieceType.equals("O")){
            return new PlayingPieceO();
        }
        return null;
    }
}

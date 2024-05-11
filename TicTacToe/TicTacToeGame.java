package lld.TicTacToe;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import lld.TicTacToe.Models.Board;
import lld.TicTacToe.Models.PieceType;
import lld.TicTacToe.Models.Player;
import lld.TicTacToe.Models.PlayingPiece;
import lld.TicTacToe.Models.PlayingPieceFactory;
import lld.TicTacToe.Models.PlayingPieceO;
import lld.TicTacToe.Models.PlayingPieceX;

public class TicTacToeGame {
    
    Queue<Player> players;
    Board board;
    Scanner scanner;

    TicTacToeGame(){
        initializeGame();
    }

    private void initializeGame(){
        players = new LinkedList<>();
        scanner = new Scanner(System.in);
        Set<PieceType> pieceTypes = new HashSet<>(Arrays.asList(PieceType.values()));
        System.out.println("Enter number of players");
        int numPlayers = scanner.nextInt();
        while(numPlayers < 2 || numPlayers > pieceTypes.size()){
            System.out.println("Number of players must be greater than 1 and less than " + (pieceTypes.size() + 1) + ". Try again..");
            numPlayers = scanner.nextInt();
        }

        System.out.println("Enter board size");
        int boardSize = scanner.nextInt();
        while (boardSize < 3) {
            System.out.println("board size must be greater than 3");
            boardSize = scanner.nextInt();
        }

        board = new Board(boardSize);
        scanner.nextLine();
        
        for(int i=1; i<=numPlayers; i++){
            
            System.out.println("Enter name of player " + i);
            String playerName = scanner.nextLine();
            while(true){
                if(pieceTypes.size() == 1){
                    for(PieceType pieceType: pieceTypes){
                        PlayingPiece playingPiece = PlayingPieceFactory.getPlayingPiece(pieceType.name());
                        players.offer(new Player(playerName, playingPiece));
                    }
                    break;
                }
                System.out.println("Enter a piece from " + pieceTypes.toString() + " for " + playerName);
                String pieceType = scanner.nextLine();
                PlayingPiece playingPiece = PlayingPieceFactory.getPlayingPiece(pieceType);
                if(playingPiece != null){
                    players.offer(new Player(playerName, playingPiece));
                    pieceTypes.remove(PieceType.valueOf(pieceType));
                    break;
                }
                else{
                    System.out.println("Invalid symbol. Try again.");
                }
            }
        }
        board.printBoard();
    }

    public String startGame(){
        while(true){
            if(!board.areFreeCellsAvailable()){
                break;
            }
            Player currPlayer = players.poll();
            System.out.println("Turn for " + currPlayer.getName());
            while(true){
                System.out.println("Choose cell position(row,column) separated by comma");
                String position = scanner.nextLine();
                String[] cellPosition = position.split(",");
                try{
                    int row = Integer.parseInt(cellPosition[0]);
                    int column = Integer.parseInt(cellPosition[1]);
                    if(board.isPositionValid(row, column)){
                        board.blockCell(row, column, currPlayer);
                        break;
                    }
                    else{
                        System.out.println("position is already filled, please choose a different cell");
                    }
                }
                catch(Exception exception){
                    System.out.println("illegal cell position, choose a correct cell");
                }
            }
            board.printBoard();
            boolean isWinner = isThereWinner(currPlayer.getPlayingPiece());
            if(isWinner){
                return currPlayer.getName() + " is the winner of the game.";
            }
            players.offer(currPlayer);
        }
        return "It's a draw";
    }


    private boolean isThereWinner(PlayingPiece playingPiece){
        boolean rowWiseWinner = board.isAnyRowCompletelyFilledWithGivenPlayingPiece(playingPiece);
        boolean columnWiseWinner = board.isAnyColumnCompletelyFilledWithGivenPlayingPiece(playingPiece);
        boolean diagonlWiseWinner = board.isAnyDiagonalCompletelyFilledWithGivenPlayingPiece(playingPiece);

        return rowWiseWinner || columnWiseWinner || diagonlWiseWinner;
    }
}

package lld.TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        String result = ticTacToeGame.startGame();
        System.out.println(result);
    }
}

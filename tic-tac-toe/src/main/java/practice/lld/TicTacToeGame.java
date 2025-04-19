package practice.lld;

import practice.lld.states.DrawState;
import practice.lld.states.GameOverState;

public class TicTacToeGame implements Game {
    private final Board board;
    private final Player xPlayer;
    private final Player oPlayer;
    Player currentPlayer;

    public TicTacToeGame(String xPlayerName, String oPlayerName,HumanPlayerStrategy xplayerStrategy, HumanPlayerStrategy oplayerStrategy,PlayerFactory playerFactory,int rows,int cols) {
       xPlayer = playerFactory.createPlayer(Symbol.X,xplayerStrategy,xPlayerName);
       oPlayer = playerFactory.createPlayer(Symbol.O,oplayerStrategy,oPlayerName);
       board =new Board(rows,cols);
       currentPlayer = xPlayer;
    }

    @Override
    public void play() {
        GameContext context = new GameContext();
       do {
           Position position = currentPlayer.getStrategy().makeMove(board);
           board.makeMove(position,currentPlayer.getSymbol());
           board.checkGameState(context);
           currentPlayer = currentPlayer == xPlayer ? oPlayer : xPlayer;

       } while(!(context.getCurrentState() instanceof GameOverState) && !(context.getCurrentState() instanceof DrawState));
    }
}

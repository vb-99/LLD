package practice.lld;

import practice.lld.pieces.ChessPiece;
import practice.lld.pieces.ChessPieceColor;
import practice.lld.pieces.King;

import java.util.ArrayList;

public class ChessGame implements Game {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private boolean isWhitePlayerTurn;
    private ArrayList<Move> movesLog;
    private GameState gameState;

    public ChessGame(int boardSize) {
        this.board =Board.getInstance(boardSize);
        this.whitePlayer = new Player("Player1",ChessPieceColor.WHITE,new HumanPlayerStrategy());
        this.blackPlayer = new Player("Player2",ChessPieceColor.BLACK,new HumanPlayerStrategy());
        this.isWhitePlayerTurn =true;
        this.movesLog = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
    }

    @Override
    public void start() {
        while(gameState == GameState.IN_PROGRESS) {
            if(isWhitePlayerTurn) {
               makeMove(whitePlayer.getPlayerStrategy().getMove(board));
            } else{
                makeMove(blackPlayer.getPlayerStrategy().getMove(board));
            }
        }
    }

    public void makeMove(Move move) {
        if(move.isMoveValid()){
            ChessPiece sourcePiece = move.getStart().getPiece();
            if(sourcePiece.canMove(board,move.getStart(),move.getEnd())){
                ChessPiece destinationPiece = move.getEnd().getPiece();
                if(destinationPiece != null) {
                    if (destinationPiece instanceof King) {
                        if (isWhitePlayerTurn) {
                            gameState = GameState.WHITE_WON;
                        } else {
                            gameState = GameState.BLACK_WON;
                        }

                    }
                    destinationPiece.setIsKilled(true);
                    return;
                }
                move.getEnd().setPiece(sourcePiece);
                move.getStart().setPiece(null);
                movesLog.add(move);
                isWhitePlayerTurn = !isWhitePlayerTurn;


            }
        }
    }
}

package practice.lld.pieces;

import practice.lld.Board;
import practice.lld.Cell;
import practice.lld.pieces.strategies.MovementStrategy;

public abstract class ChessPiece {
    private ChessPieceColor chessPieceColor;
    private boolean isKilled;
    private MovementStrategy movementStrategy;

    public ChessPiece(ChessPieceColor chessPieceColor,MovementStrategy movementStrategy) {
        this.chessPieceColor = chessPieceColor;
        this.isKilled = false;
        this.movementStrategy = movementStrategy;
    }
    public ChessPieceColor getChessPieceColor() {
        return chessPieceColor;
    }
    public boolean getIsKilled() {
        return isKilled;
    }
    public void setIsKilled(boolean isKilled) {
        this.isKilled = isKilled;
    }

    public boolean canMove(Board board, Cell source, Cell destination) {
        return movementStrategy.canMove(board, source, destination);
    }
}

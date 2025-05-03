package practice.lld.pieces;

import practice.lld.pieces.strategies.QueenMovementStrategy;

public class Queen extends ChessPiece{
    public Queen(ChessPieceColor chessPieceColor) {
        super(chessPieceColor, new QueenMovementStrategy());
    }
}

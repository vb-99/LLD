package practice.lld.pieces;

import practice.lld.pieces.strategies.BishopMovementStrategy;

public class Bishop extends ChessPiece{
    public Bishop(ChessPieceColor chessPieceColor) {
        super(chessPieceColor,new BishopMovementStrategy());
    }
}

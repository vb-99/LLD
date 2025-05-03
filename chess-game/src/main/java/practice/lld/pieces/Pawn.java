package practice.lld.pieces;

import practice.lld.pieces.strategies.PawnMovementStrategy;

public class Pawn extends ChessPiece{
    public Pawn(ChessPieceColor chessPieceColor) {
        super(chessPieceColor,new PawnMovementStrategy());
    }
}

package practice.lld.pieces;

import practice.lld.pieces.strategies.KnightMovementStrategy;

public class Knight extends ChessPiece{

    public Knight(ChessPieceColor chessPieceColor) {
        super(chessPieceColor,new KnightMovementStrategy());
    }
}

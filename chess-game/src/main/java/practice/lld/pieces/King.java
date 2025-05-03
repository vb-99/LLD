package practice.lld.pieces;

import practice.lld.pieces.strategies.KingMovementStrategy;

public class King extends ChessPiece{
    public King(ChessPieceColor chessPieceColor) {
        super(chessPieceColor,new KingMovementStrategy());
    }
}

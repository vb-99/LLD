package practice.lld.pieces.strategies;

import practice.lld.Board;
import practice.lld.Cell;

public class RookMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        // logic for validating the move
        return true;
    }
}

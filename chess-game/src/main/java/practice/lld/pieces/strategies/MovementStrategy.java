package practice.lld.pieces.strategies;

import practice.lld.Board;
import practice.lld.Cell;

public interface MovementStrategy {
    public boolean canMove(Board board, Cell start, Cell end);
}

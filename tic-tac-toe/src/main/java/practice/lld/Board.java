package practice.lld;

import practice.lld.states.DrawState;
import practice.lld.states.OWonState;
import practice.lld.states.XWonState;

import java.util.ArrayList;

public class Board {
    private final int rows;
    private final int columns;
    private final ArrayList<ArrayList<Symbol>> board;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        board = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            board.add(new ArrayList<>());
            for (int column = 0; column < columns; column++) {
                board.get(row).add(Symbol.EMPTY);
            }
        }
    }

    public Boolean validate(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        return row >= 0 && row < rows && col >= 0 && col < columns && board.get(row).get(col) == Symbol.EMPTY;
    }

    public void makeMove(Position position,Symbol symbol) {
        int row = position.getRow();
        int col = position.getCol();
        board.get(row).set(col, symbol);
    }

    public boolean checkDrawState(){
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(board.get(i).get(j) == Symbol.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    public void checkGameState(GameContext context){
        if(checkDrawState()){
            context.setCurrentState(new DrawState());
        }
        for(int i=0;i<rows;i++){
            ArrayList<Symbol> row = board.get(i);
            if(isWinningLine(row)){
                context.setCurrentState(row.get(0) == Symbol.X ? new XWonState() : new OWonState());
            }
        }
        for(int i=0; i<columns; i++){
            ArrayList<Symbol> column = new ArrayList<>();
            for(int j=0; j<rows; j++){
              column.add(board.get(j).get(i));
            }
            if(isWinningLine(column)){
                context.setCurrentState(column.get(0) == Symbol.X ? new XWonState() : new OWonState());
            }
        }
        ArrayList<Symbol> diagonal1 = new ArrayList<>();
        for(int i=0;i<rows;i++){
           diagonal1.add(board.get(i).get(i));
        }
        if(isWinningLine(diagonal1)){
            context.setCurrentState(diagonal1.get(0) == Symbol.X ? new XWonState() : new OWonState());
        }

        ArrayList<Symbol> diagonal2 = new ArrayList<>();
        for(int i=0;i<rows;i++){
            diagonal2.add(board.get(i).get(rows-i-1));
        }
        if(isWinningLine(diagonal2)){
            context.setCurrentState(diagonal2.get(0) == Symbol.X ? new XWonState() : new OWonState());
        }
        context.next();


    }

    public boolean isWinningLine(ArrayList<Symbol> line){
        for(Symbol symbol : line){
            if(symbol == Symbol.EMPTY || symbol != line.get(0)){
                return false;
            }
        }
        return true;
    }

}

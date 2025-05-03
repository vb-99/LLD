package practice.lld;

import practice.lld.pieces.ChessPieceColor;
import practice.lld.pieces.PieceFactory;

import java.util.ArrayList;

public class Board {
    private static Board board;
    private ArrayList<ArrayList<Cell>> boardCells;
    private int size;

    private Board(int size) {
       initialiseBoard(size);
    }
    public static Board getInstance(int size) {
        if(board == null) {
            board = new Board(size);
        }
        return board;
    }
    private void initialiseBoard(int size){
       boardCells = new ArrayList<ArrayList<Cell>>(size);
        for (int i = 0; i < size; i++) {
            boardCells.add(new ArrayList<>(size));
        }
       setChessPieces(0,ChessPieceColor.BLACK);
       setPawns(1,ChessPieceColor.BLACK);

       setChessPieces(size-1,ChessPieceColor.WHITE);
       setPawns(size-2,ChessPieceColor.WHITE);

       for(int i = 2; i < size-2; i++){
           for(int j = 0; j < size; j++){
               boardCells.get(i).add(new Cell(i,j,null));
           }
       }

    }

    public Cell getCell(int row, int col){
        return boardCells.get(row).get(col);
    }

    private void setChessPieces(int row, ChessPieceColor chessPieceColor){
        boardCells.get(row).add(new Cell(row,0, PieceFactory.createChessPiece("rook", chessPieceColor)));
        boardCells.get(row).add(new Cell(row,1, PieceFactory.createChessPiece("knight", chessPieceColor)));
        boardCells.get(row).add(new Cell(row,2, PieceFactory.createChessPiece("bishop", chessPieceColor)));
        boardCells.get(row).add(new Cell(row,3, PieceFactory.createChessPiece("queen", chessPieceColor)));
        boardCells.get(row).add(new Cell(row,4, PieceFactory.createChessPiece("king", chessPieceColor)));
        boardCells.get(row).add(new Cell(row,5, PieceFactory.createChessPiece("bishop", chessPieceColor)));
        boardCells.get(row).add(new Cell(row,6, PieceFactory.createChessPiece("knight", chessPieceColor)));
        boardCells.get(row).add(new Cell(row,7, PieceFactory.createChessPiece("rook", chessPieceColor)));

    }

    private void setPawns(int row,  ChessPieceColor chessPieceColor){
       for(int i=0;i<=7;i++){
           boardCells.get(row).add(new Cell(row,i,PieceFactory.createChessPiece("pawn", chessPieceColor)));
       }
    }

}

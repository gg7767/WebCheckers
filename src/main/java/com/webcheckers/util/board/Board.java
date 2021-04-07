package com.webcheckers.util.board;

import java.util.ArrayList;
import java.util.Iterator;

public class Board {
    private ArrayList<Row> rows;
    
    private int rowNum = 8;
    
    public Board() {
        this.rows = new ArrayList<>();
        
        for (int i = 0; i < this.rowNum; i++){
            Row row = new Row(i);
            rows.add(row);
        }
    }
    
    public Board(Board board) {
        this.rows = board.getBoard();
        
        for (int i = 0;i < 4;i++) {
            Row temp = this.rows.get(i);
            
            this.rows.remove(i);
            this.rows.add(i, this.rows.get(this.rowNum - 2 - i));
            this.rows.remove(this.rowNum - 1 - i);
            this.rows.add(this.rowNum - 1 - i, temp);
        }
        
        for (int j = 0;j < 8;j++) {
            for (int k = 0;k < 4;k++) {
                Space temp = this.rows.get(j).getSpaces().get(k);
                
                this.rows.get(j).getSpaces().remove(k);
                this.rows.get(j).getSpaces().add(k, this.rows.get(j).getSpaces().get(this.rowNum - 2 - k));
                this.rows.get(j).getSpaces().remove(this.rowNum - 1 - k);
                this.rows.get(j).getSpaces().add(this.rowNum - 1 - k, temp);
            }
        }
    }

    /**
     * Gets the amount of rows in the board.
     *
     * @return The amount of rows in the board.
     */
    public int getRow(){
        return this.rowNum;
    }

    /**
     * Gets the list of rows in the board.
     *
     * @return The list of rows in the board.
     */
    public ArrayList<Row> getBoard() {
        return this.rows;
    }

    /**
     * Gets the iterator for the rows of the board.
     *
     * @return The iterator for the rows.
     */
    public Iterator<Row> iterator() {
        return this.rows.iterator();
    }
    
    public boolean makeMove(Move move) {
        int rowF = move.getStart().getRow();
        int colF = move.getStart().getCol();
        int rowT = move.getEnd().getRow();
        int colT = move.getEnd().getCol();
        
        Piece piece = this.rows.get(rowF).getSpaces().get(colF).getPiece();
        
        if (piece == null) {
            return false;
        }
        
        int x = rowT - rowF;
        int y = colT - colF;
        
        if (piece.getType() != Piece.PieceType.KING && piece.getColor() == Piece.Color.WHITE && y > 0) {
            return false;
        }
        if (piece.getType() != Piece.PieceType.KING && piece.getColor() == Piece.Color.RED && y < 0) {
            return false;
        }
        
        if (!(x == 1 && y == 1) && !(x == 2 && y == 2)) {
            return false;
        }
        
        if (x == 2 && y == 2) {
            Piece betweenPiece = this.rows.get((rowF + rowT) / 2).getSpaces().get((colF + colT) / 2).getPiece();
            
            if (betweenPiece == null || betweenPiece.getColor() == piece.getColor()) {
                return false;
            }
        }
        
        if (this.rows.get(rowF + y).getSpaces().get(colF + x).getPiece() == null) {
            this.rows.get(rowF).getSpaces().get(colF).setPiece(null);
            this.rows.get(rowF + y).getSpaces().get(colF + x).setPiece(piece);
            
            if (x == 2 && y == 2) {
                this.rows.get((rowF + rowT) / 2).getSpaces().get((colF + colT) / 2).setPiece(null);
            }
            
            return true;
        }
        
        return false;
    }

    public BoardView flip() {
        Board flipped = new Board(this);
        BoardView boardView = new BoardView(flipped);
        
        return boardView;
    }
}
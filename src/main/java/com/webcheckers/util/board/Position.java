package com.webcheckers.util.board;

public class Position{

    private int row; //Row
    private int col; //Column

    /**
     * constructs a Position object
     * @param row int from 0 to 7
     * @param col int 0 to 7
     */
    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    public Position getInverse(){ return new Position(7-row, 7-col); }

    public int getRow(){
        return row;
    }

    public int getCol() {
        return col;
    }
    
    @Override
    public String toString() {
        return ("(" + this.row + ", " + this.col + ")");
    }
}

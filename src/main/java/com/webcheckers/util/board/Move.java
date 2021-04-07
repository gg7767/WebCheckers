package com.webcheckers.util.board;

public class Move{

    private Position start;
    private Position end;

    public Move(Position start, Position end){
        this.start = start;
        this.end = end;
    }

    public Move getInverse() {
        return new Move(start.getInverse(), end.getInverse());
    }

    public Position getStart(){return start;}

    public Position getEnd(){return end;}

    public boolean isStep() {
        int startRow = getStart().getRow();
        int startCol = getStart().getCol();
        int endRow = getEnd().getRow();
        int endCol = getEnd().getCol();
        if (Math.abs(startRow - endRow) != 1) {
            return false;
        }
        return Math.abs(startCol - endCol) == 1;
    }

    public boolean isJump() {
        int startRow = getStart().getRow();
        int startCol = getStart().getCol();
        int endRow = getEnd().getRow();
        int endCol = getEnd().getCol();
        if (Math.abs(startRow - endRow) != 2) {
            return false;
        }
        return Math.abs(startCol - endCol) == 2;
    }
    
    @Override
    public String toString() {
        return (this.start + " -> " + this.end);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hafizaoyunu.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cihat.Altuntas
 */
public class Board {
    private int putCount = 0;
    private Cell[][] gameCells;    
    private int score =0;
    private List<Cell> cells = new ArrayList<Cell>();

    public Board(char[][] charTable){
        isValid(charTable);
        initialize(charTable);
    }
    
    public Board(Cell[][] gameCells){
        initialize(gameCells);
    }
    
    public Cell[][] getCells() {
        return gameCells;
    }

    private void initialize(char[][] charTable) {        
        gameCells = new Cell[charTable.length][charTable[0].length];
        for (int columnIndex = 0; columnIndex < charTable.length; columnIndex++) {
            for (int rowIndex = 0; rowIndex < charTable[columnIndex].length; rowIndex++) {
                gameCells[columnIndex][rowIndex] = new Cell(charTable[columnIndex][rowIndex],rowIndex,columnIndex);
            }
        }
    }
    
    private void initialize(Cell[][] charTable) {        
        gameCells = new Cell[charTable.length][charTable[0].length];
        for (int columnIndex = 0; columnIndex < charTable.length; columnIndex++) {
            for (int rowIndex = 0; rowIndex < charTable[columnIndex].length; rowIndex++) {
                gameCells[columnIndex][rowIndex] = new Cell(charTable[columnIndex][rowIndex].getCharacter(),rowIndex,columnIndex);
            }
        }
    }

    public char open(int col, int row) throws GameException {
        isValidLocation(col, row);
        Cell requestedCell = gameCells[row][col];  
        add(requestedCell);
        return requestedCell.getCharacter();
    }

    private void add(Cell requestedCell) {
        requestedCell.setVisible(true);
        
        if(cells.contains(requestedCell)){
            requestedCell.setVisible(false);
            return;
        }
        
       cells.add(requestedCell);  
       
       if (isCheckTime()) {
            if(areAllSame()){
                score++;
                openAndClear();
            }else{
                score--;
                closeAndClear();
            }
        }
    }
    
    public int getScore(){
        return score;
    }

    private boolean areAllSame() {
        Cell firstCell = cells.get(0);
        for (Cell cell : cells) {
            if (firstCell.getCharacter() != cell.getCharacter()) {
                return false;
            }
        }
        return true;
    }

    private void closeAndClear() {
        for (Cell cell : cells) {
            cell.setVisible(false);
        }
        cells.clear();
    }

    private boolean isCheckTime() {
        putCount++;
        return ((putCount % 2) == 0);
    }

    private void isValid(char[][] charTable) throws GameException {
        if (charTable == null || charTable.length <= 0 || charTable[0].length <= 0) {
            throw new GameException("Character table can not be null");
        }
    }

    private void isValidLocation(int col, int row) throws GameException {
        if (col < 0 || row < 0 || row > gameCells[0].length || col > gameCells.length) {
            throw new GameException("Geçerisiz sutun ya da satır : " + col + "," + row);
        }
    }

    public boolean isVisible(int col, int row) {
        return gameCells[row][col].isVisible();
    }

    public boolean isOver() {
        final int length = gameCells.length;
        for (int columnIndex = 0; columnIndex < length; columnIndex++) {
            for (int rowIndex = 0; rowIndex < length; rowIndex++) {
                if (gameCells[columnIndex][rowIndex].isVisible() == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private void openAndClear() {
        for (Cell cell : cells) {
            cell.open();
        }
        cells.clear();
    }
}

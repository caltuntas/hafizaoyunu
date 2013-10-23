/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hafizaoyunu.model;

/**
 *
 * @author cihat.altuntas
 */
public class CellGenerator {

    private Cell[][] cells = null;
    private IRandom generator;

    public CellGenerator(IRandom generator) {
        this.generator = generator;
    }

    public Cell[][] generate(int  columnCount, int rowCount) {
        cells = new Cell[columnCount][rowCount];

        while (hasMoreEmptyCells(cells)) {
            char chr = generator.randomChar();
            Location location = generator.randomLocationBetween(columnCount, rowCount);
            cells[location.getColumn()][location.getRow()] = new Cell(chr, location.getColumn(), location.getRow());
            Location nextLocation = generator.randomLocationBetween(columnCount, rowCount);
            cells[nextLocation.getColumn()][nextLocation.getRow()] = new Cell(chr, nextLocation.getColumn(), nextLocation.getRow());
        }

        return cells;
    }   
   

    private boolean hasMoreEmptyCells(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }
    
}

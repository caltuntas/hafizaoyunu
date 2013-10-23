/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hafizaoyunu.model;

/**
 *
 * @author Cihat.Altuntas
 */
public class Cell
{    
    private char character;
    private boolean visible =false;
    private boolean open=false;
    private int column=0;
    private int row=0;
    
    public static Cell createEmptyCell(int columnIndex, int rowIndex){
        Cell cell =new Cell(' ',columnIndex,rowIndex);        
        return cell;
    }

    public Cell(char character, int columnIndex, int rowIndex) {
        this.character=character;
        this.row=rowIndex;
        this.column=columnIndex;
    }

    public char getCharacter() {
        return character;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        if(!isOpen())            
            this.visible = visible;
    }

    public boolean isOpen() {
        return open;
    }
    
    public void open(){
        open=true;
        visible=true;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }  
}
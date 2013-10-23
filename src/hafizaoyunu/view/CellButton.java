/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hafizaoyunu.view;

import hafizaoyunu.model.Cell;
import javax.swing.Action;
import javax.swing.JButton;

/**
 *
 * @author cihat.altuntas
 */
public class CellButton extends JButton {
    private Cell cell;

    public CellButton(Cell cell,Action action) {
        super(action);
        this.cell = cell;
        if (cell.isOpen()) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
        if (cell.isVisible()) {
            setText(String.valueOf(cell.getCharacter()));
        }
        setName(cell.getColumn() + "," + cell.getRow());
    }

    public int getRow() {
        return cell.getRow();
    }

    public int getColumn() {
        return cell.getColumn();
    }
}

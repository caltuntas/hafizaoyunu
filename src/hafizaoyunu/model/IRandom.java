/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hafizaoyunu.model;

/**
 *
 * @author cihat.altuntas
 */
public interface IRandom {
    public char randomChar();
    public Location randomLocationBetween(int col,int row);
}
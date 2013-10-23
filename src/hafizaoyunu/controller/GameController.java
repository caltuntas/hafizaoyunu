/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hafizaoyunu.controller;

import hafizaoyunu.model.Cell;
import hafizaoyunu.model.Board;
import hafizaoyunu.model.CellGenerator;
import hafizaoyunu.model.UniqueRandomGenerator;

/**
 *
 * @author Cihat.Altuntas
 */
public class GameController {
    
        char charTable[][]={
        {'A','H','B','D','T'},
        {'U','Y','C','Z','U'},
        {'T','C','A','Y','E'},
        {'B','L','D','K','L'},
        {'E','K','H','F','F'}
    };
    CellGenerator generator=new CellGenerator(new UniqueRandomGenerator());
    Board game =new Board(generator.generate(4, 4));
    public void start(){
          
    }
    
    public char open(int col,int row){
       return game.open(col, row); 
    }
           
    public Cell[][] getCells(){
        return game.getCells();
    }
    
    public int getScore(){
        return game.getScore();
    }
    
    public boolean isGameOver(){
        return game.isOver();
    }
}

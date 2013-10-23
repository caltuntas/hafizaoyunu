/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hafizaoyunu.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cihat.Altuntas
 */
public class GameTest {

    char charTable[][] = {
        {'A', 'H', 'B', 'D', 'T'},
        {'U', 'Y', 'C', 'Z', 'U'},
        {'T', 'C', 'A', 'Y', 'E'},
        {'B', 'L', 'D', 'K', 'L'},
        {'E', 'K', 'H', 'F', 'F'}
    };

    @Test
    public void ShouldBeOpen3() {
        Board game = new Board(charTable);;
  
        assertEquals('C', game.open(2, 1));
        assertTrue(game.isVisible(2, 1));
        assertEquals('C', game.open(1, 2));
        assertTrue(game.isVisible(1, 2));
        assertTrue(game.isVisible(2, 1));

        assertEquals('D', game.open(2, 3));
        assertTrue(game.isVisible(2, 3));
        assertEquals('A', game.open(2, 2));
        assertFalse(game.isVisible(2, 2));
        assertFalse(game.isVisible(2, 3));

        assertEquals('A', game.open(2, 2));
        assertTrue(game.isVisible(2, 2));
        assertEquals('A', game.open(0, 0));
        assertTrue(game.isVisible(0, 0));
        assertTrue(game.isVisible(2, 2));

        assertEquals('Y', game.open(1, 1));
        assertTrue(game.isVisible(1, 1));
        assertEquals('T', game.open(0, 2));
        assertFalse(game.isVisible(0, 2));
        assertFalse(game.isVisible(1, 1));

        assertTrue(game.isVisible(0, 0));
        assertTrue(game.isVisible(2, 2));

        assertFalse(game.isOver());
    }

    @Test
    public void ShouldBeOpen4() {
        Board game = new Board(charTable);;
  
        assertEquals('C', game.open(2, 1));
        assertTrue(game.isVisible(2, 1));
        assertEquals('C', game.open(1, 2));
        assertTrue(game.isVisible(1, 2));
        assertTrue(game.isVisible(2, 1));

        assertEquals('A', game.open(2, 2));
        assertTrue(game.isVisible(2, 2));
        assertEquals('A', game.open(0, 0));
        assertTrue(game.isVisible(0, 0));
        assertTrue(game.isVisible(2, 2));

        assertEquals('A', game.open(2, 2));
        assertTrue(game.isVisible(2, 2));
        assertEquals('Y', game.open(1, 1));
        assertFalse(game.isVisible(1, 1));

        assertTrue(game.isVisible(0, 0));
        assertTrue(game.isVisible(2, 2));

        assertFalse(game.isOver());
    }

    @Test
    public void ShouldBeOpen5() {
        Board game = new Board(charTable);;
  
        assertEquals('C', game.open(2, 1));
        assertTrue(game.isVisible(2, 1));
        assertEquals('C', game.open(1, 2));
        assertTrue(game.isVisible(1, 2));
        assertTrue(game.isVisible(2, 1));

        assertEquals('A', game.open(2, 2));
        assertTrue(game.isVisible(2, 2));
        assertEquals('A', game.open(0, 0));
        assertTrue(game.isVisible(0, 0));
        assertTrue(game.isVisible(2, 2));

        assertEquals('A', game.open(2, 2));
        assertTrue(game.isVisible(2, 2));
        assertEquals('A', game.open(0, 0));
        assertTrue(game.isVisible(0, 0));

        assertTrue(game.isVisible(0, 0));
        assertTrue(game.isVisible(2, 2));

        assertFalse(game.isOver());
    }

    @Test
    public void ShouldBeOpen6() {
        Board game = new Board(charTable);;
   
        assertEquals('C', game.open(2, 1));
        assertTrue(game.isVisible(2, 1));
        assertEquals('C', game.open(1, 2));
        assertTrue(game.isVisible(1, 2));
        assertTrue(game.isVisible(2, 1));

        assertEquals('A', game.open(2, 2));
        assertTrue(game.isVisible(2, 2));
        assertEquals('A', game.open(0, 0));
        assertTrue(game.isVisible(0, 0));
        assertTrue(game.isVisible(2, 2));

        assertEquals('C', game.open(2, 1));
        assertTrue(game.isVisible(2, 1));
        assertEquals('C', game.open(1, 2));
        assertTrue(game.isVisible(1, 2));
        assertTrue(game.isVisible(2, 1));

        assertEquals('B', game.open(2, 0));
        assertTrue(game.isVisible(2, 0));
        assertEquals('Y', game.open(1, 1));
        assertFalse(game.isVisible(2, 0));
        assertFalse(game.isVisible(1, 1));

        assertTrue(game.isVisible(0, 0));
        assertTrue(game.isVisible(2, 2));

        assertFalse(game.isOver());
    }

    @Test
    public void OpenOpenedCellAgain() {
        Board game = new Board(charTable);;
  
        assertEquals('A', game.open(2, 2));
        assertTrue(game.isVisible(2, 2));
        assertEquals('A', game.open(0, 0));
        assertTrue(game.isVisible(0, 0));
        assertTrue(game.isVisible(2, 2));

        assertEquals('A', game.open(2, 2));
        assertTrue(game.isVisible(0, 0));
        assertTrue(game.isVisible(2, 2));
    }

    @Test
    public void OpenSameCellAgain() {
        Board game = new Board(charTable);;
   
        assertEquals('A', game.open(2, 2));
        assertTrue(game.isVisible(2, 2));
        assertEquals('A', game.open(2, 2));
        assertFalse(game.isVisible(2, 2));

    }
    
    @Test
    public void Point() {
        Board game = new Board(charTable);;
  
        assertEquals('F', game.open(3, 4));
        assertTrue(game.isVisible(3, 4));
        assertEquals('C', game.open(1, 2));

        assertFalse(game.isVisible(3, 4));
        assertFalse(game.isVisible(1, 2));
        
        assertEquals(-1, game.getScore());    
        
        assertEquals('C', game.open(2, 1));
        assertTrue(game.isVisible(2, 1));
        assertEquals('C', game.open(1, 2));
        assertTrue(game.isVisible(1, 2));
        assertTrue(game.isVisible(2, 1));        
        
        assertEquals(0, game.getScore());    
    }
 
    @Test
    public void ShouldNotBeOpen() {
        Board game = new Board(charTable);;
  
        assertEquals('F', game.open(3, 4));
        assertTrue(game.isVisible(3, 4));
        assertEquals('C', game.open(1, 2));

        assertFalse(game.isVisible(3, 4));
        assertFalse(game.isVisible(1, 2));
        assertFalse(game.isOver());
    }

    @Test
    public void ShouldBeOpen() {
        Board game = new Board(charTable);;
    
        assertEquals('A', game.open(0, 0));
        assertTrue(game.isVisible(0, 0));
        assertEquals('A', game.open(2, 2));

        assertTrue(game.isVisible(0, 0));
        assertTrue(game.isVisible(2, 2));
        assertFalse(game.isOver());
    }

    @Test
    public void ShouldNotBeOpenAgain() {
        Board game = new Board(charTable);;
   
        assertEquals('A', game.open(0, 0));
        assertTrue(game.isVisible(0, 0));
        assertEquals('A', game.open(2, 2));

        assertTrue(game.isVisible(0, 0));
        assertTrue(game.isVisible(2, 2));

        assertEquals('Z', game.open(3, 1));
        assertTrue(game.isVisible(3, 1));

        assertEquals('A', game.open(2, 2));
        assertTrue(game.isVisible(2, 2));
        assertFalse(game.isVisible(3, 1));

        assertFalse(game.isOver());
    }

    @Test
    public void ShouldBeOpen2() {
        Board game = new Board(charTable);;
  
        assertEquals('Z', game.open(3, 1));
        assertTrue(game.isVisible(3, 1));
        assertEquals('C', game.open(1, 2));
        assertFalse(game.isVisible(3, 1));
        assertFalse(game.isVisible(1, 2));

        assertEquals('U', game.open(0, 1));
        assertTrue(game.isVisible(0, 1));

        assertFalse(game.isOver());
    }

    @Test
    public void Open() {
        Board game = new Board(charTable);;   
        assertEquals('A', game.open(0, 0));
    }

    @Test
    public void GameOver() {
        char charTable[][] = {
            {'B', 'C', 'K'},
            {'K', 'T', 'B'},
            {'C', 'Z', 'T'}
        };
        Board game = new Board(charTable);;
   
        //C
        game.open(1, 0);
        game.open(0, 2);

        //B
        game.open(0, 0);
        game.open(2, 1);

        //T
        game.open(1, 1);
        game.open(2, 2);

        //K
        game.open(0, 1);
        game.open(2, 0);

        //Z
        game.open(1, 2);
        
        assertFalse(game.isVisible(1, 2));
        assertTrue(game.getCells()[1][2].isOpen());

        assertTrue(game.isOver());
    }

    @Test(expected = GameException.class)
    public void OpenNegativeColumn() {
        Board game = new Board(charTable);      
        game.open(-1, 0);
    }

    @Test(expected = GameException.class)
    public void OpenNegativeRow() {
        Board game = new Board(charTable);    
        game.open(1, -2);
    }

    @Test(expected = GameException.class)
    public void OpenRowBiggerThanRowCount() {
        Board game = new Board(charTable);;
        game.open(1, 10);
    }

    @Test(expected = GameException.class)
    public void OpenColumnBiggerThanColumnCount() {
        char charTable[][] = {
            {'B', 'C', 'K'},
            {'K', 'T', 'B'}
        };
        Board game = new Board(charTable);;
        game.open(3, 1);
    }

    
    @Test(expected = GameException.class)
    public void InitWithZeroLengthCharTable() {
        Board game = new Board(new char[0][0]);
    }

    @Test
    public void Dimension() {
        char charTable[][] = {
            {'B', 'C', 'K'},
            {'K', 'T', 'B'}
        };

        assertEquals(2, charTable.length);
        assertEquals(3, charTable[0].length);
    }
}
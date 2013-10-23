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
 * @author cihat.altuntas
 */
public class CharacterTableGeneratorTest {

    class RandomCellGeneratorStub implements IRandom{
        private Location locationToReturn;
        private char charToReturn;

        public void setCharToReturn(char charToReturn) {
            this.charToReturn = charToReturn;
        }

        public void setLocationToReturn(Location locationToReturn) {
            this.locationToReturn = locationToReturn;
        }
        
        

        public char randomChar() {
            return charToReturn;
        }

        public Location randomLocationBetween(int col, int row) {
            return locationToReturn;
        }
    }

    /**
    @Test
    public void ColumnAndRowCount(){
        RandomCellGeneratorStub cellGeneratorStub =new RandomCellGeneratorStub();
        CharacterTableGenerator generator =new CharacterTableGenerator(cellGeneratorStub);
        
        Cell[][] cells= generator.generate(3,4);
        assertEquals(3, cells.length);
        assertEquals(4, cells[0].length);
    }
     * */
    
    @Test
    public void ContainsCellTwoTimes(){
        UniqueRandomGenerator cellGeneratorStub =new UniqueRandomGenerator();
        CellGenerator generator =new CellGenerator(cellGeneratorStub);        
        //cellGeneratorStub.setCharToReturn('a');
        //cellGeneratorStub.setLocationToReturn(new Location(2, 1));
        
        Cell[][] cells= generator.generate(3,4);
        assertEquals(2, ContainsTimes('a',cells));
    }
    
    private int ContainsTimes(char cellToFind,Cell[][] cells){
        int count =0;
        for(int i=0;i<cells.length; i++)
            for(int j=0; j<cells[i].length; j++){
                if(cells[i][j].getCharacter()==cellToFind)
                    count++;
            }
        return count;
    }

}
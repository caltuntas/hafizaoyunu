/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hafizaoyunu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author cihat.altuntas
 */
public class UniqueRandomGenerator implements IRandom {
    private List<Character> generatedChars =new ArrayList<Character>();
    private List<Location> generatedLocations =new ArrayList<Location>();
    public char randomChar() {
        char randomCharacter = getRandomChar();        
        while(generatedChars.contains(randomCharacter))
            randomCharacter = getRandomChar();
        
        generatedChars.add(randomCharacter);
        return randomCharacter;
    }

    public Location randomLocationBetween(int colCount, int rowCount) {
        Location randomLocation = getRandomLocation(colCount, rowCount);
        while(generatedLocations.contains(randomLocation))
            randomLocation =getRandomLocation(colCount, rowCount);
        
        generatedLocations.add(randomLocation);
        return randomLocation;
    }

    private char getRandomChar() {
        double randomNumber;
        double randomNumberSetup;
        char randomCharacter;
        randomNumber = Math.random();
        randomNumberSetup = (randomNumber * 26 + 'a');
        randomCharacter = (char) randomNumberSetup;

        return randomCharacter;
    }

    private Location getRandomLocation(int colCount, int rowCount) {
        Random random = new Random();
        int col = random.nextInt(colCount);
        int row = random.nextInt(rowCount);
        return new Location(col, row);
    }
}

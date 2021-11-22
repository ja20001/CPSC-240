// EnemyGenerator.java
// this class contains a static method for creating enemies randomly

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class EnemyGenerator {
    private static String[] enemyName = {"Goblin", "Stand", "The enemy", "Dragon", "Dog", "Evil Dog", "Even More Evil Dog", "Ogre", "Lizard"};
    private static Random rng = new Random(); 
    public static Enemy generate(int row, int col) {
	    

        
        return new Enemy("Goblin", row, col, 20, 5, 3);
    }
}


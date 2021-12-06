/**
 * This class will randomly create enemies.
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class EnemyGenerator {
    private static String[] enemyName = {"Goblin", "Stand", "The enemy", "Dragon", "Dog", "Evil Dog", "Even More Evil Dog", "Ogre", "Lizard"};
    private static Random rng = new Random(); 
    public static Enemy generate(int row, int col) {
	    String name = enemyName[rng.nextInt(enemyName.length)];
	    int health = rng.nextInt(21)+ 1;
	    int damage = rng.nextInt(6) + 1;
	    int protection =rng.nextInt(6)+ 1;    
    	    return new Enemy(name, row, col, health, damage, protection);
    }
}


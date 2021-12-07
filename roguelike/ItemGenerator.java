// ItemGenerator.java
// this class contains a static method for creating items randomly

//import java.util.Random;

//public class ItemGenerator {
  //  public static Item generate() {
        // TODO: replace this with your own code!
    //    return new Item(ItemType.Other, "Vase", 10, 2, 0);
  //  }
//}
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class ItemGenerator{
	private static String[] arrayName = {"Grog", "Frodo", "Sauron", "The Behemoth", "Koz", "Kaido", "The hundred beasts", "Dagon", "Mr. 0", "Gwyn of the first flame", "Ornstein", "The Vile beast"};
	private static String[] arrayOther = {"vase", "Keys", "lockpick", "potion", "toothpick", "The Chicken Wing", "Itme from the future called a 'Lahptahp'"};
	private static Random rng = new Random();
	
	
/**
 * Creates a random item with randomized weight, value, strength, type, and name 
 */	
	public static Item generate(){
		int weight = rng.nextInt(20) + 1;
		int value = rng.nextInt(30) + 1;
		int strength = rng.nextInt(100) + 1;
		int rollForType = rng.nextInt(3) + 1;
		int rollForName = rng.nextInt(11) + 1;
		int rollForOther = rng.nextInt(6) + 1;
		String name = "";
		ItemType type; 
		if (rollForType == 1){
			type = ItemType.Weapon;
		}else if (rollForType == 2){
			type = ItemType.Armor;
		}else{
			type = ItemType.Other;
		}
		if (type == ItemType.Weapon){
			name = "The Sword of " + arrayName[rollForName];
		}else if(type == ItemType.Armor){
			name = "The Shield of " + arrayName[rollForName];
		}else if (type == ItemType.Other){
			name = arrayOther[rollForOther];
			weight = rng.nextInt(20) + 1;
			value = rng.nextInt(30) + 1;
			strength = 0;
		
		}
		Item item = new Item(type, name, value, strength, weight);
		return item;
	}

	
}


// Character.java

import java.util.ArrayList;
import java.io.PrintWriter;
import ansi_terminal.*;

public abstract class Character extends Entity {
    // the characters health points
    protected int hp;

    public Character(int row, int col, char display, Color color, int hp) {
        super(row, col, display, color);
        this.hp = hp;
    }

    // get the hp, damage, protection and name of character
    public int getHealth() {
        return hp;
    }
    public abstract int getDamage();
    public abstract int getProtection();
    public abstract String getName();

    /** do damage to another player, returns if they died
     *Contains damage calculations, prevents negative damage, and prints character health and damage
     *@return false if character is damaged but still alive
     *@return true if character loses all health and dies
     */
    private boolean dealDamage(Character other, Room room) {
        // this character does damage to the other character
        int damageDone = getDamage() - other.getProtection();

        // prevent negative damage
        if (damageDone < 0) {
            damageDone = 0;
        }

        // actually damage them
        other.hp -= damageDone;

        // prevent negative hp
        if (other.hp < 0) {
            other.hp = 0;
        }

        // print the info on this
        Terminal.warpCursor(room.getRows(), 0);
        if (other.hp > 0) {
            System.out.print(getName() + " does " + damageDone + " damage to " + other.getName()
                + ", leaving " + other.hp + " health.\n\r");
            return false;
        } else {
            System.out.print(getName() + " does " + damageDone + " damage to " + other.getName()
                + ", killing them.\n\r");
            return true;
        }
    }

    /**
     * This method initiates combat between two Character objects.
     */
    public boolean fight(Character other, Room room, ArrayList<Enemy> enemies) {
        // do damage to them first
        boolean killed = dealDamage(other, room);
        if (killed) {
            enemies.remove(other);
        }
        System.out.printf("Press any key to return...\n\r");
        Terminal.getKey();

        /**
	 * This method prevents enemies declared dead from fighting back.
	 */
        if (killed) {
            return true;
        }

        /**
	 * This method allows a character to receive damage in battle. 
	 * @return false when damage is dealt.
	 */
        if (other.dealDamage(this, room)) {
            return false;
        }
        System.out.printf("Press any key to return...\n\r");
        Terminal.getKey();
        return true;
    }
	/**
	 *This method will save the data of each character for when the game is loaded again.
	*/ 
    public void saveChar (PrintWriter pw) {
	    super.save();
	    pw.print(hp);
	    pw.print(row);
	    pw.print(col);
    }


}


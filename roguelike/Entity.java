// Entity.java
// this class represents one moveable, drawable thing in the game

import ansi_terminal.*;
import java.io.PrintWriter;

public class Entity {
    // the location of the entity in space
    private Position position;

    // the character used to draw it
    private char display;

    // the color used for drawing
    private Color color;

    public Entity(int row, int col, char display, Color color) {
        position = new Position(row, col);
        this.display = display;
        this.color = color;
    }

    // move the entity to a new location
    public void setPosition(int row, int col) {
        position = new Position(row, col);
    }

    // get the position of this entity
    public Position getPosition() {
        return position;
    }
	/**
	 * Prints the row value associated with an entity object
	 * @Return row value
	 */
    public int getRow() {
        return position.getRow();
    }
	/**
	 * Prints the column value associated with an entity object
 	 * @Return column value 
	 */
    public int getCol() {
        return position.getCol();
    }

    	/**
	 * Adds the current row and column with the desired row and column, uses the new row/column values to move
	 * Replaces original move with space
	 * @Return true if moved
	 * @Return false if move failed
	 */
    public boolean move(int rowChange, int colChange, Room room) {
        // find new position
        int newRow = position.getRow() + rowChange;
        int newCol = position.getCol() + colChange;

        if (room.canGo(newRow, newCol)) {
            // draw a space where it currently is
            Terminal.warpCursor(position.getRow(), position.getCol());
            System.out.print(" ");

            // and then move it
            position = new Position(newRow, newCol);
            return true;
        } else {
            return false;
        }
    }

    // draw this entity to the screen
    public void draw() {
        Terminal.warpCursor(position.getRow(), position.getCol());
        Terminal.setForeground(color);
        System.out.print(display);
        Terminal.reset();
    }

    public void saveEntity (PrintWriter pw) {
	super.save(out);    
	pw.print(position.getRow());
	pw.print(position.getCol());
	pw.print(display);
	pw.print(color);
    }	
}


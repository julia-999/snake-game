/**
 * Creates a Snake object for the game
 * @author Julia Anantchenko
 */

public class Snake {

	/** The length of the snake */
	private int snakeLength;
	
	/** The array for each position of the snake's body */
	private Position[] snakeBody;

	/**
	 * Constructor for the class Snake
	 * @param row: the starting row
	 * @param col: the starting column
	 */
	public Snake(int row, int col) {
		
		// assign values to variables and make snake array
		snakeLength = 1;
		snakeBody = new Position[5];
		snakeBody[0] = new Position(row, col);
	}

	/**
	 * Getter method for the length of the snake
	 * @return the length
	 */
	public int getLength() {
		return snakeLength;
	}

	/**
	 * Gets the position based on the index of the snake
	 * @param index: which part of the snake
	 * @return the position
	 */
	public Position getPosition(int index) {
		
		// returns position if it is part of the snake
		if (index >= 0 && index < snakeLength)
			return snakeBody[index];
		
		// returns null otherwise
		return null;
	}

	/**
	 * Reduces the length of the snake by 1
	 */
	public void shrink() {
		snakeLength--;
	}

	/**
	 * Checks if there is a snake part in the specified location
	 * @param pos: the position
	 * @return true if part of the snake is there
	 */
	public boolean snakePosition(Position pos) {
		
		// checks if the position is part of the snake by going through each snake position
		for (int i = 0; i < snakeLength; i++) {
			if (pos.equals(snakeBody[i]))
				return true;
		}
		
		// returns false if the position is not in the snake
		return false;
	}

	/**
	 * Moves the head to a new position
	 * @param direction: which way the snake is moving
	 * @return the new position of the head
	 */
	public Position newHeadPosition(String direction) {
		
		// creates a new position for the head to move to
		Position newPos = new Position(getPosition(0).getRow(), getPosition(0).getCol());
		
		// switch statement for the direction, changes coordinates accordingly
		switch (direction) {
		case "right":
			newPos.setCol(newPos.getCol()+1);
			break;
		case "left": 
			newPos.setCol(newPos.getCol()-1);
			break;
		case "up": 
			newPos.setRow(newPos.getRow()-1);
			break;
		case "down": 
			newPos.setRow(newPos.getRow()+1);
			break;
		default:
			System.out.print("direction is wrong");
			break;
		}
		
		// returns the new position
		return newPos;
	}

	/**
	 * Moves the snake in a direction
	 * @param direction: the way to move
	 */
	public void moveSnake(String direction) {
		
		// moves each part of the snake to the location of the one in front of it
		for (int i = snakeLength-1; i > 0; i--) {
			snakeBody[i] = snakeBody[i-1];
		}
		
		// moves the head in the direction specified
		snakeBody[0] = newHeadPosition(direction);
	}

	/**
	 * Moves the snake and increases its length by 1
	 * @param direction: the way to move
	 */
	public void grow(String direction) {
		
		// increases snake length
		snakeLength++;

		// increases the size of the array if it is too small
		if (snakeBody.length == snakeLength)
			increaseArraySize();

		// moves the snake
		moveSnake(direction);
	}

	/**
	 * Increases the size of the array for the snake
	 */
	private void increaseArraySize() {
		
		// creates an array that is twice as big 
		Position[] a = new Position[snakeLength*2];

		// fills the new array with the positions of the snake
		for (int i = 0; i < snakeLength; i++) {
			a[i] = snakeBody[i];
		}
		
		// replaces the original array with a
		snakeBody = a;
	}

	/**
	 * Prints each position of the snake
	 */
	public String toString() {
		
		// goes through each position in a for loop and creates a string of them combined
		String str = "";
		for (int i = 0; i < getLength(); i++) {
			str += "\tPOSITION " + i + ": "+ getPosition(i) + "\n";
		}
		
		// returns the string
		return str;
	}
}

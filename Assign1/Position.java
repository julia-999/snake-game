/**
 * Creates a Position object that consists of a row and a column
 * @author Julia Anantchenko
 */

public class Position {

	/** Variables for the row and column number. */
	private int positionRow, positionColumn;
	
	/**
	 * Constructor for the class Position
	 * @param row
	 * @param column
	 */
	public Position(int row, int col) {
		positionRow = row;
		positionColumn = col;
	}
	
	/**
	 * Returns the row
	 * @return row
	 */
	public int getRow() {
		return positionRow;
	}
	
	/**
	 * Returns the column
	 * @return column
	 */
	public int getCol() {
		return positionColumn;
	}
	
	/**
	 * Sets the row
	 * @param new row
	 */
	public void setRow(int newRow) {
		positionRow = newRow;
	}
	
	/**
	 * Sets the column
	 * @param new column
	 */
	public void setCol(int newCol) {
		positionColumn = newCol;
	}
	
	/**
	 * Checks if the position is equal to another position
	 * @param otherPosition
	 * @return true if they are the same, false otherwise
	 */
	public boolean equals(Position otherPosition) {
		
		// checks if they are equal based on row and column
		if (positionRow == otherPosition.getRow() && positionColumn == otherPosition.getCol())
			return true;
		return false;
	}
	
	/**
	 * Prints the position in a coordinate format
	 */
	public String toString() {
		return "(" + positionRow + ", " + positionColumn + ")";
	}

}

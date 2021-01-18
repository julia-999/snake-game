/**
 * Creates a BoardGame object with the specified size and contents
 * @author Julia Anantchenko
 */

public class BoardGame {

	/** Length and width of the board */
	private int board_length, board_width;
	
	/** The Snake object */
	private Snake theSnake;
	
	/** The 2D array for the board */
	private String[][] matrix;
	
	/**
	 * Constructor for the class BoardGame
	 * @param boardFile: the name of the file with the size and content specifications
	 */
	public BoardGame(String boardFile) {
		
		// creates a MyFileReader object to read the contents of boardFile
		MyFileReader file = new MyFileReader(boardFile);
		
		// assigns values from boardFile to the appropriate variables
		file.readInt();
		file.readInt();
		board_length = file.readInt();
		board_width = file.readInt();
		
		// creates a Snake object from the specified position and an array for the board
		theSnake = new Snake(file.readInt(), file.readInt());
		matrix = new String[board_width][board_length];
		
		// sets all elements of the array to "empty"
		for (int i = 0; i < board_width; i++) {
			for (int j = 0; j < board_length; j++) {
				matrix[i][j] = "empty";
			}
		}
		
		// sets specified locations to appropriate values
		while (!file.endOfFile()) {
			matrix[file.readInt()][file.readInt()] = file.readString();
		}
	}
	
	/**
	 * Returns the object name in the specified location
	 * @param row
	 * @param col
	 * @return String in the location specified
	 */
	public String getObject(int row, int col) {
		return matrix[row][col];
	}
	
	/**
	 * Replaces existing object name with a new one
	 * @param row
	 * @param col
	 * @param newObject
	 */
	public void setObject(int row, int col, String newObject) {
		matrix[row][col] = newObject;
	}
	
	/**
	 * Returns the snake
	 * @return the snake
	 */
	public Snake getSnake() {
		return theSnake;
	}
	
	/**
	 * Gets the length of the board
	 * @return the length
	 */
	public int getLength() {
		return board_length;
	}
	 /**
	  * Gets the width of the board
	  * @return the width
	  */
	public int getWidth() {
		return board_width;
	}
	
	/**
	 * Gets the object associated with the location
	 * @param row
	 * @param col
	 * @return the name of the object
	 */
	public String getType(int row, int col) {
		return matrix[row][col];
	}
}

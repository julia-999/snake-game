
public class TestSnake {

	public static void main(String[] args) {
		Snake snake = new Snake(1, 1);
		
		for (int j = 0; j < 5; j++) {
			System.out.println("SNAKE LENGTH: " + snake.getLength());
			snake.moveSnake("left");
			System.out.println("GROW");
			snake.grow("up");
		}
	}
}

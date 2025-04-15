package assignment9;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {

	private Snake snake;
	private Food food;
	public int score;

	public Game() {
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);

		// ✅ Construct Snake and Food
		snake = new Snake();
		food = new Food();
		score = 0;
	}

	public void play() {
		while (snake.isInbounds()) { // ✅ Stop if the snake hits the wall
			int dir = getKeypress();

			if (dir != -1) {
				snake.changeDirection(dir); // 1. Update snake direction
			}

			snake.move(); // 2. Move the snake

			if (snake.eatFood(food)) { // 3. Check if food eaten
				food = new Food(); // Create new food in random position
				score++;
			}

			updateDrawing(); // 4. Update screen

			StdDraw.pause(100); // Game speed
		}

		System.out.println("Game Over!");
	}

	private int getKeypress() {
		if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1; // up
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2; // down
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3; // left
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4; // right
		} else {
			return -1;
		}
	}

	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		food.draw();
		displayScore();
		StdDraw.show();
	}
	 private void displayScore() {
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.text(0.5, 0.95, "Score: " + score); // Show score at the top
	    }
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}


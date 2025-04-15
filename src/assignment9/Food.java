package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		//FIXME
		this.x = Math.random(); // Random double between 0.0 and 1.0
		this.y = Math.random();
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	// Optional getters
		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}

		// Optional: If you want to respawn food
		public void respawn() {
			this.x = Math.random();
			this.y = Math.random();
		}
	}
	


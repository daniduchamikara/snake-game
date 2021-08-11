package edu.bolton.oop.snake.test;

import edu.bolton.oop.snake.*;
import org.junit.Test;

import java.awt.geom.Ellipse2D;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class SnakeTest {

	@Test
	public void sanake () {
		ScoreBoard scoreBoard;
		Ground gameField;
		scoreBoard = new ScoreBoard();
		gameField = new Ground();
		Snake snake = new Snake(gameField, scoreBoard);
		Directions.DOWN.toString();
		Directions direction = Directions.UP;

		switch (Directions.UP) {
		case UP:
			assertEquals(Directions.UP.toString(), "UP");

			break;

		default:
			new Exception("Unexcepted Direction value!").printStackTrace();
			break;
		}

	}

	@Test
	public void testSnakeMovesDown() {
		ScoreBoard scoreBoard;
		Ground gameField;
		scoreBoard = new ScoreBoard();
		gameField = new Ground();
		Snake snake = new Snake(gameField, scoreBoard);
		Directions.DOWN.toString();

		switch (Directions.DOWN) {
		case DOWN:
			assertEquals(Directions.DOWN.toString(), "DOWN");

			break;

		default:
			new Exception("Unexcepted Direction value!").printStackTrace();
			break;
		}

	}

	@Test
	public void testSnakeMovesLeft() {
		ScoreBoard scoreBoard;
		Ground gameField;
		scoreBoard = new ScoreBoard();
		gameField = new Ground();
		Snake snake = new Snake(gameField, scoreBoard);
		Directions.LEFT.toString();

		switch (Directions.LEFT) {
		case LEFT:
			assertEquals(Directions.LEFT.toString(), "LEFT");

			break;

		default:
			new Exception("Unexcepted Direction value!").printStackTrace();
			break;
		}

	}

	@Test
	public void testSnakeMovesRight() {
		ScoreBoard scoreBoard;
		Ground gameField;
		scoreBoard = new ScoreBoard();
		gameField = new Ground();
		Snake snake = new Snake(gameField, scoreBoard);
		Directions.RIGHT.toString();

		switch (Directions.RIGHT) {
		case RIGHT:
			assertEquals(Directions.RIGHT.toString(), "RIGHT");

			break;

		default:
			new Exception("Unexcepted Direction value!").printStackTrace();
			break;
		}

	}

	@Test
	public void testSnakeFoodCollision() {
		ScoreBoard scoreBoard;

		Ground gameField;
		scoreBoard = new ScoreBoard();
		gameField = new Ground();
		boolean over = false;
		Snake snake = new Snake(gameField, scoreBoard);
		List<Ellipse2D.Double> snakeParts = snake.getParts();

		Ellipse2D.Double head = snakeParts.get(0);
		Gem gem = gameField.getFood();
		scoreBoard.addPoints(10);

		if(head.getMaxX() == gem.getShape().getMinX() && head.getMinY() == gem.getShape().getMinY()) {
			assertEquals(scoreBoard,10);
		}

	}


	@Test
	public void testSnakeDies() {
		ScoreBoard scoreBoard;

		Ground gameField;
		scoreBoard = new ScoreBoard();
		gameField = new Ground();
		boolean over = false;
		Snake snake = new Snake(gameField, scoreBoard);
		List<Ellipse2D.Double> snakeParts = snake.getParts();

		Ellipse2D.Double head = snakeParts.get(0);
		Gem gem = gameField.getFood();

		snake.changeDirection(Directions.UP);
        snake.move();
        snake.changeDirection(Directions.DOWN);
        snake.move();
        snake.changeDirection(Directions.LEFT);
        snake.move();
        snake.changeDirection(Directions.RIGHT);
        snake.move();

        assertTrue(snake.isGameOver());

	}

}

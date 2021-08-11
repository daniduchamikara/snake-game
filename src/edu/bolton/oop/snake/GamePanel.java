package edu.bolton.oop.snake;

public class GamePanel implements Runnable {

	public static final int DELAY = 250;

	private Main main;
	private Ground gameField;
	private Snake snake;
	private Gem gem;

	public GamePanel(Ground gameField, Snake snake, Main main) {
		gem = new Gem(300, 300);
		this.main = main;
		this.snake = snake;
		this.gameField = gameField;

		this.gameField.setSnakeParts(snake.getParts());
		this.gameField.setApple(gem);
	}

	@Override
	public void run() {
		try {
			while (true) {
				snake.move();
				snake.check();
				if (snake.isGameOver()) {
					Thread.currentThread().interrupt();
				}
				if (!Thread.currentThread().isInterrupted()) {
					gameField.repaint();
				}
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException ex) {
			main.gameOver();
		}
	}

}

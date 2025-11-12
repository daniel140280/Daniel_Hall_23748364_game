package uk.ac.mmu.game;

import board.GameBoard;
import board.TwoPlayerGameBoard;
import dice.DiceShaker;
import dice.RandomDoubleDiceShaker;
import dice.RandomSingleDiceShaker;
import gameconfig.GameController;
import gameobserver.GameListener;
import gameobserver.ObserverConsoleLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import players.BluePlayer;
import players.Player;
import players.RedPlayer;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {

		SpringApplication.run(GameApplication.class, args);
		//Instantiating our players
		//FIELDS
		DiceShaker shaker; //instantiate interface at runtime to determine how the abstract interface will be applied by the concrete classes
		GameBoard board;

		Player red = new RedPlayer();
		Player blue = new BluePlayer();

		//Adding players in the game into an array - this will be used to determine the order of game play.
		Player[] players = {red, blue};
		//Adding the number of dice required into the game.
		shaker = new RandomDoubleDiceShaker();
		board = new TwoPlayerGameBoard();

		System.out.println("Basic Game - 2 players, 2 dice, board of 18 positions and two tails with 3 positions. Rules - Hit is allowed, and End is exact or overshoot.");

		//Observer that listens to the game and prints the output.
		GameListener consoleLogger = new ObserverConsoleLogger();
		List<GameListener> listeners = List.of(consoleLogger);

		//Instantiating the Game Controller (FACADE) and the methods required to run the game.
		GameController controller = new GameController(players, shaker, board, listeners);
		controller.playGame();

	}
}

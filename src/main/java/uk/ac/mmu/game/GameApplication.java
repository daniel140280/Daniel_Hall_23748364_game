package uk.ac.mmu.game;

import dice.DiceShaker;
import dice.RandomDoubleDiceShaker;
import dice.RandomSingleDiceShaker;
import gameconfig.GameController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import players.BluePlayer;
import players.Player;
import players.RedPlayer;

import java.util.Scanner;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {

		SpringApplication.run(GameApplication.class, args);
		//Instantiating our players
		Player red = new RedPlayer();
		Player blue = new BluePlayer();

		//Adding players in the game into an array - this will be used to determine the order of game play.
		Player[] players = {red, blue};
		//Adding the number of dice required into the game.
		DiceShaker shaker = new RandomDoubleDiceShaker();

		//Instantiating the Game Controller and the methods required to run the game.
		GameController controller = new GameController(players, shaker);
		controller.playGame();

//		DiceShaker shaker;
//
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Tell me if you want to use one or two dice, respond with an integer");
//		int userInput = scanner.nextInt();
//		if(userInput == 1){
//			shaker = new RandomSingleDiceShaker();
//		} else {
//			shaker = new RandomDoubleDiceShaker();
//		}
//		System.out.format("Shake that dice, you scored: %d%n", shaker.shake());
//	}
	}
}

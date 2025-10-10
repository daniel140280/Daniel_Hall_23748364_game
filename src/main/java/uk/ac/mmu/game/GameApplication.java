package uk.ac.mmu.game;

import dice.DiceShaker;
import dice.RandomDoubleDiceShaker;
import dice.RandomSingleDiceShaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {

		SpringApplication.run(GameApplication.class, args);

		DiceShaker shaker;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Tell me if you want to use one or two dice, respond with an integer");
		int userInput = scanner.nextInt();
		if(userInput == 1){
			shaker = new RandomSingleDiceShaker();
		} else {
			shaker = new RandomDoubleDiceShaker();
		}
		System.out.format("Shake that dice, you scored: %d%n", shaker.shake());

	}
}

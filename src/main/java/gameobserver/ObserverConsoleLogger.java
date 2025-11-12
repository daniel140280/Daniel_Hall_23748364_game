package gameobserver;

import helpers.ConsoleColor;
import players.Player;

public class ObserverConsoleLogger implements GameListener {
    @Override
    public void onMove(Player player, int moves){
        System.out.println(ConsoleColor.consoleColor(player.getName() + " rolls " + moves, player.getColorCode()));
    }
    @Override
    public void blockedMove(Player player, int attemptedPosition){
        System.out.println(ConsoleColor.consoleColor("Blocked: " + player.getName() + " attempted to move to " + attemptedPosition, player.getColorCode()));
    }
    @Override
    public void hitEnd(Player player, int attemptedPosition){
        System.out.println(ConsoleColor.consoleColor("End reached or overshot by " + player.getName() + " at " + attemptedPosition, player.getColorCode()));
    }
}
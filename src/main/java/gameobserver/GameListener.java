package gameobserver;

import players.Player;

public interface GameListener {
    void onMove(Player player, int moves);
    void blockedMove(Player player, int attemptedPosition);
    void hitEnd(Player player, int attemptedPosition);
}

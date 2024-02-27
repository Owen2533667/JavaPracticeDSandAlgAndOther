package game.guessinggame;

import game.Game;

public class GameApp {
    public static void main(String[] args) {
        Game guessGame = new GuessingGame(100);

        guessGame.play();
    }
}

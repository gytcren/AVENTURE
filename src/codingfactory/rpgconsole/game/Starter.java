package codingfactory.rpgconsole.game;

public class Starter {

    private static Game game;

    public static void main(String[] args) {
        System.out.println("À l'aventure, compagnon !");
        game = new Game();
        game.gameLoop();
        System.out.println("Ce donjon il est pourri !");
    }

}

package codingfactory.rpgconsole.game;
import codingfactory.rpgconsole.enemy.Enemy;
import codingfactory.rpgconsole.hero.Hero;

public class Game {

    private Boolean isGameOver;
    private InputHandler inputHandler;

    private Hero hero;
    private Enemy enemy;

    /** CONTRUCTOR METHOD - initialize variabe gameOver */
    public Game(){
        isGameOver = false;
        inputHandler = new InputHandler();
    }
    public void gameLoop(){

        hero = createNewHero();
        enemy = createNewEnemy();

        while (isGameOver == false){
            if(hero.getHp() != 0)
                System.out.println(":BATTERVOUS:");
            //verification of hp
            if(hero.getHp() <= 0){
                System.out.println("YOU DIED");
                System.out.println("THANKS OBAMA");
                isGameOver = true;
            }else{
                //how plays?
                System.out.println(enemy.getName() + "(PV : " + enemy.getHp() + ")"); //name of enemy
                System.out.println(hero.getName() + "(PV : " + hero.getHp() + "). À TOI DE JOUER !"); //name of hero
                System.out.println("Appuie sur 'x' si t'es un lâche.");
                System.out.println("Appuie sur 'm' si t'es curieux.");
                System.out.println("Appuie sur 'a' si tu veux de la BASTON.");

                //take caracter
                Character c = inputHandler.getChar(); //read char "c"
                if (c.equals('x')){
                    isGameOver = true;
                }else if(c.equals('a')){
                    hero.attack(enemy);
                    if(enemy.getHp() <= 0){
                        System.out.println(enemy.getName() + " s'est fait latter la gueule.");
                        hero.levelUp();
                        System.out.println(hero.getName() + " a dû dire chaussette. Il est maintenant niveau " + hero.getLevel() + ".");
                        enemy = createNewEnemy(); //if enemy died, create a new enemy
                    }else{ //if enemy not died, enemy attack hero
                        enemy.attack(hero);
                    }
                } else if (c.equals('m')){
                    Integer maxAttack = hero.getAtk() + hero.getLevel();
                    System.out.println("*** Fiche de personnage ***");
                    System.out.println(hero.getName());
                    System.out.println("(NIVEAU: " + hero.getLevel() + ")");
                    System.out.println("(PV: " + hero.getHp() + ")");
                    System.out.println("(BASTONMÈTRE: Entre " + hero.getAtk() + " et " + maxAttack + ". À une vache près, hein, c'est pas une science exacte.)");
                }
            }
        }
    }

    private Hero createNewHero(){
        System.out.println("Nomme ton pignouf : ");
        String heroName = inputHandler.getString(); //name of hero
        return new Hero(heroName); //instance new hero
    }

    private Enemy createNewEnemy() {
        String name = "Thomas";
        System.out.println("Un " + name + " sauvage est apparu !");
        Integer level = 1;
        return new Enemy(name, level);
    }
}

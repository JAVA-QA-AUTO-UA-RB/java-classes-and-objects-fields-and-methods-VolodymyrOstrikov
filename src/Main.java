import java.util.Random;

class Superhero {
    String name;
    int attackPower;
    int defensePower;
    int health = 100;

    public Superhero(String name, int attackPower, int defensePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public void attack(Superhero opponent) {
        int damage = this.attackPower - opponent.defensePower;
        if (damage < 0) damage = 0;

        System.out.println(this.name + " attacks " + opponent.name + " and deals " + damage + " damage.");
        opponent.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
        System.out.println(this.name + " health remaining: " + this.health + ".");
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void showStats() {
        System.out.println(name + " — Attack: " + attackPower + ", Defense: " + defensePower + ", Health: " + health);
    }
    public void restoreHealth() {
        this.health = 100;
        System.out.println(this.name + " is fully healed and ready for the next battle!");
    }
}


        public class Main {
            public static void main(String[] args) {
                // First battle: Flash vs Iron Man
                Superhero flash = new Superhero("Flash", 30, 10);
                Superhero ironMan = new Superhero("Iron Man", 25, 15);

                System.out.println("First battle begins!");
                flash.showStats();
                ironMan.showStats();

                Superhero winner = battle(flash, ironMan);

                // Second battle: Winner vs POLTAVA PALII
                winner.restoreHealth();
                Superhero poltavaPaliy = new Superhero("POLTAVA PALII", 35, 12); // fire-based hero
                System.out.println("\nNow POLTAVA PALII enters the arena!");
                poltavaPaliy.showStats();
                winner.showStats();

                Superhero finalWinner = battle(winner, poltavaPaliy);

                System.out.println("\nFINAL WINNER: " + finalWinner.name + "!");
            }

            public static Superhero battle(Superhero hero1, Superhero hero2) {
                int round = 1;
                while (hero1.isAlive() && hero2.isAlive()) {
                    System.out.println("\nRound " + round + ":");
                    hero1.attack(hero2);
                    if (!hero2.isAlive()) break;

                    hero2.attack(hero1);
                    round++;
                }

                System.out.println("\nBattle ended!");
                if (hero1.isAlive() && !hero2.isAlive()) {
                    System.out.println("Winner: " + hero1.name + "!");
                    return hero1;
                } else if (!hero1.isAlive() && hero2.isAlive()) {
                    System.out.println("Winner: " + hero2.name + "!");
                    return hero2;
                } else {
                    System.out.println("It's a draw! Both heroes fell in battle.");
                    return new Superhero("Nobody", 0, 0);
                }
            }
        }
public class SuperHero {

    String name;
    int attackPower;
    int defensePower;
    int health = 100;

    public SuperHero(String name, int attackPower, int defensePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public void attack(SuperHero opponent) {

        System.out.println(this.name + " attacks " + opponent.name + " with power " + this.attackPower + ".");
        opponent.takeDamage(this.attackPower);

    }

    public void takeDamage(int incomingDamage) {

        int actualDamage = incomingDamage - this.defensePower;
        if (actualDamage < 0) {
            actualDamage = 0;
        }


        this.health -= actualDamage;
        if (this.health <= 0) {
            this.health = 0;
            System.out.println(this.name + " took " + actualDamage + " damage and Burned out at work!");

        } else {
            System.out.println(this.name + " took " + actualDamage + " damage. Health remaining is: " + this.health + ".");

        }
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

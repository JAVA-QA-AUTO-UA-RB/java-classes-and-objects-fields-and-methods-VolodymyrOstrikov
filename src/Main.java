public class Main {
    public static void main(String[] args) {
        // First battle: Flash vs Iron Man
        SuperHero flash = new SuperHero("Flash", 30, 10);
        SuperHero ironMan = new SuperHero("Iron Man", 25, 15);

        System.out.println("First battle begins!");
        flash.showStats();
        ironMan.showStats();

        SuperHero winner = BattleField.battle(flash, ironMan);

        // Second battle: Winner vs POLTAVA PALII
        winner.restoreHealth();
        SuperHero poltavaPalii = new SuperHero("POLTAVA PALII", 35, 12); // fire-based hero
        System.out.println("\nNow POLTAVA PALII enters the arena!");
        poltavaPalii.showStats();
        winner.showStats();

        SuperHero finalWinner = BattleField.battle(winner, poltavaPalii);

        System.out.println("\nFINAL WINNER: " + finalWinner.name + "!");
    }
}
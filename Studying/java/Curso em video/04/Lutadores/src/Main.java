public class Main {
    public static void main(String[] args) {
        Fighter[] fighters = new Fighter[6];

        fighters[0] = new Fighter("Carlos Silva", "Brazilian", 32, 1.85, 84.5, 25, 3, 1);
        fighters[1] = new Fighter("Aiko Tanaka", "Japanese", 23, 1.68, 58.2, 10, 2, 0);
        fighters[2] = new Fighter("Jack Thompson", "American", 40, 1.90, 92.3, 45, 10, 3);
        fighters[3] = new Fighter("Ivan Petrov", "Russian", 19, 1.75, 78.0, 3, 1, 0);
        fighters[4] = new Fighter("Connor Flynn", "Irish", 28, 1.80, 75.5, 20, 5, 2);
        fighters[5] = new Fighter("Sophie Carter", "Canadian", 27, 1.70, 65.0, 18, 2, 1);

        // Criar combates
        FIGHT fight1 = new FIGHT(fighters[0], fighters[1]);
        fight1.setFighters(fighters[0], fighters[1]);
        fight1.fight(); // Simula o combate

        FIGHT fight2 = new FIGHT(fighters[2], fighters[3]);
        fight2.setFighters(fighters[2], fighters[3]);
        fight2.fight(); // Simula o combate

        FIGHT fight3 = new FIGHT(fighters[4], fighters[5]);
        fight3.setFighters(fighters[4], fighters[5]);
        fight3.fight(); // Simula o combate

        // Exibir resultados dos lutadores
        for (Fighter fighter : fighters) {
            fighter.displayInfo();
        }
    }
}

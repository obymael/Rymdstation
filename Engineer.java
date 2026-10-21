/** Engineer
 * - ärver från CrewMember
 * - kan reparera reaktorn
 */

public class Engineer extends CrewMember {

    int skillLevel; // basic, normal, experienced
    
    /**
     * Konstruktor för att skapa ett objekt av klassen
     */
    public Engineer(String name, int skillLevel) {
        super(name);
        this.skillLevel = skillLevel;
    }

    public void repair(SpaceStation station) {
        int energyCost = 20;

        if (energy >= energyCost) {
            // kalla på metoden som finns i parent class
            useEnergy(energyCost); // här använder den då 20 energi av ingengörens tillgängliga energi

            int repairAmount = skillLevel * 10; // hur mycket den ska reparera beroende på skill level
            station.repairDamage(repairAmount); // reparera enl. föregående beräkning

            System.out.println(name + " repaired " + repairAmount + " of the damage!");
        } else {
            System.out.println(name + " doesn't have enough energy to repair the damage...");
        }
    }
}

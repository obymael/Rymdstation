/** Engineer
 * - ärver från CrewMember
 * - kan reparera system via interfacet Repairable
 */

public class Engineer extends CrewMember {
    // Static final KONSTANTER för att undvika magic numbers (lättare att ändra och hålla reda på)
    private static final int REPAIR_ENERGY_COST = 20;
    int skillLevel; // basic, normal, experienced
    
    /**
     * Konstruktor för att skapa ett objekt av klassen
     */
    public Engineer(String name, int skillLevel) {
        super(name); // ta från föräldraklassen
        this.skillLevel = skillLevel; // vi måste ange en skillevel när vi skapar en engineer
    }

    /**
     * samma metod kan reparera både dörrar och reaktorer (polymorphism)
     * - boolean så den kan returna true eller false
     * @param system
     */
    public boolean repair(Repairable system) {
        if (system.isRepaired()) {
            System.out.println(system.getSystemName() + " is already repaired.");
            return true;
        }

        if (!isConscious() || energy < REPAIR_ENERGY_COST) {
            System.out.println(name + "cannot repair " + system.getSystemName() + " (not enough HP or energy).");
            return false;
        }

        // Repaira
        useEnergy(REPAIR_ENERGY_COST);
        system.repair();
        System.out.println(name + " repairs " + system.getSystemName() + " (-" + REPAIR_ENERGY_COST + " energy: " + energy + " left).");
        return system.isRepaired();

        /* int energyCost = 20;

        if (energy >= energyCost) {
            // kalla på metoden som finns i parent class
            useEnergy(energyCost); // här använder den då 20 energi av ingenjörens tillgängliga energi

            int repairAmount = skillLevel * 10; // hur mycket den ska reparera beroende på skill level
            //station.repairDamage(repairAmount); // reparera enl. föregående beräkning
            system.repair();

            System.out.println(name + " repaired " + repairAmount + " of the damage!");
        } else {
            System.out.println(name + " doesn't have enough energy to repair the damage...");
        } */
    }
}

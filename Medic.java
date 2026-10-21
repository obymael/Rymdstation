/** Medic
 * - ärver från CrewMember
 * - kan återställa hp hos skadade crewmembers
 */

public class Medic extends CrewMember {

    int healingPower;
    int numbOfBandages;

    /**
     * Konstruktor för att skapa en medic
     */
    public Medic(String name) {
        super(name);
        this.healingPower = 20;
        this.numbOfBandages = 3;
    }

    /**
     * metod för att heala en crewmember
     */
    public void heal(CrewMember target) {
        int energyCost = 20;

        if (energy >= energyCost && numbOfBandages > 0) {
            // anropa metoden useEnergy() från parent class
            useEnergy(energyCost);
            numbOfBandages--;

            target.hp += healingPower;

            if (target.hp > 100) {
                target.hp = 100;
            }

            System.out.println(name + " healed " + target.name);
        } else {
            System.out.println(name + " cannot heal right now!");

            /* if (numbOfBandages <= 0) {
                System.out.println(name + " has no bandages left and cannot heal!");
            } */
        }
    }
}

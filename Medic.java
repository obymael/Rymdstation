/** Medic
 * - ärver från CrewMember
 * - kan återställa hp hos skadade crewmembers
 */

public class Medic extends CrewMember {
    // Static final KONSTANTER för att undvika magic numbers (lättare att ändra och hålla reda på)
    private static final int HEAL_ENERGY_COST = 20;
    private static final int DEFAULT_HEALING_POWER = 20;
    private static final int START_BANDAGES = 3;

    int healingPower;
    int numbOfBandages;

    /**
     * Konstruktor för att skapa en medic
     */
    public Medic(String name) {
        super(name);
        this.healingPower = DEFAULT_HEALING_POWER;
        this.numbOfBandages = START_BANDAGES;
    }

    /**
     * metod för att heala en crewmember
     * - public så att metoden kan anropas från andra klasser
     * - använder boolean för att kunna tala om ifall behandlingen lyckades eller inte
     *      (metoden returnerar då antingen sant eller falskt)
     */
    public boolean heal(CrewMember target) {
        // kolla condition som gör att det inte kommer gå att heala
        if (!isConscious() || energy < HEAL_ENERGY_COST || numbOfBandages <= 0 || target.hp >= MAX_HP || !target.isConscious()) {
            System.out.println(name + " cannot treat " + target.name + " (check HP, energy and bandage levels).");
            return false;
        }

        // begin healing process ...
        int hpBefore = target.hp; // spara för utskrift
        useEnergy(HEAL_ENERGY_COST); // medics energi minskar med 20
        numbOfBandages--; // använd bandage (minskar med 1)

        //target.hp += healingPower; // heala med 20
        target.hp = target.hp + healingPower; // samma sak som den ovan

        if (target.hp > 100) {
            target.hp = 100;
        }


        System.out.println(name + " treats " + target.name + ": +" + (target.hp - hpBefore) + " HP (now " + target.hp + "/" + MAX_HP + ", bandages left: " + numbOfBandages + ").");
        return true;

        /* int energyCost = 20;

        if (energy >= energyCost && numbOfBandages > 0) {
            // anropa metoden useEnergy() från parent class
            useEnergy(energyCost);
            numbOfBandages--;

            target.hp += healingPower;

            if (target.hp > 100) {
                target.hp = 100;
            }

            System.out.println(name + " healed " + target.name + " with " + healingPower + " HP, current HP: " + target.hp);
        } else {
            System.out.println(name + " cannot heal right now!");

            if (numbOfBandages <= 0) {
                System.out.println(name + " has no bandages left and cannot heal!");
            }
        } */
    }
}

/** Doctor
 * - ärver från Medic (som i sin tur är en förlängning av crewmember)
 * - kan läka snabbare än en Medic
 * - har akutbehandling som läker hela skadan
 */

public class Doctor extends Medic {
    // Static final KONSTANTER för att undvika magic numbers (lättare att ändra och hålla reda på)
    private static final int DOCTOR_HEALING_POWER = 40;
    private static final int DOCTOR_BANDAGES = 5;
    private static final int EMERGENCY_ENERGY_COST = 30;
    private static final int START_EMERGENCY_KITS = 1;
    int emergencyKit;

    /**
     * konstruktor för att skapa en doktor
     */
    public Doctor(String name) {
        super(name);
        this.healingPower = DOCTOR_HEALING_POWER;
        this.numbOfBandages = DOCTOR_BANDAGES;
        this.emergencyKit = START_EMERGENCY_KITS;
    }

    /**
     * akutbehandling som återställer till fullt hp
     * - public så att metoden kan anropas från andra klasser
     * - använder boolean för att kunna tala om ifall behandlingen lyckades eller inte
     *      (metoden returnerar då antingen sant eller falskt)
     */
    public boolean emergencyHeal(CrewMember target) {

        // kolla condition som gör att det inte kommer gå att heala
        if (!isConscious() || energy < EMERGENCY_ENERGY_COST || emergencyKit <= 0 || target.hp >= MAX_HP) {
            System.out.println(name + " cannot use emergency treatment on " + target.name);
            return false; // behandlingen misslyckades
        }

        // begin healing process ...
        useEnergy(EMERGENCY_ENERGY_COST); // doktorns energi minskar med 30
        emergencyKit--; // använd kit (minskar antalet kit med -1)

        int restored = MAX_HP - target.hp; // spara mängden återställt hp för att kunna skriva ut

        target.hp = MAX_HP; // sätt hp till 100 på den som är healad 

        System.out.println(name + " uses an emergency kit on " + target.name + ": +" + restored + " HP (fully recovered).");
        return true; // behandlingen lyckades
    }
}

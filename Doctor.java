/** Doctor
 * - ärver från Medic
 * - kan läka snabbare än en Medic
 * - har akutbehandling som läker hela skadan
 */

public class Doctor extends Medic {
    int emergencyKit;

    /**
     * konstruktor
     */
    public Doctor(String name) {
        super(name);
        this.healingPower = 40;
        this.numbOfBandages = 5;
        this.emergencyKit = 1;
    }

    /**
     * akutbehandling som återställer till fullt hp
     */
    public void emergencyHeal(CrewMember target) {
        int energyCost = 30;

        if (energy >= energyCost && emergencyKit > 0) {
            // anropa metod för att använda energi
            useEnergy(energyCost);
            emergencyKit--;

            target.hp = 100; // återställ hp för crewmember

            System.out.println(name + " has healed " + target + " to full HP!");
        } else {
            System.out.println(name + " cannot perform emergency healing!");
        }
    }
}

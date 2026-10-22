/** SpaceStation
 * - själva rymdstationen som håller reda på sektionerna 
 * - samt vad som händer på stationen
 */

public class SpaceStation {
    // Static final KONSTANTER för att undvika magic numbers (lättare att ändra och hålla reda på)
    private static final int START_OXYGEN = 100;
    private static final int START_DAMAGE = 100;
    private static final int OXYGEN_LOSS = 20;
    private static final int AIRLOCK_ENERGY_COST = 20;
    private static final int AIRLOCK_DAMAGE = 35;
    private static final int ALARM_INCREASE = 1;
    private static final int MIN_DOOR_SKILL = 2; // engineering skill som krävs för att öppna dörren
    private static final int CRITICAL_HP = 80;
    int alarmLevel = 0;
    int damage = START_DAMAGE;
    int oxygenLevel = START_OXYGEN;

    private final Reactor reactor = new Reactor();
    private final DoorSystem labDoor = new DoorSystem();
    private final Section[] sections = {
        Section.AIRLOCK,
        Section.LAB,
        Section.REACTOR
    };

    public void startMission(CrewMember[] team) {
        System.out.println("=== WELCOME TO SPACE STATION 404 ===");
        System.out.println("Mission: cross the airlock, unlock the lab and repair the reactor.");
        System.out.println("\nCREW ROSTER:");
        showTeam(team);

        // Gå igenom varje enum-värde i vår array (bestämd ordning) för varje sektion i sektioner
        for (Section section : sections) {
            System.out.println("\n=== Entering: " + section + " ===");

            switch (section) {
                case AIRLOCK:
                    oxygenLevel = oxygenLevel - OXYGEN_LOSS; // minska syre nivå med 20 när vi går in
                    alarmLevel = alarmLevel + ALARM_INCREASE;

                    System.out.println("WARNING: Oxygen is leaking! Station oxygen -" + OXYGEN_LOSS + ".");

                    // Gå igenom varje crewmember i arrayen team som skapas i Main()
                    for (CrewMember member : team) {
                        member.useEnergy(AIRLOCK_ENERGY_COST); // varje crewmember förlorar 20 energi
                        System.out.println(member.name + " loses " + AIRLOCK_ENERGY_COST + " energy while crossing.");
                        //member.showStatus();
                    }

                    // En crewmember skadas i airlock och behöver vård
                    CrewMember injured = findByName(team, "Jennie");
                    if (injured == null) {
                        System.out.println("MISSION FAILED: Jennie is missing from the crew.");
                        return;
                    }

                    injured.takeDamage(AIRLOCK_DAMAGE);
                    System.out.println("Medical check: " + injured.name + " must have at least " + CRITICAL_HP + " HP to continue.");
                    if (injured.hp < CRITICAL_HP) {
                        Medic medic = findMedic(team);
                        if (medic != null) {
                            medic.heal(injured);
                        }
                    }

                    if (injured.hp < CRITICAL_HP) {
                        Doctor doctor = findDoctor(team);
                        if (doctor != null) {
                            doctor.emergencyHeal(injured);
                        }
                    }

                    if (injured.hp < CRITICAL_HP || oxygenLevel <= 0) {
                        System.out.println("MISSION FAILED: crew health or oxygen is too low.");
                        return;
                    }
                    
                    System.out.println("Airlock cleared. Medical check passed.");
                    break; // för att avbryta här annars skulle LAB köras samtidigt
                
                case LAB:
                    System.out.println("The lab door is broken! Engineer skill " + MIN_DOOR_SKILL + "+ required.");
                    boolean doorFixed = false;

                    // gå igenom array från först till sist (elin -> nathalie -> othman -> jennie)
                    for (CrewMember member : team) {
                        if (member instanceof Engineer) {
                            // instanceof säkerställer att objektet är en engineer innan typomvandling
                            // TODO: Förklara detta senare
                            Engineer engineer = (Engineer) member; // typecasting (downcasting) omvandlar referensen från CrewMember (parent) till Engineer (child) för att komma åt attribut o metoder

                            if (engineer.skillLevel >= MIN_DOOR_SKILL && engineer.repair(labDoor)) { // kollar om någon ingenjör har rätt skill level för att reparera dörren
                                doorFixed = true;
                                break; // sluta leta när dörren är lagad
                                //engineer.repair(labDoor);
                            }
                        }
                    }

                    if (!doorFixed) {
                        System.out.println("MISSION FAILED: Lab door is still locked.");
                        return;
                    }
                    
                    /* if (!labDoor.isRepaired()) {
                        System.out.println("MISSION FAILED! Lab door is still locked.");
                        return;
                    } */

                    System.out.println("Lab cleared. The team can now enter the reactor section.");
                    break; // utan Break här skulle REACTOR köras redan under LAB

                case REACTOR:
                    System.out.println("The reactor is unstable! An engineer must repair it.");
                    boolean reactorFixed = false;

                    // Reparera via samma metod o interface som dörren
                    for (CrewMember member : team) {
                        if (member instanceof Engineer) {
                            // instanceof säkerställer att objektet är en engineer innan typomvandling
                            Engineer engineer = (Engineer) member; // typecasting (downcasting) omvandlar referensen från CrewMember (parent) till Engineer (child) för att komma åt attribut o metoder

                            if (engineer.repair(reactor)) {
                                reactorFixed = true;
                                break; // sluta leta när dörren är lagad
                            }
                        }
                    }

                    if (!reactorFixed) {
                        System.out.println("MISSION FAILED: Reactor could not be repaired.");
                        return;
                    }


                    damage = 0; // stationens skada nollställs först när reaktorn är lagad
                    System.out.println("MISSION COMPLETE! The reactor is stable and Space Station 404 is saved!");
                    break;
            }
            showStatus();
        }
        System.out.println("\nFINAL CREW STATUS:");
        showTeam(team);
    }

    private CrewMember findByName(CrewMember[] team, String name) {
        for (CrewMember member : team) {
            if (member.name.equals(name)) {
                return member;
            }
        }
        return null;
    }

    private Medic findMedic(CrewMember[] team) {
        for (CrewMember member : team) {
            // Doctor är också mediv via arv, därför måste vi kontrollera så det inte är en doctor
            if (member instanceof Medic && !(member instanceof Doctor)) {
                return (Medic) member;
            }
        }
        return null;
    }

    private Doctor findDoctor(CrewMember[] team) {
        for (CrewMember member : team) {
            if (member instanceof Doctor) {
                return (Doctor) member;
            }
        }
        return null;
    }

    private void showTeam(CrewMember[] team) {
        for (CrewMember member : team) {
            member.showStatus();
        }
    }

    /**
     * metod som minskar stationens skada vid reparation
     * @param amount hur mycket skada som repareras
     */
    /* public void repairDamage(int amount) {
        damage -= amount;
        // kan också skrivas som:
        // damage = damage - amount;

        if (damage < 0) {
            damage = 0;
        }

    } */

    public void showStatus() {
        System.out.println("\n--- s t a t i o n  s t a t u s ---");
        System.out.println("| Station damage: " + damage);
        System.out.println("| Oxygen level: " + oxygenLevel);
        System.out.println("| Alarm level: " + alarmLevel);
        System.out.println("----------------------------------");
    }

}

/** Main
 * - härifrån kör vi programmet
 */
public class Main {
    public static void main(String[] args) {
        SpaceStation station = new SpaceStation();

        // en array av basklasstyp som kan innehålla olika subklasser (polymorphism)
        CrewMember [] team = {
            new Engineer("Elin", 1),
            new Medic("Nathalie"),
            new Doctor("Othman"),
            new Engineer("Jennie", 2),
            // new CrewMember("Anna") // kan inte instancieras eftersom den är abstrakt
        };

        station.startMission(team);

        /* Engineer engineer = new Engineer("Elin", 3);
        Medic medic = new Medic("Nathalie");
        Doctor doctor = new Doctor("Othman");

        // testa skada
        engineer.takeDamage(40);

        // testa healing
        medic.heal(engineer);

        // testa reparation
        engineer.repair(station);
        // engineer.repair(new Reactor());
        // engineer.repair(new DoorSystem());

        // visa status
        engineer.showStatus();
        medic.showStatus();
        doctor.showStatus();

        station.showStatus(); */
    }
}

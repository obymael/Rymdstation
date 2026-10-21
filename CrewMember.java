/** CrewMember (Teammedlem)
 * - basklass (parent)
 * - children: Engineer, Medic, Doctor
 * - den är abstract eftersom den ligger till grund för de andra klasserna
 * - vi kommer inte skapa någon generisk crewmember utan de ska ha någon av titlarna
 */

public abstract class CrewMember {

    // Variabler som varje CrewMember ska ha
    String name; // deklarerat en variabel av typen String
    int hp; // hur mycket skada teammedlemmen tål
    int energy;

    // Konstruktor som används för att skapa ett objekt
    public CrewMember (String name) {
        this.name = name;
        this.hp = 100; // intitierat den med värdet 100 (alla startar med 100 i hp)
        this.energy = 100;
    }

    /**
     * metod för att ta skada och beräkna nytt hp
     * @param damage
     */
    public void takeDamage(int damage) {
        hp = Math.max(0, hp - damage); // använder Math, 0 är för att hp inte kan vara negativt

        /* 
        hp = hp - damage;
        if (hp < 0) {
            hp = 0;
        } 
        */
    }

    /**
     * metod för att använda energi till att göra uppgifter
     * @param amount för att veta hur mycket energi som ska användas
     */
    public void useEnergy(int amount) {
        energy = Math.max(0, energy - amount);
    }
    
    public void showStatus() {
        System.out.println(name + " HP: " + hp + " Energy: " + energy);
    }
}

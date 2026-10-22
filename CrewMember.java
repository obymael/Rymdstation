/** CrewMember (Teammedlem)
 * - basklass (parent)
 * - children: Engineer, Medic, Doctor
 * - den är abstract eftersom den ligger till grund för de andra klasserna
 * - vi kommer inte skapa någon generisk crewmember utan de ska ha någon av titlarna
 */

public abstract class CrewMember {

    // Static final KONSTANTER för att undvika magic numbers (lättare att ändra och hålla reda på)
    public static final int MAX_HP = 100;
    public static final int MAX_ENERGY = 100;
    

    // Variabler som varje CrewMember ska ha
    String name; // deklarerat en variabel av typen String
    int hp; // hur mycket skada crewmembern tål
    int energy;

    // Konstruktor som används för att skapa ett objekt
    public CrewMember (String name) {
        this.name = name; // namnet måste specificeras när man skapar en ny crewmember
        this.hp = MAX_HP; // alla startar med 100 i HP
        this.energy = MAX_ENERGY;
    }

    /**
     * metod för att ta skada och beräkna nytt HP
     * - minskar HP men aldrig under 0
     * @param damage
     */
    public void takeDamage(int damage) {
        hp = Math.max(0, hp - damage); // använder Math, 0 är för att hp inte kan vara negativt

        /* kan också skrivas som... 
        hp = hp - damage;
        if (hp < 0) {
            hp = 0;
        } 
        */

        System.out.println(name + " takes " + damage + " damage (HP: " + hp + "/" + MAX_HP + ").");

    }

    /**
     * metod för att använda energi till att göra uppgifter
     * - kontrollerar först så att energin räcker till
     * @param amount för att veta hur mycket energi som ska användas
     */
    public void useEnergy(int amount) {
        energy = Math.max(0, energy - amount);
    }

    public boolean isConscious() {
        return hp > 0;
    }
    
    public void showStatus() {
        System.out.println(name + " (" + getClass().getSimpleName() + ") | HP: " + hp + "/" + MAX_HP + " | Energy: " + energy + "/" + MAX_ENERGY);
    }
}

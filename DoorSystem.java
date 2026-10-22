/**
 * Dörren är trasig tills att någon reparerar den
 * DoorSystem
 */
public class DoorSystem implements Repairable {

    private boolean repaired = false; // private skyddar objektets interna status

    @Override
    public void repair() {
        repaired = true;
        // System.out.println("Lab door repaired!");
    }

    @Override
    public boolean isRepaired() {
        return repaired;
    }

    @Override
    public String getSystemName() {
        return "lab door";
    }
}
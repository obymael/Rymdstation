public class Reactor implements Repairable {
    private boolean repaired = false;

    @Override
    public void repair() {
        repaired = true;
        //System.out.println("Reactor repaired!");
    }

    @Override
    public boolean isRepaired() {
        return repaired;
    }

    @Override
    public String getSystemName() {
        return "reactor";
    }
}

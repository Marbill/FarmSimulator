package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/* @author marbi */
public class Farm implements Alive {

    private String owner;
    private Barn barn;
    private List<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Farm owner: " + this.owner + "\nBarn bulk tank: " + this.barn.getBulkTank() + "\n" + this.getCows();
    }

    public void addCow(Cow cow) {
        cows.add(cow);
    }

    private String getCows() {
        String print = "";
        if (this.cows.isEmpty()) {
            print = "No cows.";
        }

        print = "Animals:\n";

        for (Cow cow : cows) {
            print += "        " + cow + "\n";
        }

        return print;
    }

    public void manageCows() {
        this.barn.takeCareOf(cows);
    }

    @Override
    public void liveHour() {
        for (Cow cow : cows) {
            cow.liveHour();
        }
    }

    public void installMilkingRobot(MilkingRobot robot) {
        this.barn.installMilkingRobot(robot);
    }

}

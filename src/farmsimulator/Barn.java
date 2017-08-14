package farmsimulator;

import java.util.Collection;

/* @author marbi */
public class Barn {

    private BulkTank tank;
    private MilkingRobot robot;

    public Barn(BulkTank tank) {
        this.tank = tank;
    }

    public BulkTank getBulkTank() { //returns the barn's bulk tank
        return this.tank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) { //installs a milking robot and connects it to the barn bulk tank
        this.robot = milkingRobot;
        this.robot.setBulkTank(this.tank);

    }

    public void takeCareOf(Cow cow) { //milks the parameter cow with the help of the milking robot, the method throws an IllegalStateException if the milking robot hasn't been installed
        if (this.robot == null) {
            throw new IllegalStateException("Barn hasn't installed robot");
        }

        robot.milk(cow);
    }

    public void takeCareOf(Collection<Cow> cows) { //milks the parameter cows with the help of the milking robot, the method throws an IllegalStateException if the milking robot hasn't been installed
        if (robot == null) {
            throw new IllegalStateException("Barn hasn't installed robot");
        }

        for (Cow cow : cows) {
            robot.milk(cow);
        }
    }

    @Override
    public String toString() { //returns the state of the bulk tank contained by the barn
        return this.tank.toString();
    }

}

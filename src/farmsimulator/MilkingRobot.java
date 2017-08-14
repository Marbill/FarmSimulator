package farmsimulator;

/* @author marbi */
public class MilkingRobot {

    private BulkTank tank;

    public MilkingRobot() { //creates a new milking robot
        tank = null;

    }

    public BulkTank getBulkTank() { //returns the connected bulk tank, or a null reference, if the tank hasn't been installed
        return this.tank;
    }  

    public void setBulkTank(BulkTank tank) { //installs the parameter bulk tank to the milking robot
        this.tank = tank;
    }

    public void milk(Milkable milkable) { //milks the cow and fills the connected bulk tank; the method returns an IllegalStateException is no tank has been fixed
        if (this.tank == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }

        this.tank.addToTank(milkable.milk());
    }

}

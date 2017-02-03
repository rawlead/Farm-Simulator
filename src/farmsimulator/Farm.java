package farmsimulator;

import java.util.Collection;
import java.util.LinkedList;

public class Farm implements Alive {
    private String owner;
    private Collection<Cow> farmCows;
    private Barn barn;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.farmCows = new LinkedList<Cow>();
    }

    public String getOwner() {
        return this.owner;
    }

    public void installMilkingRobot(MilkingRobot robot) {
        this.barn.installMilkingRobot(robot);
    }

    @Override
    public String toString() {
        String howManyCows = "";
        if (farmCows.isEmpty())
            howManyCows = "No cows.";
        else {
            howManyCows = "Animals:\n"
                    + getCowsString();
        }
        return "Farm owner: " + getOwner()
                + "\nBarn bulk tank: " + barn
                + "\n" + howManyCows;
    }

    private String getCowsString() {
        String result = "";
        for (Cow cow : farmCows) {
            result += "        " + cow + "\n";
        }
        return result;
    }

    public void addCow(Cow cow) {
        this.farmCows.add(cow);
    }

    @Override
    public void liveHour() {
        for (Cow cow : farmCows)
            cow.liveHour();
    }

    public void manageCows() {
        barn.takeCareOf(farmCows);
    }
}

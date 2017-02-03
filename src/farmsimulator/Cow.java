package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive{
    private String name;
    private Random random = new Random();
    private double udderCapacity;
    private double udderAmount;
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this.name = generateAName();
        this.udderCapacity = generateACapacity();
    }

    public Cow(String name) {
        this.name = name;
        this.udderCapacity = generateACapacity();
    }

    private String generateAName() {
        int index = this.random.nextInt(NAMES.length);
        return NAMES[index];
    }

    private double generateACapacity() {
        return 15 + this.random.nextInt(26);
    }

    public String getName() {
        return this.name;
    }

    public double getCapacity() {
        return this.udderCapacity;
    }

    public double getAmount() {
        return this.udderAmount;
    }

    @Override
    public String toString() {
        return getName() + " " + Math.ceil(getAmount()) + "/" + Math.ceil(getCapacity());
    }

    @Override
    public void liveHour() {
        double producedMilk = 0.0;
        producedMilk += this.random.nextDouble() * 1.3 + 0.7;
        if (getAmount() + producedMilk > getCapacity()) {
            this.udderAmount = getCapacity();
        } else
            this.udderAmount += producedMilk;

    }

    @Override
    public double milk() {
        double taken = getAmount();
        this.udderAmount = 0.0;
        return taken;
    }
}

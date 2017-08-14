package farmsimulator;

import java.util.Random;

/* @author marbi */
public class Cow implements Milkable, Alive {

    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    private String name;
    private double capacity;
    private double volume;
    private Random rand;

    public Cow() {  //creates a new cow with a random name
        rand = new Random();
        int r = rand.nextInt(NAMES.length);
        this.name = NAMES[r];
        this.capacity = 15 + new Random().nextInt(26);
        this.volume = 0.0;
    }

    public Cow(String name) { //creates a new cow with its given name
        this.name = name;
        this.capacity = 15 + new Random().nextInt(26);
        this.volume = 0.0;
    }

    public String getName() { //returns the cow's name
        return this.name;

    }

    public double getCapacity() { //returns the udder capacity
        return this.capacity;
    }

    public double getAmount() { //returns the amount on milk available in the cow's udders
        return this.volume;
    }

    @Override
    public String toString() {//returns a String which describes the cow (see the example below)
        return this.name + " " + Math.ceil(this.volume) + "/" + this.capacity;
    }

    @Override
    public double milk() {
        double totalMilk = this.volume;
        this.volume = 0.0;

        return totalMilk;
    }

    @Override
    public void liveHour() {
        //double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        //double hourMilk = Math.ceil(0.7 + new Random().nextDouble() * 2.0);
        double hourMilk = 0.7 + (2.0 - 0.7) * new Random().nextDouble();
        if (hourMilk <= this.capacity - this.volume) {
            this.volume += hourMilk;
        } else {
            this.volume = this.capacity;
        }
    }

}

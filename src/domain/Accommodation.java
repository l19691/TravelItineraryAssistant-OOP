package domain;

public class Accommodation {
    private String name;
    private String address;
    private double cost;

    public Accommodation(String name, String address, double cost) {
        this.name = name;
        this.address = address;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name + " at " + address + " (€" + cost + ")";
    }
}

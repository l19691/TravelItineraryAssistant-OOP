package domain;

public class Budget {
    private double limit;
    private double spent;

    public Budget() {
        this.limit = 1000.0;
        this.spent = 0.0;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void addSpent(double amount) {
        this.spent += amount;
    }

    public double getLimit() {
        return limit;
    }

    public double getSpent() {
        return spent;
    }

    public double getRemaining() {
        return limit - spent;
    }

    @Override
    public String toString() {
        return "Budget Limit: €" + limit + ", Spent: €" + spent + ", Remaining: €" + getRemaining();
    }
}

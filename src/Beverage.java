public class Beverage extends Product {

    private double flOunces;

    public Beverage(String name, double price, double flOunces)
    {
        super(name, price);
        if(flOunces < 0)
        {
            throw new IllegalArgumentException("FlOunces cannot be negative");
        }else {
            this.flOunces = flOunces;
        }
    }
    public Beverage(String name, double price) {
        super(name, price);
    }
    public double getFlOunces() {
        return flOunces;
    }

    public void setFlOunces(double flOunces) {
        if(flOunces < 0)
        {
            throw new IllegalArgumentException("FlOunces cannot be negative");
        }else {
            this.flOunces = flOunces;
        }
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "flOunces=" + flOunces +
                "} " + super.toString();
    }
}

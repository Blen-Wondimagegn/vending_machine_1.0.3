public class Product {

    private String name;

    private double price;

    public Product(){
        this.name ="";
        this.price = 0.0;
    }
    public Product(String name, double price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }else if (price < 0)
        {
            throw new IllegalArgumentException("Invalid Price");
        }else{
            this.name = name;
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be Null or Empty");
        }else{
            this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price Cannot Be Negative");
        }else {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class Snack extends Product{

    private boolean isVegan;

    public Snack(String name, int quantity, boolean isVegan) {
        super(name, quantity);
        this.isVegan = isVegan;
    }
    public Snack(String name, double price) {
        super(name, price);
    }
    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "isVegan=" + isVegan +
                super.toString()+
               "}";

    }
}

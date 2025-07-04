package fawry.models;

public abstract class nonExpirableProduct extends Product {

    public nonExpirableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public boolean isExpirable() {
        return false;
    }
}

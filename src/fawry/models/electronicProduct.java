package fawry.models;

import fawry.Interfaces.Shippable;

public class electronicProduct extends nonExpirableProduct implements Shippable {
    //Assume Weight is in Grams
    private double weight;

    public electronicProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

}

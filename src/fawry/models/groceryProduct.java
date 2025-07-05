package fawry.models;

import fawry.Interfaces.Shippable;

import java.time.LocalDate;

public class groceryProduct extends expirableProduct implements Shippable {
    // Assume Weight is in Grams
    private double weight;

    public groceryProduct(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }
}

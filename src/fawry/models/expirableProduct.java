package fawry.models;

import java.time.LocalDate;

public abstract class expirableProduct extends Product{
    private LocalDate expirationDate;

    public expirableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name,price,quantity);
        this.expirationDate = expirationDate;
    }

    public boolean isExpirable(){
        return true;
    }

    public boolean isExpired(){
        return LocalDate.now().isAfter(expirationDate);
    }
}

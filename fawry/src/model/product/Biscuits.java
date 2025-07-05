package model.product;

import interfaces.Expirable;
import interfaces.Shippable;
import java.time.LocalDate;

public class Biscuits extends Product implements Expirable, Shippable {
    private double weight;
    private LocalDate expiryDate;

    public Biscuits(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;

    }

    public double getWeight() {
        return weight;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

}

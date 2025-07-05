package service;

public class ShippingItem {
    private String name;
    private double unitWeight;
    private int quantity;

    public ShippingItem(String name, double unitWeight, int quantity) {
        this.name = name;
        this.unitWeight = unitWeight;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalWeight() {
        return unitWeight * quantity;
    }

    public double getShippingCost() {
        return Math.ceil(getTotalWeight() * 2); // shipping cost is 2 EGP per kg (rounded up)
    }
}

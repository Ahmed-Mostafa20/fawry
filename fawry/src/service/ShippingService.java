package service;

import java.util.List;

public class ShippingService {
    public static double ship(List<ShippingItem> items) {
        if (items.isEmpty())
            return 0;

        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        double totalShipping = 0;

        for (ShippingItem item : items) {
            double weight = item.getTotalWeight();
            double shippingCost = item.getShippingCost();

            System.out.println(item.getQuantity() + "x " + item.getName()
                    + "    " + (weight * 1000) + "g   Shipping: " + shippingCost + " EGP");

            totalWeight += weight;
            totalShipping += shippingCost;
        }

        System.out.println("Total package weight: " + totalWeight + " kg\n");

        return totalShipping;
    }
}

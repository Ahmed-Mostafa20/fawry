package model.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.product.Product;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        if (quantity <= product.getQuantity()) {
            items.add(new CartItem(product, quantity));
        } else {
            System.out.println("Error: Not enough stock for " + product.getName());
        }
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

}

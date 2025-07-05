package service;

import interfaces.*;
import model.cart.CartItem;
import model.product.Product;
import model.user.Customer;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    public static void checkout(Customer customer) {
        var cart = customer.getCart();

        if (cart.isEmpty()) {
            System.out.println("Error: Your cart is empty.");
            return;
        }

        List<CartItem> items = cart.getItems();
        double subtotal = 0;
        List<ShippingItem> shippingItems = new ArrayList<>();

        for (CartItem item : items) {
            Product product = item.getProduct();

            // check expiry
            if (product instanceof Expirable expProduct && expProduct.isExpired()) {
                System.out.println("Error: Product " + product.getName() + " is expired.");
                return;
            }

            // check stock
            if (item.getQuantity() > product.getQuantity()) {
                System.out.println("Error: Not enough quantity for " + product.getName());
                return;
            }

            subtotal += item.getTotalPrice();

            if (product instanceof Shippable shipProduct) {
                int quantity = item.getQuantity();
                shippingItems.add(new ShippingItem(product.getName(), shipProduct.getWeight(), quantity));
            }
        }

        double shippingFee = ShippingService.ship(shippingItems);
        double total = subtotal + shippingFee;

        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        customer.deductBalance(total);

        // update stock
        for (CartItem item : items) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName()
                    + "     " + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal         " + subtotal);
        System.out.println("Shipping         " + shippingFee);
        System.out.println("Amount           " + total);
        System.out.println("Remaining Balance: " + customer.getBalance());
    }
}

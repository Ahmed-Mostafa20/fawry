import model.product.*;
import model.user.*;
import service.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Ahmed", 1000);

        Cheese Mozzarella = new Cheese("Mozzarella", 20, 20, 1, LocalDate.of(2026, 12, 31));
        Biscuits oreo = new Biscuits("Oreo", 2, 50, .3, LocalDate.of(2028, 8, 3));
        TV samsung = new TV("Samsumng", 200, 10, 20);
        ScratchCard mezCard = new ScratchCard("MezCard", 50, 5);
        customer.getCart().addProduct(Mozzarella, 2);
        customer.getCart().addProduct(oreo, 20);
        customer.getCart().addProduct(samsung, 3);
        customer.getCart().addProduct(mezCard, 1);
        CheckoutService.checkout(customer);

    }
}

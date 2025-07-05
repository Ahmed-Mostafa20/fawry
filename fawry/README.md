# Fawry Quantum Internship - E-Commerce System

## Description

A Java console-based e-commerce system that allows customers to:
- Add products to a cart with limited quantity
- Handle expirable and shippable products
- Checkout with validation (stock, expiry, balance)
- Calculate shipping: 2 EGP per 1 kg
- Print invoice and shipping notice in the console

## Technologies

- Java 17
- VS Code
- OOP (Object-Oriented Programming)

## Folder Structure
src/
├── Main.java
├── model/
│   ├── product/
│   │   ├── Product.java
│   │   ├── Cheese.java
│   │   ├── TV.java
│   │   ├── Biscuits.java
│   │   └── ScratchCard.java
│   ├── user/
│   │   └── Customer.java
│   ├── cart/
│   │   ├── Cart.java
│   │   └── CartItem.java
├── interfaces/
│   ├── Shippable.java
│   └── Expirable.java
└── service/
    ├── CheckoutService.java
    ├── ShippingService.java
    └── ShippingItem.java


Each folder represents a specific part of the system:
- `model.product`: all product types and subtypes (e.g., Cheese, TV, Biscuits, etc.)
- `model.cart`: cart and cart item logic
- `model.user`: customer-related data
- `interfaces`: shared behaviors implemented by products (e.g., Shippable, Expirable)
- `service`: business logic such as checkout process and shipping handling

## How to Run

1. Compile:
javac src/**/*.java

2. Run:
java -cp src Main
 
## Example Test Case

Customer: balance = 1000 EGP  
Products:
- 2x Mozzarella (1kg each)
- 20x Oreo (0.3kg each)
- 3x Samsung TV (20kg each)
- 1x MezCard (non-shippable)

## Expected Output

- Subtotal: 730 EGP  
- Shipping: 136 EGP  
- Total: 866 EGP  
- Remaining Balance: 134 EGP  
- Shipping weight: 68 kg  
- Shipping breakdown printed in the console  
- Invoice printed with product details

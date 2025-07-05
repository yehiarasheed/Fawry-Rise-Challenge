## Fawry Rise Journey — Quantum Internship Challenge

### Overview

This repository contains my implementation of the **Fawry Rise Journey — Full Stack Development Internship Challenge 3**.
The goal is to design and build a simple, robust e-commerce system in **Java**, demonstrating core **object-oriented programming** concepts and proper handling of real-world use cases and edge cases.

---

### Features

* **Product Modeling**

  * Abstract `Product` class located in `src/fawry/models`.
  * Two subclasses:

    * `ExpirableProduct` — for items that can expire (e.g., groceries).
    * `NonExpirableProduct` — for items that do not expire (e.g., electronics, mobile scratch cards).
  * Concrete implementations:

    * `GroceryProduct` (extends `ExpirableProduct`).
    * `ElectronicProduct` (extends `NonExpirableProduct`).
    * `MobileScratchCard` (extends `NonExpirableProduct`).

* **Cart System**

  * `Cart` class in `src/fawry/cart` handles adding products, updating quantities, and enforcing stock rules.

* **Shipping Service**

  * `ShippingService` class in `src/fawry/shipping` generates and prints shipping notices for shippable products.

* **Interfaces**

  * `Shippable` interface (`src/fawry/interfaces`) defines:

    ```java
    String getName();
    double getWeight();
    ```

* **Driver and Checkout**

  * `Fawry` class (`src/fawry`) is the main driver.
  * Contains the `checkout` method.
  * Includes comprehensive **test cases** in `main()` to verify all success and failure scenarios.
  * Test cases are organized by sections for clarity.

---

### Example Output

Example shipping notice and checkout receipt:

```
** Shipment Notice **
2x Cheese - 400.0g
1x Biscuits - 700.0g
Total package weight: 1.1kg

** Checkout Receipt **
2x Cheese - 200.0
1x Biscuits - 150.0
----------------------
Subtotal: 350.0
Shipping: 30.0
Total Paid: 380.0
Remaining Balance: 120.0
```

The system:

* Rejects checkout if the cart is empty.
* Validates sufficient balance.
* Prevents adding items that are out of stock or expired.
* Separates shippable and non-shippable products.

---

### Project Structure

```
src/fawry/
 ├── Fawry.java          # Driver class with checkout logic and test cases
 ├── interfaces/
 │    └── Shippable.java # Interface for shippable products
 ├── models/
 │    ├── Product.java
 │    ├── ExpirableProduct.java
 │    ├── NonExpirableProduct.java
 │    ├── GroceryProduct.java
 │    ├── ElectronicProduct.java
 │    └── MobileScratchCard.java
 ├── cart/
 │    └── Cart.java
 └── shipping/
      └── ShippingService.java
```

---

### Requirements

* Java 8 or later.
* IntelliJ IDEA or Eclipse recommended.

---

### How to Run

#### 1. Clone the Repository

```bash
git clone https://github.com/yehiarasheed/Fawry-Rise-Challenge.git
```

---

#### 2. Open in IntelliJ IDEA

1. Open **IntelliJ IDEA**.
2. Click **Open** and select the cloned project folder.
3. Let IntelliJ index the project.
4. Right-click `Fawry.java` in the `src/fawry` package.
5. Click **Run 'Fawry.main()'**.
6. Check the console output for all test case results.

---

#### 3. Open in Eclipse

1. Open **Eclipse IDE**.
2. Click **File > Import > Existing Projects into Workspace**.
3. Browse to the cloned project folder and click **Finish**.
4. In the **Package Explorer**, expand the `src` folder.
5. Right-click `Fawry.java` in `src/fawry`.
6. Select **Run As > Java Application**.
7. Check the console output for all test cases.

---

### Notes

* The project demonstrates **clean separation of concerns**, **inheritance**, **interfaces**, and proper **error handling**.
* Console output verifies correct behavior and all edge cases.
* No AI-generated code was used to implement the core logic.

---

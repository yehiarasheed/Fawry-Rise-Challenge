package fawry;

import fawry.Interfaces.Shippable;
import fawry.cart.Cart;
import fawry.customer.Customer;
import fawry.models.Product;
import fawry.models.groceryProduct;
import fawry.models.mobileScratchCards;
import fawry.shipping.ShippingService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;

public class Fawry {
    // Assume Shipping Cost is Constant for simplicity
    private static double shippingCost = 30;
    private Customer customer;


    // Assume Default shipping cost is 30 for simplicity, unless stated otherwise.
    public Fawry(Customer customer){
        this.customer = customer;
    }

    public Fawry(Customer customer, double shippingCost) {
        this.customer = customer;
        this.shippingCost = shippingCost;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public static void checkout(Customer customer, Cart cart) {
        double subtotal = 0;
        LinkedList<Shippable> shippedProducts = new LinkedList<>();

        if (cart.isEmpty()) {
            System.err.println("Error Occurred during Checkout: Cart is empty, please add items to your Cart.");
        } else {
            HashMap<Product, Integer> cartItems = cart.getCartItems();
            for (Product product : cartItems.keySet()) {
                if (product instanceof Shippable)
                    shippedProducts.add((Shippable) product);
                subtotal += product.getPrice()*cartItems.get(product);
            }
            if(shippedProducts.isEmpty()){
                shippingCost = 0;
            }
            if(customer.getBalance()<(subtotal+shippingCost)){
                System.err.println("Error Occurred during Checkout: Insufficient Balance, please recharge your balance.");
            }
            else{
                if(!shippedProducts.isEmpty()){
                    ShippingService wasalha = new ShippingService(cartItems);
                    wasalha.ship(shippedProducts);
                }
                System.out.println("** Checkout receipt **");
                for(Product product : cartItems.keySet()){
                    System.out.print(cartItems.get(product) + "x " + product.getName());
                    for(int i = 0; i < (15-product.getName().length()); i++)
                        System.out.print(" ");
                    System.out.print(cartItems.get(product)*product.getPrice());
                    System.out.println();
                }
                System.out.println("----------------------");
                System.out.print("Subtotal");
                for(int i = 0; i < (15-("Subtotal").length()); i++)
                    System.out.print(" ");
                System.out.print(subtotal);
                System.out.println();
                System.out.print("Shipping");
                for(int i = 0; i < (15-("Shipping").length()); i++)
                    System.out.print(" ");
                System.out.print(shippingCost);
                System.out.println();
                System.out.print("Amount");
                for(int i = 0; i < (15-("Amount").length()); i++)
                    System.out.print(" ");
                System.out.print(subtotal + shippingCost);
                customer.deductBalance(subtotal + shippingCost);
                System.out.println();
                System.out.println("Remaining Balance: " + customer.getBalance());
            }
        }
    }
    public static void main(String[] args) {
        Customer y = new Customer("1","Yehia Rasheed", "Smart Village", "0100", 500);
        // To Test Insufficient balance (Corner Case 1)
//        Customer y = new Customer("1","Yehia Rasheed", "Smart Village", "0100", 379);
        Fawry fawry = new Fawry(y);
        // To Test Expiry Change the LocalDate to an old Date (Corner Case 2)
        // To Test Out Of Stock Error, change the Quantity to 0 or Even Less than Zero (Corner Case 3)
        //To Test the Individual shipping weights as well as the Total Package Weight, adjust individual product weights
        //to be 1000 grams or more to see kg instead of g for grams ex: a 1000 gram product should be shown as 1 kg for simplicity (hidden case)
        groceryProduct cheese = new groceryProduct("Cheese", 100, 2, LocalDate.parse("2025-12-20"),200);
        groceryProduct biscuits = new groceryProduct("Biscuits", 150, 3, LocalDate.parse("2025-07-07"),700);
        mobileScratchCards scratchCards = new mobileScratchCards("kalemny",15,2);
        Cart myCart = new Cart();
        // To Test an empty Cart, Comment both lines below that add products to cart (Corner Case 4)
        myCart.addProduct(cheese,2);
        myCart.addProduct(biscuits,1);
        //To Test the Shipping cost being zero, do not add the cheese and biscuits (Comment the previous two lines) and only add the Scratch Cards
//        myCart.addProduct(scratchCards,2);
        checkout(y,myCart);

    }
}

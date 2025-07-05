package fawry.cart;

import fawry.models.Product;
import fawry.models.expirableProduct;

import java.util.HashMap;

public class Cart {
    private HashMap<Product, Integer> cartItems;

    public Cart() {
        this.cartItems = new HashMap<>();
    }

    public boolean addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            return false;
        }

        if (product.getQuantity() == 0) {
            System.err.println("Error Occurred while Adding Product to Cart: " + product.getName() + " is Out of Stock, please try again later.");
            return false;
        }

        if (product.isExpirable() && ((expirableProduct)product).isExpired()) {
            System.err.println("Error Occurred while Adding Product to Cart: " + product.getName() + " is Expired, please try again later.");
            return false;
        }

        if(quantity <= product.getQuantity()){
            product.setQuantity(product.getQuantity() - quantity);
            cartItems.put(product, quantity);
            return true;
        }
        else{
            System.err.println("Error Occurred while Purchasing the Product: " + product.getName() + " due to insufficient quantity.");
        }
        return false;
    }

    public boolean removeProduct(Product product) {
        if(cartItems.containsKey(product)){
            product.setQuantity(product.getQuantity()+cartItems.get(product));
            cartItems.remove(product);
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return cartItems.isEmpty();
    }

    public HashMap<Product, Integer> getCartItems() {
        return cartItems;
    }
}

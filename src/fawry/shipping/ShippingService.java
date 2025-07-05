package fawry.shipping;

import fawry.Interfaces.Shippable;
import fawry.models.Product;

import java.util.HashMap;
import java.util.LinkedList;

public class ShippingService {
    private HashMap<Product,Integer> cartItems;

    public ShippingService(HashMap<Product,Integer> cartItems) {
        this.cartItems = cartItems;
    }
    public void ship(LinkedList<Shippable> shippedProducts){
        double totalWeight = 0.0;
        System.out.println("** Shipment notice **");
        for(Shippable s : shippedProducts){
            Product p = (Product) s;
            totalWeight += s.getWeight()*cartItems.get(p);
            System.out.print(cartItems.get(p) + "x " + p.getName());
            for(int i = 0; i < (15-p.getName().length()); i++)
                System.out.print(" ");
            String printedWeight = (cartItems.get(p)*s.getWeight())>=1000?(cartItems.get(p)*s.getWeight())/1000 + "kg": (cartItems.get(p)*s.getWeight()) + "g";
            System.out.print(printedWeight);
            System.out.println();
        }
        String printedTotalWeight = (totalWeight>=1000)?totalWeight/1000 + "kg":totalWeight + "g";
        System.out.println("Total package weight: " + printedTotalWeight);
        System.out.println();
    }
}

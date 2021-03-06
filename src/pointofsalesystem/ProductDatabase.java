/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;

/**
 * This class represents a simulation of a database that holds information in
 * products. It is responsible for managing specific product information and
 * searching for a specific product when provided a productID.
 *
 * @author Josh
 * @version 1.00
 *
 */
public class ProductDatabase {

    private final Product[] products = {
        new Product("A1504", "Men's Baseball Cap ", 15.00, new FlatRateDiscount(3.00)),
        new Product("T4339", "Nike Basketball    ", 20.00, new PercentOffDiscount(.10)),
        new Product("B7821", "Men's (3)T-Shirt   ", 12.00, new QuantityDiscount(3, .20)),
        new Product("C5933", "Woman's (3) Socks  ", 10.00, new QuantityDiscount(3, .25))
    };

    public Product findProductByID(String productID) {
        Product product = null;
        //validation needed

        for (Product p : products) {
            if (productID.equals(p.getProductID())) {
                product = p;
            }
        }
        return product;
    }

    public static void main(String[] args) {

        ProductDatabase db = new ProductDatabase();

        System.out.println(db.findProductByID("A1504").getProductDescription());
    }
}

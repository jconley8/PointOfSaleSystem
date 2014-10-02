/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;

/**
 *
 * @author Josh
 */
public class Product {

    private String productID;
    private String productDescription;
    private double productPrice;
    private DiscountStrategy discount;

    public Product(String productID, String productDescription, double productPrice, DiscountStrategy discount) {
        //validation needed
        this.productID = productID;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.discount = discount;
    }

    public final String getProductID() {
        return productID;
    }

    public final void setProductID(String productID) {
        if (productID == null || productID.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.productID = productID;
    }

    public final String getProductDescription() {
        return productDescription;
    }

    public final void setProductDescription(String productDescription) {
        //validation needed
        this.productDescription = productDescription;
    }

    public final double getProductPrice() {
        return productPrice;
    }

    public final void setProductPrice(double productPrice) {
        //validation needed
        this.productPrice = productPrice;
    }

    public final DiscountStrategy getDiscount() {
        return discount;
    }

    public final void setDiscount(DiscountStrategy discount) {
        //validation needed
        this.discount = discount;
    }

}

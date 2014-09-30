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

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        if(productID == null || productID.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.productID = productID;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        //validation needed
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        //validation needed
        this.productPrice = productPrice;
    }

    public DiscountStrategy getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountStrategy discount) {
        //validation needed
        this.discount = discount;
    }

}

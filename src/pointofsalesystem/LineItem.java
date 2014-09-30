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
public class LineItem {

    private double subtotal;
    private double grandTotal;
    private double quantity;
    private Product product;
    ProductDatabase db = new ProductDatabase();

    public LineItem(String productID, double quantity) {
        this.quantity = quantity;
        this.product = db.findProduct(productID);
    }

    public double getCalculatedGrandTotal() {
        return (db.findProduct(product.getProductID()).getProductPrice());
    }

    public double getCalculatedSubTotal() {
        return product.getProductPrice() * quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        //validation needed
        this.subtotal = subtotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        //validation needed
        this.grandTotal = grandTotal;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        //validation needed
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        //validation needed
        this.product = product;
    }

}

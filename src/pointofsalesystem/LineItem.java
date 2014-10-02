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
        //validation needed
        this.quantity = quantity;
        this.product = db.findProductByID(productID);
    }

    public final double getCalculatedGrandTotal() {
        return (db.findProductByID(product.getProductID()).getProductPrice());
    }

    public final double getCalculatedSubTotal() {
        return product.getProductPrice() * quantity;
    }

    public final double getSubtotal() {
        return subtotal;
    }

    public final void setSubtotal(double subtotal) {
        //validation needed
        this.subtotal = subtotal;
    }

    public final double getGrandTotal() {
        return grandTotal;
    }

    public final void setGrandTotal(double grandTotal) {
        //validation needed
        this.grandTotal = grandTotal;
    }

    public final double getQuantity() {
        return quantity;
    }

    public final void setQuantity(double quantity) {
        //validation needed
        this.quantity = quantity;
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        //validation needed
        this.product = product;
    }

}

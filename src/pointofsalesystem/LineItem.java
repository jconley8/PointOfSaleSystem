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
    private double taxRate = .05;
    private double quantity;
    private Product product;
    ProductDatabase db = new ProductDatabase();

    public LineItem(String productID, double quantity) {
        this.quantity = quantity;
        this.product = db.findProduct(productID);
    }

    public double getCalculatedTax (String productID) {
        //validation needed
        return db.findProduct(productID).getProductPrice() * taxRate;
    }
   
    public double getCalculatedGrandTotal(String productID) {
        //validation needed
        return (db.findProduct(productID).getProductPrice() + getCalculatedTax(productID));
    }

    public double getCalculatedSubTotal () {
        //validation needed
        return (getCalculatedGrandTotal(product.getProductID()) * quantity) + getCalculatedTax(productID);
    }
    
    
    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
    
    
    
}

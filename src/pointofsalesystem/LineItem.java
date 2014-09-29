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

    public LineItem(String productID, double quantity) {
        this.quantity = quantity;
    }
    
    
    
    
}

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
public interface ReceiptOutputStrategy {
 
    public abstract void outputReceipt();
    public abstract void addLineItem(String productID, double quantity);
}

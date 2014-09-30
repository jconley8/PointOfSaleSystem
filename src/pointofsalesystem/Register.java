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
public class Register {

    public Register() {
    
    }

    Receipt receipt = new Receipt();

    public void ScanItem(String productID, double quantity) {
        //validation needed        
        receipt.addLineItem(productID, quantity);

    }

    public void printReceipt() {
        receipt.outputReceipt();
    }

}

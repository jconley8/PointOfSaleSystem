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

    private String customerID;
    private ReceiptOutputStrategy outputStrategy;

    public Register(ReceiptOutputStrategy outputStrategy) {
        this.outputStrategy = outputStrategy;
    }

    public final void startSale(String customerID) {
        this.customerID = customerID;
    }

    public final void ScanItem(String productID, double quantity) {
        //validation needed        
        outputStrategy.addLineItem(productID, quantity);

    }

    public final void printReceipt() {
        outputStrategy.outputReceipt(customerID);
    }

    public final ReceiptOutputStrategy getOutputStrategy() {
        return outputStrategy;
    }

    public final void setOutputStrategy(ReceiptOutputStrategy outputStrategy) {
        this.outputStrategy = outputStrategy;
    }

}

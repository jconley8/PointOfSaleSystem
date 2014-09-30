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

    private ReceiptOutputStrategy outputStrategy;

    public Register(ReceiptOutputStrategy outputStrategy) {
        this.outputStrategy = outputStrategy;
    }   


    public void ScanItem(String productID, double quantity) {
        //validation needed        
        outputStrategy.addLineItem(productID, quantity);

    }

    public void printReceipt() {
        outputStrategy.outputReceipt();
    }

    public ReceiptOutputStrategy getOutputStrategy() {
        return outputStrategy;
    }

    public void setOutputStrategy(ReceiptOutputStrategy outputStrategy) {
        this.outputStrategy = outputStrategy;
    }
    
    

}

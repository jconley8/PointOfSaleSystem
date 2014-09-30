/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;

import java.util.Date;

/**
 *
 * @author Josh
 */
public class Receipt {
    
    private int receiptNumber = 0;
    private double quantity;
    private LineItem[] lineItems;

    public Receipt() {
        lineItems = new LineItem[0];
    }
    
    

    public final void addLineItem(final String productID, final double quantity) {
        // needs validation
        this.quantity = quantity;
        LineItem item = new LineItem(productID, quantity);
        addToArray(item);
    }

    private void addToArray(final LineItem item) {
        // needs validation
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

    public void outputReceipt() {
        Date date = new Date();

        System.out.println("Thank you for shopping at Kohls!"
                + "\nDate of Sale: " + date.toString()
                + "\n\nID       Item                  Price      Qty     Subtotal        Discount"
                + "\n-----------------------------------------------------------------------------");
        for (LineItem item : lineItems) {
            System.out.println(item.getProduct().getProductID() + "    "
                    + item.getProduct().getProductDescription() + "    "
                    + item.getProduct().getProductPrice() + "       "
                    + quantity + "     "
                    + item.getCalculatedSubTotal(null)
                    + item.getProduct().getDiscount().getDiscountAmount(item.getProduct().getProductPrice(), quantity));
        }
    }
}

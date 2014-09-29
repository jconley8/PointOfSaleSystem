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
public class Receipt {

    private LineItem[] lineItems;
//    Date date = new Date();

    public final void addLineItem(final String productID, final double quantity) {
        // needs validation
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

}

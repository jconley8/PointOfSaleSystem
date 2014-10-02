/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;

import java.util.Date;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

/**
 *
 *
 *
 *
 * @author Josh
 */
public class GuiReceiptOutput implements ReceiptOutputStrategy {

    private final String INDENT_TOTALS = "                                                                   ";
    private int receiptNumber = 0;
    private LineItem[] lineItems;
    private double netTotal = 0;
    private double totalSaved = 0;

    public GuiReceiptOutput() {
        lineItems = new LineItem[0];
    }

    /**
     * This class adds a line item to the receipt after given productID and
     * quantity
     *
     * @param productID - Unique identification number for a product
     * @param quantity - The quantity of the product that the customer is
     * purchasing
     */
    @Override
    public void addLineItem(String productID, double quantity) {
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
    
    private void calculateTotals () {
        for (LineItem item : lineItems) {
            netTotal += item.getCalculatedSubTotal();
            totalSaved += item.getProduct().getDiscount().getDiscountAmount(item.getProduct().getProductPrice(), item.getQuantity());
        }
    }
    
    @Override
    public void outputReceipt(String customerID) {
        CustomerDatabase customerDB = new CustomerDatabase();
        receiptNumber++;

        Date date = new Date();
        StringBuilder s = new StringBuilder();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        s.append("Thank you for shopping at Kohl's!");
        s.append("\nDate of Sale: ").append(date.toString());
        s.append("\nCustomer: ").append(customerDB.findCustomerByID(customerID).getCustomerFullName());
        s.append("\nReceipt number: ").append(receiptNumber);
        s.append("\n\nID            Item                                   Price      Qty    Subtotal      Discount");
        s.append("\n--------------------------------------------------------------------------------------------\n");

        calculateTotals();
        
        for (LineItem item : lineItems) {
            s.append(item.getProduct().getProductID()).append("    ");
            s.append(item.getProduct().getProductDescription()).append("    ");
            s.append(formatter.format(item.getProduct().getProductPrice())).append("     ");
            s.append(item.getQuantity()).append("     ");
            s.append(formatter.format(item.getCalculatedSubTotal())).append("        ");
            s.append(formatter.format(item.getProduct().getDiscount().getDiscountAmount(item.getProduct().getProductPrice(), item.getQuantity()))).append("\n");
        }
        
        JOptionPane.showMessageDialog(null, s
                + INDENT_TOTALS + "--------------------------------------\n"
                + INDENT_TOTALS + "Net Total:    " + formatter.format(netTotal) + "\n"
                + INDENT_TOTALS + "Total Saved:  " + formatter.format(totalSaved) + "\n"
                + INDENT_TOTALS + "Total Due:    " + formatter.format((netTotal - totalSaved)) + "\n");

        lineItems = new LineItem[0];
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;

import java.util.Date;
import java.text.NumberFormat;

/**
 *
 *
 *
 *
 * @author Josh
 */
public class ConsoleReceiptOutput implements ReceiptOutputStrategy {
    
    private final String THANKS_FOR_SHOPPING = "Thank you for shopping at Kohl's!";
    private final String DATE_OF_SALE = "\nDate of Sale: ";
    private final String CUSTOMER = "\nCustomer #: ";
    private final String RECEIPT_NUMBER = "\nReceipt number: ";
    private final String RECEIPT_LABELS = "\n\nID       Item                   Price      Qty    Subtotal      Discount";
    private final String RECEIPT_BORDER = "\n-------------------------------------------------------------------------\n";
    private final String TOTALS_BORDER = "-------------------";
    private final String NET_TOTAL = "Net Total: ";
    private final String TOTAL_SAVED = "Total Saved: ";
    private final String TOTAL_DUE = "Total Due: ";
    private final String NEW_LINE = "\n";

    private final String INDENT_TOTALS = "                                                    ";
    private int receiptNumber = 0;
    private double netTotal = 0;
    private double totalSaved = 0;
    private LineItem[] lineItems;

    public ConsoleReceiptOutput() {
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

    private void calculateTotals() {
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

        s.append(THANKS_FOR_SHOPPING);
        s.append(DATE_OF_SALE).append(date.toString());
        s.append(CUSTOMER).append(customerID).append(": ").append(customerDB.findCustomerByID(customerID).getCustomerFullName());
        s.append(RECEIPT_NUMBER).append(receiptNumber);
        s.append(RECEIPT_LABELS);
        s.append(RECEIPT_BORDER);

        calculateTotals();

        for (LineItem item : lineItems) {
            s.append(item.getProduct().getProductID()).append("    ");
            s.append(item.getProduct().getProductDescription()).append("    ");
            s.append(formatter.format(item.getProduct().getProductPrice())).append("     ");
            s.append(item.getQuantity()).append("     ");
            s.append(formatter.format(item.getCalculatedSubTotal())).append("        ");
            s.append(formatter.format(item.getProduct().getDiscountAmount(item.getQuantity()))).append(NEW_LINE);
//          s.append(formatter.format(item.getProduct().getDiscount().getDiscountAmount(item.getProduct().getProductPrice(), item.getQuantity()))).append("\n");
        }
        System.out.println(s);

        System.out.println(INDENT_TOTALS + TOTALS_BORDER);
        System.out.println(INDENT_TOTALS + NET_TOTAL + formatter.format(netTotal));
        System.out.println(INDENT_TOTALS + TOTAL_SAVED + formatter.format(totalSaved));
        System.out.println(INDENT_TOTALS + TOTAL_DUE + formatter.format((netTotal - totalSaved)) + NEW_LINE);
        lineItems = new LineItem[0];
    }
}

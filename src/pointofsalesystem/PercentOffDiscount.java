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
public class PercentOffDiscount implements DiscountStrategy {

    private double percentOff;

    public PercentOffDiscount(double percentOff) {
        this.percentOff = percentOff;
    }

    @Override
    public double getDiscountAmount(double price, double quantity) {
        //validation needed
        return price * quantity * percentOff;
    }

    @Override
    public double getTotalAfterDiscount(double price, double quantity) {
        //validation needed
        return (price * quantity) - (price * quantity * percentOff);
    }

    public double getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(double percentOff) {
        //validation needed
        this.percentOff = percentOff;
    }

    
    //TEST CODE
    public static void main(String[] args) {
        PercentOffDiscount percentOff = new PercentOffDiscount(.20);

        System.out.println("Discount amount: " + percentOff.getDiscountAmount(10, 2));
        System.out.println("Total after discount: " + percentOff.getTotalAfterDiscount(10, 2));
    }
}

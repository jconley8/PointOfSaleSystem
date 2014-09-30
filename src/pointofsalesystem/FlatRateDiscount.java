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
public class FlatRateDiscount implements DiscountStrategy {

    private double flatRateDiscount;

    public FlatRateDiscount(double flatRateOff) {
        this.flatRateDiscount = flatRateOff;
    }

    @Override
    public double getDiscountAmount(double price, double quantity) {
        //validation needed
        return (price * quantity) - (price - flatRateDiscount);
    }

    @Override
    public double getTotalAfterDiscount(double price, double quantity) {
        //validation needed
        return (price * quantity) - flatRateDiscount;
    }

    public double getFlatRateOff() {
        return flatRateDiscount;
    }

    public void setFlatRateOff(double flatRateOff) {
        //validation needed
        this.flatRateDiscount = flatRateOff;
    }

    public static void main(String[] args) {
        FlatRateDiscount flatRate = new FlatRateDiscount(10.00);

        System.out.println("Discount amount: " + flatRate.getDiscountAmount(15.00, 1));
        System.out.println("Total after discount: " + flatRate.getTotalAfterDiscount(15.00, 1));

    }
}

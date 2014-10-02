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
public class QuantityDiscount implements DiscountStrategy {

    private double minimumQuantityForDiscount;
    private double percentOff;

    public QuantityDiscount(double minimumQuantityForDiscount, double percentOff) {
        //validation needed
        this.minimumQuantityForDiscount = minimumQuantityForDiscount;
        this.percentOff = percentOff;
    }

    @Override
    public double getDiscountAmount(double price, double quantity) {
        double discountAmount;
        //further validation needed
        if (quantity < minimumQuantityForDiscount) {
            discountAmount = 0;
        } else {
            discountAmount = price * quantity * percentOff;
        }

        return discountAmount;

    }

    @Override
    public double getTotalAfterDiscount(double price, double quantity) {
        double totalAfterDiscount;
        //further validation needed
        if (quantity < minimumQuantityForDiscount) {
            totalAfterDiscount = price * quantity;
        } else {
            totalAfterDiscount = (price * quantity) - (price * quantity * percentOff);
        }

        return totalAfterDiscount;
    }

    public final double getMinimumQuantityForDiscount() {
        return minimumQuantityForDiscount;
    }

    public final void setMinimumQuantityForDiscount(double minimumQuantityForDiscount) {
        //validation needed
        this.minimumQuantityForDiscount = minimumQuantityForDiscount;
    }

    public final double getPercentOff() {
        return percentOff;
    }

    public final void setPercentOff(double percentOff) {
        //validation needed
        this.percentOff = percentOff;
    }

    //TEST CODE
    public static void main(String[] args) {
        QuantityDiscount quantityDisc = new QuantityDiscount(3, .20);

        System.out.println("Discount amount: " + quantityDisc.getDiscountAmount(20, 2));

        System.out.println("Total after discount: " + quantityDisc.getTotalAfterDiscount(20, 2));
    }

}

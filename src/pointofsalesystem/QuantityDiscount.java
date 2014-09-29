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
        this.minimumQuantityForDiscount = minimumQuantityForDiscount;
        this.percentOff = percentOff;
    }

    @Override
    public double getDiscountAmount(double price, double quantity) {
        double discountAmount;

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

        if (quantity < minimumQuantityForDiscount) {
            totalAfterDiscount = price * quantity;
        } else {
            totalAfterDiscount = (price * quantity) - (price * quantity * percentOff);
        }

        return totalAfterDiscount;
    }

    public static void main(String[] args) {
        QuantityDiscount quantityDisc = new QuantityDiscount(3, .20);

        System.out.println("Discount amount: " + quantityDisc.getDiscountAmount(20, 2));

        System.out.println("Total after discount: " + quantityDisc.getTotalAfterDiscount(20, 2));
    }

    public double getMinimumQuantityForDiscount() {
        return minimumQuantityForDiscount;
    }

    public void setMinimumQuantityForDiscount(double minimumQuantityForDiscount) {
        this.minimumQuantityForDiscount = minimumQuantityForDiscount;
    }

    public double getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(double percentOff) {
        this.percentOff = percentOff;
    }

}

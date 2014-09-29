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

    public QuantityDiscount(double minimumQuantityForDiscount) {
        this.minimumQuantityForDiscount = minimumQuantityForDiscount;
    }

    public double getMinimumQuantityForDiscount() {
        return minimumQuantityForDiscount;
    }

    public void setMinimumQuantityForDiscount(double minimumQuantityForDiscount) {
        this.minimumQuantityForDiscount = minimumQuantityForDiscount;
    }

    @Override
    public double getDiscountAmount(double price, double quantity) {
        
    }

    @Override
    public double getTotalAfterDiscount(double price, double quantity) {
        double discountAmount;
        
        if (quantity < minimumQuantityForDiscount)
            
        
        
    }
    
    
    
    
    
}

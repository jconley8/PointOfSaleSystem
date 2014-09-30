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
public class NoDiscount implements DiscountStrategy {

    public NoDiscount() {
    
    }

    @Override
    public double getDiscountAmount(double price, double quantity) {
        //validation needed
        return 0;
    }

    @Override
    public double getTotalAfterDiscount(double price, double quantity) {
        //validation needed
        return price * quantity;
    }

}

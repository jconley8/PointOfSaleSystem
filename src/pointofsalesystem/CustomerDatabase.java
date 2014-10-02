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
public class CustomerDatabase {

    private final Customer[] customers = {
        new Customer("5420", "Josh", "Conley"),
        new Customer("5421", "George", "Wilkinson"),
        new Customer("5422", "Bobby", "Jefferson"),
        new Customer("5423", "Jeffrey", "Hinderson")};
    
    public final Customer findCustomerByID(String customerID) {
        Customer customer = null;
        
        for(Customer c : customers) {
            if(customerID.equals(c.getCustomerID())) {
                customer = c;
            }
        }
        return customer;
    }
    
    public static void main(String[] args) {
        
        CustomerDatabase db = new CustomerDatabase();
        
        System.out.println(db.findCustomerByID("5420").getCustomerFullName());
    }
}

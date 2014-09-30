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
public class Startup {
    
    public static void main(String[] args) {
        Register register = new Register();
        
        register.ScanItem("A1504", 1);
        register.printReceipt();
    }
}

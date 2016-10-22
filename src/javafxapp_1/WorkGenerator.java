/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp_1;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caleb
 */
public class WorkGenerator implements Runnable{

    public static int IncomingRate=1000;
    public WorkGenerator() {
        System.out.println("Inside work generator");
    Thread t = new Thread(this);
            t.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(WorkGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    }
    
     
        
        
        
        
    
    
    public void run(){
        System.out.println("Inside run method");
        for(int i=0;i<10;i++){
        Restaurant.addCustomer(Customer.createCustomer());
        ArrayList alist= (ArrayList)Restaurant.getCustomerNamesInQueue();
        while(alist.size()>0){
          System.out.println("Customer list "+(String)alist.remove(0)) ;
        }
        
        
        try {
            Thread.sleep(IncomingRate);
        } catch (InterruptedException ex) {
            Logger.getLogger(WorkGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Restaurant(5,"Res").startServicing();
    }}
    
}

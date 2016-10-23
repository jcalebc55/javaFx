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
    Thread t2 = new Thread(this);
    Thread t3 = new Thread(this);
    Thread t4 = new Thread(this);
           t.start();
        t2.start();
        t3.start();
        t4.start();
        
    
    }
    
     
        
        
        
        
    
    
    public void   run(){
        Restaurant res=Restaurant.createRestaurent();
        System.out.println("Inside run method");
        for(int i=0;i<30;i++){
           Customer cust=Customer.createCustomer(); 
        res.addCustomer(cust);
            System.out.println("The customer "+cust.getCustname()+" visits "+res.getResName());
        
        ArrayList alist= (ArrayList)res.getCustomerNamesInQueue();
        while(alist.size()>0){
          System.out.println("Customer list "+(String)alist.remove(0)) ;
        }
        
        
        try {
            Thread.sleep(IncomingRate);
        } catch (InterruptedException ex) {
            Logger.getLogger(WorkGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        res.startServicing();
        //res.printCustomerRestaurantList();
        
    }}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp_1;

/**
 *
 * @author Caleb
 */
public class Customer {
    private static int cCount=0;
    String Custname;
    int Custid;
    
    Customer(String Custname,int Custid){
        this.Custname=Custname;
        this.Custid=Custid;
    }

    public String getCustname() {
        return Custname;
    }
    
    
    
   public static Customer createCustomer(){
        Customer customer= new Customer("Customer"+cCount++,cCount);
        System.out.println(customer.getCustname()+" is created");
        
        return customer;
    }
    
}

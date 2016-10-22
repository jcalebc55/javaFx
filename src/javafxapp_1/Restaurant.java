/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp_1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caleb
 */
public class Restaurant implements Runnable{
    private static int  rcount=0;
    private static ArrayList<Customer> CustomerList= new ArrayList<Customer>();
    private static int serviceTime=3000;
    private static boolean doService;
    
    public static void addCustomer(Customer customer){
    
        CustomerList.add(customer);
    }
    
    public static List getCustomerNamesInQueue(){
        ArrayList custList=new ArrayList<String>();
        for(Customer cust:CustomerList){
        custList.add(cust.getCustname());
        
        
    }
        return custList;
    }
    
    public  void startServicing(){
        
        Thread t = new Thread(this);
        t.start();
        
    }
    
    
    int id;
    String name;
    
    boolean isOpen;
    //String address;

    public Restaurant(int id, String name) {
        this.id=id;
        this.name=name;
    }
    
    
    
    public static void serviceCustomer(){
        if(CustomerList.size()>0){
      Customer cust=  CustomerList.remove(0);
        System.out.println("Customer "+cust.getCustname()+" is serviced");}
    }
    
    
    public Restaurant createRestaurent(){
        
        return new Restaurant(rcount++, "Restaurant"+rcount);
        
        
    }
    
    
    
    public void stopServicing(){
        doService=false;
    }

    @Override
    public void run() {
        doService=true;
        while(CustomerList.size()>0 && doService){
            try{
        Thread.sleep(serviceTime);}
            catch(Exception E){ System.out.println("Servicing Interrupted");}
        
        serviceCustomer();
        }
        doService=false;
    }
    
    
    
    
}

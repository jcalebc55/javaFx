/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Caleb
 */
public class Restaurant implements Runnable{
    private static int  rcount=0;
    
   // private static ArrayList<Customer> CustomerList= new ArrayList<Customer>();
    private static ArrayList<Restaurant> restaurantList= new ArrayList<Restaurant>();
    
    private static  Map <Integer,ArrayList<Customer>> restaurantCustList= new HashMap<Integer,ArrayList<Customer>>();
    private static int serviceTime=3000;
    private static boolean doService;
    
    public  void addCustomer(Customer customer){
    if(restaurantCustList.containsKey(this.id))
    {
    ArrayList<Customer> CustList=restaurantCustList.get(id);
    CustList.add(customer);
    
    }else{
        ArrayList<Customer> CustList=new ArrayList<Customer>();
        CustList.add(customer);
    restaurantCustList.put(this.id,CustList);
    }
        
    }
    
    public  List getCustomerNamesInQueue(){
        ArrayList<Customer> custList=restaurantCustList.get(this.id);
        ArrayList<String> custNames= new ArrayList<String>();
        for(Customer cust:custList){
        custNames.add(cust.getCustname());
               
    }
        return custNames;
    }
    
    public synchronized void  startServicing(){
        
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
    
    
    
    public  void serviceCustomer(){
        ArrayList<Customer> custList=restaurantCustList.get(this.id);
        
        if(custList.size()>0){
      Customer cust=  custList.remove(0);
        System.out.println("Customer "+cust.getCustname()+" is serviced in Restaurant "+this.name);}
    }
    
    
    public synchronized static Restaurant createRestaurent(){
        
        Restaurant res= new Restaurant(rcount++, "Restaurant"+rcount);
        restaurantList.add(res);
        return res;
        
    }
    
    
    
    public void stopServicing(){
        doService=false;
    }

    @Override
    public void run() {
        
        ArrayList<Customer> custList=restaurantCustList.get(this.id);
        doService=true;
        while(custList.size()>0 && doService){
            try{
        Thread.sleep(serviceTime);}
            catch(Exception E){ System.out.println("Servicing Interrupted");}
        
        serviceCustomer();
        }
        doService=false;
    }

    void printCustomerRestaurantList() {
        
    }
    
    
    
    
}

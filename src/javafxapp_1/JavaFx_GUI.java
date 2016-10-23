/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Caleb
 */
public class JavaFx_GUI extends Application implements Runnable{

    Button button=new Button("Hello");
    Button button2=new Button("Input");
    volatile boolean  flag;
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
     
    //   ArrayList alist= (ArrayList)Restaurant.getCustomerNamesInQueue();
    window=primaryStage;
      // primaryStage.setTitle("Grid Pane usage");
    GridPane grid= new GridPane();
    grid.setPadding(new Insets(10,10,10,10));
    grid.setVgap(8);
    grid.setHgap(20);
    
        
    
        GridPane.setConstraints(button, 0, 0);
        grid.getChildren().add(button);
 
    GridPane.setConstraints(button2, Integer.MAX_VALUE, 0);
    grid.getChildren().add(button2);
      //////////////////////////////
    HashMap  map= (HashMap) Restaurant.getAllCustomerArrays();
    ArrayList<Integer> RestIds= new ArrayList<Integer>(map.keySet());
        int x=1,y=1;
        for(int i=0;i<RestIds.size();i++){
            x=1;
          ArrayList<Customer> custList= (ArrayList<Customer>)map.get( (RestIds.get(i)));
            for(int j=0;j<custList.size();j++ ){
                Customer cust=(Customer)custList.get(j);
                grid=addToGrid(x,y,cust.getCustname(),window,grid);
                x++;
            }
          y++;
          
        }
    
    
    
    /////////////////////////////////////////////////////////////
        //HBox layout=new HBox(20);
        //button.setText("Hello");
        //layout.getChildren().add(button);
        //while(alist.size()>0){
        //layout.getChildren().add(   new Button((String)alist.remove(0))   );
        //}
        Scene scene= new Scene(grid,1000,1000);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        window=primaryStage;
        
        button.setOnAction(e -> window.setScene(getNewScene()));
       // Thread t = new Thread(this);
    //t.start();
        
     
        
    }
    
     public static void main(String[] args) {
        new WorkGenerator();
         launch(args);
        
    }
     
     public void stop(){
         flag=false;
         
     }

    @Override
    public void run() {
        System.out.println("Inside the run method for GUI");
        flag=true;
        while(flag){
        button.fire();
        }    



    }

    private Scene getNewScene() {
        
//     /   ArrayList alist= (ArrayList)Restaurant.getCustomerNamesInQueue();
//        HBox layout=new HBox(20);
//        layout.getChildren().add(button);
//        while(alist.size()>0){
//            
//        layout.getChildren().add(   new Button((String)alist.remove(0))   );
//        }
//        Scene newscene= new Scene(layout,1000,1000);
//        return newscene;

GridPane grid= new GridPane();
    grid.setPadding(new Insets(10,10,10,10));
    grid.setVgap(8);
    grid.setHgap(20);
 
    GridPane.setConstraints(button, 0, 0);
        grid.getChildren().add(button);
      //////////////////////////////
    HashMap  map= (HashMap) Restaurant.getAllCustomerArrays();
    ArrayList<Integer> RestIds= new ArrayList<Integer>(map.keySet());
        int x=1,y=1;
        for(int i=0;i<RestIds.size();i++){
            x=1;
          ArrayList<Customer> custList= (ArrayList<Customer>)map.get( (RestIds.get(i)));
            for(int j=0;j<custList.size();j++ ){
                Customer cust=(Customer)custList.get(j);
                grid=addToGrid(x,y,cust.getCustname(),window,grid);
                x++;
                
            }
          y++;
          
        }

Scene scene= new Scene(grid,1000,1000);
return scene;




    }

    private GridPane addToGrid(int x, int y, String custname, Stage primaryStage, GridPane grid) {

        Button button1=new Button(custname);
        GridPane.setConstraints(button1, x, y);
        grid.getChildren().add(button1);
        return grid;
        
    }

    
    
}

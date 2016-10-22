///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package javafxapp_1;
//
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
///**
// *
// * @author Caleb
// */
//public class JavaFx_GUI extends Application implements Runnable{
//
//    Button button=new Button();
//    volatile boolean  flag;
//    Stage window;
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//     
//    //    ArrayList alist= (ArrayList)Restaurant.getCustomerNamesInQueue();
//         
//        HBox layout=new HBox(20);
//        button.setText("Hello");
//        layout.getChildren().add(button);
//        while(alist.size()>0){
//        layout.getChildren().add(   new Button((String)alist.remove(0))   );
//        }
//        Scene scene= new Scene(layout,500,500);
//        
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        window=primaryStage;
//        
//        button.setOnAction(e -> window.setScene(getNewScene()));
//       // Thread t = new Thread(this);
//    //t.start();
//        
//     
//        
//    }
//    
//     public static void main(String[] args) {
//        new WorkGenerator();
//         launch(args);
//        
//    }
//     
//     public void stop(){
//         flag=false;
//         
//     }
//
//    @Override
//    public void run() {
//        System.out.println("Inside the run method for GUI");
//        flag=true;
//        while(flag){
//        button.fire();
//        }    
//
//
//
//    }
//
//    private Scene getNewScene() {
//        
////     /   ArrayList alist= (ArrayList)Restaurant.getCustomerNamesInQueue();
//        HBox layout=new HBox(20);
//        layout.getChildren().add(button);
//        while(alist.size()>0){
//            
//        layout.getChildren().add(   new Button((String)alist.remove(0))   );
//        }
//        Scene newscene= new Scene(layout,1000,1000);
//        return newscene;
//    }
//
//    
//    
//}

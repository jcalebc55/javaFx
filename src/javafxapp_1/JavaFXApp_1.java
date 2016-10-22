/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp_1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Caleb
 */
public class JavaFXApp_1 extends Application implements Runnable{
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        switchScenes(primaryStage);
        //createAlertDialog(primaryStage);
       // gridPaneWindow(primaryStage);
        //checkBox(primaryStage);
        //ChooseBox(primaryStage);
        
    }
    
    public void switchScenes(Stage primaryStage){
        Scene scene1,scene2;
        
        Button btn = new Button();
        Label label=new Label("This is Scene 1");
        btn.setText("Go to scene 2");
        VBox layout=new VBox(20);
        layout.getChildren().addAll(label,btn);
        scene1=new Scene(layout,250,250);
        Button btn2 = new Button("Go back to scene1");
        
      
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(btn2);
        scene2=new Scene(layout2,200,200);
        
        
        
        
        
        btn.setOnAction(e -> {System.out.println("Button fired");  
        primaryStage.setScene(scene2);
        });
        //btn2.setOnAction(e -> {primaryStage.setScene(scene1);} );
        
        primaryStage.setScene(scene1);
        
        
        
        
        
        primaryStage.setTitle("Swicth Scens");
        
        primaryStage.show();
        
        //switchStageOnLoop(stage);
        Thread thread= new Thread(this);
        thread.start();
        
        
    }
    
    
    
    public Scene getNewScene(){
        Button btn2 = new Button("Go back to scene1");
        Scene scene2;
      
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(btn2);
        scene2=new Scene(layout2,200,200);
        return scene2;
    }
    
    public void createAlertDialog(Stage PrimaryStage){
        Button btn = new Button();
           Label label=new Label("This is Scene 1");
        btn.setText("Go to scene 2");
        VBox layout=new VBox(20);
        layout.getChildren().addAll(label,btn);
        
        btn.setOnAction(e -> alertWindow.display("Alert window", "Test Label"));
        Scene scene=new Scene(layout,250,250);
        PrimaryStage.setScene(scene);
        
      PrimaryStage.show();
        
    }
    
    public void gridPaneWindow(Stage PrimaryStage){
    PrimaryStage.setTitle("Grid Pane usage");
    GridPane grid= new GridPane();
    grid.setPadding(new Insets(10,10,10,10));
    grid.setVgap(8);
    grid.setHgap(40);
    
    Label NameLabel= new Label("Name:");
    GridPane.setConstraints(NameLabel, 0, 0);
    
    
    
        TextField textField=new TextField("Caleb");
    GridPane.setConstraints(textField, 1, 0);
    
    Label PaswdLabel= new Label("Password:");
    GridPane.setConstraints(PaswdLabel, 0, 1);
    
    
    TextField pasText= new TextField();
    pasText.setPromptText("password");
    GridPane.setConstraints(pasText, 1, 1);
    
    Button b= new Button("login");
    GridPane.setConstraints(b, 1, 2);
    
    grid.getChildren().addAll(NameLabel,textField,PaswdLabel,pasText,b);
    Scene scene= new Scene(grid,200,300);
    
    PrimaryStage.setScene(scene);
    PrimaryStage.show();
    
    }
    
    
    public void checkBox(Stage PStage){
        CheckBox c1= new CheckBox("Option 1");
        CheckBox c2= new CheckBox("Option 2");
        Button btn= new Button("Choose option");
        VBox layout = new VBox(20);
        layout.getChildren().addAll(c1,c2,btn);
        
        Scene scene= new Scene(layout,300,300);
        PStage.setScene(scene);
        PStage.show();
        
        
    }
    
    
    public void ChooseBox(Stage pStage){
        ChoiceBox<String> box= new ChoiceBox<>();
        
        box.getItems().addAll("Apple","Banana","Pine apple", "Mango","Raspberry");
        box.setValue("Apple");
        
        box.getSelectionModel().selectedItemProperty().addListener((V,oldValue,newValue) -> System.out.println(" print"+newValue) );
        
        VBox layput =new VBox(20);
        layput.getChildren().add(box);
        Scene scene= new Scene(layput,300,300);
        pStage.setScene(scene);
        pStage.show();
        
        
        
    }
    
    public void ComboBox(){
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void run() {
        System.out.println("In side JavaFX app run");
        
        
    }

    private void switchStageOnLoop(Stage stage) {
        
        Label label=new Label("This is Scene 1");
        Button btn= new Button();
        btn.setText("Go to scene 2");
        VBox layout=new VBox(20);
        layout.getChildren().addAll(label,btn);
        Scene scene1=new Scene(layout,250,250);
        Button btn2 = new Button("Go back to scene1");
        
      
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(btn2);
        Scene scene2=new Scene(layout2,200,200);
        
        
        
        for(int i=0;i<25;i++)
        {
            System.out.println("Switch to secene 2");
        stage.setScene(scene2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(JavaFXApp_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Switch to secene 1");
        stage.setScene(scene1);
        
        }
        //btn2.setOnAction(e -> {primaryStage.setScene(scene1);} );
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
}

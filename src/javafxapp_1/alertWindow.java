/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp_1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Caleb
 */
public class alertWindow {
    
    
    public static void display(String title,String message){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        
        Label label= new Label(message);
        Button button= new Button("Close Button");
        button.setOnAction(e -> window.close());
        
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label,button);
        Scene scene = new Scene(layout,200,200);
        window.setScene(scene);
        window.show();
        
        
        
    }
    
}

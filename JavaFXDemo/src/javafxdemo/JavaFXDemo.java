/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxdemo;

import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author 6316704
 */
public class JavaFXDemo extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        Circle obj1 = new Circle(50, 50, 30);
        obj1.setFill(Color.RED);
        Rectangle rect = new Rectangle(50, 150, 400, 200);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        
        Path path = new Path();
        
        //path.getElements().add(new MoveTo(0f, 50f));
        //path.getElements().add(new CubicCurveTo());
        
        PathTransition pt = new PathTransition();
        pt.setPath(rect);
        pt.setNode(obj1);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();
        
        Pane root = new Pane(rect, obj1);
        
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("j");
        stage.setScene(scene);
        stage.show();
    }
}

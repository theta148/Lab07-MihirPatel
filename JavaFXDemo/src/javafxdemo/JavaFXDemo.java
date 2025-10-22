/* https://github.com/theta148/Lab07-MihirPatel
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxdemo;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
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
        Ellipse objA = new Ellipse(50, 50, 30, 20);
        objA.setFill(Color.RED);
        
        Path path = new Path();
        
        path.getElements().add(new MoveTo(50f, 150f));
        path.getElements().add(new LineTo(450f, 150f));
        path.getElements().add(new LineTo(450f, 350f));
        path.getElements().add(new LineTo(50f, 350f));
        path.getElements().add(new LineTo(50f, 150f));
        
        PathTransition pt = new PathTransition();
        pt.setPath(path);
        pt.setNode(objA);
        pt.setDuration(Duration.millis(9000));
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setInterpolator(Interpolator.LINEAR);
        pt.play();
        
        Ellipse objB = new Ellipse(250, 300, 50, 20);
        objB.setFill(Color.GREEN);
        
        FadeTransition fade = new FadeTransition(Duration.seconds(3), objB);
        fade.setFromValue(1.0);
        fade.setToValue(0.25);
        fade.setAutoReverse(true);
        
        ScaleTransition scale = new ScaleTransition(Duration.seconds(1.5), objB);
        scale.setToX(2.0);
        scale.setToY(2.0);
        
        RotateTransition rotate = new RotateTransition(Duration.seconds(3), objB);
        rotate.setByAngle(180);
        
        TranslateTransition move = new TranslateTransition(Duration.seconds(1.5), objB);
        move.setToX(50);
        move.setToY(-100);
        
        SequentialTransition seq = new SequentialTransition(fade, scale, rotate, move);
        
        Button start = new Button("Start");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");
        
        start.setOnAction(e -> {
            seq.play();
        });
        
        reset.setOnAction(e -> {
            seq.play();
        });
        
        exit.setOnAction(e -> {
            seq.stop();
        });
        
        HBox hb = new HBox(10, start, reset, exit);
        
        Pane root = new Pane(objA, objB, hb);
        hb.setTranslateX(220);
        hb.setTranslateY(450);
        
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("j");
        stage.setScene(scene);
        stage.show();
    }
}

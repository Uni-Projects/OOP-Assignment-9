package assignment_9;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 * 
 */
public class Assignment_9 extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Pane diagram = new Pane();
        VBox vb = new VBox(5);

        root.setLeft(vb);
        root.setCenter(diagram);
        
        final TextField[] t;
        t = new TextField[4];
        
        IntegerProperty[] i;
        i = new SimpleIntegerProperty[4];
        
        DoubleProperty[] d;
        d = new SimpleDoubleProperty[4];
        
        Arc[] a;
        a = new Arc[4];
        
        IntegerProperty sum = new SimpleIntegerProperty();
        
        for(int j = 0 ; j < 4; j++){
            TextField tf = t[j] = new TextField();
            i[j] = new SimpleIntegerProperty();
            
            tf.textProperty().addListener(new ChangeListener< String>() {
            @Override
            public void changed(
                    ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                if (!newValue.matches(" [1 -9]\\ d{0 ,3}")) {
                    tf.setText(oldValue);
                    }
                }
             }
            );
    
            vb.getChildren().add(t[j]);
            tf.textProperty().bindBidirectional(i[j], new NumberStringConverter());  
        }
        
        sum.bind(i[0].add(i[1]).add(i[2]).add(i[3])); 
        Color[] c = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};
        
        for(int j = 0 ; j < 4; j++){
            
            a[j] = new Arc();
            d[j] = new SimpleDoubleProperty();
            
            d[j].bind(i[j].add(0f).divide(sum));
            a[j].setType(ArcType.ROUND);
            a[j].setFill(c[j]);
            a[j].centerXProperty().bind(diagram.widthProperty().divide(2.0f));
            a[j].centerYProperty().bind(diagram.heightProperty().divide(2.0f));
            a[j].lengthProperty().bind(d[j].multiply(360.0f));
            a[j].radiusXProperty().bind(diagram.widthProperty().multiply(0.45));
            a[j].radiusYProperty().bind(diagram.widthProperty().multiply(0.45));

            diagram.getChildren().add(a[j]);
        }
        
        a[1].startAngleProperty().bind(a[0].lengthProperty());
        a[2].startAngleProperty().bind(a[0].lengthProperty().add(a[1].lengthProperty()));
        a[3].startAngleProperty().bind(a[0].lengthProperty().add(a[1].lengthProperty()).add(a[2].lengthProperty()));
        
        Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("Assignment 9");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

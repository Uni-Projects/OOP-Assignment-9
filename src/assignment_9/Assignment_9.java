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

        TextField textField = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();

        textField.textProperty().addListener(new ChangeListener< String>() {
            @Override
            public void changed(
                    ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                if (!newValue.matches(" [1 -9]\\ d{0 ,3}")) {
                    textField.setText(oldValue);
                }
            }
        }
        );
        textField2.textProperty().addListener(new ChangeListener< String>() {
            @Override
            public void changed(
                    ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                if (!newValue.matches(" [1 -9]\\ d{0 ,3}")) {
                    textField.setText(oldValue);
                }
            }
        }
        );
        textField3.textProperty().addListener(new ChangeListener< String>() {
            @Override
            public void changed(
                    ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                if (!newValue.matches(" [1 -9]\\ d{0 ,3}")) {
                    textField.setText(oldValue);
                }
            }
        }
        );
        textField4.textProperty().addListener(new ChangeListener< String>() {
            @Override
            public void changed(
                    ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                if (!newValue.matches(" [1 -9]\\ d{0 ,3}")) {
                    textField.setText(oldValue);
                }
            }
        }
        );

        IntegerProperty inValue = new SimpleIntegerProperty();
        IntegerProperty inValue2 = new SimpleIntegerProperty();
        IntegerProperty inValue3 = new SimpleIntegerProperty();
        IntegerProperty inValue4 = new SimpleIntegerProperty();
        IntegerProperty sum = new SimpleIntegerProperty();

        sum.bind(inValue.add(inValue2).add(inValue3).add(inValue4));

        DoubleProperty outValue = new SimpleDoubleProperty();
        DoubleProperty outValue2 = new SimpleDoubleProperty();
        DoubleProperty outValue3 = new SimpleDoubleProperty();
        DoubleProperty outValue4 = new SimpleDoubleProperty();

        textField.textProperty().bindBidirectional(inValue, new NumberStringConverter());
        textField2.textProperty().bindBidirectional(inValue2, new NumberStringConverter());
        textField3.textProperty().bindBidirectional(inValue3, new NumberStringConverter());
        textField4.textProperty().bindBidirectional(inValue4, new NumberStringConverter());

        outValue.bind(inValue.add(0f).divide(sum));
        outValue2.bind(inValue2.add(0f).divide(sum));
        outValue3.bind(inValue3.add(0f).divide(sum));
        outValue4.bind(inValue4.add(0f).divide(sum));

        Arc arc = new Arc();
        arc.setType(ArcType.ROUND);

        arc.setFill(javafx.scene.paint.Color.RED);

        arc.centerXProperty().bind(diagram.widthProperty().divide(2.0f));
        arc.centerYProperty().bind(diagram.heightProperty().divide(2.0f));
        arc.lengthProperty().bind(outValue.multiply(360.0f));
        arc.radiusXProperty().bind(diagram.widthProperty().multiply(0.45));
        arc.radiusYProperty().bind(diagram.widthProperty().multiply(0.45));

        Arc arc2 = new Arc();
        arc2.setType(ArcType.ROUND);

        arc2.setFill(javafx.scene.paint.Color.BLUE);

        arc2.centerXProperty().bind(diagram.widthProperty().divide(2.0f));
        arc2.centerYProperty().bind(diagram.heightProperty().divide(2.0f));

        arc2.startAngleProperty().bind(arc.lengthProperty());
        arc2.lengthProperty().bind(outValue2.multiply(360.0f));

        arc2.radiusXProperty().bind(diagram.widthProperty().multiply(0.45));
        arc2.radiusYProperty().bind(diagram.widthProperty().multiply(0.45));

        Arc arc3 = new Arc();
        arc3.setType(ArcType.ROUND);

        arc3.setFill(javafx.scene.paint.Color.GREEN);

        arc3.centerXProperty().bind(diagram.widthProperty().divide(2.0f));
        arc3.centerYProperty().bind(diagram.heightProperty().divide(2.0f));

        arc3.startAngleProperty().bind(arc.lengthProperty().add(arc2.lengthProperty()));
        arc3.lengthProperty().bind(outValue3.multiply(360.0f));

        arc3.radiusXProperty().bind(diagram.widthProperty().multiply(0.45));
        arc3.radiusYProperty().bind(diagram.widthProperty().multiply(0.45));

        Arc arc4 = new Arc();
        arc4.setType(ArcType.ROUND);

        arc4.setFill(javafx.scene.paint.Color.ORANGE);

        arc4.centerXProperty().bind(diagram.widthProperty().divide(2.0f));
        arc4.centerYProperty().bind(diagram.heightProperty().divide(2.0f));

        arc4.startAngleProperty().bind(arc.lengthProperty().add(arc2.lengthProperty()).add(arc3.lengthProperty()));
        arc4.lengthProperty().bind(outValue4.multiply(360.0f));

        arc4.radiusXProperty().bind(diagram.widthProperty().multiply(0.45));
        arc4.radiusYProperty().bind(diagram.widthProperty().multiply(0.45));

        diagram.getChildren().addAll(arc, arc2, arc3, arc4);
        vb.getChildren().addAll(textField, textField2, textField3, textField4);

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

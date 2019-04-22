package assignment_9;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author scatt
 */
public class Assignment_9 extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(20);
        root.setVgap(10);
        
        TextField textField = new TextField();
        
        textField.textProperty().addListener( new ChangeListener< String>() {
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
        
        TextField textField2 = new TextField();
        textField2.textProperty().addListener( new ChangeListener< String>() {
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
        
        TextField textField3 = new TextField();
        textField3.textProperty().addListener( new ChangeListener< String>() {
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
        TextField textField4 = new TextField();
         textField4.textProperty().addListener( new ChangeListener< String>() {
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
        
        Label outText = new Label("0");
        Label outText2 = new Label("0");
        Label outText3 = new Label("0");
        Label outText4 = new Label("0");
        
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
        
        outText.textProperty().bind(outValue.asString());
        outText2.textProperty().bind(outValue2.asString());
        outText3.textProperty().bind(outValue3.asString());
        outText4.textProperty().bind(outValue4.asString());
        
        root.add(textField, 0, 0);
        root.add(textField2, 0, 1);
        root.add(textField3, 0, 2);
        root.add(textField4, 0, 3);
        root.add(outText,1,0);
        root.add(outText2,1,1);
        root.add(outText3,1,2);
        root.add(outText4,1,3);
        
        Scene scene = new Scene(root, 300, 250);

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pie.chart.generator;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author jubi
 */
public class PieChartGenerator extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(20);
        root.setVgap(10);
        
        // first text field
        TextField textField = new TextField();
        textField.textProperty().addListener(
            new ChangeListener <String> () {
            @Override
                public void changed(ObservableValue<? extends String> observable,
                        String oldValue, String newValue) {
                    if (!newValue.matches("[1-9]\\d{0,3}")) {
                        textField.setText(oldValue);
                    }
                }
            }
        );
        
        // second text field
        TextField textField2 = new TextField();
        textField2.textProperty().addListener(
            new ChangeListener <String> () {
            @Override
                public void changed(ObservableValue<? extends String> observable,
                        String oldValue, String newValue) {
                    if (!newValue.matches("[1-9]\\d{0,3}")) {
                        textField2.setText(oldValue);
                    }
                }
            }
        );
        
        // third text field
        TextField textField3 = new TextField();
        textField3.textProperty().addListener(
            new ChangeListener <String> () {
            @Override
                public void changed(ObservableValue<? extends String> observable,
                        String oldValue, String newValue) {
                    if (!newValue.matches("[1-9]\\d{0,3}")) {
                        textField3.setText(oldValue);
                    }
                }
            }
        );
        
        // fourth text field
        TextField textField4 = new TextField();
        textField4.textProperty().addListener(
            new ChangeListener <String> () {
            @Override
                public void changed(ObservableValue<? extends String> observable,
                        String oldValue, String newValue) {
                    if (!newValue.matches("[1-9]\\d{0,3}")) {
                        textField4.setText(oldValue);
                    }
                }
            }
        );
        
        Label output1 = new Label("0");
        Label output2 = new Label("0");
        Label output3 = new Label("0");
        Label output4 = new Label("0");
        
        IntegerProperty value1 = new SimpleIntegerProperty();
        IntegerProperty value2 = new SimpleIntegerProperty();
        IntegerProperty value3 = new SimpleIntegerProperty();
        IntegerProperty value4 = new SimpleIntegerProperty();
        
        textField.textProperty().bindBidirectional(value1,
                new NumberStringConverter());
        textField2.textProperty().bindBidirectional(value2,
                new NumberStringConverter());
        textField3.textProperty().bindBidirectional(value3,
                new NumberStringConverter());
        textField4.textProperty().bindBidirectional(value4,
                new NumberStringConverter());
        
        SimpleIntegerProperty sum = new SimpleIntegerProperty();
        sum.bind(value1.add(value2).add(value3).add(value4));
        
        DoubleProperty outVal1 = new SimpleDoubleProperty();
        DoubleProperty outVal2 = new SimpleDoubleProperty();
        DoubleProperty outVal3 = new SimpleDoubleProperty();
        DoubleProperty outVal4 = new SimpleDoubleProperty();
        
        outVal1.bind(value1.add(0f).divide(sum));
        outVal2.bind(value2.add(0f).divide(sum));
        outVal3.bind(value3.add(0f).divide(sum));
        outVal4.bind(value4.add(0f).divide(sum));
        
        
        output1.textProperty().bind(outVal1.asString("%.4f"));
        output2.textProperty().bind(outVal2.asString("%.4f"));
        output3.textProperty().bind(outVal3.asString("%.4f"));
        output4.textProperty().bind(outVal4.asString("%.4f"));
       
        
        root.add(textField, 0, 0);
        root.add(output1, 1, 0);
        root.add(textField2, 0, 1);
        root.add(output2, 1, 1);
        root.add(textField3, 0, 2);
        root.add(output3, 1, 2);
        root.add(textField4, 0, 3);
        root.add(output4, 1, 3);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Pie-chart Generator");
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

package fib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

public class Controller {
    public TextField txtBox;
    public FlowPane flowpane;
    @FXML
    public Label num;
    @FXML
    public Label value;

    public void calcFib(ActionEvent actionEvent) {
        String num = txtBox.getText();
        try {
            int value = parseNum(num);
            System.out.println(value);
            int[] fibonacci = calc(value);
            printArr(fibonacci);
            displayArr(fibonacci);
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("An error occurred with the integer you have input");
            alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(e.toString())));
            alert.showAndWait();
        }

    }

    //store last added textfield coordinates then modify them on each click
    //create and implement reset button
    //make it possible to press enter instead of clicking the button

    public static void printArr(int[] arr) {
        for (int i = 0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int parseNum(String num) {
        if(!num.matches("^\\d+$")) {
            throw new IllegalArgumentException("Please input a positive integer (whole number) between 1 and 32");
        } else {
            int value = Integer.parseInt(num);
            if (value>32||value<1) {
                throw new IllegalArgumentException("Please input a positive integer (whole number) between 1 and 32");
            } else {
                return value;
            }
        }
    }

    public static int[] calc(int num) {
        int[] result = new int[num];
        int prev = 0;

        result[0] = 0;

        if (num<2) {
            result[0]=0;
        } else {
            result[1] = 1;

            for (int i = 2; i < num; i++) {
                result[i] = result[i - 1] + result[i - 2];
            }
        }
        return result;
    }

    public void displayArr(int[] fibonacci) {
        //num.setText("Number\t\tValue");
        //value.setText("Value");

//        Label lab = new Label();
//        lab.setText("Number\t\tValue");
//        flowpane.getChildren().add(lab);
        flowpane.getChildren().clear();

        int size = fibonacci.length;
        if (size<7) {
            for (int i = 0; i < size; i++) {
                Label l = new Label();
                l.setText(i + "\t  " + fibonacci[i]);

                flowpane.getChildren().add(l);
            }
        } else {
            for (int i = 0; i < 6; i++) {
                Label l = new Label();
                l.setText(i + "\t  " + fibonacci[i]);

                flowpane.getChildren().add(l);
            }

           // flowpane.getChildren().add(lab);

            for (int i = 6; i < size; i++) {
                Label l = new Label();
                l.setText(i + "\t  " + fibonacci[i]);

                flowpane.getChildren().add(l);
            }
        }
    }
}

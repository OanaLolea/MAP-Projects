package sample;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RevolutStrategy implements PaymentStrategy {

    static String telephoneNumber = "0728 343 457";

    private String inputTelNumber = "";

    @Override
    public boolean pay(double amount) {
        return inputTelNumber.equals(telephoneNumber);
    }

    @Override
    public void collectPaymentDetails() {
        Stage stage = new Stage();
        GridPane root = new GridPane();
        Label l1 =new Label("Telephone number: ");
        root.add(l1, 0,0);

        TextField telephoneField = new TextField();

        root.add(telephoneField, 1,0);

        Button b1 = new Button("OK");

        b1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                inputTelNumber = telephoneField.getText();
                //System.out.println(pay(5));
                stage.close();
            }
        });

        Button b2 = new Button("Cancel");

        b2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.close();
            }
        });

        root.add(b1,0,1);
        root.add(b2,1,1);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}

package sample;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PayByCardStrategy implements PaymentStrategy {

    static String cardNumber = "4552 6541 3331 0221";
    static String cardHolder = "Oana";

    String inputCardNo, inputCardHolder;

    @Override
    public boolean pay(double amount) {
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        Stage stage = new Stage();
        GridPane root = new GridPane();
        Label l1 =new Label("CArd number: ");
        root.add(l1, 0,0);

        TextField cardField = new TextField();
        TextField holderField = new TextField();

        root.add(cardField, 1,0);
        root.add(holderField, 2,0);

        Button b1 = new Button("OK");

        b1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                inputCardNo = cardField.getText();
                inputCardHolder = holderField.getText();

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

        //Button b1 = new Button("OK");

        root.add(b1,0,1);
        root.add(b2,1,1);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}

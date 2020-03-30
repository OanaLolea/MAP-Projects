package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void populate(Order o){
        Margherita pizza1 = new Margherita();
        CheeseFilledCrust c1 = new CheeseFilledCrust(pizza1);
        Peperonni p1 = new Peperonni(c1);
        Peperonni p2 = new Peperonni(p1);

        Pizza pizza2 = new Capriciossa();
        Pizza p3 = new Peperonni(pizza2);
        Pizza m1 =new Mozzarella(p3);
        Pizza m2 =new Mozzarella(m1);
        Pizza m3 = new CheeseFilledCrust(m2);

        o.add(p2);
        o.add(m3);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Order order = new Order();

        primaryStage.setTitle("Hello World");
        populate(order);

        System.out.println(order.getTotal());

        PaymentStrategy s = new RevolutStrategy();

        order.processOrder(s);


        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

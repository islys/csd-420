// Ryan Monnier
// CSD 420 - Module 7
// 1-July-2025


import java.io.File;    // needed for loading CSS file
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleFun extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 4 circles of radius 69 w/o color properties, yet
        Circle circle1 = new Circle(69);
        Circle circle2 = new Circle(69);
        Circle circle3 = new Circle(69);
        Circle circle4 = new Circle(69);

        // setting the first two circles to have a plain style
        circle1.getStyleClass().add("plaincircle");
        circle2.getStyleClass().add("plaincircle");

        // set red/green to 3/4
        circle3.setId("redcircle");
        circle4.setId("greencircle");

        // arrange circles horizontally and centred because otherwise they look dumb lol
        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(circle1, circle2, circle3, circle4);
        hbox.setAlignment(Pos.CENTER);

        // big enough scene to fit the circles
        Scene scene = new Scene(hbox, 750, 200);

        // css
        File cssFile = new File("mystyle.css");
        scene.getStylesheets().add(cssFile.toURI().toString());

        // .show() our window
        primaryStage.setTitle("I like big circles, and I cannot lie!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

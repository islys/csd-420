// Java program to create a line with starting
// and ending coordinates passed as arguments
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage; 

public class modDiscussion extends Application {

    // launch the application
    @Override
    public void start(Stage stage)
    {
        
        // set title for the stage
        stage.setTitle("creating line");

        // create a line
        Line line = new Line(10.0, 10.0, 200.0, 140.0);
        line.setStroke(Color.FUCHSIA);

        // create a Group
        Group group = new Group(line);

        // translate the line to a position
        line.setTranslateX(100);
        line.setTranslateY(100);

        // create a scene
        Scene scene = new Scene(group, 500, 300);

        // set the scene
        stage.setScene(scene);

        stage.show();
    }

    // Main Method
    public static void main(String[] args)
    {
        // launch the application
        launch(args);
    }
}
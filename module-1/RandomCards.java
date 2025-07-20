// Ryan Monnier
// CSD-420 - Module 1 - Random Cards
// 1-June-2025


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RandomCards extends Application {

    private static int NUM_CARDS = 4;
    private static int TOTAL_CARDS = 52;
    private static String CARD_PATH = "cards/";

    private List<ImageView> imageViews = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        // create 10 pixels of space between cards, arranged horizontally
        HBox cardBox = new HBox(10);
        Button generateButton = new Button("Shuffle and Draw Cards!");

        // iterate through NUM_CARDS amount of times to generate empty slots for images
        for (int i = 0; i < NUM_CARDS; i++) {
            ImageView imageView = new ImageView();
            // adding the new empty imageViews to the list
            imageViews.add(imageView);
            cardBox.getChildren().add(imageView);
        }

        // call our function to grab random cards
        loadRandomCards();

        // assign the loadRandomCards() function to our button
        generateButton.setOnAction(e -> loadRandomCards());

        // our HBox and button go in a VBox for vertical alignment
        VBox root = new VBox(10, cardBox, generateButton);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // wrapping our UI into a scene
        Scene scene = new Scene(root);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // method to load our cards from CARD_PATH, but only 52 so we dont get the card backs
    private void loadRandomCards() {
        List<Integer> cardNumbers = new ArrayList<>();
        for (int i = 1; i <= TOTAL_CARDS; i++) {
            cardNumbers.add(i);
        }

        // using the shuffle method from Collections to randomize the card numbers
        Collections.shuffle(cardNumbers);

        // plucking out NUM_CARDS amount of random cards
        for (int i = 0; i < NUM_CARDS; i++) {
            String imagePath = CARD_PATH + cardNumbers.get(i) + ".png";
            Image image = new Image(imagePath);
            imageViews.get(i).setImage(image);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

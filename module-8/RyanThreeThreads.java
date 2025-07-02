// Ryan Monnier
// CSD 420 - Module 8
// 1-July-2025



import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Random;

public class RyanThreeThreads extends Application {

    private static final int CHAR_COUNT = 10000; // 10k iterations, oh boy!
    private TextArea textArea = new TextArea();
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        // set up UI components
        textArea.setWrapText(true);
        textArea.setEditable(false);

        BorderPane pane = new BorderPane();
        pane.setCenter(textArea);

        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Three Threads Character Output");
        primaryStage.setScene(scene);
        primaryStage.show();

        // 3 threads for letters, digits, and symbols
        startLetterThread();
        startDigitThread();
        startSymbolThread();
    }

    private void startLetterThread() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < CHAR_COUNT; i++) {
                    char c = (char) ('a' + random.nextInt(26));
                    appendChar(c);
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private void startDigitThread() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < CHAR_COUNT; i++) {
                    char c = (char) ('0' + random.nextInt(10));
                    appendChar(c);
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private void startSymbolThread() {
        final char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        Thread t = new Thread(new Runnable() {
        @Override
            public void run() {
                for (int i = 0; i < CHAR_COUNT; i++) {
                    char c = symbols[random.nextInt(symbols.length)];
                    appendChar(c);
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private void appendChar(final char c) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textArea.appendText(String.valueOf(c));
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
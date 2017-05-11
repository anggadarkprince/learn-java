import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by angga on 11/05/17.
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btnAction = new Button("Click Me");
        btnAction.setOnAction(event -> System.out.println("Hello JavaFX"));

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(event -> {
            System.out.println("Exit app!");
            System.exit(0);
        });

        VBox root = new VBox();
        root.getChildren().addAll(btnAction, btnExit);

        Scene scene = new Scene(root, 500, 300);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class Controller {
    @FXML
    private Label randomLabel;

    public void generateRandom(ActionEvent event) {
        Random random = new Random();
        int result = random.nextInt(100) + 1;
        randomLabel.setText(Integer.toString(result));
        System.out.println(Integer.toString(result));
    }
}

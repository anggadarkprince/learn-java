package skethproject.calculatorfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import skethproject.calculatorfx.models.Calculator;

public class CalculatorController {

    @FXML
    private Label labelResult;
    private float number1;
    private float number2;
    private boolean start;
    private String lastOperation;
    private Calculator calculator;

    public CalculatorController() {
        calculator = new Calculator();
        number1 = 0;
        number2 = 0;
        start = true;
        lastOperation = "";
    }

    @FXML
    public void processNumbers(ActionEvent event) {
        if (start) {
            labelResult.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        String newValue = labelResult.getText() + value;
        if (Float.parseFloat(newValue) == 0) {
            labelResult.setText("0");
        } else {
            labelResult.setText(newValue);
        }
    }

    @FXML
    public void processOperators(ActionEvent event) {
        String operator = ((Button) event.getSource()).getText();

        String currentValue = labelResult.getText();
        if (number1 == 0) {
            number1 = Float.parseFloat(currentValue);
            System.out.println(number1);
        } else if (number2 == 0) {
            number2 = Float.parseFloat(currentValue);
            float result = calculator.calculate(number1, number2, lastOperation);
            labelResult.setText(String.valueOf(result));
            number1 = result;
            number2 = 0;
        }
        lastOperation = operator;
        start = true;

        if (operator.equals("=")) {
            number1 = 0;
            number2 = 0;
            lastOperation = "";
        }
    }
}

package skethproject.calculatorfx.models;

/**
 * Created by angga on 11/05/17.
 */
public class Calculator {

    public float calculate(float number1, float number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "X":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    return 0;
                }
                return number1 / number2;
        }
        return 0;
    }
}

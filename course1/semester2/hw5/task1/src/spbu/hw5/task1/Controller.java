package spbu.hw5.task1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;


public class Controller {
    @FXML
    private MenuButton menu;
    @FXML
    private TextField firstValue;
    @FXML
    private TextField secondValue;
    @FXML
    private TextField result;

    public void changeValue(KeyEvent keyEvent) {
        count();
    }

    public void changeOperation(ActionEvent actionEvent) {
        MenuItem temp = (MenuItem) actionEvent.getSource();
        menu.setText(temp.getText());
        count();
    }

    private void count() {
        if ((menu.getText().isEmpty()) || (firstValue.getText().isEmpty()) || (secondValue.getText().isEmpty())) {
            result.setText("");
            return;
        }

        int firstNumber = Integer.parseInt(firstValue.getText());
        int secondNumber = Integer.parseInt(secondValue.getText());

        switch (menu.getText()) {
            case "+":
                result.setText(Integer.toString(firstNumber + secondNumber));
                break;
            case "-":
                result.setText(Integer.toString(firstNumber - secondNumber));
                break;
            case "*":
                result.setText(Integer.toString(firstNumber * secondNumber));
                break;
            case "/":
                result.setText(Integer.toString(firstNumber / secondNumber));
                break;
        }
    }
}
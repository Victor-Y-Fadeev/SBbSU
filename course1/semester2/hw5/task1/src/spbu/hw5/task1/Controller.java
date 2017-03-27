package spbu.hw5.task1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class Controller {
    @FXML
    private MenuButton menu;
    @FXML
    private Spinner firstValue;
    @FXML
    private Spinner secondValue;
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

    public void clickSpinner(MouseEvent mouseEvent) {
        Spinner spinner = (Spinner) mouseEvent.getSource();

        if (spinner.getValueFactory() == null) {
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9));
        }

        count();
    }

    private void count() {
        if ((menu.getText().isEmpty()) || (firstValue.getValueFactory() == null) || (secondValue.getValueFactory() == null)) {
            result.setText("");
            return;
        }

        int firstNumber = (Integer) firstValue.getValue();
        int secondNumber = (Integer) secondValue.getValue();

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
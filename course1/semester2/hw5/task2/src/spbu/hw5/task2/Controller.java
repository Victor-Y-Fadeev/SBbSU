package spbu.hw5.task2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/** Controller class for JavaFX. */
public class Controller {
    private StackCalculator calculator;
    @FXML
    private TextField display;

    public Controller() {
        calculator = new StackCalculator();
    }

    public void clickButton(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();

        calculator.computing(button.getText());
        display.setText(calculator.getOutput());
    }
}
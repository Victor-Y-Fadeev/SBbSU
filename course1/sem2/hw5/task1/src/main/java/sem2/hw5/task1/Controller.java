package sem2.hw5.task1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;


/** Controller class for JavaFX. */
public class Controller implements Initializable {
    private Calculator calculator;
    @FXML
    private MenuButton menu;
    @FXML
    private Spinner firstValue;
    @FXML
    private Spinner secondValue;
    @FXML
    private TextField result;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calculator = new Calculator();
        int minValue = calculator.getMinValue();
        int maxValue = calculator.getMaxValue();

        firstValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(minValue, maxValue));
        secondValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(minValue, maxValue));
    }

    /** Recount result value after menu changes. */
    public void changeOperation(ActionEvent actionEvent) {
        MenuItem temp = (MenuItem) actionEvent.getSource();
        menu.setText(temp.getText());
        setResult();
    }

    /** Recount result value after Spinner changes. */
    public void clickSpinner(MouseEvent mouseEvent) {
        setResult();
    }

    private void setResult() {
        if (menu.getText().equals("")) {
            return;
        }

        int firstNumber = (Integer) firstValue.getValue();
        int secondNumber = (Integer) secondValue.getValue();

        if ((menu.getText().equals("/")) && (secondNumber == 0)) {
            result.setText("");
            return;
        }

        int answer = calculator.count(menu.getText(), firstNumber, secondNumber);
        result.setText(Integer.toString(answer));
    }
}
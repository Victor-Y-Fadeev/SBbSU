package spbu.test2.task1;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


/** Controller class for JavaFX. */
public class Controller {
    private final int N = 4;
    private Pair pair;
    private Button tempButton;


    /** Create controller. */
    public Controller() {
        pair = new Pair(N);
        tempButton = null;
    }

    /** Choose the pair. */
    public void clickButton(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();

        int rowIndex = getRowIndex(button);
        int columnIndex = getColumnIndex(button);

        if (tempButton == null) {
            tempButton = button;
            return;
        }

        int tempColumnIndex = getColumnIndex(tempButton);
        int tempRowIndex = getRowIndex(tempButton);

        if ((rowIndex == tempRowIndex) && (columnIndex == tempColumnIndex)) {
            return;
        }

        pair.checkButtons(columnIndex, rowIndex, tempColumnIndex, tempRowIndex);
        button.setText(pair.getFirstButton());
        tempButton.setText(pair.getSecondButton());

        if (pair.checkEquals()) {
            button.setDisable(true);
            tempButton.setDisable(true);
        } else {
            button.setText("");
            tempButton.setText("");
        }

        tempButton = null;
    }

    private int getRowIndex(Button button) {
        Integer rowIndex = GridPane.getRowIndex(button);

        if (rowIndex == null) {
            rowIndex = 0;
        }

        return rowIndex;
    }

    private int getColumnIndex(Button button) {
        Integer columnIndex = GridPane.getColumnIndex(button);

        if (columnIndex == null) {
            columnIndex = 0;
        }

        return columnIndex;
    }
}
package spbu.hw7.task2;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/** Controller class for JavaFX. */
public class Controller {
    private TicTacToe game;

    /** Create controller. */
    public Controller() {
        game = new TicTacToe();
    }

    /** To move the game. */
    public void clickButton(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();

        Integer rowIndex = GridPane.getRowIndex(button);
        Integer columnIndex = GridPane.getColumnIndex(button);

        if (rowIndex == null) {
            rowIndex = 0;
        }
        if (columnIndex == null) {
            columnIndex = 0;
        }

        button.setText(game.toMove(rowIndex, columnIndex));
    }
}
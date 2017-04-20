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

        button.setText(game.toMove(button.getText()));
    }
}
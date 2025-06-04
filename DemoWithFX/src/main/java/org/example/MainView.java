package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainView {

    @FXML
    private Label greetingLabel;

    @FXML
    private TextField nameField;

    @FXML
    protected void handleGreet() {
        String name = nameField.getText();
        greetingLabel.setText("Hello" + name + "!");
    }

}

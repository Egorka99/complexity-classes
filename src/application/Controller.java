package application;

import algoritms.p.PrimeNumberCheck;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class Controller {

    @FXML
    private TextField cliqueVCountTextBox;

    @FXML
    private TextArea cliqueLinksTextBox;

    @FXML
    private Label cliqueVLabel;

    @FXML
    private ListView<?> cliqueResultTextBox;

    @FXML
    private Button cliqueButton;

    @FXML
    private TextArea tspMatrixTextBox;

    @FXML
    private ListView<?> tspResultListBox;

    @FXML
    private Button tspButton;

    @FXML
    private TextField primeNumberTextBox;

    @FXML
    private Label primeNumberResultMessage;

    @FXML
    private Button primeNumberButton;

    @FXML
    private TextField minDistX1TextBox;

    @FXML
    private TextField minDistY1TextBox;

    @FXML
    private TextField minDistX2TextBox;

    @FXML
    private TextField minDistY2TextBox;

    @FXML
    private Label test; 

    @FXML
    private Button minDistButton;

    @FXML
    private Label minDistResultMessage;

    @FXML
    void cliqueButton_click(ActionEvent event) {
    }

    @FXML
    void minDistButton_click(ActionEvent event) {

    }

    @FXML
    void primeNumberButton_click(ActionEvent event) {
        try {
            int inputNumber = Integer.parseInt(primeNumberTextBox.getText());
            if (PrimeNumberCheck.isPrime(inputNumber)) {
                test.setText("PRime");
            } else {
                test.setText("PRimenot");
            }
        } catch (Exception ex) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Ошибка");
            errorAlert.show();
        }
    }

    @FXML
    void tspButton_click(ActionEvent event) {

    }
}
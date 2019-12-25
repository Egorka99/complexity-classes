package application;

import algoritms.np.CliqueTask;
import algoritms.np.Graph;
import algoritms.np.Node;
import algoritms.np.TravellingSalesmanProblem;
import algoritms.p.MinDistance;
import algoritms.p.Point;
import algoritms.p.PrimeNumberCheck;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    @FXML
    private TextField cliqueVCountTextBox;

    @FXML
    private TextArea cliqueLinksTextBox;

    @FXML
    private Label cliqueVLabel;

    @FXML
    private ListView<String> cliqueResultTextBox;

    @FXML
    private Button cliqueButton;

    @FXML
    private TextArea tspMatrixTextBox;

    @FXML
    private ListView<String> tspResultListBox;

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
    private TextField tspCitiesCountTextBox;

    @FXML
    private Label test; 

    @FXML
    private Button minDistButton;

    @FXML
    private Label minDistResultMessage;

    @FXML
    void cliqueButton_click(ActionEvent event) {
        int countV = Integer.parseInt(cliqueVCountTextBox.getText());
        String input = cliqueLinksTextBox.getText();
        String[] lines = input.split("\\n");

        Graph g = new Graph();

        String[] vert = new String[countV];
        String vertInfo = "";
        for (int i = 0; i < countV; i++) {
            vertInfo+=i + " ";
            vert[i] = String.valueOf(i);
        }
        cliqueVLabel.setText(vertInfo);

        for(String v : vert) {
            g.addNode(v);
        }

        for (int i = 0; i < lines.length; i++) {
            String[] tempArray = lines[i].split(" ");
            g.addEdge(tempArray[0],tempArray[1]);
        }
        List<Node> R = new ArrayList<>();
        List<Node> X = new ArrayList<>();
        List<Node> P = g.getUniverse();
        CliqueTask cliqueTask = new CliqueTask();
        cliqueTask.bronKerbosch(R,P,X);

        ObservableList<String> listOfItems = FXCollections.observableArrayList(cliqueTask.getResult());
        cliqueResultTextBox.setItems(listOfItems);
    }

    @FXML
    void minDistButton_click(ActionEvent event) {
        try {
            int X1 = Integer.parseInt(minDistX1TextBox.getText());
            int Y1 = Integer.parseInt(minDistY1TextBox.getText());
            int X2 = Integer.parseInt(minDistX2TextBox.getText());
            int Y2 = Integer.parseInt(minDistY2TextBox.getText());

            double result = MinDistance.calculateMinDistanceBetweenTwoPoints(new Point(X1,Y1),new Point(X2,Y2));
            minDistResultMessage.setText(String.valueOf(result));
        }
        catch (Exception ex) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Ошибка");
            errorAlert.show();
        }
    }

    @FXML
    void primeNumberButton_click(ActionEvent event) {
        try {
            int inputNumber = Integer.parseInt(primeNumberTextBox.getText());
            if (PrimeNumberCheck.isPrime(inputNumber)) {
                test.setText("Число является простым");
            } else {
                test.setText("Число не является простым");
            }
        } catch (Exception ex) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Ошибка");
            errorAlert.show();
        }
    }

    @FXML
    void tspButton_click(ActionEvent event) {
        String input = tspMatrixTextBox.getText();
        Integer N = Integer.parseInt(tspCitiesCountTextBox.getText());


        String[] matrixLine = input.split("\\n");
        List<String> lineElements = new ArrayList<>();
        for (int i = 0; i < matrixLine.length; i++) {
            String[] tempArray = matrixLine[i].split(",");
            lineElements.addAll(Arrays.asList(tempArray));
        }

        int[][] dists = new int[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dists[i][j] = Integer.parseInt(lineElements.get(count));
                count++;
                System.out.print(dists[i][j] + " ");
            }
            System.out.println();
        }

        TravellingSalesmanProblem travellingSalesmanProblem = new TravellingSalesmanProblem(dists);
        travellingSalesmanProblem.permutation(1);
        ObservableList<String> listOfItems = FXCollections.observableArrayList(travellingSalesmanProblem.getResult());
        tspResultListBox.setItems(listOfItems);
    }
}
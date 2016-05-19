package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class MainController {


    @FXML public TextArea txt2;
    @FXML private TextField txt1;
    @FXML private Button btn2Save;
    public void initialize() {
        System.out.println("Application started");

    }

    @FXML private void btn2SaveClicked(ActionEvent event) {
        System.out.println("Btn 1 save clicked");
    }

}
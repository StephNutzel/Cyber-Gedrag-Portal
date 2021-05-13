package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {

    @FXML private Button loginButton;

    private MainController mainController;

    public void setReferenceToMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void handelLoginButtonPressed() {
        try {
            mainController.startMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

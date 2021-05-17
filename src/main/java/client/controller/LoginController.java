package client.controller;

import client.MainClient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import server.MainServer;
import server.model.User;

public class LoginController {

    @FXML private Button loginButton;
    @FXML private TextField emailTextField;
    @FXML private TextField passwordTextField;

    public void handelLoginButtonPressed() {
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        User user = MainServer.attemptLogin(email, password);
        if (user == null) {
            return;
        }
        MainServer.start(user);
        MainClient.startMain();
    }

}

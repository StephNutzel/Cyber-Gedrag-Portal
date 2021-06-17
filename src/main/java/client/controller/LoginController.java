package client.controller;

import client.MainClient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import server.MainServer;
import server.model.Tester;

public class LoginController {

    @FXML private Button loginButton;
    @FXML private TextField emailTextField;
    @FXML private TextField passwordTextField;

    @FXML
    public void initialize() {
        emailTextField.setText("n.poelenjee@gmail.com");
        passwordTextField.setText("Np300902");
    }

    public void handelLoginButtonPressed() {
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        Tester tester = MainServer.attemptLogin(email, password);
        if (tester == null) {
            passwordTextField.setText(null);
            return;
        }
        MainServer.start(tester);
        MainClient.startMain();
    }

}

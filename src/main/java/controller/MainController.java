package controller;

import com.intellij.ide.ui.EditorOptionsTopHitProvider;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController {

    private Parent root;
    private Stage stage;
    private static int SCENE_WIDTH, SCENE_HEIGHT;

    public MainController() {

    }

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        startLogin();
    }

    public void startLogin() throws Exception {
        SCENE_WIDTH = 600;
        SCENE_HEIGHT = 440;
        stage.setTitle("Human Cyber Lab: Portal");
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/login.fxml"));
        root = loader.load();
        LoginController loginController = (LoginController)loader.getController();
        loginController.setReferenceToMainController(this);
        Scene loginScene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setX((Screen.getPrimary().getBounds().getWidth() - SCENE_WIDTH)/2);
        stage.setY((Screen.getPrimary().getBounds().getHeight() - SCENE_HEIGHT)/2);
        stage.setResizable(false);
        stage.setScene(loginScene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }

    public void startMain() throws Exception {
        SCENE_WIDTH = 1080;
        SCENE_HEIGHT = 720;
        stage.setTitle("Human Cyber Lab: Portal");
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/base.fxml"));
        root = loader.load();
        BaseController baseController = (BaseController)loader.getController();
        baseController.setReferenceToMainController(this);
        baseController.setupPage();
        Scene homeScene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setX((Screen.getPrimary().getBounds().getWidth() - SCENE_WIDTH)/2);
        stage.setY((Screen.getPrimary().getBounds().getHeight() - SCENE_HEIGHT)/2);
        stage.setResizable(true);
        stage.setScene(homeScene);
    }
}

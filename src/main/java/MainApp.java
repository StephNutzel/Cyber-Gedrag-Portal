import com.intellij.ide.ui.EditorOptionsTopHitProvider;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private int SCENE_WIDTH, SCENE_HEIGHT;

    public static void main(String[] args) {
        System.out.println("Program Start");
        launch(args);
        System.out.println("Program End");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainController mainController = new MainController();
        mainController.start(primaryStage);

    }


}

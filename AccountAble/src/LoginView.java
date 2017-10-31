import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginView extends Application {

    public static void main(String[] args) {
        Application.launch(LoginView.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
     
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        stage.setTitle("FXML Welcome");
        stage.setScene(new Scene(root, 300, 275));
        stage.setMaximized(true);
        stage.show();
    }
}
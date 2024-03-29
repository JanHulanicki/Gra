package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Rummi-klikamy w komorke gridPane a nastepnie w klocek");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

package application.View;
	
import application.Model.EntenModel;
import application.database.api.SqlConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EntenView.fxml"));
			Scene scene = new Scene(loader.load());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("RENT-A-ENT");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../duck.png")));
			primaryStage.setMinHeight(400);
			primaryStage.setMinWidth(600);
			primaryStage.setScene(scene);
			SqlConnector.connect("localhost", "3306", "rentaent", "admin", "heinzketchup");
			loader.<EntenModel>getController().init();
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}

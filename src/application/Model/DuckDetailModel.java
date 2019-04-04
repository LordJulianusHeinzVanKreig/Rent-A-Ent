package application.Model;

import application.database.entities.Duck;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DuckDetailModel {
	
	Text DuckDetailName;
	Text DuckDetailAge;
	Text DuckDetailGender;
	Text DuckDetailTemperament;
	Text DuckDetailDescription;
	Text DuckDetailType;
	
	public DuckDetailModel(Duck duck) {
		this.DuckDetailName.setText(duck.getName());
		this.DuckDetailAge.setText(Integer.toString(duck.getAge()));
		if(duck.isGender()) this.DuckDetailGender.setText("Männlich");
		else this.DuckDetailGender.setText("Weiblich");
		this.DuckDetailTemperament.setText(Integer.toString(duck.getTemperament()));
		
	}
	
	public void startDuckDetailStage() {
		Stage DuckDetailStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../View/DuckDetailView.fxml"));
			Scene DuckDetailScene = new Scene(root);
//			DuckDetailScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			DuckDetailStage.setScene(DuckDetailScene);
			DuckDetailStage.setTitle("Enten-Details");
			DuckDetailStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

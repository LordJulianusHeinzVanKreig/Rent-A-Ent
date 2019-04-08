package application.Model;

import application.database.entities.Duck;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DuckDetailModel {
	
	@FXML
	Text DuckDetailName;
	@FXML
	Text DuckDetailAge;
	@FXML
	Text DuckDetailGender;
	@FXML
	Text DuckDetailTemperament;
	@FXML
	TextArea DuckDetailType;
	@FXML
	TextArea DuckDetailDescription;
	
//	public DuckDetailModel(Duck duck) {
////		
////		this.DuckDetailName.setText(duck.getName());
////		this.DuckDetailAge.setText(Integer.toString(duck.getAge()));
////		if(duck.isGender()) this.DuckDetailGender.setText("Männlich");
////		else this.DuckDetailGender.setText("Weiblich");
////		this.DuckDetailTemperament.setText(Integer.toString(duck.getTemperament()));
////		this.DuckDetailType.setText("Region:" + duck.getType().getRegion() + "\n");
////		this.DuckDetailType.setText("Brutzeit:" + duck.getType().getBreedTime() + "\n");
////		this.DuckDetailType.setText("Max. Alter:" + duck.getType().getMaxAge() + "\n");
////		this.DuckDetailDescription.setText(duck.getDescription());
//		
//	}
	
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

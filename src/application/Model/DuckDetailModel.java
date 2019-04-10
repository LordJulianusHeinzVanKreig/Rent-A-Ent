package application.Model;

import application.database.entities.Duck;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

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
	Text DuckDetailType;
	@FXML
	Text DuckDetailDescription;
	
	
	public void startDuckDetailStage(Duck duck) {
		
			DuckDetailName.setText(duck.getName());
			DuckDetailAge.setText(Integer.toString(duck.getAge()));
			if(duck.isGender()) DuckDetailGender.setText("Männlich");
			else DuckDetailGender.setText("Weiblich");
			DuckDetailTemperament.setText(Integer.toString(duck.getTemperament()));
			DuckDetailType.setText("Region: " + duck.getType().getRegion() + "\n" + 
					"Brutzeit: " + duck.getType().getBreedTime() + "\n" + 
					"Max. Alter: " + duck.getType().getMaxAge() + "\n");
			DuckDetailDescription.setText(duck.getDescription());
				
	}

}

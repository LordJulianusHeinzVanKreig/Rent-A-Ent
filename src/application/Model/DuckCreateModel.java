package application.Model;


import java.sql.SQLException;
import java.util.List;

import application.database.api.DuckRepository;
import application.database.api.DuckTypeRepository;
import application.database.entities.Duck;
import application.database.entities.DuckType;
import application.database.entities.Location;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DuckCreateModel {

	@FXML
	TextField NameTextID;
	@FXML
	TextField AgeTextID;
	@FXML
	ChoiceBox<String> GenderTextID;
	@FXML
	TextField TemperamentTextID;
	@FXML
	ChoiceBox TypeTextID;
	@FXML
	TextField DescriptionTextID;
	List<DuckType> list;
	Location Location;
	
	
	@FXML
	public void onClickDuckCreate() {
		
		DuckType dt = null;
		boolean gender;
		for (DuckType duckType : list) {
			if(duckType.getRegion().equals(TypeTextID.getSelectionModel().getSelectedItem())) {
				dt = duckType;
			}
		}

		if(GenderTextID.getSelectionModel().getSelectedItem().equals("männlich")) {
			gender = true;
		}else gender = false;
		Duck duck = new Duck(0, Integer.parseInt(AgeTextID.getText()), NameTextID.getText(), DescriptionTextID.getText(), Integer.parseInt(TemperamentTextID.getText()) , gender, dt);
		
		DuckRepository.addDuck(duck, Location);
		Stage s = (Stage) NameTextID.getScene().getWindow();
		s.fireEvent(new WindowEvent(s, WindowEvent.WINDOW_CLOSE_REQUEST));
	}
	
	public void startDuckCreateStage(Location location) {
		try {
			Location = location;
			
			list = DuckTypeRepository.getAllDuckTypes();
			for (DuckType duckType : list) {
				TypeTextID.getItems().add(duckType.getName());
			}
			GenderTextID.getItems().add("männlich");
			GenderTextID.getItems().add("weiblich");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}

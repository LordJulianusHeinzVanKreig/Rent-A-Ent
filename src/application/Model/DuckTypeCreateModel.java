package application.Model;

import java.util.Date;

import application.database.api.DuckTypeRepository;
import application.database.entities.DuckType;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DuckTypeCreateModel {

	@FXML
	TextField DuckTypeCreateName;
	@FXML
	TextField DuckTypeCreateBreedTime;
	@FXML
	TextField DuckTypeCreateRegion;
	@FXML
	TextField DuckTypeCreateMaxAge;
	
	@FXML
	public void onClickDuckTypeCreate() {
		DuckType dt = new DuckType(0, DuckTypeCreateName.getText(), Integer.parseInt(DuckTypeCreateBreedTime.getText()), DuckTypeCreateRegion.getText(), Integer.parseInt(DuckTypeCreateMaxAge.getText()));
		DuckTypeRepository.addDuckType(dt);
		Stage s = (Stage) this.DuckTypeCreateName.getScene().getWindow();
		s.fireEvent(new WindowEvent(s, WindowEvent.WINDOW_CLOSE_REQUEST));
	}
}

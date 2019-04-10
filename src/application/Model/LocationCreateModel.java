package application.Model;

import application.database.api.LocationRepository;
import application.database.entities.Location;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LocationCreateModel {
	@FXML
	TextField LocationCreateStreet;
	@FXML
	TextField LocationCreateHouseNumber;
	@FXML
	TextField LocationCreateZipCode;
	
	@FXML
	public void onOkButtonPressed() {
		if(LocationCreateStreet.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Straße benötigt!");
			alert.showAndWait();
			return;
		} else if(LocationCreateHouseNumber.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Hausnummer benötigt!");
			alert.showAndWait();
			return;
		} else if(LocationCreateZipCode.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Postleitzahl benötigt!");
			alert.showAndWait();
			return;
		}
		int plz;
		try {			
			plz = Integer.parseInt(this.LocationCreateZipCode.getText());
		} catch(NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Postleitzahl keine Zahl!");
			alert.showAndWait();
			return;
		}
		Location loca = new Location(0, this.LocationCreateStreet.getText(), plz, this.LocationCreateHouseNumber.getText(), null);
		LocationRepository.addLocation(loca);
		Stage s = (Stage) this.LocationCreateStreet.getScene().getWindow();
		s.fireEvent(new WindowEvent(s, WindowEvent.WINDOW_CLOSE_REQUEST));
	}
}

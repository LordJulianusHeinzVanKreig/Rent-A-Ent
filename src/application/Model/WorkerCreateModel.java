package application.Model;

import application.database.api.WorkerRepository;
import application.database.entities.Customer;
import application.database.entities.Location;
import application.database.entities.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class WorkerCreateModel {
	Location Location;
	@FXML
	TextField FirstNameText;
	@FXML
	TextField LastNameText;
	@FXML
	TextField HouseNumberText;
	@FXML
	TextField ZipCodeText;
	@FXML
	TextField StreetText;
	@FXML
	TextField phoneNumberText;
	@FXML
	TextField ageText;
	@FXML
	TextField HoursText;

	@FXML
	public void sendOnClick() {

		if (FirstNameText.getText().equals("")) {
			this.showError("Vorname benötigt!");
			return;
		} else if (LastNameText.getText().equals("")) {
			this.showError("Nachname benötigt!");
			return;
		} else if (StreetText.getText().equals("")) {
			this.showError("Straße benötigt!");
			return;
		} else if (HouseNumberText.getText().equals("")) {
			this.showError("Hausnummer benötigt!");
			return;
		} else if (ZipCodeText.getText().equals("")) {
			this.showError("PLZ benötigt!");
			return;
		} else if (phoneNumberText.getText().equals("")) {
			this.showError("Telefonnummer benötigt!");
			return;
		} else if (ageText.getText().equals("")) {
			this.showError("Telefonnummer benötigt!");
			return;
		} else if (HoursText.getText().equals("")) {
			this.showError("Telefonnummer benötigt!");
			return;
		}
		int zipCode;
		try {
			zipCode = Integer.parseInt(ZipCodeText.getText());
		} catch (Exception e) {
			this.showError("Zip Code hat falsches Format");
			return;
		}
		Worker cu = new Worker(0, FirstNameText.getText(), LastNameText.getText(), HouseNumberText.getText(), zipCode,
				StreetText.getText(), phoneNumberText.getText(), 40, 40);
		WorkerRepository.addWorker(cu, Location);
		Stage s = (Stage) FirstNameText.getScene().getWindow();
		s.fireEvent(new WindowEvent(s, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	public void startWorkerCreateStage(Location location) {
		Location = location;
	}

	private void showError(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}
}

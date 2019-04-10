package application.Model;

import application.database.api.CustomerRepository;
import application.database.api.LocationRepository;
import application.database.entities.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CustomerCreateModel {
	@FXML
	TextField CustomerCreateFirstName;
	@FXML
	TextField CustomerCreateLastName;
	@FXML
	TextField CustomerCreateStreet;
	@FXML
	TextField CustomerCreateHouseNumber;
	@FXML
	TextField CustomerCreateZipCode;
	@FXML
	TextField CustomerCreateTelephoneNumber;
	
	public void onOkButtonClick() {
		if(CustomerCreateFirstName.getText().equals("")) {
			this.showError("Vorname benötigt!");
			return;
		} else if(CustomerCreateLastName.getText().equals("")) {
			this.showError("Nachname benötigt!");
			return;
		} else if(CustomerCreateStreet.getText().equals("")) {
			this.showError("Straße benötigt!");
			return;
		} else if(CustomerCreateHouseNumber.getText().equals("")) {
			this.showError("Hausnummer benötigt!");
			return;
		} else if(CustomerCreateZipCode.getText().equals("")) {
			this.showError("PLZ benötigt!");
			return;
		} else if(CustomerCreateTelephoneNumber.getText().equals("")) {
			this.showError("Telefonnummer benötigt!");
			return;
		}
		int zipCode;
		try {
			zipCode = Integer.parseInt(CustomerCreateZipCode.getText());
		} catch (Exception e) {
			this.showError("Zip Code hat falsches Format");
			return;
		}
		Customer cu = new Customer(0, CustomerCreateFirstName.getText(), CustomerCreateLastName.getText(), CustomerCreateHouseNumber.getText(),
				zipCode, CustomerCreateStreet.getText(), CustomerCreateTelephoneNumber.getText(), 0);
		CustomerRepository.addCustomer(cu);
		Stage s = (Stage) CustomerCreateFirstName.getScene().getWindow();
		s.fireEvent(new WindowEvent(s, WindowEvent.WINDOW_CLOSE_REQUEST));
	}
	
	private void showError(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}
}

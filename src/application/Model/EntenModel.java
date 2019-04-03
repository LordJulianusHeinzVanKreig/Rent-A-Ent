package application.Model;

import application.entities.Location;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class EntenModel  {
	
	
	@FXML
	ListView<Location> listLocations;
	@FXML
	ListView listDucks;
	@FXML
	ListView listWorkers;
	
	@FXML
	public void handleOnClickListLocations(MouseEvent event) {
		
		System.out.println(listLocations.getSelectionModel().getSelectedItem().getStreet());
	}
	
	@FXML
	public void handleOnClickListDucks() {
		System.out.println("check");
	}
	
	@FXML 
	public void handleOnClickListWorkers() {
		
	}
	
	@FXML
	public void handleButton(ActionEvent event) {
		listLocations.getItems().add(new Location(1,"hi",2, "hi2"));
	}
	
}

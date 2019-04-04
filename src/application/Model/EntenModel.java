package application.Model;

import application.Model.cellFactories.DuckViewCell;
import application.Model.cellFactories.LocationViewCell;
import application.Model.cellFactories.WorkerViewCell;
import application.entities.Duck;
import application.entities.Location;
import application.entities.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class EntenModel  {
	
	
	@FXML
	ListView<Location> listLocations;
	@FXML
	ListView<Duck> listDucks;
	@FXML
	ListView<Worker> listWorkers;
	
	@FXML
	public void handleOnClickListLocations(MouseEvent event) {
		listDucks.getItems().add(new Duck(1, 2, "kevin", "stinks", 500, true));
		listDucks.setCellFactory(new Callback<ListView<Duck>,ListCell<Duck>>(){
			@Override
			public ListCell<Duck> call(ListView<Duck> listDucks){
				return new DuckViewCell();
			}
		});
		listWorkers.getItems().add(new Worker(2, "Gustav", "Gans", "35", 91717, "Dönerstraße", "010101", 35, 17));
		listWorkers.setCellFactory(new Callback<ListView<Worker>,ListCell<Worker>>(){
			@Override
			public ListCell<Worker> call(ListView<Worker> listWorkers){
				return new WorkerViewCell();
			}
		});
	}
	
	@FXML
	public void handleOnClickListDucks() {
		
	}
	
	@FXML 
	public void handleOnClickListWorkers() {
		
	}
	
	@FXML
	public void handleButton(ActionEvent event) {
		listLocations.getItems().add(new Location(1,"Entenstraße 27",2, "hi2"));
		listLocations.setCellFactory(new Callback<ListView<Location>,ListCell<Location>>(){
			@Override
			public ListCell<Location> call(ListView<Location> listLocations){
				return new LocationViewCell();
			}
		});
	}
}

package application.Model;

import java.sql.SQLException;
import java.util.List;

import application.Model.cellFactories.DuckViewCell;
import application.Model.cellFactories.LocationViewCell;
import application.Model.cellFactories.WorkerViewCell;
import application.database.api.DuckRepository;
import application.database.api.LocationRepository;
import application.database.api.WorkerRepository;
import application.database.entities.Duck;
import application.database.entities.DuckType;
import application.database.entities.Location;
import application.database.entities.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
		Location location = listLocations.getSelectionModel().getSelectedItem();
		try {
			List<Worker>workers = WorkerRepository.getWorkersfromLocation(location);
			listDucks.getItems().clear();
			for (Worker worker : workers) {
				listWorkers.getItems().add(worker);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		listDucks.setCellFactory(new Callback<ListView<Duck>,ListCell<Duck>>(){
			@Override
			public ListCell<Duck> call(ListView<Duck> listDucks){
				return new DuckViewCell();
			}
		});
		
		try {
			List<Duck>ducks = DuckRepository.getAllDucksFromLocation(location);
			listDucks.getItems().clear();
			for (Duck duck : ducks) {
				listDucks.getItems().add(duck);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		listWorkers.setCellFactory(new Callback<ListView<Worker>,ListCell<Worker>>(){
			@Override
			public ListCell<Worker> call(ListView<Worker> listWorkers){
				return new WorkerViewCell();
			}
		});
	}
	
	@FXML
	public void handleOnClickListDucks() {
		
		Stage DuckDetailStage = new Stage();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/DuckDetailView.fxml"));
			Scene DuckDetailScene = new Scene(loader.load());
			DuckDetailModel model = loader.<DuckDetailModel>getController();
//			DuckDetailScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			DuckDetailStage.setScene(DuckDetailScene);
			DuckDetailStage.setTitle("Enten-Details");
			DuckDetailStage.show();
			Duck selectedDuck =	listDucks.getSelectionModel().getSelectedItem();
			model.startDuckDetailStage(selectedDuck);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	@FXML 
	public void handleOnClickListWorkers() {
		
		Stage DuckDetailStage = new Stage();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/WorkerDetailView.fxml"));
			Scene DuckDetailScene = new Scene(loader.load());
			WorkerDetailModel model = loader.<WorkerDetailModel>getController();
//			DuckDetailScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			DuckDetailStage.setScene(DuckDetailScene);
			DuckDetailStage.setTitle("Mitarbeiter-Details");
			DuckDetailStage.show();
			Worker selectedWorker =	listWorkers.getSelectionModel().getSelectedItem();
			model.startWorkerDetailStage(selectedWorker);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void init() {
		
		try {
			List<Location>locations = LocationRepository.getAllLocations();
			listLocations.getItems().clear();
			for (Location location: locations) {
				listLocations.getItems().add(location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listLocations.setCellFactory(new Callback<ListView<Location>,ListCell<Location>>(){
			@Override
			public ListCell<Location> call(ListView<Location> listLocations){
				return new LocationViewCell();
			}
		});
	}
}

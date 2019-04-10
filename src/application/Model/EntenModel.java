package application.Model;

import java.sql.SQLException;
import java.util.List;

import application.Model.cellFactories.CustomerViewCell;
import application.Model.cellFactories.DuckViewCell;
import application.Model.cellFactories.LocationViewCell;
import application.Model.cellFactories.WorkerViewCell;
import application.database.api.CustomerRepository;
import application.database.api.DuckRepository;
import application.database.api.LocationRepository;
import application.database.api.WorkerRepository;
import application.database.entities.Customer;
import application.database.entities.Duck;
import application.database.entities.Location;
import application.database.entities.Worker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class EntenModel  {
	
	@FXML
	ListView<Location> listLocations;
	@FXML
	ListView<Duck> listDucksOfCustomer;
	@FXML
	ListView<Duck> listDucks;
	@FXML
	ListView<Worker> listWorkers;
	@FXML
	ListView<Customer> listCustomers;
	@FXML
	Text CustomerDetailID;
	@FXML
	Text CustomerDetailFirstName;
	@FXML
	Text CustomerDetailLastName;
	@FXML
	Text CustomerDetailHouseNumber;
	@FXML
	Text CustomerDetailZipCode;
	@FXML
	Text CustomerDetailStreet;
	@FXML
	Text CustomerDetailPhoneNumber;
	@FXML
	Text CustomerDetailRating;
	
	@FXML
	public void handleOnClickListLocations(MouseEvent event) {
		Location location = listLocations.getSelectionModel().getSelectedItem();
		try {
			List<Worker>workers = WorkerRepository.getWorkersfromLocation(location);
			listWorkers.getItems().clear();
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
	
	private void fillCustomerInformationList(Customer customer) {
		CustomerDetailID.setText(Integer.toString(customer.getId()));
		CustomerDetailFirstName.setText(customer.getFirstName());
		CustomerDetailLastName.setText(customer.getLastName());
		CustomerDetailHouseNumber.setText(customer.getHouseNumber());
		CustomerDetailZipCode.setText(Integer.toString(customer.getZipCode()));
		CustomerDetailStreet.setText(customer.getStreet());
		CustomerDetailPhoneNumber.setText(customer.getPhoneNumber());
		CustomerDetailRating.setText(Integer.toString(customer.getRating()));
		
	}
	
	@FXML 
	public void handleOnClickListCustomers(MouseEvent event) {
		Customer customer = listCustomers.getSelectionModel().getSelectedItem();
		fillCustomerInformationList(customer);
		try {  // done
			List<Duck>ducks = DuckRepository.getAllDucksFromCustomer(customer);
			listDucksOfCustomer.getItems().clear();
			for (Duck duck : ducks) {
				listDucksOfCustomer.getItems().add(duck);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		
		try {
			List<Customer>customers = CustomerRepository.getAllCustomer();
			listCustomers.getItems().clear();
			for (Customer customer : customers) {
				listCustomers.getItems().add(customer);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		listLocations.setCellFactory(new Callback<ListView<Location>,ListCell<Location>>(){
			@Override
			public ListCell<Location> call(ListView<Location> listLocations){
				return new LocationViewCell();
			}
		});
		
		listCustomers.setCellFactory(new Callback<ListView<Customer>,ListCell<Customer>>(){
			@Override
			public ListCell<Customer> call(ListView<Customer> listWorkers){
				return new CustomerViewCell();
			}
		});
	}
}

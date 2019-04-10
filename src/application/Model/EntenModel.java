package application.Model;

import java.sql.SQLException;
import java.util.List;

import application.Model.cellFactories.CustomerViewCell;
import application.Model.cellFactories.DucksOfCustomerViewCell;
import application.Model.cellFactories.LocationViewCell;
import application.Model.cellFactories.WorkerViewCell;
import application.database.api.CustomerRepository;
import application.database.api.DuckRepository;
import application.database.api.DuckTypeRepository;
import application.database.api.LocationRepository;
import application.database.api.WorkerRepository;
import application.database.entities.Customer;
import application.database.entities.Duck;
import application.database.entities.DuckType;
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
	Text LocationDetailStreet;
	@FXML
	Text LocationDetailHouseNumber;
	@FXML
	Text LocationDetailZipCode;
	@FXML
	Text LocationDetailLeader;
	
	@FXML
	public void handleOnClickListLocations(MouseEvent event) {
		Location location = listLocations.getSelectionModel().getSelectedItem();
		
		refreshWorkersOfLocation(location);
		
		listWorkers.setCellFactory(new Callback<ListView<Worker>,ListCell<Worker>>(){
			@Override
			public ListCell<Worker> call(ListView<Worker> listWorkers){
				return new WorkerViewCell();
			}
		});
	
		refreshDucksOfLocation(location);
		
		listDucks.setCellFactory(new Callback<ListView<Duck>,ListCell<Duck>>(){
			@Override
			public ListCell<Duck> call(ListView<Duck> listDucks){
				return new DucksOfCustomerViewCell();
			}
		});
		
		fillLocationInformation(location);
	}
	
	private void fillLocationInformation(Location location) {
		
		if(location.getHouseNumber() != null) LocationDetailHouseNumber.setText(location.getHouseNumber());
		if(location.getStreet() != null) LocationDetailStreet.setText(location.getStreet());
		LocationDetailZipCode.setText(Integer.toString(location.getZipCode()));
		if(location.getLeader() != null) {
			LocationDetailLeader.setText(location.getLeader().getFirstName() + " " + location.getLeader().getLastName());
		} else {
			LocationDetailLeader.setText("none");
		}
			
		
	}
	
	private void fillCustomerInformation(Customer customer) {
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
		fillCustomerInformation(customer);
		
		refreshDucksForCustomer(customer);
		
		listDucksOfCustomer.setCellFactory(new Callback<ListView<Duck>,ListCell<Duck>>(){
			@Override
			public ListCell<Duck> call(ListView<Duck> listDucksOfCustomer){
				return new DucksOfCustomerViewCell();
			}
		});
		
	}
	
	@FXML 
	public void handleOnClickListDucksOfCustomer() {
		
		Duck selectedDuck =	listDucksOfCustomer.getSelectionModel().getSelectedItem();
		listDucksOfCustomer.getSelectionModel().clearSelection();
		if(selectedDuck != null) {
			try {
				Stage DuckDetailStage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/DuckDetailView.fxml"));
				Scene DuckDetailScene = new Scene(loader.load());
				DuckDetailModel model = loader.<DuckDetailModel>getController();
	//			DuckDetailScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				DuckDetailStage.setScene(DuckDetailScene);
				DuckDetailStage.setTitle("Enten-Details");
				DuckDetailStage.show();
				model.startDuckDetailStage(selectedDuck);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@FXML
	public void handleOnClickListDucks() {

		Duck selectedDuck =	listDucks.getSelectionModel().getSelectedItem();
		listDucksOfCustomer.getSelectionModel().clearSelection();
		if(selectedDuck != null) {
			try {
				Stage DuckDetailStage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/DuckDetailView.fxml"));
				Scene DuckDetailScene = new Scene(loader.load());
				DuckDetailModel model = loader.<DuckDetailModel>getController();
//			DuckDetailScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				DuckDetailStage.setScene(DuckDetailScene);
				DuckDetailStage.setTitle("Enten-Details");
				DuckDetailStage.show();
				model.startDuckDetailStage(selectedDuck);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@FXML 
	public void handleOnClickListWorkers() {

		Worker selectedWorker =	listWorkers.getSelectionModel().getSelectedItem();
		listDucksOfCustomer.getSelectionModel().clearSelection();
		if(selectedWorker != null) {
			try {
				Stage DuckDetailStage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/WorkerDetailView.fxml"));
				Scene DuckDetailScene = new Scene(loader.load());
				WorkerDetailModel model = loader.<WorkerDetailModel>getController();
//			DuckDetailScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				DuckDetailStage.setScene(DuckDetailScene);
				DuckDetailStage.setTitle("Mitarbeiter-Details");
				DuckDetailStage.show();
				model.startWorkerDetailStage(selectedWorker);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
	
	private void reloadLocations() {		
		try {
			List<Location>locations = LocationRepository.getAllLocations();
			listLocations.getItems().clear();
			for (Location location: locations) {
				listLocations.getItems().add(location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void reloadCustomers() {
		try {
			List<Customer>customers = CustomerRepository.getAllCustomer();
			listCustomers.getItems().clear();
			for (Customer customer : customers) {
				listCustomers.getItems().add(customer);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	private void refreshWorkersOfLocation(Location location) {
		try {
			List<Worker>workers = WorkerRepository.getWorkersfromLocation(location);
			listWorkers.getItems().clear();
			for (Worker worker : workers) {
				listWorkers.getItems().add(worker);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void refreshDucksOfLocation(Location location) {
		try {
			List<Duck>ducks = DuckRepository.getAllDucksFromLocation(location);
			listDucks.getItems().clear();
			for (Duck duck : ducks) {
				listDucks.getItems().add(duck);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void refreshDucksForCustomer(Customer customer) {
		try {  // done
			List<Duck>ducks = DuckRepository.getAllDucksFromCustomer(customer);
			listDucksOfCustomer.getItems().clear();
			for (Duck duck : ducks) {
				listDucksOfCustomer.getItems().add(duck);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refreshDuckTypes() {
		try {
			List<DuckType> duckTypes = DuckTypeRepository.getAllDuckTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void init() {
		
		this.reloadLocations();
		
		this.reloadCustomers();
		
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
	
	@FXML
	public void onClickLocationCreate() {
		try {
			Stage LocationCreateStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/LocationCreateView.fxml"));
			Scene LocationCreateScene = new Scene(loader.load());
			LocationCreateStage.setScene(LocationCreateScene);
			LocationCreateStage.setTitle("Standort erstellen");
			LocationCreateStage.show();
			LocationCreateStage.setOnCloseRequest(event -> this.reloadLocations());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@FXML
	public void onClickDuckForLocationCreate() {
		
		Location selectedLocation = listLocations.getSelectionModel().getSelectedItem();

		if(selectedLocation != null) {
			try {
				Stage DuckCreateStage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/DuckCreateView.fxml"));
				Scene DuckCreateScene = new Scene(loader.load());
				DuckCreateModel model = loader.<DuckCreateModel>getController();
//			DuckDetailScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				DuckCreateStage.setScene(DuckCreateScene);
				DuckCreateStage.show();
				DuckCreateStage.setTitle("Ente erstellen");
				DuckCreateStage.setOnCloseRequest(Event -> refreshDucksOfLocation(selectedLocation));
				model.startDuckCreateStage(selectedLocation);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
	}
	
	@FXML
	public void onClickWorkerForLocationCreate() {
		Location selectedLocation = listLocations.getSelectionModel().getSelectedItem();
		if(selectedLocation != null) {			
			try {
				Stage WorkerCreateStage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/WorkerCreateView.fxml"));
				
				Scene WorkerCreateScene = new Scene(loader.load());
				WorkerCreateModel model = loader.<WorkerCreateModel>getController();
				WorkerCreateStage.setScene(WorkerCreateScene);
				
				WorkerCreateStage.setTitle("Mitarbeiter erstellen");
				WorkerCreateStage.show();
				WorkerCreateStage.setOnCloseRequest(event -> this.reloadLocations());
				model.startWorkerCreateStage(selectedLocation);
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}
	
	@FXML
	public void onClickCustomerCreate() {
		try {
			Stage CustomerCreateStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/CustomerCreateView.fxml"));
			Scene CustomerCreateScene = new Scene(loader.load());
			CustomerCreateStage.setScene(CustomerCreateScene);
			CustomerCreateStage.setTitle("Kunde erstellen");
			CustomerCreateStage.show();
			CustomerCreateStage.setOnCloseRequest(event -> this.reloadCustomers());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	@FXML
	public void onClickDuckTypeCreate() {
		try {
			Stage DuckTypeCreateStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/DuckTypeCreateView.fxml"));
			Scene DuckTypeCreateScene = new Scene(loader.load());
			DuckTypeCreateStage.setScene(DuckTypeCreateScene);
			DuckTypeCreateStage.setTitle("Ententyp erstellen");
			DuckTypeCreateStage.show();
			DuckTypeCreateStage.setOnCloseRequest(event -> refreshDuckTypes());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * this is the most important function
	 */
	@FXML
	public void onClickRentAEntByCustomer() {
		Customer selectedCustomer = this.listCustomers.getSelectionModel().getSelectedItem();
		if(selectedCustomer != null) {
			try {
				Stage DuckRentStage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/DuckRentView.fxml"));
				Scene DuckRentScene = new Scene(loader.load());
				DuckRentStage.setScene(DuckRentScene);
				DuckRentStage.setTitle("Ente ausleihen");
				DuckRentStage.show();
				loader.<DuckRentModel>getController().startDuckRentModel(selectedCustomer);
				DuckRentStage.setOnCloseRequest(event -> refreshDucksForCustomer(selectedCustomer));
			} catch (Exception e) {
				e.printStackTrace();
			}				
		}
	}
	
	@FXML
	public void onClickSelectLeader() {
		Location selectedLocation = this.listLocations.getSelectionModel().getSelectedItem();
		if(selectedLocation != null) {
			try {
				Stage LeaderSelectStage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/LeaderSelectView.fxml"));
				Scene LeaderSelectScene = new Scene(loader.load());
				LeaderSelectStage.setScene(LeaderSelectScene);
				LeaderSelectStage.setTitle("Leiter auswählen");
				LeaderSelectStage.show();
				loader.<LeaderSelectModel>getController().startLeaderSelectModel(selectedLocation);
				LeaderSelectStage.setOnCloseRequest(event -> {
					reloadLocations();
					for (Location l : listLocations.getItems()) {
						if(l.getId() == selectedLocation.getId()) {
							listLocations.getSelectionModel().select(l);
							fillLocationInformation(l);
							refreshDucksOfLocation(l);
							refreshWorkersOfLocation(l);
							break;
						}
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}				
		}
	}
	
}

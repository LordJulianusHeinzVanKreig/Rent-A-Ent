package application.Model;

import java.sql.SQLException;
import java.util.List;

import application.Model.cellFactories.DucksOfCustomerViewCell;
import application.Model.cellFactories.WorkerViewCell;
import application.database.api.DuckRepository;
import application.database.api.LocationRepository;
import application.database.api.WorkerRepository;
import application.database.entities.Customer;
import application.database.entities.Duck;
import application.database.entities.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

import application.database.entities.Location;;

public class LeaderSelectModel {
	@FXML
	Text LocationName;
	
	@FXML
	ComboBox<Worker> LeaderSelect;
	
	Location Location;
	List<Worker> Workers;
	
	public void startLeaderSelectModel(Location location) {
		Location = location;
		LocationName.setText(location.getStreet());
		try {
			Workers = WorkerRepository.getWorkersfromLocation(Location);
			for (Worker worker : Workers) {
				LeaderSelect.getItems().add(worker);
			}
			Callback<ListView<Worker>, ListCell<Worker>> cb = new Callback<ListView<Worker>,ListCell<Worker>>(){
				@Override
				public ListCell<Worker> call(ListView<Worker> listDucks){
					return new WorkerViewCell();
				}
			};
			LeaderSelect.setButtonCell(cb.call(null));
			LeaderSelect.setCellFactory(cb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onClickOkButton() {
		Worker leader = LeaderSelect.getValue();
		if(leader != null) {
			LocationRepository.addLeaderToLocation(Location, leader);
		}
		Stage s = (Stage) LeaderSelect.getScene().getWindow();
		s.fireEvent(new WindowEvent(s, WindowEvent.WINDOW_CLOSE_REQUEST));
	}
}

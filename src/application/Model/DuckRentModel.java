package application.Model;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

import java.sql.SQLException;
import java.util.List;

import application.Model.cellFactories.DucksOfCustomerViewCell;
import application.database.api.DuckRepository;
import application.database.entities.Customer;
import application.database.entities.Duck;

public class DuckRentModel {
	@FXML
	Text DuckRenterName;
	
	@FXML
	ComboBox<Duck> DuckSelect;
	
	Customer Customer;
	List<Duck> Ducks;
	
	public void startDuckRentModel(Customer customer) {
		Customer = customer;
		DuckRenterName.setText(customer.getFirstName() + " " + customer.getLastName());
		try {
			Ducks = DuckRepository.getAllUnrentedDucks();
			for (Duck duck : Ducks) {
				DuckSelect.getItems().add(duck);
			}
			Callback<ListView<Duck>, ListCell<Duck>> cb = new Callback<ListView<Duck>,ListCell<Duck>>(){
				@Override
				public ListCell<Duck> call(ListView<Duck> listDucks){
					return new DucksOfCustomerViewCell();
				}
			};
			DuckSelect.setButtonCell(cb.call(null));
			DuckSelect.setCellFactory(cb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onClickOkButton() {
		Duck selectedDuck = DuckSelect.getValue();
		if(selectedDuck != null) {			
			DuckRepository.giveDuckToCustomer(selectedDuck, Customer);
		}
		Stage s = (Stage) DuckSelect.getScene().getWindow();
		s.fireEvent(new WindowEvent(s, WindowEvent.WINDOW_CLOSE_REQUEST));
	}
}

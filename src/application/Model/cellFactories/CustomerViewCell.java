package application.Model.cellFactories;

import application.database.entities.Customer;
import javafx.scene.control.ListCell;

public class CustomerViewCell extends ListCell<Customer>{

	@Override
	public void updateItem(Customer customer, boolean empty) {
		super.updateItem(customer, empty);
		if(!empty) {
			setText(customer.getLastName());
		}
	}
}

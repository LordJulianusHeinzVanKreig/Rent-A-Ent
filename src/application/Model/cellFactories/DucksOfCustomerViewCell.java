package application.Model.cellFactories;

import application.database.entities.Duck;
import javafx.scene.control.ListCell;

public class DucksOfCustomerViewCell extends ListCell<Duck> {
	
	@Override
	public void updateItem(Duck duck, boolean empty) {
		super.updateItem(duck, empty);
		if(!empty) {
			setText(duck.getName());
		}
	}

}

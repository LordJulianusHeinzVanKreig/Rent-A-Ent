package application.Model.cellFactories;

import application.entities.Location;
import javafx.scene.control.ListCell;

public class LocationViewCell extends ListCell<Location>{
		
	@Override
	public void updateItem(Location location, boolean empty) {
		super.updateItem(location, empty);
		if(!empty) {
			setText(location.getStreet() +"");
			
		}
	}
}

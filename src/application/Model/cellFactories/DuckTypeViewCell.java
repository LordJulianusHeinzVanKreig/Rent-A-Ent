package application.Model.cellFactories;

import application.database.entities.DuckType;
import javafx.scene.control.ListCell;

public class DuckTypeViewCell extends ListCell<DuckType> {
	
	@Override
	public void updateItem(DuckType duckType, boolean empty) {
		super.updateItem(duckType, empty);
		if(!empty) {
			setText(duckType.getName());
		}
	}
}

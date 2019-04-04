package application.Model.cellFactories;

import application.entities.Duck;
import javafx.scene.control.ListCell;

public class DuckViewCell extends ListCell<Duck>{

	@Override
	public void updateItem(Duck duck, boolean empty) {
		super.updateItem(duck, empty);
		if(!empty) {
			setText(duck.getName());
		}
	}
}

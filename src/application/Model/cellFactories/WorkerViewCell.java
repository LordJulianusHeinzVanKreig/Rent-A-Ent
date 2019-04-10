package application.Model.cellFactories;

import application.database.entities.Worker;
import javafx.scene.control.ListCell;

public class WorkerViewCell extends ListCell<Worker> {
	
	@Override
	public void updateItem(Worker worker, boolean empty) {
		super.updateItem(worker, empty);
		if(!empty) {
			setText(worker.getFirstName() + " " + worker.getLastName());
		}
	}
}

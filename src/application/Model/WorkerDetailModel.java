package application.Model;

import application.database.entities.Worker;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class WorkerDetailModel {
	
	@FXML
	Text WorkerDetailID;
	@FXML
	Text WorkerDetailFirstName;
	@FXML
	Text WorkerDetailLastName;
	@FXML
	Text WorkerDetailHouseNumber;
	@FXML
	Text WorkerDetailZipCode;
	@FXML
	Text WorkerDetailStreet;
	@FXML
	Text WorkerDetailPhoneNumber;
	@FXML
	Text WorkerDetailAge;
	@FXML
	Text WorkerDetailWorkHours;
	
	public void startWorkerDetailStage(Worker worker) {
		WorkerDetailID.setText(Integer.toString(worker.getId()));
		WorkerDetailFirstName.setText(worker.getFirstName());
		WorkerDetailLastName.setText(worker.getLastName());
		WorkerDetailHouseNumber.setText(worker.getHouseNumber());
		WorkerDetailZipCode.setText(Integer.toString(worker.getZipCode()));
		WorkerDetailStreet.setText(worker.getStreet());
		WorkerDetailPhoneNumber.setText(worker.getPhoneNumber());
		WorkerDetailAge.setText(Integer.toString(worker.getAge()));
		WorkerDetailWorkHours.setText(Integer.toString(worker.getWorkHours()));
		
	}

}

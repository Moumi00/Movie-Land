package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorViewController 
{
	@FXML
	private Label errorMessage;
	@FXML
	private Button closeButton;

	// Event Listener on Button[#closeButton].onAction
	@FXML
	public void handleCloseButton(ActionEvent event) 
	{
		// TODO Autogenerated
	  Stage currentStage = (Stage) this.closeButton.getScene().getWindow();
    currentStage.close();
	}
	
	public void setErrorMessage(String error)
	{
	  this.errorMessage.setText(error);
	}
}

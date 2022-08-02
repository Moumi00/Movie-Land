package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utilities.*;

import java.io.IOException;

import dataclass.Person;
import javafx.event.ActionEvent;

public class UserAccountViewerController 
{
  @FXML
  private ImageView profilePicture;
  @FXML
  private TextField handleTextField;
	@FXML
	private Button logoutbutton;
	@FXML
	private Button addAmoviebutton;
	@FXML
	private Button homepageButton;
	@FXML
	private Button archiveButton;
	
	private String profilePicturePath;
	
	private Person currentPerson;
	
	public void updateProfileImageViewNode()
  {
    Image profileImage = new Image("file://" + this.profilePicturePath);
    this.profilePicture.setImage(profileImage);
  }
	
	// Event Listener on Button[#logoutbutton].onAction
	@FXML
	public void handleLogoutbuttonClicked(ActionEvent event) throws IOException
	{
	  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogInViewer.fxml"));
    Pane root = (Pane) fxmlLoader.load();
    Scene scene = new Scene(root);
    Stage primaryStage = (Stage) this.logoutbutton.getScene().getWindow(); 
    primaryStage.setScene(scene);
    primaryStage.show();
	}
	
	// Event Listener on Button[#addAmoviebutton].onAction
	@FXML
	public void handleAddAmovieButtonClicked(ActionEvent event) 
	{
	  Stage primaryStage = (Stage) this.addAmoviebutton.getScene().getWindow();
    ViewUtilities.showMovieAdder(primaryStage, currentPerson);
	}
	
	// Event Listener on Button[#homepageButton].onAction
	@FXML
	public void handleHomepageButtonClicked(ActionEvent event) throws IOException 
	{
	  Stage primaryStage = (Stage) this.homepageButton.getScene().getWindow();
    ViewUtilities.showHomePage(primaryStage);
	}
	
	// Event Listener on Button[#archiveButton].onAction
	@FXML
	public void handleArchiveButtonClicked(ActionEvent event) throws IOException 
	{
		// TODO: Make it work as a error message
	  Stage primaryStage = (Stage) this.addAmoviebutton.getScene().getWindow();
	  System.out.println(currentPerson);
    ViewUtilities.showArchiveViewer(primaryStage, currentPerson);
	}
	
	public void transferPersonData(Person chosenPerson)
	{
	  
	  this.currentPerson = chosenPerson;
	  System.out.println(currentPerson);
	  handleTextField.setText(chosenPerson.getHandle());
	  
	  this.profilePicturePath = chosenPerson.getPathToProfilePicture();
	  updateProfileImageViewNode();
	}
}

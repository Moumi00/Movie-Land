package application;

import java.io.IOException;

import dataclass.Person;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewUtilities
{
  public static void showErrorMessageDialougeBox(String error, Stage parentStage) 
  {
    try
    {
      FXMLLoader fxmlLoader = new FXMLLoader(ViewUtilities.class.getResource("ErrorView.fxml"));
      Pane root = (Pane) fxmlLoader.load();
      ErrorViewController errorViewController = fxmlLoader.getController();
      errorViewController.setErrorMessage(error);
      
      Scene errorViewScene = new Scene(root);
      Stage errorStage = new Stage();
      errorStage.setScene(errorViewScene);
      errorStage.initOwner(parentStage);
      errorStage.initModality(Modality.APPLICATION_MODAL);
      errorStage.setTitle("ERROR!!");
      errorStage.showAndWait();
    }
    catch(Exception exception)
    {
      exception.printStackTrace();
    }
    
  }
  
  public static void showMessage(String message, Stage parentStage)
  {
    try
    {
      FXMLLoader fxmlLoader = new FXMLLoader(ViewUtilities.class.getResource("Message.fxml"));
      Pane root = (Pane) fxmlLoader.load();
      MessageController messageController = fxmlLoader.getController();
      messageController.setMessage(message);
      
      Scene messageScene = new Scene(root);
      Stage messageStage = new Stage();
      messageStage.setScene(messageScene);
      messageStage.initOwner(parentStage);
      messageStage.initModality(Modality.APPLICATION_MODAL);
      messageStage.setTitle("Conformation");
      messageStage.showAndWait();
    }
    catch(Exception exception)
    {
      exception.printStackTrace();
    }
  }
  
  public static void showMovieAdder(Stage parentStage, Person person)
  {
    try
    {
      FXMLLoader fxmlLoader = new FXMLLoader(ViewUtilities.class.getResource("AddMovieViewer.fxml"));
      Pane root = (Pane) fxmlLoader.load();
      
      AddMovieViewerController addMovieViewerController = (AddMovieViewerController) fxmlLoader.getController();
      addMovieViewerController.transferData(person);
      
      Scene addMovieScene = new Scene(root);
      Stage addMovieStage = new Stage();
      addMovieStage.setScene(addMovieScene);
      addMovieStage.initOwner(parentStage);
      addMovieStage.initModality(Modality.APPLICATION_MODAL);
      addMovieStage.setTitle("Conformation");
      addMovieStage.showAndWait();
    }
    catch(Exception exception)
    {
      exception.printStackTrace();
    }
  }
  
  public static void showArchiveViewer(Stage parentStage, Person person)
  {
    try
    {
      FXMLLoader fxmlLoader = new FXMLLoader(ViewUtilities.class.getResource("ArchiveViewer.fxml"));
      System.out.println(fxmlLoader);
      FlowPane root = fxmlLoader.load();
      
      ArchiveViewerController archiveViewerController = (ArchiveViewerController) fxmlLoader.getController();
      System.out.println(person);
      archiveViewerController.transferPersonData(person);
      
      Scene archiveScene = new Scene(root);
      Stage archiveStage = new Stage();
      archiveStage.setScene(archiveScene);
      archiveStage.initOwner(parentStage);
      archiveStage.initModality(Modality.APPLICATION_MODAL);
      archiveStage.setTitle("My Archive");
      archiveStage.showAndWait();
    }
    catch(Exception exception)
    {
      exception.printStackTrace();
    } 
  }
  
  public static void showHomePage(Stage parentStage)
  {
    try
    {
      FXMLLoader fxmlLoader = new FXMLLoader(ViewUtilities.class.getResource("HomePage.fxml"));
      System.out.println(fxmlLoader);
      FlowPane root = fxmlLoader.load();
      
      Scene homeScene = new Scene(root);
      Stage homeStage = new Stage();
      homeStage.setScene(homeScene);
      homeStage.initOwner(parentStage);
      homeStage.initModality(Modality.APPLICATION_MODAL);
      homeStage.setTitle("My Home Page");
      homeStage.showAndWait();
    }
    catch(Exception exception)
    {
      exception.printStackTrace();
    } 
  }
}

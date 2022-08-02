package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dataclass.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.ListView;
import utilities.Serializer;

public class ArchiveViewerController 
{
	@FXML
	private ListView<String> favoriteListView;
	@FXML
	private ListView<String> viewListView;
	@FXML
	private ListView<String> reviewListView;
	@FXML
	private ListView<String> ratedListView;
	@FXML
	private ListView<String> wishListView;
	
	private Person currentPerson;
	
  private ObservableList<String> observablePersonList1;
  private ObservableList<String> observablePersonList2;
  private ObservableList<String> observablePersonList3;
  private ObservableList<String> observablePersonList4;
  private ObservableList<String> observablePersonList5;
  //?? Should I make 5 observable List?
	
  public void transferPersonData(Person chosenPerson)
  {
    this.currentPerson = chosenPerson;
    observablePersonList1 = FXCollections.observableArrayList(currentPerson.favorite);
    favoriteListView.setItems(observablePersonList1);
    
    observablePersonList2 = FXCollections.observableArrayList(currentPerson.viewed);
    viewListView.setItems(observablePersonList2);
    
    ArrayList<String> newList = new ArrayList<String>();
    for(Map.Entry<String, String> key : currentPerson.review.entrySet()) 
    {
      newList.add(key.getKey() + " : " + key.getValue());
    }
    
    observablePersonList4 = FXCollections.observableArrayList(newList);
    reviewListView.setItems(observablePersonList4);
    
    newList = new ArrayList<String>();
    for(Map.Entry<String, String> key : currentPerson.rating.entrySet()) 
    {
      newList.add(key.getKey() + " : " + key.getValue());
    }
    
    observablePersonList5 = FXCollections.observableArrayList(newList);
    ratedListView.setItems(observablePersonList5);
    
    observablePersonList3 = FXCollections.observableArrayList(currentPerson.wishlist);
    wishListView.setItems(observablePersonList3);    
  }
  
  @FXML
	public void initialize()
	{
	  System.out.println(currentPerson);
	  
	}

}

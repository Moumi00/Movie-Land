package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utilities.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import dataclass.*;


public class AddMovieViewerController 
{
	@FXML
	private TextField movieName;
	@FXML
	private CheckBox favoriteChecker;
	@FXML
	private TextField reviewMovie;
	@FXML
	private TextField ratingMovie;
	@FXML
	private CheckBox wishlistChecker;
	@FXML
	private CheckBox viewChecker;
  @FXML
	private Button cancelButton;
  @FXML
  private Button saveButton;
  
  private int currentPersonIndex;
  
  private Set<Movie> movieSetList;
  
  private Person currentPerson;
  
  //private HashMap<String, ArrayList> movieMapList; //Might change Set<Movie> to HashMap later on
  
  private ArrayList<Person> personArrayList;
  
  public void ResetUI()
  {
    this.movieName.setText("");
    this.reviewMovie.setText("");
    this.ratingMovie.setText("");
    this.favoriteChecker.setSelected(false);
    this.viewChecker.setSelected(false);
    this.wishlistChecker.setSelected(false);
  }
	
  public boolean isContained(Movie movie)
  {
    for(Movie x: movieSetList)
    {
      if(x.getName().equals(movie.getName()))
        return true;
    }    
    return false;
  }
  
	@FXML
  void handleCancelButton(ActionEvent event) 
	{
	  ResetUI();
	  Stage currentStage = (Stage) this.cancelButton.getScene().getWindow();
    currentStage.close();
  }

  @FXML
  void handleSaveButton(ActionEvent event) 
  {
    String movie = movieName.getText();
    String review = reviewMovie.getText();
    String rating = ratingMovie.getText();
    
    double ratingInNumber = Double.parseDouble(rating);
    boolean favorite = favoriteChecker.isSelected();
    boolean wishlist = wishlistChecker.isSelected();
    
    boolean reviewed = true;
    if(review.equals(""))
      reviewed = false;
    
    if(wishlist)
      viewChecker.setSelected(false);
    else
      viewChecker.setSelected(true);
    boolean viewed = viewChecker.isSelected();
    
    Scanner scanner = new Scanner(rating);
    
    boolean flag = true;
    
    if(!scanner.hasNextDouble())
    {
      flag = false;
      Stage primaryStage = (Stage) this.saveButton.getScene().getWindow();
      String error = "Invalid! Rating should be a number.";
      ViewUtilities.showErrorMessageDialougeBox(error, primaryStage);
    }
    
    else if(ratingInNumber > 10)
    {
      flag = false;
      Stage primaryStage = (Stage) this.saveButton.getScene().getWindow();
      String error = "You should rate the movie out of 10.";
      ViewUtilities.showErrorMessageDialougeBox(error, primaryStage);
    }
    
    else if(movie.equals(""))
    {
      flag = false;
      Stage primaryStage = (Stage) this.saveButton.getScene().getWindow();
      String error = "Movie name should not be empty.";
      ViewUtilities.showErrorMessageDialougeBox(error, primaryStage);
    }
      
    Movie chosenMovie = new Movie(movie, favorite, reviewed, ratingInNumber, wishlist, viewed);
    
    if(!isContained(chosenMovie))
    {
      movieSetList.add(chosenMovie);
    }
    
    for(Movie x: movieSetList)
    {
      if(favorite)
      {
        personArrayList.get(this.currentPersonIndex).favorite.add(movie);
        currentPerson.favorite.add(movie);
        x.increaseFavourite();
      }
      
      if(wishlist)
      {
        personArrayList.get(this.currentPersonIndex).wishlist.add(movie);
        currentPerson.wishlist.add(movie);
        x.increaseWishlist();
      }
      
      if(viewed)
      {
        personArrayList.get(this.currentPersonIndex).viewed.add(movie);
        currentPerson.viewed.add(movie);
        //Because it means the user have already seen the movie.
        personArrayList.get(this.currentPersonIndex).wishlist.remove(movie);
        currentPerson.wishlist.remove(movie);
        x.increaseViews();
      }
      
      if(reviewed)
      {
        x.increaseReviews();
        
        //If the user change his mind, he can easily change the review of a movie he reviewed before. 
        //Only his latest review will be saved.
        personArrayList.get(this.currentPersonIndex).review.put(movie, review);
        currentPerson.review.put(movie, review);
      }
      
      if(ratingInNumber != 0)
      {
        x.increaseRating(ratingInNumber);
        
        //If the user change his mind, he can easily change the rating of a movie he rated before. 
        //Only his latest rating of the movie  will be saved.
        personArrayList.get(this.currentPersonIndex).rating.put(movie, rating);
        currentPerson.rating.put(movie, rating);
      }
    }
    SerializerSet.serialize("./Movies.bin", movieSetList);
    Serializer.serialize("./Accounts.bin", personArrayList);
    
    if(flag)
    {
      Stage primaryStage = (Stage) this.saveButton.getScene().getWindow();
      String message = "Your changes have been saved succesfully";
      ViewUtilities.showMessage(message, primaryStage);
      primaryStage.close(); 
    }  
  }
  
  public void transferData(Person person)
  {
    System.out.println(person);
    currentPerson = person;
    for(int i = 0; i < personArrayList.size(); i++)
    {
      if(personArrayList.get(i).getHandle().equals(person.getHandle()))
      {
        this.currentPersonIndex = i;
        break;
      }
    }
    System.out.println(this.currentPersonIndex);
  }
  
  public void initialize()
  {
   
    ratingMovie.setText("0");;
    personArrayList = Serializer.deserialize("./Accounts.bin");

    movieSetList = SerializerSet.deserialize("./Movies.bin");
    
    if (movieSetList == null)
    {
      movieSetList = new HashSet<Movie>();
    }

  }
}

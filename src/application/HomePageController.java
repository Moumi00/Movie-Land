package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javafx.event.ActionEvent;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utilities.SerializerSet;
import dataclass.Movie;
import java.util.Comparator;

public class HomePageController
{
	@FXML
	private ImageView ImageView;
	@FXML
	private TextField mostViewed1;
	@FXML
	private TextField mostViewed2;
	@FXML
	private TextField mostViewed3;
	@FXML
	private TextField mostFavourite1;
	@FXML
	private TextField mostFavourite2;
	@FXML
	private TextField mostFavourite3;
	@FXML
	private TextField mostReviewed1;
	@FXML
	private TextField mostReviewed2;
	@FXML
	private TextField mostReviewed3;
	@FXML
	private TextField topRated1;
	@FXML
	private TextField topRated2;
	@FXML
	private TextField topRated3;
	@FXML
	private TextField topWishlist1;
	@FXML
	private TextField topWishlist2;
	@FXML
	private TextField topWishlist3;
	@FXML
	private Button closeButton;

	private Set<Movie> movieSetList;
	
	//The ArrayList that will help storing top three movies of every attributes
	private ArrayList<Movie> Topers;
	
	// Event Listener on Button[#closeButton].onAction
	@FXML
	public void handleCloseButtonClicked(ActionEvent event) throws IOException 
	{
		// TODO Autogenerated
	  ((Stage)this.closeButton.getScene().getWindow()).close();
	}
	
	public void FavSort()
	{
	  Topers.sort((a, b) -> 
	  {
	    if(a.getFavourite() == b.getFavourite())
	      return 0;
	    return a.getFavourite() > b.getFavourite() ? -1: 1;
	  });
	  
	  mostFavourite1.setText(Topers.get(0).getName());
	  mostFavourite2.setText(Topers.get(1).getName());
	  mostFavourite3.setText(Topers.get(2).getName());
	}
	
	public void ViewSort()
  {
    Topers.sort((a, b) -> 
    {
      if(a.getViews() == b.getViews())
        return 0;
      return a.getViews() > b.getViews() ? -1: 1;
    });
    
    mostViewed1.setText(Topers.get(3).getName());
    mostViewed2.setText(Topers.get(4).getName());
    mostViewed3.setText(Topers.get(5).getName());
  }
	
	public void ReviewSort()
  {
    Topers.sort((a, b) -> 
    {
      if(a.getReviews() == b.getReviews())
        return 0;
      return a.getReviews() > b.getReviews() ? -1: 1;
    });
    
    mostReviewed1.setText(Topers.get(6).getName());
    mostReviewed2.setText(Topers.get(7).getName());
    mostReviewed3.setText(Topers.get(8).getName());
  }
	
	public void RatingSort()
  {
    Topers.sort((a, b) -> 
    {
      if(a.getRating() == b.getRating())
        return 0;
      return a.getRating() > b.getRating() ? -1: 1;
    });
    
    topRated1.setText(Topers.get(9).getName());
    topRated2.setText(Topers.get(10).getName());
    topRated3.setText(Topers.get(11).getName());
  }
	
	public void WishlistSort()
  {
    Topers.sort((a, b) -> 
    {
      if(a.getWishlist() == b.getWishlist())
        return 0;
      return a.getWishlist() > b.getWishlist() ? -1: 1;
    });
    
    topWishlist1.setText(Topers.get(12).getName());
    topWishlist2.setText(Topers.get(13).getName());
    topWishlist3.setText(Topers.get(14).getName());
  }
	
	public void initialize()
	{
	  movieSetList = SerializerSet.deserialize("./Movies.bin");
	  
	  if (movieSetList == null)
    {
      movieSetList = new HashSet<Movie>();
    }
	  
	  if(Topers == null)
	  {
	    Topers = new ArrayList<>(movieSetList);
	    for(int i = 0; i < 15; i++)
	    {
	      Topers.add(new Movie());
	    }
	  }
	  //Should I declare here?
	  FavSort();
	  ViewSort();
	  ReviewSort();
	  RatingSort();
	  WishlistSort();
	}
}

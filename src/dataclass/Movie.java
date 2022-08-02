package dataclass;

import java.io.Serializable;

public class Movie implements Serializable
{
  private String name = "";
  private long favourite = 0;
  private long views = 0;
  private double rating = 0;
  private long wishlist = 0;
  private long reviews = 0;
  
  public Movie()
  {
    this.name = "";
    this.favourite = 0;
    this.views = 0;
    this.rating = 0;
    this.wishlist = 0;
    this.reviews = 0;
  }
  
  public Movie(String name, boolean favorite, boolean reviewed, double rating, boolean wishlist, boolean viewed)
  {
    this.name = name;
    this.rating = (this.rating + rating) / 20;
    
    if(favorite)
      this.favourite++;
    
    if(reviewed)
      this.reviews++;
    
    if(wishlist)
      this.wishlist++;
    
    if(viewed)
      this.views++;
  }
  
  public void increaseFavourite()
  {
    this.favourite++;
  }
  
  public void increaseViews()
  {
    this.views++;
  }
  
  public void increaseRating(double ratings)
  {
    this.rating = (this.rating + ratings) / 20;
  }
  
  public String getName()
  {
    return name;
  }

  public long getFavourite()
  {
    return favourite;
  }

  public long getViews()
  {
    return views;
  }
  
  public double getRating()
  {
    return rating;
  }

  public long getWishlist()
  {
    return wishlist;
  }

  public long getReviews()
  {
    return reviews;
  }

  public void increaseReviews()
  {
    this.reviews++;
  }
  
  public void increaseWishlist()
  {
    this.wishlist++;
  }
}

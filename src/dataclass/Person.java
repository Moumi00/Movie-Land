package dataclass;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Person implements Serializable ///Might delete later
{
  ///private static final long serialVersionUID = -6820912904576758442L;
  
  private String firstName;
  private String lastName;
  private String handle; //Must be unique for every person
  private String password;
  private String gender;
  private LocalDate dateOfBirth;
  
  private String pathToProfilePicture;
  
  public Set<String> favorite = new HashSet<>();
  public Set<String> wishlist = new HashSet<>();
  public Set<String> viewed = new HashSet<>();
  public Map<String, String> review = new HashMap<>();
  public Map<String, String> rating = new HashMap<>();
  
  public Person(String firstName, String lastName, String handle, String gender, 
                LocalDate dateOfBirth, String password, String pathToProfilePicture)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.handle = handle;
    this.password = password;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.pathToProfilePicture = pathToProfilePicture;
  }

  public String getPathToProfilePicture()
  {
    return pathToProfilePicture;
  }

  public void setPathToProfilePicture(String pathToProfilePicture)
  {
    this.pathToProfilePicture = pathToProfilePicture;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getHandle()
  {
    return handle;
  }

  public void setHandle(String handle)
  {
    this.handle = handle;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getGender()
  {
    return gender;
  }

  public void setGender(String gender)
  {
    this.gender = gender;
  }

  public LocalDate getDateOfBirth()
  {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth)
  {
    this.dateOfBirth = dateOfBirth;
  } 
  
  public String toString()
  {
    StringBuilder x = new StringBuilder("-------------------------------------------------------------------------\n");
    x.append("\nFirst name: " + this.firstName);
    x.append("\nLast name: " + this.lastName);
    x.append("\nHandle: " + this.handle);
    x.append("\nGender: " + this.gender);
    x.append("\nDate of Birth: " + this.dateOfBirth);
    x.append("\nPassword: " + this.password);
    x.append("\n-------------------------------------------------------------------------");
    return x.toString();
  }
}


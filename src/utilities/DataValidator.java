package utilities;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.*;

import dataclass.Person;

public class DataValidator
{
  private static final int VALID_NAME_LENGTH  = 3;
  private static final int VALID_PASSWORD_LENGTH  = 8;
  
  public static void isValidData(String firstName, String lastName, String handle, String gender, LocalDate date, String password, 
      String confirmPassword, String pathToProfilePicture, ArrayList<Person> personList) 
  throws Exception
  {
    if(isNameInvalid(firstName))
    {
      throw new InvalidNameException(firstName + " is not valid. Names must have at least " + VALID_NAME_LENGTH + " characters.");
    } 
    
    if(isNameInvalid(lastName))
    {
      throw new InvalidNameException(lastName + " is not valid. Names must have at least " + VALID_NAME_LENGTH + " characters.");
    }
    
    if(isHandleInvalid(handle))
    {
      throw new InvalidHandleException(handle + " is not valid. First character of a handle must be an alphabet.");
    }
    
    if(isNull(gender))
    {
      throw new NullException("Gender must be chosen. Probably you did not choose a valid gender?");
    }
    
    if(isNull(date)) 
    {
      throw new NullException("Date must be chosen. Probably you did not choose a valid date of birth?");
    }
    
    if(isPasswordInvalid(password))
    {
      throw new InvalidPasswordException("Password must be atLeast " + VALID_PASSWORD_LENGTH + " characters.");
    }
    
    if(!confirmPassword.equals(password))
    {
      throw new InvalidPasswordException("Password does not match. Please try again.");
    }
    
    if (isNull(pathToProfilePicture)) 
    {
      throw new NullException("Invalid path to profile picture. Maybe you didn't select a path?");
    }
    
    for(int i = 0; i < personList.size(); i++)
    {
      if(personList.get(i).getHandle().equals(handle))
      {
        throw new InvalidHandleException(handle + " is already used. Please try something else.");
      }
    }
    
  }
  
  private static <T> boolean isNull(T data) 
  { 
    return data == null;
  }
  
  private static boolean isNameInvalid(String name)
  {
    return (isNull(name) || name.length() < VALID_NAME_LENGTH);
  }
  
  private static boolean isHandleInvalid(String handle)
  {
    return !Character.isAlphabetic(handle.charAt(0));
  }
  
  private static boolean isPasswordInvalid(String password)
  {
    return (isNull(password) || password.length() < VALID_PASSWORD_LENGTH);
  }
}

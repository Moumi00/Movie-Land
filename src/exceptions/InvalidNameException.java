package exceptions;

public class InvalidNameException extends Exception
{
  private static final long serialVersionUID = -5084526013652975263L;
  
  public InvalidNameException()
  {
    super();
  }
  
  public InvalidNameException(String error)
  {
    super(error);
  }
}


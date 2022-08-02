package exceptions;

public class InvalidPasswordException extends Exception
{
  private static final long serialVersionUID = -1234545613652975263L;
  
  public InvalidPasswordException()
  {
    super();
  }
  
  public InvalidPasswordException(String error)
  {
    super(error);
  }
}

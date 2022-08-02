package exceptions;

public class InvalidHandleException extends Exception
{
  private static final long serialVersionUID = -4168545613652975263L;
  
  public InvalidHandleException()
  {
    super();
  }
  
  public InvalidHandleException(String error)
  {
    super(error);
  }
}

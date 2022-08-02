package exceptions;

public class NullException extends Exception
{
  private static final long serialVersionUID = -8548545613652975263L;
  
  public NullException()
  {
    super();
  }
  
  public NullException(String error)
  {
    super(error);
  }
}

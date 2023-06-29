package CustomExceptions;

@SuppressWarnings("serial")
public class EmployeeHandlingException extends Exception{
	public EmployeeHandlingException(String errMsg) {
		super(errMsg);
	}
}

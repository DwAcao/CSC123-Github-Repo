public class Customer 
{
	// fields
	private String firstName;
	private String lastName;
	private String SSN;
	
	//constructor
	public Customer(String fn,String ln,String ssn) 
	{
		this.firstName=fn;
		this.lastName=ln;
		this.SSN=ssn;
	}
	
	//getters and setters
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getSocialSecurityNumber() {
		return SSN;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setSocialSecurityNumber(String SSN) {
		this.SSN = SSN;
	}

}

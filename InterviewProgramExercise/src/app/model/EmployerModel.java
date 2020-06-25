/**
 * 
 */
package app.model;

import java.util.Comparator;
import java.util.Date;

/**
 * @author irvingvelazquez
 * @date June 25, 2020
 */
public class EmployerModel implements Comparable<EmployerModel>{

	private String	firstName;
	private String	lastName;
	private Date 	startDate;
	private String	address1;
	private String	address2;
	private String	city;
	private String	state;
	private String	country;
	private	Long	zip;
	
	public EmployerModel(String firstName, String lastName, Date startDate, String address1, String address2,
			String city, String state, String country, Long zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public EmployerModel() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getZip() {
		return zip;
	}

	public void setZip(Long zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "EmployeerModel"+
				"\nfirstName =" + firstName + 
				"\nLastName =" + lastName + 
				"\nStartDate =" + startDate +
				"\nAddress1 =" + address1 + 
				"\nAddress2 =" + address2 + 
				"\nCity =" + city + 
				"\nState =" + state +
				"\nCountry =" + country + 
				"\nzip =" + zip ;
	}
	

	@Override
	public int compareTo(EmployerModel o) {
		// TODO Auto-generated method stub
		return this.firstName.compareTo(o.firstName);
	}
	
	
	/** Comparators to order List by attribute (FirstName, LastName, StartDate) */
	
	public Comparator<EmployerModel> compareByFirstName = (EmployerModel o1, EmployerModel o2) 
			-> o1.getFirstName().compareTo(o2.getFirstName());

	public Comparator<EmployerModel> compareByLastName = (EmployerModel o1, EmployerModel o2) 
					-> o1.getLastName().compareTo(o2.getLastName());
	
	public Comparator<EmployerModel> compareByStartDate = (EmployerModel o1, EmployerModel o2) 
							-> o1.getStartDate().compareTo(o2.getStartDate());
	
}

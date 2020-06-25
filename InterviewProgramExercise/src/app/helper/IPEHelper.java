/**
 * 
 */
package app.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import app.model.EmployerModel;

/**
 * @author irvingvelazquez
 * @date June 25, 2020
 */
public class IPEHelper {
	
	/**
	 * Function: Convert The String Line With No Commas to an EmployerModel
	 * Parameters: The String Line and Line Index 
	 * Return: A Employer
	 */
	public EmployerModel converLineNoCommasToEmployer(String strLine, int line) throws Exception {
		EmployerModel employer = new EmployerModel();
		
		employer.setFirstName	(strLine.substring(0, 9).trim());
		employer.setLastName	(strLine.substring(10, 26).trim());
		employer.setStartDate	(convertStringToDate(strLine.substring(27,35)));
		employer.setAddress1	(strLine.substring(35, 45).trim());
		employer.setAddress2	(strLine.substring(45, 55).trim());
		employer.setCity		(strLine.substring(55, 65).trim());
		employer.setState		(strLine.substring(65, 67).trim());
		employer.setCountry		(strLine.substring(67, 70).trim());
		employer.setZip			(converStringToLong(strLine.substring(70)));
		checkNoOptionalFields(employer, line);
		checkDefaultValues(employer);
		//System.out.println(employer.toString());
		return employer;
	}
	
	/**
	 * Function: Convert The String Line With Commas to an EmployerModel
	 * Parameters: The String Line and Line Index 
	 * Return: A Employer
	 */
	public EmployerModel converLineCommasToEmployer(String strLine, int line) throws Exception {
		EmployerModel employer = new EmployerModel();
		
		String elements[] = strLine.split("\u002C");
		employer.setFirstName	(elements[0].trim());
		employer.setLastName	(elements[1].trim());
		employer.setStartDate	(convertStringToDate(elements[2].trim()));
		employer.setAddress1	(elements[3].trim());
		employer.setAddress2	(elements[4].trim());
		employer.setCity		(elements[5].trim());
		employer.setState		(elements[6].trim());
		employer.setCountry		(elements[7].trim());
		employer.setZip			(converStringToLong(elements[8].trim()));
		checkNoOptionalFields(employer, line);
		checkDefaultValues(employer);
		//System.out.println(employer.toString());
		return employer;
	}
	
	/**
	 * Function: Check The No Optional Fields
	 * Parameters: Employer Model / Index Line
	 * Return: Throw an Exception when fields are missing
	 */
	public static void checkNoOptionalFields(EmployerModel employer, int line) throws Exception {
		if(employer.getFirstName().equals("")) {
			throw new Exception("First Name is missing in line " + line);
		}
		if(employer.getLastName().equals("")) {
			throw new Exception("Last Name is missing in line " + line);
		}
		if(employer.getStartDate() == null) {
			throw new Exception("Start Date is missing in line " + line);
		}
	}
	
	/**
	 * Function: Check The Default Values
	 * Parameters: Employer Model
	 * Return: Change State and Country with Default Values.
	 */
	public static void checkDefaultValues(EmployerModel employer) {
		if(employer.getState().equals("")) {
			employer.setState("CA");
		}
		if(employer.getCountry().equals("")) {
			employer.setCountry("USA");
		}
	}
	
	/**
	 * Function: convert a String to Date
	 * Parameters: String d
	 * Return: Date date
	 */
	public static Date convertStringToDate(String d) {
		String strDate = d.substring(0, 4) + "-" + d.substring(4, 6) + "-" + d.substring(6);
		//Format to be used for parse
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = format.parse(strDate);
		} catch (ParseException e) {
			System.out.println("Error converting String to Date");
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * Function: Convert String To Long
	 * Parameters: String str
	 * Return: Long
	 */
	public static Long converStringToLong(String str) {
		str = str.trim();
		return Long.parseLong(str);
	}
	
	/**
	 * Function: Format To be Printed in output.txt file
	 * Parameters: Employer Model and Index 
	 * Return: String 
	 */
	public String stringFormatToFile(EmployerModel employer, int index) {
		return "index"+
				"\n\t" + employer.getFirstName() + " " + employer.getLastName() +
				", (" + converDateToFileFormat(employer.getStartDate()) + ") ," +
				"\n\t" + employer.getAddress1() + ", " + employer.getAddress2() + "," + 
				"\n\t" + employer.getCity() + ", " + employer.getState() + "," + 
				"\n\t" + employer.getCountry() + ", " + employer.getZip();
				
	}
	
	/**
	 * Function: convert a Date to String
	 * Parameters: Date date 
	 * Return: String newDateFormat
	 */
	
	public String converDateToFileFormat(Date date) {
		//Format to be printed in output file
		DateFormat format = new SimpleDateFormat("MMMMMMM dd, yyyy");
		String newDateFormat = "";
		newDateFormat = format.format(date);
		return newDateFormat;
	}
}


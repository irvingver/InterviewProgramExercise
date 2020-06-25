/**
 * 
 */
package app.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.helper.IPEHelper;
import app.model.EmployerModel;

/**
 * @author irvingvelazquez
 * @date June 25, 2020
 */
public interface IPEService {

	/**
	 * Function: Read Employers from file
	 * Parameters: File path
	 * Return: a list of Employers
	 */
	public static List<EmployerModel> readEmployersfromFile(String path) throws Exception {

		List<EmployerModel> employers = new ArrayList<EmployerModel>();
		BufferedReader inputStream = null;
		int intLine = 0;
		try {
			inputStream = new BufferedReader(new FileReader(path));
			String strLine;
			while((strLine = inputStream.readLine()) != null) {
				//System.out.println(strLine);
				intLine++;
				employers.add(convertLineToEmployer(strLine, intLine));
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("FILE NOT FOUND ");
			System.out.println("\t Please check path and file format");
			throw e;
		}finally {
			inputStream.close();
		}

		
		return employers;
	}

	/**
	 * Function: convert String Line to EmployerModel Object
	 * Parameters: The String Line and the number of the Line
	 * Return: a Employer
	 */
	public static EmployerModel convertLineToEmployer(String strLine, int intLine) throws Exception {
		EmployerModel employer = new EmployerModel();
		IPEHelper helper = new IPEHelper();
		
		if(strLine.contains("\u002C")) {
			employer = helper.converLineCommasToEmployer(strLine, intLine);
		}else {
			employer = helper.converLineNoCommasToEmployer(strLine, intLine);
		}
		return employer;
	}

	/**
	 * Function: Order the List Of Employers based on paramToOrder
	 * Parameters: The list of Employers and the parameter to Order (firstname, lastname, startdate)
	 * Return: a list of Employer
	 */
	public static List<EmployerModel> orderEmployerListByParam(List<EmployerModel> employers, String paramToOrder) {
		EmployerModel employerModel = new EmployerModel();
		
		if(paramToOrder.equals("fn")) {
			Collections.sort(employers, employerModel.compareByFirstName);
			System.out.println("List Order By First Name");
		}else if(paramToOrder.equals("ln")) {
			Collections.sort(employers, employerModel.compareByLastName);
			System.out.println("List Order By Last Name");
		}else if(paramToOrder.equals("sd")) {
			Collections.sort(employers, employerModel.compareByStartDate);
			System.out.println("List Order By Start Date");
		}

		return employers;
	}
	
	/**
	 * Function: Write in output.txt file the list of Employers sorted.
	 * Parameters: List Of Employers
	 * Return: void.
	 */
	public static void writeFileWithListOfEmployers(List<EmployerModel> employers) throws Exception {
		PrintWriter outputStream = null;
		IPEHelper helper = new IPEHelper();
		int index = 1;
		try {
			outputStream = new PrintWriter (new FileWriter("output.txt"));
			for(EmployerModel emp: employers) {
				outputStream.println(helper.stringFormatToFile(emp, index));
				index++;
			}
			System.out.println("EMPLOYERS SAVED IN OUTPUT.TXT FILE");
		}catch(Exception e) {
			throw e;
		}finally {
			if(outputStream != null) {
				outputStream.close();
			}
		}
	}
	
}


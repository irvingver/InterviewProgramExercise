package app.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import app.model.EmployerModel;

public interface IPEService {

	/**
	 * Function: Read Employers from file
	 * Parameters: File path
	 * Return: a list of Employers
	 */
	public default List<EmployerModel> readEmployersfromFile(String path) throws Exception {

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
	
	public EmployerModel convertLineToEmployer(String strLine, int intLine) throws Exception ;
	
	public List<EmployerModel> orderEmployerListByParam(List<EmployerModel> employers, String paramToOrder);
	
	public void writeFileWithListOfEmployers(List<EmployerModel> employers) throws Exception;
	
	
	
}

/**
 * 
 */
package app.controller;

import java.util.List;

import app.model.EmployerModel;
import app.service.IPEService;

/**
 * @author irvingvelazquez
 * @date June 25, 2020
 */
public class IPEController implements IPEService{
	
	/**
	 * Function: Controller of the application
	 * Parameters: File Path, Parameter to Order the List
	 * Return: void.
	 */
	public static void convertFileContentToEmployers(String path, String paramToOrder) throws Exception {
		
		/** Read Employer from File */
		List<EmployerModel> employers = 	IPEService.readEmployersfromFile(path);
		
		/** Order the list of Employers by Parameter */
		employers =  						IPEService.orderEmployerListByParam(employers, paramToOrder);
		
		/** Writhe the sorted list in output file */
		IPEService.writeFileWithListOfEmployers(employers);
	}

}

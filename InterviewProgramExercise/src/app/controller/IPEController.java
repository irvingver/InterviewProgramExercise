/**
 * 
 */
package app.controller;

import java.util.List;

import app.model.EmployerModel;
import app.service.IPEServiceImpl;

/**
 * @author irvingvelazquez
 * @date June 25, 2020
 */
public class IPEController{
	
	/**
	 * Function: Controller of the application
	 * Parameters: File Path, Parameter to Order the List
	 * Return: void.
	 */
	public static void convertFileContentToEmployers(String path, String paramToOrder) throws Exception {
		
		IPEServiceImpl ipeService = new IPEServiceImpl();
		
		/** Read Employer from File */
		List<EmployerModel> employers = 	ipeService.readEmployersfromFile(path);
		
		/** Order the list of Employers by PaipeServicerameter */
		employers =  						ipeService.orderEmployerListByParam(employers, paramToOrder);
		
		/** Writhe the sorted list in output file */
		ipeService.writeFileWithListOfEmployers(employers);
	}

}

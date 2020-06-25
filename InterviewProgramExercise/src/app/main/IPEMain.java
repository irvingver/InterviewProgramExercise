/**
 * 
 */
package app.main;

import java.util.Scanner;

import app.controller.IPEController;

/**
 * @author irvingvelazquez
 * @date June 25, 2020
 */
public class IPEMain {

	//final static String PATH = "/Users/irvingvelazquez/Workspace/InterviewProgramExercise/src/app/resources/input1.txt";
	//final static String PARAMTOORDER = "startdate"; //Options: firstname, lastname or startdate.
	
	/**
	 * Function: Main Function
	 * Parameters: PATH and PARAMTOORDER (Could be changed for the user)
	 * Return: void.
	 */
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("**************** WELCOME **************");
		System.out.println("Please insert the path of your file: ");
		System.out.println("E.g. cd:/src/app/resources/input1.txt");
		String path = scanner.nextLine();
		
		System.out.println("\nInsert the order of the final list:");
		System.out.println("First Name (fn), Last Name (ln), Start Date (sd)");
		String paramToOrder = scanner.nextLine();
		scanner.close();
		
		IPEController.convertFileContentToEmployers(path, paramToOrder);
	}

}
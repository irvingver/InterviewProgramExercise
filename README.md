# InterviewProgramExercise
Java program that read a list of employee records from an ascii input file and write out a sorted list to an ascii output file. 

# Steps to Run InterviewProgramExercise (IPE).

  1. Download IPE.jar
  2. Open terminal and go to the IPE.jar location.
  3. Run the below script:
  
    java -cp IPE.jar app.main.IPEMain
  4. Once the application is running, is going to ask you for the input file location:
  
    Please insert the path of your file: 
   
  5. Insert the file path.
  
    E.g. cd:/src/app/resources/input1.txt
    
  6. Next Step is to select the Order Option:
  
    Insert the order of the final list:
    First Name (fn), Last Name (ln), Start Date (sd)
    
  7. The application is going to run after this steps and you check the result in output.txt file, location in the same directory as IPE.jar 
    
    Expected Result:
    1
      Irving Velazquez, (October 08, 2003) ,
      1 Jay St, Apt 498,
      Gso, NC,
      USA, 49567
    2
      Jon Abner, (December 08, 2003) ,
      1 Jay St, Apt 498,
      Dublin, CA,
      USA, 49567
    3
      Will Abner, (November 08, 2003) ,
      1 Jay St, Apt 498,
      Dublin, CA,
      USA, 49567
      
_________________________________________________________________________________________________________________________________________________________

# Explanation of the content of the application

IPEMain.java

	- This is the main class that run the entire application.
	- It help us to insert the file path and the order param with the util Scanner.
	- Calls the Controller of the application IPEController.
  
IPEController.java

	- Is the flow of the application and implements IPEService interface, steps:
		* Read Employer from File and return the list of Employers
		* Order the list of Employers by Parameter and return the sorted list.
		* Writhe the sorted list in output.txt file

IPEService interface
	
	- Contains all the importat functions to complete the process.
		* Function readEmployersfromFile:
			Open, Read and Close the file with BufferReader and and every line is sending to convertLineToEmployer function
			Return the list of Employers
		* Function convertLineToEmployer:
			It has a condition that validate if the line contains commas ("\u002C"), if so, it calls to converLineCommasToEmployer if not it calls converLineNoCommasToEmployer from IPEHelper.java class.
			Return the list of Employers
		* Function orderEmployerListByParam:
			Validate if the  Parameter to Order
			And it calls the Collection sort from EmployerModel class dependending on the Parameter.
			Returns the list sorted by Parameter
		* Function writeFileWithListOfEmployers:
			Open, Write and close the output file with PrintWriter.
			Iterate the list and its writen out in the output.txt file with an specific format.

IPEHelper.java
	
	- Contains helper functions to get and print the Employers:
		* Function converLineNoCommasToEmployer:
			For every line, this function is called to substring the elements of the employer.
			Based on the Max Lenght of the table Input Format 1 from the file progQuestion.doc
			It also check the default values and the No Optional Fields.
			Returns an Employer Model
		*Function converLineCommasToEmployer
			For every line in the input document, it split based in commas ("\u002C"), and it gets the array of elements.
			The array of elements are added to the EmployeerModel.
			It also check the default values and the No Optional Fields.
			Returns an Employer Model.
		* Function checkNoOptionalFields.
			Check The No Optional Fields and it throws an exception when the value is missing.
		* Function checkDefaultValues:
			Check the Default values if they are null, if so it add the default values based on table Input Format 1 .
		* Function convertStringToDate:
			It converts the data string to the format "yyyy-MM-dd".
			It format and parse the String to a util.Data.
		* Function converStringToLong:
			It only converts the ZIP string element to a Long value.
		* Function stringFormatToFile:
			It returns the correct format to write every Employeer in output file:
				E.g 
				1
					 Jon Abner, (December 11, 2003)
					 1 Jay St, Apt 498,
					 Dublin,CA,
					 USA,49567
		* Function converDateToFileFormat.
			It converts the Employer start date to String to be writed in output file.

EmployerModel.java
	
	-Employer Class that has all the attribures for an Employer based on table Input Format 1 with constructor, getters and setters:
			First name
			Last name
			Start date 
			Address 1
			Address 2
			City
			State
			Country
			Zip
		* Implements Comparable that help us to order a list of EmployerModel based on firstName.
		* It has compareByFirstName, compareByLastName, compareByStartDate functions that help us to order the List of Employers with the compereTo method.
		

			
		

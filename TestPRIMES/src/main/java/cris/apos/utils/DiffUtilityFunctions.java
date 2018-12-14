package cris.apos.utils;

import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import cris.apos.input.*;





public class DiffUtilityFunctions {
	
	/*public static String getPropertyValue (String propertyName) {
		
		String propertyValue = null;
		
		File configFile = new File("config.properties");
		
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    propertyValue = props.getProperty(propertyName);
		 
		    System.out.print("\n" + propertyName + "="   + propertyValue);
		    reader.close();
		} catch (FileNotFoundException ex) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		
		return propertyValue;
		
	}
	*/
	public static String capchaInputDialog() throws IOException {
		String inpString;
		System.out.print("\nCalling capcha dialog joption pane");
		inpString = JOptionPane.showInputDialog("Please enter Capcha: ");
		return inpString;
	}
	
	public static List<SingleLinkDetails> readInputFilePopulateData(Path inpFile ) {
		
		//ArrayList<SingleLinkDetails> inputLinkArray = new ArrayList<SingleLinkDetails>();
		List<SingleLinkDetails> inputLinkArray = new ArrayList<>();
		SingleLinkDetails singleLinkDetails ;
		//Path inpFile = Paths.get(DiffUtilityFunctions.getPropertyValue("ngetQuickBookInputFile"));
		//Path inpFile = Paths.get(DiffUtilityFunctions.getPropertyValue(inpFileName));
		try (BufferedReader br = Files.newBufferedReader(inpFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			while (line != null) {
				 singleLinkDetails = new SingleLinkDetails();
				String[] attributes = line.split(",");
			//	System.out.println("attributes " + Arrays.toString(attributes));
				singleLinkDetails.setTestCaseId(attributes[0]);
				singleLinkDetails.setcategoryName(attributes[1]);
				singleLinkDetails.setfunctionName(attributes[2]);
				singleLinkDetails.setLinkName(attributes[3]);
				
				//System.out.println("singleLinkDetails==> " + singleLinkDetails);
				inputLinkArray.add(singleLinkDetails);
				line = br.readLine();
			} 

		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return inputLinkArray;

	}



public static String getPropertyValue (String propertyName) {
	
	String propertyValue = null;	
//	ResourceBundle bundle = ResourceBundle.getBundle("resources\\config\\config");
	//ResourceBundle bundle = ResourceBundle.getBundle("..\\..\\..\\..\\..\\resources\\config\\config");
	
	//ResourceBundle bundle = ResourceBundle.getBundle("D:\\APOSWorkSpaceInGradle\\TestPRIMES\\resources\\config\\config.properties");
	//ResourceBundle bundle = ResourceBundle.getBundle("config");
	// correct ResourceBundle bundle = ResourceBundle.getBundle("cris.apos.utils.config");
	//ResourceBundle bundle = ResourceBundle.getBundle("..\\..\\..\\..\\..\\..\\resources\\config\\config");
	
//	ResourceBundle bundle = ResourceBundle.getBundle("..\\..\\..\\..\\..\\..\\..\\resources\\config\\config");
	
	ResourceBundle bundle = ResourceBundle.getBundle("cris.apos.utils.config");
	propertyValue = bundle.getString(propertyName);	
//	System.out.print("\n" + propertyName + "="   + propertyValue);
	return propertyValue;
}

public static boolean srCitizenConcEligible(char psgnGender, int psgnAge) {

	if ( psgnGender == 'M' && psgnAge >= Integer.parseInt(DiffUtilityFunctions.getPropertyValue("SeniorCitizenMaleAge") ))
		return true ;
	else if ( psgnGender == 'F' && psgnAge >= Integer.parseInt(DiffUtilityFunctions.getPropertyValue("SeniorCitizenFemaleAge") ))
		return true ;
	else 
		return false ;
/*	if (Character.toString(psgnGender).matches("Mm") && psgnAge >= Integer.parseInt(DiffUtilityFunctions.getPropertyValue("SeniorCitizenMaleAge")) )
		return true;
	else if (Character.toString(psgnGender).matches("Ff") && psgnAge >= Integer.parseInt(DiffUtilityFunctions.getPropertyValue("SeniorCitizenFemaleAge")) )
			return true ;
	else 
		return false ;*/
}




}
	









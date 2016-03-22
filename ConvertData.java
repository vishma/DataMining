package datamine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Vishma
 */

public class ConvertData
{
	

	public static void main( String[] args )
	{
		String line1;
		String line2;
		BufferedReader reader;
		BufferedReader readcsv;
		ArrayList<String> code_array = new ArrayList<String>();
		try
		{
				reader = new BufferedReader(new FileReader("F://Data Mining/backup/dataAll.csv"));
				readcsv = new BufferedReader(new FileReader("F://Data Mining/backup/COLLECTION_SET(Updated).csv"));
				readcsv.readLine();
				reader.readLine();
				
			  
		
			  while ((line1 = readcsv.readLine()) != null){
				  
			  String[] splitted = line1.split(",");
			  
			  
			  if(!code_array.contains( splitted[8]) ){
					 code_array.add( splitted[8] ); 
					 
			  	}
			  
			  }
			  while((line2 = reader.readLine()) != null){
				  String[] splitted1 = line2.split(",");
				  
				  if(code_array.contains( splitted1[7] )){
					  	System.out.println( "yes" );
				  } else {
					  System.out.println( "no" );
			  
			  }
			  }

		}
				
		catch ( IOException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		
	}

}

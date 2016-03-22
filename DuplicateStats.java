package datamine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import java.util.ArrayList;


/**
 *
 * @author Vishma
 */

public class DuplicateStats {

    public String getStringCode(String splitted[]) {
        //generating duplicateId
    	String code = "";
        code = splitted[2] +  splitted[4] + splitted[5] + splitted[6] + splitted[7]
                + splitted[8] +splitted[9];
        return code;
    }
                                                                   
    public static void main(String[] args) throws IOException, ParseException {
    	   	
        DuplicateStats stat = new DuplicateStats();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("F://Data Mining/sql_req.csv"));
            FileWriter writer = new FileWriter("F://Data Mining/sql_req_out.csv");

            ArrayList<DataRow> DataArray = new ArrayList<DataRow>();

            String line;
            String code = null;
           
            String writeHeader = "DEP_DATE"+","+"USER_NAME"+","+"PAX"+","+"NIGHTS"+","+"CITY"+","+"COUNTRY"+","+"CODE"+"\n";
            
            writer.append(writeHeader);
            writer.flush();
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitted = line.split(",");
                
                if(splitted.length != 10)
                	continue;
				//Generating the first duplicateId
                if (code == null) {                     
                    code = stat.getStringCode(splitted);                  
                }
                
                if (code.equals(stat.getStringCode(splitted))) {
                   
                    DataArray.add(new DataRow(splitted[0], splitted[2], splitted[3], splitted[4], splitted[5], splitted[6],
                    							splitted[7], splitted[8], splitted[9], code));
                    
                    
                } else {
                    code = stat.getStringCode(splitted);                    
                   
                                              
                        String writeLine = "";
                                                
                        writeLine = DataArray.get(0).getDistribution_chanel() + "," + DataArray.get(0).getSearch_date() + "," + 
                        			DataArray.get(0).getDep_date() + "," + DataArray.get(0).getAction() + "," + DataArray.get(0).getUser_name() +
                        			"," + DataArray.get(0).getPax()+ "," + DataArray.get(0).getNights()+ "," + DataArray.get(0).getCity() + "," + 
                        			DataArray.get(0).getCountry() + "," + DataArray.size()+ ","+DataArray.get(0).getCode() + "\n";
                                                                                                                                                                                                                                          
                        writer.append(writeLine);
                        writer.flush();
                     
                    }
                    
                    DataArray=new ArrayList<>();
                    DataArray.add(new DataRow(splitted[0], splitted[2], splitted[3], splitted[4], splitted[5],
                    		splitted[6], splitted[7], splitted[8], splitted[9] ,code));
                    
                }
                                   
            
            writer.close();
            reader.close();
            System.out.println("CSV file was created Successfully...");
                        

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

}
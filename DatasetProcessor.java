package datamine;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Vishma
 */
public class DatasetProcessor {
    
    public static String getStringCode(String pax, String nights, String depDate) {
        String code = "";
        code = pax + nights + depDate;
        return code;
    }
    
    public static String getCode(String splitted[]){    
        String code = "";
        code = splitted[0] + splitted[1] + splitted[2];

        
        return code;        
    }
    
    public void writeCSV(String dataSet, String paxList, String nightList, String dateList) throws FileNotFoundException, IOException, ParseException{
    
        BufferedReader data = new BufferedReader(new FileReader(dataSet));        
        BufferedReader pax = new BufferedReader(new FileReader(paxList));
        BufferedReader nights = new BufferedReader(new FileReader(nightList));
        BufferedReader dates = new BufferedReader(new FileReader(dateList));
        
        data.readLine();
        pax.readLine();
        nights.readLine();
        dates.readLine();
        
        ArrayList<String> codeArray = new ArrayList<>();
        ArrayList<String> paxArray = new ArrayList<>();
        ArrayList<String> nightsArray = new ArrayList<>();
        ArrayList<Date> datesArray = new ArrayList<>();
        
        String lineData;
        String linePax;
        String lineNights;
        String lineDates;
        
        while( (lineData = data.readLine()) != null ){
            String[] splitted = lineData.split(",");
            codeArray.add(getCode(splitted));
        }
                      
        while( (linePax = pax.readLine()) != null ){
            paxArray.add(linePax);
        }
        
        while( (lineNights = nights.readLine()) != null ){
            nightsArray.add(lineNights);
        }
        
        DateFormat df = new SimpleDateFormat("M/d/yyyy");
        while( (lineDates = dates.readLine()) != null ){
            datesArray.add(df.parse(lineDates));
        }
        
        FileWriter writer = new FileWriter("F://Data Mining/updated_data/dataset.csv");
        String writeHeader = "adult" + "," + "child" + "," + "infant" + "," + "nights" + "," + "depDate" + "," + "Class" + "\n";
        writer.append(writeHeader);
        writer.flush();
          
       
        
        for (String a : paxArray) {
            
            for (String b : nightsArray) {
                
                for (Date c : datesArray) {
                    
                    String d = df.format(c);
                    
                    String code = getStringCode(a, b, d);
                    
                    
                    String[] splitted = a.split("_");
                    
                    Calendar cal = new GregorianCalendar();
                    cal.setTime(c);
                    int dayNo = cal.get(Calendar.DAY_OF_YEAR);
                    
          
                    
//                    for(int i=0;i<codeArray.size();i++)    	
//                    	System.out.println( codeArray.get( i ) );
                    
                    if(codeArray.contains(code)){
                        String writeLine ="";
                        writeLine += splitted[0] + "," + splitted[1] + "," + splitted[2] + "," + b + "," + dayNo + "," + "Yes" + "\n";
                        writer.append(writeLine);
                        writer.flush();
                    }
					
                    else{
                        String writeLine ="";
                        writeLine += splitted[0] + "," + splitted[1] + "," + splitted[2] + "," + b + "," + dayNo + "," + "No" + "\n";
                        writer.append(writeLine);
                        writer.flush();
                    }                   
                    
                }
                
            }
            
        }
        
        writer.close();
        
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException{
    
    	DatasetProcessor dataset = new DatasetProcessor();
        dataset.writeCSV("F://Data Mining/updated_data/stat_updated.csv", "F://Data Mining/updated_data/paxList.csv", "F://Data Mining/updated_data/nightList.csv", "F://Data Mining/updated_data/dateList.csv");
        System.out.println("Done...");
        
    }
    
}


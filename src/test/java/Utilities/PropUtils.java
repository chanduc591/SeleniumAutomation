package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {
	
	public static Properties getReadData(String fileName) {
		
		Properties pr=null;
		
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\config\\"+fileName);
			
			pr=new Properties();
			
			pr.load(fis);

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pr;
		
		
	}
	
	public static void main(String[] args) {
		
	Properties data=PropUtils.getReadData("config.properties");
	
	   System.out.println(data.getProperty("App_URL"));   
	
	
		
	}
	
	

}

package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtil {
	
	// common method for connecting DB and get the raw data
	
	public static ResultSet getData(String query) throws SQLException {
		
		ResultSet dataset=null;
		
		//String syntax="jdbc:typeofDb://address:port/your_database_name";
		
		String db_url="jdbc:postgresql://localhost:5432/dvd_shop";
		String db_username="postgres";
		String db_password="admin";
		
		Connection connection=DriverManager.getConnection(db_url,db_username, db_password);
		
		dataset=connection.createStatement().executeQuery(query);
		
		return dataset;
		
	}

// create a common method to convert rawData into List of HashMap
	
	public static List<Map<String,String>>readData(String query) throws SQLException {
		
		List<Map<String,String>>dataList=new ArrayList<Map<String,String>>();
		
		//get the rawData from database
		
		ResultSet dataset=getData(query);
		
		
		// copy the data into List of HashMap
		while(dataset.next()) {// verify the next row is available,  if yes , the move to row
			
			Map<String,String>rowData=new HashMap<String ,String>();
			
			// loop through all the columns
			
			for(int c=1;c<=dataset.getMetaData().getColumnCount();c++) {
				
				
				String columnname=dataset.getMetaData().getColumnName(c);// get the column name

				String columnvalue=dataset.getString(c);// get the column value
				    
				    
				rowData.put(columnname, columnvalue);
				
			}
			
			dataList.add(rowData); // add data to mapList
		}
		
		return dataList;

	}
	
	
}

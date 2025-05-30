package Testcases;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Utilities.DbUtil;

public class ReadDb {

	public static void main(String[] args) throws SQLException {

		List<Map<String,String>> data=DbUtil.readData(DbQueries.Horro_movi_List);
		
		System.out.println(data);
		
		System.out.println(data.get(1).get("movie_name"));
		System.out.println(data.get(2).get("movie_name"));
		
	}

}

package TestVagrant.TestVagrant;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDatafromjson {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		int count_fr=0;
		int count_wk=0;
		
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(".\\jsonfiles\\Rcb.json");
		Object obj=jsonparser.parse(reader);
		JSONObject empjsonobj=(JSONObject)obj;
		
		String fname=(String) empjsonobj.get("name");
		String loc=(String) empjsonobj.get("location");
		
		JSONArray array=(JSONArray)empjsonobj.get("player");
		for (int i =0;i<array.size(); i++)
		{
			JSONObject player=(JSONObject)array.get(i);
			String country=(String) player.get("country");
			String role=(String) player.get("role");
			
			if(country.compareTo("India")!=0)
			{
				count_fr=count_fr+1;
				
			}
			
			if(country.compareTo("Wicket-keeper")!=0)
			{
				count_wk=count_wk+1;
			}
			
		}
		
		if(count_fr<=4)
		{
			System.out.println("Team has 4 foreign players");
		}
		else
		{
			System.out.println("More than 4 foreign players not allowed");
		}
		
		if(count_wk>=1)
		{
			System.out.println("Team has a wicket keeper");
		}
		else
		{
			System.out.println("Team should consist atleast one wicket keeper");
		}




	}

}

import org.json.simple.parser.ParseException;

import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader 
{

	public static void main(String[] args) throws ParseException 
	{
		// \"Apple\" support inside quotes, Concept 3 
		// String struc = "[\"Apple\", \"Orange\",13,12]";
		String struc = "{\"key1\":\"Apple\", \"key2\":\"Orange\", \"key3\":13, \"key4\":12}";
		
		JSONParser job = new JSONParser();
		Object obj = job.parse(struc);
		
		// JSONArray outerArray = (JSONArray)obj;
		// System.out.println(obj.getClass().getName());
		
		//	System.out.println();
		
		//for(Object o: outerArray) {
		//	System.out.println(o);
		//}
		
		//	System.out.println();
		// Concept 4
		JSONObject outerArray = (JSONObject)obj;
		
		Set keys = outerArray.keySet();
		
		//for(Object o: keys) {
			//System.out.println(o + );
		//}
		
		// Concept 5 - key value pairs
		 //[{\"Name\":...}] Joe and Jane
		 // JSONObject job = (JsonObject)o;
		 // Sys.out.println(job.get("Name"));
		
	}
}
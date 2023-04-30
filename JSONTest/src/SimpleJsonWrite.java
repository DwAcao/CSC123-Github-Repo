import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SimpleJsonWrite 
{

	public static void main(String[] args) 
	{
		// JSON Concept 1 like in challenge 1 from lab 12 - Lists
		JSONArray array = new JSONArray();
		
		array.add("30");
		array.add("31");
		array.add("34");
		array.add("28");
		array.add("49");
		
		// String msg = fruits.toJSONString();
		
		System.out.println(array.toJSONString());
		
		System.out.println();
		
		// JSON Concept 2 {} - curly brackets - Map object with a list inside
		JSONObject IntegerArray = new JSONObject();
		
		IntegerArray.put("array", array);
		
		System.out.println(IntegerArray.toJSONString());
		
		
	}
}
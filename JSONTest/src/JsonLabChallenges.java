/**
 * I was not able to complete all of them, but just tried to do most of them.
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonLabChallenges 
{

	public static void main(String[] args) 
	{
		// Challenge Part 1 JSON i
		JSONArray arrayInts = new JSONArray();

		arrayInts.add(30);
		arrayInts.add(31);
		arrayInts.add(34);
		arrayInts.add(28);
		arrayInts.add(49);

		JSONObject IntegerArray = new JSONObject();
		IntegerArray.put("array", arrayInts);

		System.out.println(IntegerArray.toJSONString());
		System.out.println(); // end of code section

		
		
		// Challenge Part 1 JSON ii
		JSONArray arrayStrs = new JSONArray();

		arrayStrs.add("One");
		arrayStrs.add("Two");
		arrayStrs.add("Three");
		arrayStrs.add("Four");

		JSONObject StringsArray = new JSONObject();
		StringsArray.put("array", arrayStrs);

		System.out.println(StringsArray.toJSONString());
		System.out.println(); // end of code section

		
		
		
		// Challenge Part 1 Json iii
		JSONArray mixedArray = new JSONArray();
		JSONArray ofStrings = new JSONArray();

		mixedArray.add(31);
		mixedArray.add(32);
		mixedArray.add("Hello World");

		ofStrings.add("One");
		ofStrings.add("Two");
		ofStrings.add("Three");
		ofStrings.add("Four");
		mixedArray.add(ofStrings);

		JSONObject addedStrs = new JSONObject();
		addedStrs.put("array", mixedArray);

		System.out.println(addedStrs.toJSONString());
		System.out.println();
		
		
		

		// Challenge Part 1 JSON iv
		JSONObject locationObj = new JSONObject();

		locationObj.put("Name", "Name1");
		locationObj.put("Address", "213 Washington Blv");
		locationObj.put("Zip", 90532);

		System.out.println(locationObj.toJSONString());
		System.out.println(); // end of code section
		
		
		

		// Challenge Part 2 JSON 1
		JSONArray fruitsArray = new JSONArray();

		fruitsArray.add("Apples");
		fruitsArray.add("Oranges");
		fruitsArray.add("Banana");

		System.out.println(fruitsArray.toJSONString());
		System.out.println(); // end of code section
		
		
		

		// Challenge Part 2 JSON 2
		JSONObject carObj = new JSONObject();

		carObj.put("YearsOld", 3);
		carObj.put("Odometer", 123452);
		carObj.put("Price", 23122.00);
		carObj.put("Color", "Black");
		carObj.put("Make", "Toyota");

		System.out.println(carObj.toJSONString());
		System.out.println(); // end of code section

		
		
		
		// Challenge Part 2 JSON 3
		JSONArray carList = new JSONArray();
		JSONObject ToyotaObj = new JSONObject();
		JSONObject HondaObj = new JSONObject();

		ToyotaObj.put("YearsOld", 3);
		ToyotaObj.put("Odometer", 123452);
		ToyotaObj.put("Price", 23122.00);
		ToyotaObj.put("Color", "White");
		ToyotaObj.put("Make", "Toyota");

		HondaObj.put("YearsOld", 5);
		HondaObj.put("Odometer", 13342);
		HondaObj.put("Price", 24122.00);
		HondaObj.put("Color", "Black");
		HondaObj.put("Make", "Honda");

		carList.add(ToyotaObj);
		carList.add(HondaObj);

		System.out.println(carList.toJSONString());
		System.out.println(); // end of code section
	}
}
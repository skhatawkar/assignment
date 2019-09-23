import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.json.JSONObject;

public class JsonReader {

	public static void main(String[] args) {
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            String contents = buffer.lines().collect(Collectors.joining("\n"));
            if(contents.trim().isEmpty()) {
            	throw new IllegalArgumentException("Please verify the Json File!");
            }
            readJson(contents);
        } catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readJson(String contents) {
			JSONObject inputJsonObj = new JSONObject(contents);
			JSONObject responseJsonObj = new JSONObject();
			inputJsonObj.keySet().forEach(key -> {
				Object value = inputJsonObj.get(key);
				if (value instanceof JSONObject) {
					traverseNestedJsonObj(key, (JSONObject) value, responseJsonObj);
				} else {
					responseJsonObj.put(key, value);
				}
			});
			System.out.println(responseJsonObj.toString(4));
	}

	//Recursive calls to read Nested Json Objects
	public static void traverseNestedJsonObj(String key, JSONObject nestedJsonObj, JSONObject responseJsonObj) {
		if (key == null || key.trim().isEmpty() || nestedJsonObj == null) {
			return;
		}
		nestedJsonObj.keySet().forEach(entry -> {
			Object value = nestedJsonObj.get(entry);
			if (value instanceof JSONObject) {
				traverseNestedJsonObj(key + "." + entry, (JSONObject) value, responseJsonObj);
			} else {
				responseJsonObj.put(key + "." + entry, value);
			}
		});
	}
}
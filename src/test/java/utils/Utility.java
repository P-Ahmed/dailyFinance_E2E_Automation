package utils;

import com.github.javafaker.Faker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utility {
    static Faker faker = new Faker();

    public static String randomFirstName() {
        return faker.name().firstName();
    }

    public static String randomEmail() {
        return randomFirstName() + randomNum(9999, 1000) + "@gmail.com";
    }

    public static String randomPassword() {
        return faker.internet().password(8, 20, true);
    }

    public static String randomPhoneNumber() {
        return "014" + randomNum(99999999, 10000000);
    }

    public static int randomNum(int max, int min) {
        return (int) (Math.random() * ((max + min) - min));
    }

    public static void writeJSONFile(String firstName, String email, String phoneNumber, String password) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("firstName", firstName);
            jsonObject.put("email", email);
            jsonObject.put("phoneNumber", phoneNumber);
            jsonObject.put("password", password);

            FileWriter file = new FileWriter("src/main/resources/users.json");
            file.write(jsonObject.toJSONString());
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readJSONFile(String key) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("src/main/resources/users.json"));
        JSONObject jsonObject = (JSONObject) obj;

        return (String) jsonObject.get(key);
    }
}

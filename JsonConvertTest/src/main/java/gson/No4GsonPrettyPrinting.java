package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class No4GsonPrettyPrinting {

    public static void main(String[] args) {

        Map<String, Integer> items = new HashMap<>();

        items.put("chair", 3);
        items.put("pencil", 1);
        items.put("book", 5);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        System.out.println(gson.toJson(items));

        String s = "{\n" +
                "  \"chair\": 3,\n" +
                "  \"book\": 5,\n" +
                "  \"pencil\": 1\n" +
                "}";
    }

}

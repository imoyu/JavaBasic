package gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;

public class No14GsonEasyEx {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        System.out.println(gson.fromJson("\"true\"", boolean.class));

        System.out.println(gson.toJson(new List14()));

        String jsonS = "{\n" +
                "  \"list\": null\n" +
                "}";

        jsonS = jsonS.replace("\n", "");
        jsonS = jsonS.replace("  ", "");
        System.out.println(jsonS);

        System.out.println(gson.toJson(jsonS));

        new GsonBuilder()
                .registerTypeAdapter(Time.class, new JsonSerializer<Time>() {
                    @Override
                    public JsonElement serialize(Time src, Type typeOfSrc, JsonSerializationContext context) {
                        return null;
                    }
                })
                .registerTypeAdapter(Time.class, new JsonDeserializer<Time>() {
                    @Override
                    public Time deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        return null;
                    }
                })
                .create();

    }

}

class List14 {
    private List<String> list;
}

class Time {

}
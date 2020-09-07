package gson;

import com.google.gson.*;

import java.util.List;

public class No7GsonTreeModelRead {

    public static void main(String[] args) {

        String jsonString = "[{\"name\":\"Audi\",\"model\":\"2012\",\"price\":22000,\"colors\":[\"gray\",\"red\",\"white\"]},\n" +
                " {\"name\":\"Skoda\",\"model\":\"2009\",\"price\":14000,\"colors\":[\"black\",\"gray\",\"white\"]},\n" +
                " {\"name\":\"Volvo\",\"model\":\"2010\",\"price\":19500,\"colors\":[\"black\",\"silver\",\"beige\"]}]";

        JsonParser parser = new JsonParser();
        JsonElement tree = parser.parse(jsonString);

        JsonArray jsonArray = tree.getAsJsonArray();

        for (JsonElement element : jsonArray) {

            if (element.isJsonObject()) {
                JsonObject car = element.getAsJsonObject();

                System.out.println("=====================");
                System.out.println(car.get("name").getAsString());
                System.out.println(car.get("model").getAsString());
                System.out.println(car.get("price").getAsInt());

                JsonArray colors = car.getAsJsonArray("colors");

                colors.forEach(System.out::println);
            }

        }

        Gson gson = new Gson();
        List list = gson.fromJson(jsonString, List.class);

        Object o = list.get(0);

        String jsonList = "[\"abc\", \"deb\", null]";
        JsonElement alps = parser.parse(jsonList);
        JsonArray stringArray = alps.getAsJsonArray();

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();

        for (JsonElement element : stringArray) {
            if (element.isJsonPrimitive()) {
                System.out.println(element.getAsString());
            }
            if (element.isJsonNull()) {
                JsonNull jsonNull = element.getAsJsonNull();
                System.out.println(element.getAsJsonNull());
            }
        }
    }

}

package gson;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class No6GsonTreeModelWrite {

    public static void main(String[] args) {
        List<Car6> cars = new ArrayList<>();
        cars.add(new Car6("Audi", "2012", 22000,
                new String[]{"gray", "red", "white"}));
        cars.add(new Car6("Skoda", "2016", 14000,
                new String[]{"black", "gray", "white"}));
        cars.add(new Car6("Volvo", "2010", 19500,
                new String[]{"black", "silver", "beige"}));

        Gson gson = new Gson();
        JsonElement tree = gson.toJsonTree(cars);

        System.out.println(gson.toJson(tree));

        JsonArray jsonArray = tree.getAsJsonArray();
        JsonElement jsonElement = jsonArray.get(0);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        System.out.println(jsonObject);

        jsonObject.addProperty("name", "Modify");
        jsonObject.addProperty("addProperty", "-----");
        System.out.println(jsonObject);
    }

}

class Car6 {

    private final String name;
    private final String model;
    private final int price;
    private final String[] colours;

    public Car6(String name, String model, int price, String[] colours) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.colours = colours;
    }
}
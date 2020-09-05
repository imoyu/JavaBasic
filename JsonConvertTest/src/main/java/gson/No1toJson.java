package gson;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class No1toJson {

    public static void main(String[] args) {

        Map<Integer, String> colors = new HashMap<>();
        colors.put(1, "blue");
        colors.put(2, "yellow");
        colors.put(3, "green");

        Gson gson = new Gson();
        String json = gson.toJson(colors);
        System.out.println(json);

    }

}

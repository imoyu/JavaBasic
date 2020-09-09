package gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class No13JsonDeserialize {

    public static void main(String[] args) {

        String jsonS = "{\"name\":null, \"age\":12, \"alps\":[\"abc\", \"dfg\", \"joj\"]}";

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(H.class, new JsonDeserializer<H>() {
                    @Override
                    public H deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {



                        H h = new H();
                        JsonObject jsonObject = json.getAsJsonObject();

                        if (!jsonObject.get("name").isJsonNull()) {
                            String value = jsonObject.get("name").getAsString();
                            h.setName(value);
                        }
                        if (!jsonObject.get("age").isJsonNull()) {
                            int value = jsonObject.get("age").getAsInt();
                            h.setAge(value);
                        }
                        if (!jsonObject.get("alps").isJsonNull()) {
                            JsonArray alps = jsonObject.get("alps").getAsJsonArray();
                            List<String> list = new ArrayList<>();
                            for (JsonElement alp : alps) {
                                if (alp.isJsonNull()) {
                                    list.add(null);
                                } else {
                                    list.add(alp.getAsString());
                                }
                            }
                            list.add("定制化反序列化生效 -----------------------------");
                            h.setAlps(list);
                        }
                        return h;
                    }
                })
                .setPrettyPrinting()
                .create();

        System.out.println(gson.fromJson(jsonS, H.class));

    }

}

class H {
    private String name;
    private Integer age;
    private List<String> alps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getAlps() {
        return alps;
    }

    public void setAlps(List<String> alps) {
        this.alps = alps;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", H.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("alps=" + alps)
                .toString();
    }
}
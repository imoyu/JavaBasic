package gson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.StringJoiner;

public class No8GsonSerializedNameEx {

    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = gson.toJson(new Hunman8("包青天", 21, "huhuhu@qo.com"));
        System.out.println(json);

        String jsonS1 = "{\"name\":\"包青天\",\"age\":24,\"email\":\"ikidou@example.com\"}";
        Hunman8 hunman8 = gson.fromJson(jsonS1, Hunman8.class);
        System.out.println(hunman8);
    }

}

class Hunman8 {

    private String name;
    private Integer age;
    @SerializedName(value = "email_address", alternate = {"email", "emailAddress"})
    private String email;

    public Hunman8() {

    }

    public Hunman8(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Hunman8.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("email='" + email + "'")
                .toString();
    }
}
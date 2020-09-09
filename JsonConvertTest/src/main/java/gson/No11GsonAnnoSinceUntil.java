package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Until;

import java.util.StringJoiner;

public class No11GsonAnnoSinceUntil {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setVersion(0).create();
        System.out.println(gson.toJson(new Dog11("JJJ", "Blue")));
    }

}

class Dog11 {
    @Until(-1)
    private String name;
    private String color;

    public Dog11() {
    }

    public Dog11(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Dog11.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("color='" + color + "'")
                .toString();
    }
}
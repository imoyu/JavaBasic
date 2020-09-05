package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.util.StringJoiner;

public class No5ExposeEx {

    public static void main(String[] args) {

        User5 user = new User5("zoom", "18190901212", true, new Dog("小白", "Yellow"));

        Gson gson = new GsonBuilder()
//                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(user);

        System.out.println(json);

        System.out.println(new Gson().toJson(new Dog("KKK", "Black")));
        String dogJson = "{\"name\":\"KKK\",\"color\":\"Black\"}";
        Dog dog = new Gson().fromJson(dogJson, Dog.class);
        System.out.println(dog);


    }

}

class User5 {

    @Expose
    private String name;
    private String tel;
    @Expose
    private Boolean old;
    @Expose
    private Dog dog;

    public User5(String name, String tel, Boolean old, Dog dog) {
        this.name = name;
        this.tel = tel;
        this.old = old;
        this.dog = dog;
    }

    public User5() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Boolean getOld() {
        return old;
    }

    public void setOld(Boolean old) {
        this.old = old;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User5.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("tel='" + tel + "'")
                .add("old=" + old)
                .add("dog=" + dog)
                .toString();
    }
}

class Dog {
    private String name;
    private String color;

    public Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

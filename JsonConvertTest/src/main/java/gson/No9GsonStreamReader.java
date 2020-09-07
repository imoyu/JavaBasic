package gson;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class No9GsonStreamReader {

    public static void main(String[] args) throws IOException {
        String json = "{\"name\":\"包青天\",\"age\":\"24\"}";
        User9 user = new User9();

        JsonReader reader = new JsonReader(new StringReader(json));

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if ("name".equals(name)) {
                user.setName(reader.nextString());
            }
            if ("age".equals(name)) {
                user.setAge(reader.nextInt());
            }
        }
        reader.endObject();

        System.out.println(user);

        String json2 = "{\"name\":\"包青天\",\"age\":\"24\",\"u9s\":[{\"name\":\"包儿子1\",\"age\":\"20\"}, {\"name\":\"包儿子2\",\"age\":\"21\"}]}";
        UserWithList user2 = new UserWithList();
        JsonReader reader2 = new JsonReader(new StringReader(json2));

        reader2.beginObject();
        while (reader2.hasNext()) {
            String key = reader2.nextName();

            if ("name".equals(key)) {
                user2.setName(reader2.nextString());
            }
            if ("age".equals(key)) {
                user2.setAge(reader2.nextInt());
            }
            if ("u9s".equals(key)) {
                List<User9> list = new ArrayList<>();
                reader2.beginArray();
                Gson gson = new Gson();
                while (reader2.hasNext()) {
                    User9 u = gson.fromJson(reader2, User9.class);
                    list.add(u);
                }
                reader2.endArray();
                user2.setU9s(list);
            }
        }
        reader2.endObject();

        System.out.println(user2);
    }

}

class User9 {
    private String name;
    private Integer age;

    public User9() {
    }

    public User9(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return new StringJoiner(", ", User9.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }
}

class UserWithList {
    private String name;
    private Integer age;
    private List<User9> u9s;

    public UserWithList() {
    }

    public UserWithList(String name, Integer age, List<User9> u9s) {
        this.name = name;
        this.age = age;
        this.u9s = u9s;
    }

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

    public List<User9> getU9s() {
        return u9s;
    }

    public void setU9s(List<User9> u9s) {
        this.u9s = u9s;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserWithList.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("u9s=" + u9s)
                .toString();
    }
}
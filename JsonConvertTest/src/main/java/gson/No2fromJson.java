package gson;

import com.google.gson.Gson;

public class No2fromJson {

    public static void main(String[] args) {
        String jsonString = "{\"firstName\":\"Tom\", \"lastName\": \"Broody\"}";
        // 没有 "" 也能解析
        String jsonString2 = "{firstName:Tom, lastName: null}";

        Gson gson = new Gson();
        User user = gson.fromJson(jsonString, User.class);

        System.out.println(user);
    }

}

class User {
    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + lastName + '\'' +
                '}';
    }
}

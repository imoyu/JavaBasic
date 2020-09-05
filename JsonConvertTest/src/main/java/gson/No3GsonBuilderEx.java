package gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class No3GsonBuilderEx {

    public static void main(String[] args) throws UnsupportedEncodingException {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        User user = new User("Peter", "Flemming");

        PrintStream printStream = new PrintStream(System.out, true, "UTF-8");
        gson.toJson(user, printStream);

        String jsonString = "{\"firstName\":\"Peter\",\"LastName\":\"Flemming\"}";
        System.out.println();
        System.out.println(gson.fromJson(jsonString, User.class));

    }

}

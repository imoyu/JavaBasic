package gson;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class No12GsonExcludeStrategy {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        // 根据字段名排除
                        if ("color".equals(f.getName()))
                            return true;
                        // 根据 type 排除
                        Type type = f.getDeclaredType();
                        if (new TypeToken<Integer>(){}.getType() == type)
                            return true;

                        // 根据 Class 排除
                        Class<?> clazz = f.getDeclaredClass();
                        if (clazz == Integer.class)
                            return true;

                        // 根据父类字段还是子类字段进行排除
                        // 可以用这个方法排除父类的字段
                        Class<?> declaringClass = f.getDeclaringClass(); // class gson.Ser12

                        // 根据注解排除
                        Expose annotation = f.getAnnotation(Expose.class);
                        if (annotation != null && !annotation.serialize())
                            return  true;
                        return false;

                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return clazz == Double.class;
                    }
                })
                .create();
        Ser12 s = new Ser12();

        System.out.println(gson.toJson(s));

        Gson gson1 = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .create();
        System.out.println(gson1.toJson(new Ser12()));

        Ser12 ser12 = gson1.fromJson("{\"name\":\"GGG\",\"age\":18,\"color\":\"Yellow\",\"pets\":[\"dog\",\"cat\"],\"d\":1.2,\"email-address\":\"1010010@opo.com\"}", Ser12.class);
        System.out.println(ser12);

    }

}

class Ser12 {
    private String name;
    private Integer age;
    private String color;
    private List<String> pets;
    private Double d;
    private String emailAddress;

    public Ser12() {
        name = "GGG";
        age = 18;
        color = "Yellow";
        pets = Arrays.asList("dog", "cat");
        d = 1.2;
        emailAddress = "1010010@opo.com";
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ser12.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("color='" + color + "'")
                .add("pets=" + pets)
                .add("d=" + d)
                .add("emailAddress=" + emailAddress)
                .toString();
    }
}
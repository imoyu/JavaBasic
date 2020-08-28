package com.stream.baeldung.lambda_basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class SortLambda {

    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Sarah", 10));
        humans.add(new Human("Jack", 12));

        Collections.sort(humans, new CompareClass());

        humans.sort((final Human h1, final Human h2) -> {
            return h1.getName().compareTo(h2.getName());
        });
        humans.sort((final Human h1, final Human h2) -> h1.getName().compareTo(h2.getName()));
        humans.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));
        humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
        humans.sort(Comparator.comparing(Human::getName));
        humans.sort(Human::compareByNameThenAge);
        Human human = new Human("", 12);
        humans.sort(human::compareByNameThenAge2);

        Collections.sort(humans, Comparator.comparing(Human::getName));

        Comparator<Human> comparing = Comparator.comparing(new Function<Human, String>() {
            @Override
            public String apply(Human human) {
                return human.getName();
            }
        });


        humans.sort(comparing(new HumanFunction()));

        Comparator<HumanSon> cop1 = Comparator.comparing(Human::getName);
        Comparator<Human> cop2 = comparing(new Function<HumanFather, String>() {
            @Override
            public String apply(HumanFather father) {
                return null;
            }
        });
        Comparator<Human> comparing1 = Comparator.comparing(Human::getName);

        String s = f(new G<String>("generic"), new G<Integer>());
        System.out.println(s);

        List<? extends Integer> list = new ArrayList<>();
    }

    private static class HumanFunction implements Function<Human, String> {
        @Override
        public String apply(Human human) {
            return human.getName();
        }
    }

    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor) {
        return null;
//        Objects.requireNonNull(keyExtractor);
//        return (Comparator<T> & Serializable) (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }

    public static <T> T f(G<? extends T> g, G<? super Integer> g2) {
        return (T) g.t;
    }
}

class CompareClass implements Comparator<Human> {

    @Override
    public int compare(Human h1, Human h2) {
        return h1.getName().compareTo(h2.getName());
    }

}

class G<T> {
    T t;

    public G() {
    }

    public G(T t) {
        this.t = t;
    }
}

class GS<T> extends G<T> {}

class InfImp implements Inf<String> {

    @Override
    public void f(String s) {

    }
}

class InfImp2<T> implements Inf<T> {
    @Override
    public void f(T t) {

    }
}

class InfImp3 implements Inf {
    @Override
    public void f(Object o) {

    }
}

class HumanFather{}

class Human extends HumanFather{
    private String name;
    private int age;

    public Human() {
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int compareByNameThenAge(Human lhs, Human rhs) {
        if (lhs.name.equals(rhs.name)) {
            return Integer.compare(lhs.age, rhs.age);
        } else {
            return lhs.name.compareTo(rhs.name);
        }
    }
    public int compareByNameThenAge2(Human lhs, Human rhs) {
        if (lhs.name.equals(rhs.name)) {
            return Integer.compare(lhs.age, rhs.age);
        } else {
            return lhs.name.compareTo(rhs.name);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (age != human.age) return false;
        return name != null ? name.equals(human.name) : human.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

class HumanSon extends Human {}

class P<T> {
    <T> void func(T t) {}

    static <E> void print(E a, E b) {
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        print("", 12);
    }
}
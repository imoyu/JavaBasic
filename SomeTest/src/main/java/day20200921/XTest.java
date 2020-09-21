package day20200921;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XTest {

    @Test
    public void OutCloseTest() {

        System.out.println("---");
        System.out.close();
        System.out.println("---");

    }

    @Test
    public void DeleteDataTest() throws IOException {

        Path path1 = Paths.get("D:\\Code\\Java\\BasicJava\\SomeTest\\src\\main\\java\\day20200921\\1.txt"); // absolute path
        Stream<String> streamOfStrings1 = Files.lines(path1);

        Path path2 = Paths.get("src/main/java/day20200921/2.txt"); // content root
        Stream<String> streamOfStrings2 = Files.lines(path2);

        Path path3 = Paths.get("src/main/java/day20200921/3.txt"); // content root
        Stream<String> streamOfStrings3 = Files.lines(path3);

        Path path4 = Paths.get("src/main/java/day20200921/4.txt"); // content root
        Stream<String> streamOfStrings4 = Files.lines(path4);

        Path path5 = Paths.get("src/main/java/day20200921/5.txt"); // content root
        Stream<String> streamOfStrings5 = Files.lines(path5);

        Path path6 = Paths.get("src/main/java/day20200921/6.txt"); // content root
        Stream<String> streamOfStrings6 = Files.lines(path6);

        Path path8 = Paths.get("src/main/java/day20200921/8.txt"); // content root
        Stream<String> streamOfStrings8 = Files.lines(path8);

        Map<String, String> map3 = streamOfStrings3
                .collect(Collectors.toMap(s -> s.split(",")[1], s -> s.split(",")[0]));

        Map<String, String> map8 = streamOfStrings8
                .skip(1)
                .collect(Collectors.toMap(s -> s.split(",")[0], s -> s.split(",")[1]));

        map3.forEach((k, v) -> {
            String res = v + " " + map8.get(k);
            System.out.println(res);
        });

    }
}


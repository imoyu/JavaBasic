package gson;

import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

public class No10GsonStreamWriter {

    public static void main(String[] args) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        JsonWriter writer = new JsonWriter(out);

        writer.beginObject()
                .name("name").value("包青天")
                .name("age").value(24)
                .name("email").nullValue()
                .endObject();

//        writer.close();
//        out.close();

        // ==========================================================================

        StringWriter stringWriter = new StringWriter();
        JsonWriter writer2 = new JsonWriter(stringWriter);
        writer2.setIndent("  ");

        writer2.beginObject()
                    .name("name").value("kiki")
                    .name("children")
                        .beginArray()
                            .beginObject()
                                .name("child").value("lisa")
                            .endObject()
                            .beginObject()
                                .name("child").value("lily")
                            .endObject()
                            .beginObject()
                                .name("child").value("lucy")
                            .endObject()
                        .endArray()
                    .name("age").value(38)
                .endObject();

        System.out.println(stringWriter.toString());
        writer2.close();
        stringWriter.close();
    }

}

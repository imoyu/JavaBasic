package day20200927;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class MapNullValuetest {

    public static void main(String[] args) {

        List<KV> list = new ArrayList<>();
        list.add(new KV("202004", "1729.80"));
        list.add(new KV("202006", null));
        list.add(new KV("202007", "9777.20"));

        Map<String, String> map = list.stream()
                .collect(Collectors.toMap(KV::getK, KV::getV));

    }

}

class KV {

    private String k;
    private String v;

    public KV(String k, String v) {
        this.k = k;
        this.v = v;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", KV.class.getSimpleName() + "[", "]")
                .add("k='" + k + "'")
                .add("v='" + v + "'")
                .toString();
    }
}

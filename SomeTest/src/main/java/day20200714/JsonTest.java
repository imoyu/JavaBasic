package day20200714;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {

    public static void main(String[] args) {

        Map<String, List<String>> map = new HashMap<>();

        List<String> list = new ArrayList<>();
        list.add("大萨达大所多啥多啥");
        list.add("发大水发计划将客户即可查看");
        list.add("大飒飒大城市破视频是东方");

        map.put("list", list);

        Gson gson = new Gson();
        String gJson = gson.toJson(map);
        System.out.println(gJson);

        String fJson = JSONObject.toJSONString(map);
        System.out.println(fJson);

        System.out.println(gson.equals(fJson));
        System.out.println(gJson.length());
        System.out.println(fJson.length());

        for (int i = 0; i < gJson.length(); i++) {
            if (gJson.charAt(i) != fJson.charAt(i)) {
                System.out.println(String.format("%c : %c", gJson.charAt(i), fJson.charAt(i)));
            }
        }
    }

}

package com.test.project;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YzsSQLGenerator {

    @Test
    public void Test() throws IOException {

        String inputFilePath = "C:\\Users\\admin\\Desktop\\temp\\input\\aaa.txt";
        String outputDirectoryPath = "C:\\Users\\admin\\Desktop\\temp\\output\\";

        StringBuilder sb = new StringBuilder();
        List<String> outputs = new ArrayList<>();

        Files.lines(Paths.get(inputFilePath))
                .forEach(s -> {
                    if (s.length() > 0) {
                        sb.append(s);
                        if (s.charAt(0) == ']') {
                            outputs.add(sb.toString());
                            sb.setLength(0);
                        }
                    }
                });


        for (String output : outputs) {
            String[] outs = generate(output);

            if (outs[1] == null) {
                System.out.println(outs[0] + " 有数据为空，生成 sql 失败");
                continue;
            }

            String fileName = outputDirectoryPath + outs[0] + ".sql";

            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer;
            try {
                writer = new FileWriter(fileName);
                writer.write(outs[1]);
                writer.flush();
                writer.close();
                System.out.println(outs[0] + ".sql 创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private static String func(String o) {
        return "'" + o + "'";
    }

    private static String[] generate(String input) {

        Gson gson = new Gson();
        List<Map<String, String>> list = gson.fromJson(input, new TypeToken<List<Map<String, String>>>() {
        }.getType());

        Map<String, String> map = list.get(0);

        String template = "INSERT INTO ecommerce.customer_order (id, created_by, creation_time, last_update_time, updated_by, version,\n" +
                "appointment_date, comments, customer_name, customer_phone, number, paid,\n" +
                "paid_time, payment_trade_no, remark, total_price, activity_id, address_id,\n" +
                "customer_id, order_type_id, payment_way_id, order_status_id, valid, PAID_AMOUNT,\n" +
                "truck_plate_number, vendor_id, vendor_user_id, delivery_mode,\n" +
                "distribution_address, door_point_id, promote_product, promote_message,\n" +
                "promote_amount)\n" +
                "VALUES (null, '', @create_time, @create_time, '', 1, null, null, @customer_name, @customer_phone,\n" +
                "@order_number, false, @create_time, null, @content,\n" +
                "@total_price, null, null, @customer_id, 'ORDER_TYPE_OIL_OTHER', null, 'ORDER_COMPLETED', true, @paid_amount, @plate_number,\n" +
                "@vendor_id, @vendor_user_id, null, null, null, null, null, null);\n" +
                "\n" +
                "INSERT INTO ecommerce.order_product_rel (id, created_by, creation_time, last_update_time, updated_by, version, price,\n" +
                "product_description, product_name, qty, order_id, product_id, cost_price,\n" +
                "delivery_fee, is_mounting_tyre, mounting_tyre_time)\n" +
                "VALUES (null, '', @create_time, @create_time, '', 0, cast(@paid_amount / @qty as decimal(10,2)), null, @product_name, cast(@qty * 1000 as unsigned), @@identity, @product_id,\n" +
                "cast(@total_price / @qty as decimal(10,2)), null, null, null);\n" +
                "\n" +
                "INSERT INTO yzs_tms.payment_record (ID, CREATED_BY, CREATION_TIME, LAST_UPDATE_TIME, UPDATED_BY, VERSION, AMOUNT,\n" +
                "CONTAINER_LOAD_ID, PAYMENT_BUSSINESS, TYPE, COMPANY_ID, DRIVER_ID, REF_ID,\n" +
                "CAN_WITHDRAWAL, DESCRIPTION, tag, REMARK)\n" +
                "VALUES (null, '', @create_time, @create_time, '', 0, @paid_amount, null, '加油', '加油', null,\n" +
                "@customer_id, '', false, @description, '消费', @remark);\n" +
                "\n" +
                "INSERT INTO yzs_tms.payment_record_detail (ID, CREATED_BY, CREATION_TIME, LAST_UPDATE_TIME, UPDATED_BY, VERSION, AMOUNT,\n" +
                "CAN_WITHDRAWAL, CAN_WITHDRAWAL_TIME, PAYMENT_RECORD_ID)\n" +
                "VALUES (null, '', @create_time, @create_time, '', 0, @paid_amount, false, null, @@identity);";

        String s1 = map.get("@plate_number");

        for (String value : map.values()) {
            if (value == null || value.trim().equals("")) {
                return new String[]{s1, null};
            }
        }

        String s2 = template
                .replace("@total_price", map.get("@total_price"))
                .replace("@paid_amount", map.get("@paid_amount"))
                .replace("@qty", map.get("@qty"))
                .replace("@product_name", func(map.get("@product_name")))
                .replace("@order_time", func(map.get("@order_time")))
                .replace("@oil", func(map.get("@oil")))
                .replace("@plate_number", func(map.get("@plate_number")))
                .replace("@customer_id", func(map.get("@customer_id")))
                .replace("@customer_name", func(map.get("@customer_name")))
                .replace("@customer_phone", func(map.get("@customer_phone")))
                .replace("@number", func(map.get("@number")))
                .replace("@vendor_id", map.get("@vendor_id"))
                .replace("@product_id", map.get("@product_id"))
                .replace("@vendor_user_id", func(map.get("@vendor_user_id")))
                .replace("@create_time", func(map.get("@create_time")))
                .replace("@order_number", func(map.get("@order_number")))
                .replace("@content", func(map.get("@content")))
                .replace("@description", func(map.get("@description")))
                .replace("@remark", func(map.get("@remark")));
        return new String[] {s1, s2};
    }
}

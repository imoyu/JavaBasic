package com.test.itextpdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;

public class T1 {

    // https://www.cnblogs.com/xxyfhjl/p/4143076.html
    @Test
    public void Test() throws Exception {

        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED,10f, Font.NORMAL, BaseColor.BLACK);
        InputStream input = new FileInputStream("C:\\Users\\admin\\Desktop\\temp\\pdf\\input\\模板2.pdf");
        PdfReader reader = new PdfReader(input);
        OutputStream output = new FileOutputStream("C:\\Users\\admin\\Desktop\\temp\\pdf\\output\\安全承诺书.pdf");
        PdfStamper stamper = new PdfStamper(reader, output);

        PdfContentByte page2 = stamper.getOverContent(2);
        //将文字贴入pdf
        page2.beginText();
        page2.setFontAndSize(baseFont, 15);
        BaseColor color = new BaseColor(0, 0, 0);
        page2.setColorFill(color);

        // 填充中文
        page2.setTextMatrix(155, 160);
        page2.showText("上海鸭嘴兽供应链管理有限公司");

        page2.setTextMatrix(115, 111);
        page2.showText("2021");

        page2.setTextMatrix(166, 111);
        page2.showText("04");

        page2.setTextMatrix(204, 111);
        page2.showText("18");

        page2.setTextMatrix(380, 111);
        page2.showText("2021");

        page2.setTextMatrix(432, 111);
        page2.showText("04");

        page2.setTextMatrix(470, 111);
        page2.showText("18");


        page2.endText();


        // 签名
        Image image1 = Image.getInstance("C:\\Users\\admin\\Desktop\\temp\\pdf\\input\\d10d.png");
        image1.scaleToFit(60, 40);
        image1.setAbsolutePosition(435, 142);
        page2.addImage(image1);

        // 盖章
        Image image2 = Image.getInstance("C:\\Users\\admin\\Desktop\\temp\\pdf\\input\\01.png");
        image2.scaleToFit(135, 135);
        image2.setAbsolutePosition(112, 70);
        page2.addImage(image2);

        stamper.close();
        reader.close();
        input.close();

    }

    @Test
    public void LDTest() {

        LocalDate now = LocalDate.now();

        System.out.println(now.getYear());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getMonthValue());

    }

}

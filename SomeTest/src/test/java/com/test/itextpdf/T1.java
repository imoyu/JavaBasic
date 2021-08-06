package com.test.itextpdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;

public class T1 {

    // https://www.cnblogs.com/xxyfhjl/p/4143076.html
    @Test
    public void S1Test() throws Exception {

        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED,10f, Font.NORMAL, BaseColor.BLACK);
        InputStream input = new FileInputStream("C:\\Users\\admin\\Desktop\\temp\\pdf\\input\\eee.pdf");
        PdfReader reader = new PdfReader(input);
        OutputStream output = new FileOutputStream("C:\\Users\\admin\\Desktop\\temp\\pdf\\output\\安全承诺书.pdf");
        PdfStamper stamper = new PdfStamper(reader, output);
        BaseColor color = new BaseColor(0, 0, 0);

        PdfContentByte page1 = stamper.getOverContent(1);
        page1.beginText();
        page1.setFontAndSize(baseFont, 22);
        page1.setCharacterSpacing(-2);
        page1.setColorFill(color);

        float x = 83;
        x = (float)(x - 0 * 11.5);
        System.out.println(x);
        page1.setTextMatrix(x, 735);
        page1.showText("2021年深圳市道路运输企业驾驶人交通安全承诺书");

        page1.endText();

        PdfContentByte page2 = stamper.getOverContent(2);
        //将文字贴入pdf
        page2.beginText();
        page2.setFontAndSize(baseFont, 15);
        page2.setColorFill(color);

        // 填充中文
        page2.setTextMatrix(125, 160);
        page2.showText("上海鸭嘴兽供应链管理有限公司");

        page2.setTextMatrix(85, 111);
        page2.showText("2021");

        page2.setTextMatrix(136, 111);
        page2.showText("04");

        page2.setTextMatrix(174, 111);
        page2.showText("18");

        page2.setTextMatrix(373, 111);
        page2.showText("2021");

        page2.setTextMatrix(425, 111);
        page2.showText("04");

        page2.setTextMatrix(463, 111);
        page2.showText("18");


        page2.endText();


        // 签名
        Image image1 = Image.getInstance("C:\\Users\\admin\\Desktop\\temp\\pdf\\input\\b.png");
        image1.scaleToFit(78, 52);
        image1.setAbsolutePosition(430, 142);
        page2.addImage(image1);

        // 盖章
        Image image2 = Image.getInstance("C:\\Users\\admin\\Desktop\\temp\\pdf\\input\\c.png");
        image2.scaleToFit(155, 155);
        image2.setAbsolutePosition(85, 70);
        page2.addImage(image2);

        stamper.close();
        reader.close();
        input.close();

    }

    // 图片设置 https://blog.csdn.net/tomatocc/article/details/80668701
    @Test
    public void S2Test() throws Exception {

        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED,10f, Font.NORMAL, BaseColor.BLACK);
        InputStream input = new FileInputStream("C:\\Users\\admin\\Desktop\\temp\\pdf\\input2\\右转必停承诺书me2.pdf");
        PdfReader reader = new PdfReader(input);
        OutputStream output = new FileOutputStream("C:\\Users\\admin\\Desktop\\temp\\pdf\\input2\\result.pdf");
        PdfStamper stamper = new PdfStamper(reader, output);
        BaseColor color = new BaseColor(0, 0, 0);

//        page1.setFontAndSize(baseFont, 22);
//        page1.setCharacterSpacing(-2);

        PdfContentByte page1 = stamper.getOverContent(1);
        //将文字贴入pdf
        page1.beginText();
        page1.setFontAndSize(baseFont, 14);
        page1.setColorFill(color);

        // 填充中文
        page1.setTextMatrix(245, 282.5f);
        page1.showText("上海鸭嘴兽供应链管理有限公司");

        page1.setTextMatrix(336, 219.7f);
        page1.showText("2021年9月11日");

        page1.endText();


        // 签名
        Image image1 = Image.getInstance("C:\\Users\\admin\\Desktop\\temp\\pdf\\input\\b.png");
        image1.scaleToFit(62.4f, 41.6f);
        image1.setAbsolutePosition(335, 235);
        page1.addImage(image1);

        // 盖章
        Image image2 = Image.getInstance("C:\\Users\\admin\\Desktop\\temp\\pdf\\input\\c.png");
        image2.scaleToFit(155, 155);
        image2.setAbsolutePosition(240, 185);
        page1.addImage(image2);

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

package ui.SearchDealer;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class MyFont {
    public MyFont() {

    }


        public Font loadHeadlineAFont( float fontSize)  //第一个参数是外部字体名，第二个是字体大小
        {
            try
            {
                File file = new File("src/ui/font/HeadlineA.ttf");
                FileInputStream aixing = new FileInputStream(file);
                Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, aixing);
                Font dynamicFontPt = dynamicFont.deriveFont(fontSize);
                aixing.close();
                return dynamicFontPt;
            }
            catch(Exception e)//异常处理
            {
                e.printStackTrace();
                //return new java.awt.Font("宋体", Font.PLAIN, 14);
            }
            return null;
        }
    public Font loadHeitiFont( float fontSize)  //第一个参数是外部字体名，第二个是字体大小
    {
        try
        {
            File file = new File("src/ui/font/heiti.ttf");
            FileInputStream aixing = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, aixing);
            Font dynamicFontPt = dynamicFont.deriveFont(fontSize);
            aixing.close();
            return dynamicFontPt;
        }
        catch(Exception e)//异常处理
        {
            e.printStackTrace();
            //return new java.awt.Font("宋体", Font.PLAIN, 14);
        }
        return null;
    }
    public Font loadCourierFont( float fontSize)  //第一个参数是外部字体名，第二个是字体大小
    {
        try
        {
            File file = new File("src/ui/font/Courier New Bold.ttf");
            FileInputStream aixing = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, aixing);
            Font dynamicFontPt = dynamicFont.deriveFont(fontSize);
            aixing.close();
            return dynamicFontPt;
        }
        catch(Exception e)//异常处理
        {
            e.printStackTrace();
            //return new java.awt.Font("宋体", Font.PLAIN, 14);
        }
        return null;
    }
    public Font loadSensaSansFont( float fontSize)  //第一个参数是外部字体名，第二个是字体大小
    {
        try
        {
            File file = new File("src/ui/font/SensaSans.otf");
            FileInputStream aixing = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, aixing);
            Font dynamicFontPt = dynamicFont.deriveFont(fontSize);
            aixing.close();
            return dynamicFontPt;
        }
        catch(Exception e)//异常处理
        {
            e.printStackTrace();
            //return new java.awt.Font("宋体", Font.PLAIN, 14);
        }
        return null;
    }

    public Font loadNanumBrushScriptFont( float fontSize)  //第一个参数是外部字体名，第二个是字体大小
    {
        try
        {
            File file = new File("src/ui/font/NanumBrushScript.ttf");
            FileInputStream aixing = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, aixing);
            Font dynamicFontPt = dynamicFont.deriveFont(fontSize);
            aixing.close();
            return dynamicFontPt;
        }
        catch(Exception e)//异常处理
        {
            e.printStackTrace();
            //return new java.awt.Font("宋体", Font.PLAIN, 14);
        }
        return null;
    }

    public Font loadBauhausFont( float fontSize)  //第一个参数是外部字体名，第二个是字体大小
    {
        try
        {
            File file = new File("src/ui/font/Bauhaus 93.ttf");
            FileInputStream aixing = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, aixing);
            Font dynamicFontPt = dynamicFont.deriveFont(fontSize);
            aixing.close();
            return dynamicFontPt;
        }
        catch(Exception e)//异常处理
        {
            e.printStackTrace();
            //return new java.awt.Font("宋体", Font.PLAIN, 14);
        }
        return null;
    }

    public Font loadCALIBRIBFont( float fontSize)  //第一个参数是外部字体名，第二个是字体大小
    {
        try
        {
            File file = new File("src/ui/font/CALIBRIB.ttf");
            FileInputStream aixing = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, aixing);
            Font dynamicFontPt = dynamicFont.deriveFont(fontSize);
            aixing.close();
            return dynamicFontPt;
        }
        catch(Exception e)//异常处理
        {
            e.printStackTrace();
            //return new java.awt.Font("宋体", Font.PLAIN, 14);
        }
        return null;
    }

    public Font loadOCRAStdFont( float fontSize)  //第一个参数是外部字体名，第二个是字体大小
    {
        try
        {
            File file = new File("src/ui/font/OCRAStd.otf");
            FileInputStream aixing = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, aixing);
            Font dynamicFontPt = dynamicFont.deriveFont(fontSize);
            aixing.close();
            return dynamicFontPt;
        }
        catch(Exception e)//异常处理
        {
            e.printStackTrace();
            //return new java.awt.Font("宋体", Font.PLAIN, 14);
        }
        return null;
    }
//        public static java.awt.Font Font(){
//            String root=System.getProperty("user.dir");//项目根目录路径
//            Font font = Loadfont.loadFont(root+"/data/PRISTINA.ttf", 18f);//调用
//            return font;//返回字体
//        }
//        public static java.awt.Font Font2(){
//            String root=System.getProperty("user.dir");//项目根目录路径
//            Font font = Loadfont.loadFont(root+"/data/XXXX.ttf", 18f);
//            return font;//返回字体
//        }






}

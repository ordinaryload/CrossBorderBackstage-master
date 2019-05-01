package sugar.tools.assist;
/*
 *@auther suger
 *2019
 *14:16
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class getNowDate {
   public static String Date(){
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
       String nowTime=df.format(new Date());
       System.out.println(nowTime);// new Date()为获取当前系统时间
       return nowTime;
   }
    public static String Time(){
        SimpleDateFormat df = new SimpleDateFormat("HH-mm-ss");//设置日期格式
        String nowTime=df.format(new Date());
        System.out.println(nowTime);// new Date()为获取当前系统时间
        return nowTime;
    }

    public static String Complete(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//设置日期格式
        String nowTime=df.format(new Date());
        System.out.println(nowTime);// new Date()为获取当前系统时间
        return nowTime;
    }
}

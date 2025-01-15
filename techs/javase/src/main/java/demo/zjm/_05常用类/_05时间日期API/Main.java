package demo.zjm._05常用类._05时间日期API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        //获取时间戳
        System.out.println(System.currentTimeMillis());
        //Date
        System.out.println(new Date());//Thu Mar 24 11:36:06 CST 2022
        System.out.println(new Date().getTime());//也能获取时间戳
        System.out.println(new Date(0));//Thu Jan 01 08:00:00 CST 1970
        System.out.println(new Date(2022, 1, 1));//Wed Feb 01 00:00:00 CST 3922
        //sql.Date
        //public class Date extends java.util.Date {
        System.out.println(new java.sql.Date(System.currentTimeMillis()));//2022-03-24
        java.sql.Date date = new java.sql.Date(new Date().getTime());

        //格式化和解析
        //格式化器可以指定参数
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);//22-3-24 下午12:01
        Date parse = simpleDateFormat.parse(format);
        System.out.println(parse);//Thu Mar 24 12:01:00 CST 2022

        //Calendar
        System.out.println(Calendar.getInstance().getClass());//class java.util.GregorianCalendar
        //get传入写死的参数获取
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DATE));//24
        //calendar对象是可以修改的
        calendar.set(Calendar.DATE, 1);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//60
        calendar.add(Calendar.DATE, 1);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//60
        //与Date转换
        Date time = calendar.getTime();
        calendar.setTime(new Date());
    }
}

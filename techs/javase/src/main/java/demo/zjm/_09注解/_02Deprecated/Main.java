package demo.zjm._09注解._02Deprecated;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //这里的横线就是表示过时了
//        @Deprecated
//        public Date(int year, int month, int date) {
//            this(year, month, date, 0, 0, 0);
//        }
        Date date = new Date(2022, 1, 30);
    }
}

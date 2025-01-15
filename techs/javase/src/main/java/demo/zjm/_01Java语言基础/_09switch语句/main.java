package demo.zjm._01Java语言基础._09switch语句;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        char c = '2';
        int a = 3;

        //Java7以后允许控制的变量为字符串
        String s = "";
        switch (s) {

        }

        switch (c) {

            // case expressions must be constant expressions 1
            //case (char) ('3'+ a):

            case ('3'):
                System.out.println();
                break;
            default:
                System.out.println("--1");
        }

        cout:
        while (true) {
            c = new Scanner(System.in).next().charAt(0);
            switch (c) {
                //fallthrough现象
                case ('1'):
                    System.out.println("1--");
                case ('2'):
                    System.out.println("2--");
                case ('3'):
                    System.out.println("3--");
                    break;
                default:
                    System.out.println("退出循环");
                    break cout;
            }
        }
        //1
        //1--
        //2--
        //3--
        //2
        //2--
        //3--
        //3
        //3--
        //4
        //退出循环
    }
}

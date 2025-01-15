package demo.zjm._02面向对象._01可变形参;

import java.util.Arrays;

public class Main {

    static void fun(int... nums) {
        //本质上nums是可变长的数组
        System.out.println(Arrays.toString(nums));
        System.out.println(nums.length);
        System.out.println(nums[0]);
    }

    public static void main(String[] args) {
        fun(new int[]{1, 2, 3});
        fun(new int[]{1, 2});
        //[1, 2, 3]
        //3
        //1
        //[1, 2]
        //2
        //1
    }
}

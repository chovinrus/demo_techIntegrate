package demo.zjm.ds.util;

import demo.zjm.ds.sort.Sort;

import java.util.Arrays;

/**
 * 对数器，生成数组等
 */
public class BasicUtil {

    // 生成范围内整数字（左闭右开）
    public static int randomInteger(int upper){
        return (int)Math.random()*upper;
    }

    // 生成长度为n,数值下界为0,上界maxValue的数组
    public static int[] random(int n, int upper) {
        int[] table = new int[n];
        for (int i = 0; i < n; i++) {
            table[i] = randomInteger(upper);
        }
        return table;
    }

    //对数器
    public static boolean isRight(int[] toBeCompare) {
        int length = toBeCompare.length;
        int[] right = new int[length];
        System.arraycopy(toBeCompare, 0, right, 0, length);
        Arrays.sort(right);
        for (int i = 0; i < length; i++) {
            if (toBeCompare[i] != right[i]) {
                System.out.println("index:" + i + ", right value:" + right[i] + ", actual value:" + toBeCompare[i]);
                print(toBeCompare);
                print(right);
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        if(i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        int[] arr;
        for (int i = 0; i < 100; i++) {
            arr = random(100, 100);
            Sort.bInsertSort(arr);
            if (!isRight(arr)) {
                System.out.println(isRight(arr));
                throw new Exception("对数器失败！");
            }
        }
        System.out.println("true");
    }
}

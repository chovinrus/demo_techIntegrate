package demo.zjm._01Java语言基础._11数组类型;

public class Main {
    public static void main(String[] args) {
        //动态初始化
        int[] ints = new int[3];
        int[] ints1;
        ints1 = new int[3];

        //静态初始化
        int[] ints2 = {};
        int[] ints3 = new int[]{};

        //静态初始化的一个错误
        int[] ints4;
        //ints4 = {};//Array initializer is not allowed here
        ints4 = new int[]{};//这样才是对的


        //  char类型的数组初始值是'\u0000',意为NIL
        char[] arr_c = new char[3];
        System.out.println(arr_c[0] == '\u0000');//true

        //  String数组初始值为null
        String[] arr_s = new String[3];
        System.out.println(null == arr_s[0]);//true


        //二维数组规定二维长度但不规定一维数组的长度
        int[][] matrix = new int[3][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[i + 1];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //0
        //0 0
        //0 0 0
    }
}

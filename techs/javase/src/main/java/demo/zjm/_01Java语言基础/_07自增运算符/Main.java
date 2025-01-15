package demo.zjm._01Java语言基础._07自增运算符;

public class Main {
    public static void main(String[] args) {
        int num = 0;
        //这里等号右侧的num是复制的num未自增时的值，自增操作是立刻执行的，当前语句留下的是复制值
        num = num++;
        System.out.println(num);//0
    }
}

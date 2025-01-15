package demo.zjm._05常用类._04StringBuffer常用方法;

public class Main {
    public static void main(String[] args) {
        //可变字符序列的可变
        StringBuffer sb = new StringBuffer("zz");
        sb.append(2);
        System.out.println(sb);//zz2
        sb.insert(1, "lll");
        System.out.println(sb);//zlllz2
        sb.replace(1, 4, "---");
        System.out.println(sb);//z---z2
        System.out.println(sb.delete(1, 4));//zz2
        System.out.println(sb.reverse());//2zz
        sb.setCharAt(0, '4');
        System.out.println(sb);//4zz
        //链式操作
        System.out.println(sb.append(3).reverse().append(2));//3zz42
    }
}

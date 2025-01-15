package demo.zjm._07IO与网络编程._02FIle常用方法;//package _07IO与网络编程._02FIle常用方法;



import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("src/_07IO与网络编程/_02File常用方法/Main.java");
        System.out.println(file);


        System.out.println(file.getPath());//这里返回的就是new File的pathName，怎么new的就返回什么
        System.out.println(file.getAbsolutePath());//这个规范路径名就是适应系统而言
        //创建的时候若是以绝对路径方式，则返回pathname
        //Unix系统的解析绝对路径是当前用户家目录下路径
        //window系统的解析绝对路径是磁盘下路径
        System.out.println(file.getCanonicalPath());//返回唯一的标准规范绝对路径。会将.、..替换掉
        //参照这个栗子理解下，当然这个是Unix系统下了
        //Path: /Users/martin6699/../martin6699/test.txt
        //Absolute Path: /Users/martin6699/../martin6699/test.txt
        //Canonical Path: /Users/martin6699/test.txt

        System.out.println(file.getName());
        System.out.println(file.getParent());//获取文件目录
        System.out.println(file.length());//文件内容的长度
        System.out.println(Date.valueOf(String.valueOf(new Date(file.lastModified()))).toString());//最后修改时间

        file = new File("src/_07IO与网络编程/_02File常用方法");
        System.out.println(Arrays.asList(file.listFiles()));//当前路径下的所有文件及目录作为数组
        System.out.println(Arrays.asList(file.list()));//和上面一致，string类型数组
        System.out.println(Arrays.asList(file.list()).get(0).getClass());//和上面一致，string类型数组
        System.out.println(Arrays.asList(file.list()).get(0).getClass());//和上面一致，string类型数组

        //路径重命名，要保证新路径的目录存在
//        file = new File("src\\_07IO与网络编程\\_02FIle常用方法\\zz.txt");
//        boolean b = file.renameTo(new File("src\\_07IO与网络编程\\_02FIle常用方法\\dirc\\zz.txt"));
//        System.out.println(b);

        //exsit
        System.out.println(file.exists());//false
        file = new File("src/_07IO与网络编程/_02FIle常用方法/resource.properties");
        System.out.println(file.isFile());//true
        System.out.println(file.isDirectory());//false

        //canExcute,canRead,canWrite,isHidden
        System.out.println(file.canExecute());//true
        System.out.println(file.canRead());//true
        System.out.println(file.canWrite());//true
        System.out.println(file.isHidden());//false

        //createNewFile，同样要保证目录路径存在
        file = new File("src/_07IO与网络编程/_02FIle常用方法/toBedelete.mp3");
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            System.out.println(newFile + "创建成功！");
        }

        //delete删除文件或目录，是目录的话必须先将目录下的文件和目录清空
        //删除不经过回收站
        boolean delete = new File("src/_07IO与网络编程/_02FIle常用方法/toBedelete.mp3").delete();
        System.out.println(delete + "删除成功！");//true

        //创建目录mkdir,mkdirs，后面这个可以帮助创建父级目录
        file = new File("src/_07IO与网络编程/_02FIle常用方法/zz");
        file.mkdir();
        file = new File("src/_07IO与网络编程/_02FIle常用方法/zx/zz");
        file.mkdirs();
    }

    @Test
    public void test() throws IOException {
        //测试一个问题
        //相对的根目录是当前module位置
        System.out.println(new File("Main.java").getCanonicalPath());
    }
}

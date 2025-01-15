package demo.zjm._08_原型模式.client;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: DesignPattern
 * @ClassName: Student
 * @description:
 * @author: AlanMa
 * @create: 2024-01-13 20:27
 */
@Data
public class Student implements Serializable {

    private String stuName;
    private Integer age;

    public Student() {
    }

    public Student(String stuName, Integer age) {
        this.stuName = stuName;
        this.age = age;
    }
}

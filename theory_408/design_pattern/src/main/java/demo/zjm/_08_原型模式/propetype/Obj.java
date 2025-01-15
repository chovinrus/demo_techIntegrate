package demo.zjm._08_原型模式.propetype;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @program: DesignPattern
 * @ClassName: Obj
 * @description:
 * @author: AlanMa
 * @create: 2024-01-13 11:24
 */
@Getter
public class Obj implements Serializable {
    private String s = "";

    public Obj() {
    }

    public Obj(String number) {
    }
}

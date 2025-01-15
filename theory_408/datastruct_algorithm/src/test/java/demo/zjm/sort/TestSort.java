package demo.zjm.sort;

import demo.zjm.ds.sort.Sort;
import demo.zjm.ds.util.BasicUtil;
import org.junit.jupiter.api.Test;

/**
 * @program: demo_techIntegrate
 * @ClassName: Sort
 * @description:
 * @author: AlanMa
 * @create: 2024-04-04 02:21
 */
public class TestSort {
    @Test
    public void test() throws Exception {

        int[] arr;
        for (int i = 0; i < 100; i++) {
            arr = BasicUtil.random(100, 100);
            Sort.selectSort(arr);
            if (!BasicUtil.isRight(arr)) {
                System.out.println(BasicUtil.isRight(arr));
                throw new Exception("对数器失败！");
            }
        }
        System.out.println("true");
    }
}

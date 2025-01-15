package demo.zjm.ds.nj842._1选择问题;

import org.junit.jupiter.api.Test;

import java.util.*;



public class Main {

    /*
     * 找出第k大的对象
     * @param arr
     * @return T
     * @Param k
     * @author 26973
     * @date 2024/2/20 19:21
     **/
    <T extends Comparable> T selectK(List<T> list, int k, Comparator<T> comparator) {
        // 先对0到k-1位置进行排序，构建为链表
        List<T> subList = list.subList(0, k);
        Collections.sort(subList, comparator);

        // 遍历list中k以后的元素，若大于list的队尾元素则放入list合适位置
        T t;
        int insLoc;
        for (int i = k; i < list.size(); i++) {
            t = list.get(i);
            for (insLoc = k - 1; insLoc >= 0 && comparator.compare(t, subList.get(insLoc)) < 0; insLoc--) ;
            subList.add(++insLoc, t);
            subList.remove(k);
        }
        return subList.get(k - 1);
    }

    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 3, 2, 5, 4));
        Integer res = selectK(list, 4, (i1, i2) -> i2 - i1);
        System.out.println(res);
    }
}


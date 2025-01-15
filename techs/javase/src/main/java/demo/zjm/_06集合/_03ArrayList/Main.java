package demo.zjm._06集合._03ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            integers.add(i);
        }


        //trimToSize 裁剪capacity为size，可以调试查看效果
        ((ArrayList) integers).trimToSize();
        System.out.println(integers);

        List<Integer> list = new ArrayList<>();
        int[] a = {1, 2, 3};
        //System.arraycopy(integers, 0, list, 0, integers.size());
        int[] ints = Arrays.copyOf(a, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        System.out.println(list);

        //public ArrayList() {
        //        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        //    }

        //private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

        //protected transient int modCount = 0;//记录结构性变化的次数

        //public static Integer valueOf(int i) {
        //        if (i >= IntegerCache.low && i <= IntegerCache.high)
        //            return IntegerCache.cache[i + (-IntegerCache.low)];
        //        return new Integer(i);
        //    }

        //public boolean add(E e) {
        //        ensureCapacityInternal(size + 1);  // Increments modCount!!
        //        elementData[size++] = e;
        //        return true;
        //    }

        //private void ensureCapacityInternal(int minCapacity) {
        //        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        //            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        //        }
        //
        //        ensureExplicitCapacity(minCapacity);
        //    }

        //private void ensureExplicitCapacity(int minCapacity) {
        //        modCount++;
        //
        //        // overflow-conscious code
        //        if (minCapacity - elementData.length > 0)
        //            grow(minCapacity);
        //    }

        //private void grow(int minCapacity) {
        //        // overflow-conscious code
        //        int oldCapacity = elementData.length;
        //        int newCapacity = oldCapacity + (oldCapacity >> 1);
        //        if (newCapacity - minCapacity < 0)
        //            newCapacity = minCapacity;
        //        if (newCapacity - MAX_ARRAY_SIZE > 0)
        //            newCapacity = hugeCapacity(minCapacity);
        //        // minCapacity is usually close to size, so this is a win:
        //        elementData = Arrays.copyOf(elementData, newCapacity);
        //    }
        //
        //    private static int hugeCapacity(int minCapacity) {
        //        if (minCapacity < 0) // overflow
        //            throw new OutOfMemoryError();
        //        return (minCapacity > MAX_ARRAY_SIZE) ?
        //            Integer.MAX_VALUE :
        //            MAX_ARRAY_SIZE;
        //    }
    }
}

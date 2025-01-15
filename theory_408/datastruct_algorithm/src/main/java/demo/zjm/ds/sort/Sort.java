package demo.zjm.ds.sort;

import demo.zjm.ds.util.BasicUtil;

/**
 * @program: demo_techIntegrate
 * @ClassName: Sort
 * @description:
 * @author: AlanMa
 * @create: 2024-04-04 02:11
 */
public class Sort {


    //插排（稳定）
    static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i], j = i;
            for (; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    //二分插排nlogn，准确说应该叫二分查找插入排序(稳定)
    public static void bInsertSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int temp = arr[i], insertLoc = 0;
            int low = 0, high = i - 1, mid;
            //在已排序的范围查找插入位置
            while (low <= high) {
                mid = (low + high) / 2;
                if (temp <= arr[mid]) {
                    high = mid - 1;
                } else if (temp > arr[mid]) {
                    low = mid + 1;
                }
            }
            insertLoc = low;
            for (int j = i; j > insertLoc; j--) {
                arr[j] = arr[j - 1];
            }
            arr[insertLoc] = temp;
        }
    }


    // 希尔排序(不稳定)
    public static void shellSort(int[] arr) {
        for (int mid = arr.length / 2; mid > 0; mid /= 2) {// 若干趟扫描控制增量，增量减半
            for (int i = mid; i < arr.length; i++) {// 一趟分若干组，每组进行直接插入排序
                int temp = arr[i], j;
                // 每组元素相距delta远，寻找插入位置
                for (j = i - mid; j >= 0 && temp < arr[j]; j -= mid)
                    arr[j + mid] = arr[j];
                arr[j + mid] = temp;// 插入元素
            }
        }
    }

    //冒泡排序法(稳定)
    static void bubbleSort(int[] arr) {
        boolean flag = true; //还需继续排序
        for (int i = 0; i < arr.length - 1 && flag; i++) {
            flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    BasicUtil.swap(arr, j, j - 1);
                    flag = true;
                }
            }
        }
    }

    //快速排序(不稳定)
    public static void quickSort(int[] table) {
        quickSort(table, 0, table.length - 1);
    }

    static void quickSort(int[] arr, int l, int h) {
        int povit = arr[l], i = l, j = h;
        while (i < j) {
            while (i < j && arr[j] > povit) {
                j--;
            }
            while (i < j && arr[i] < povit) {
                i++;
            }
            if (i < j && arr[i] == arr[j]) {
                i++;
            } else {
                BasicUtil.swap(arr, i, j);
            }
        }
        if (i - 1 > l) quickSort(arr, l, i - 1);
        if (j + 1 < h) quickSort(arr, j + 1, h);
    }

    // 选择排序-------------直接选择排序(不稳定)
    public static void selectSort(int[] arr){
        int min;
        for(int i = 0; i < arr.length-1; i++ ){
            min = i;
            for(int j = i+1; j < arr.length; j++){
                if (arr[min] > arr[j])
                    min = j;
            }
            BasicUtil.swap(arr, min, i);
        }
    }

    // 选择排序-------------------堆排序(不稳定)
    public static void heapSort(int[] table) {
        int n = table.length;
        // 创建最小堆
        for (int j = n / 2 - 1; j >= 0; j--)
            sift(table, j, n - 1);
        for (int j = n - 1; j > 0; j--) {// 每趟将最小堆交换到后面，再调整成堆
            int temp = table[0];
            table[0] = table[j];
            table[j] = temp;
            sift(table, 0, j - 1);
        }
    }

    // 将以begin为跟的子树调整成最小堆，begin，end是序列下界和上界
    private static void sift(int[] table, int begin, int end) {
        int i = begin, j = 2 * i + 1;// i为子树的跟，j为i结点的跟
        int temp = table[i];// 获得第i个元素的值

        while (j <= end) {// 沿较小值孩子结点向下筛选
            if (j < end && table[j] < table[j + 1])// 数组元素比较
                j++;
            if (temp > table[j]) {// 若父母结点较大
                table[i] = table[j];// 孩子结点中的较小值上移
                i = j;// i，j向下一层
                j = 2 * i + 1;
            } else
                break;
        }
        table[i] = temp;// 当前子树的原跟值调整后的位置
    }

    // 一次归并
    private static void merge(int[] X, int[] Y, int m, int r, int n) { // 一次归并
        int i = m, j = r, k = m;

        while (i < r && j < r + n && j < X.length)
            // 将X中两个相邻子序列归并到Y中
            if (X[i] < X[j])// 较小值复制到Y中
                Y[k++] = X[i++];
            else
                Y[k++] = X[j++];
        // 将前一个子序列剩余元素复制到Y中
        while (i < r)
            Y[k++] = X[i++];
        while (j < r + n && j < X.length)
            // 将后一个子序列剩余元素复制到Y中
            Y[k++] = X[j++];
    }

    // 一趟归并
    private static void mergepass(int[] X, int[] Y, int n) {
        int i = 0;
        while (i < X.length - 2 * n + 1) {
            merge(X, Y, i, i + n, n);
            i += 2 * n;
        }
        if (i + n < X.length)
            merge(X, Y, i, i + n, n);// 再一次归并
        else
            for (int j = i; j < X.length; j++)
                // 将X剩余元素复制到Y中
                Y[j] = X[j];
    }

    // 归并排序---------------------------------(稳定)
    public static void mergeSort(int[] X) {
        int[] Y = new int[X.length];// Y数组长度同X数组
        int n = 1;// 已排序的子序列长度，初值为1
        while (n < X.length) {
            mergepass(X, Y, n);// 一趟排序，将X数组中各子序列归并到Y中
            n *= 2;// 子序列长度加倍
            if (n < X.length) {
                mergepass(Y, X, n);// 将Y数组个子序列再归并到X中
                n *= 2;
            }
        }
    }
}

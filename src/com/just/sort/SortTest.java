package com.just.sort;

public class SortTest {
    public static void main(String[] args) {
        int[] a = {0, 12, 15, 9, 20, 34, 31, 17, 234, 10, 5};
//        new SortTest().InsertSort(a);

//        new SortTest().ShellSort(a);
//        new SortTest().BubbleSort(a);

//        new SortTest().QuickSort(a, 0, a.length-1);
        new SortTest().SelectSort(a);
        for (int i = 1; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    //直接插入排序 O(n²)
    public void InsertSort(int[] r) {
        if (r == null || r.length < 2) {
            return;
        }
        for (int i = 2; i < r.length; i++) {
            r[0] = r[i]; //0 号位 作为暂存位置
            int j = i - 1;
            for (; r[0] < r[j]; j--) {
                r[j + 1] = r[j];
            }
            r[j + 1] = r[0];
        }
    }

    //希尔排序 O(n1.3)
    public void ShellSort(int[] r) {
        if (r == null || r.length < 2) {
            return;
        }
        for (int d = r.length / 2; d >= 1; d = d / 2) {
            for (int i = d + 1; i < r.length; i++) {
                r[0] = r[i];
                int j = i - d;
                for (; j > 0 && r[0] < r[j]; j = j - d) {
                    r[j + d] = r[j];
                }
                r[j + d] = r[0];
            }
        }
    }

    //冒泡排序O(n²)
    public void BubbleSort(int[] r) {
        int exchange = r.length - 1;
        while (exchange != 0) {
            int bound = exchange;
            exchange = 0;
            int i = 1;
            for (; i < bound; i++) {
                if (r[i] > r[i + 1]) {
                    r[0] = r[i];  // 0 作为交换位。
                    r[i] = r[i + 1];
                    r[i + 1] = r[0];
                    exchange = i;
                }
            }
        }
    }

    //快速排序O(nlog₂n)
    public int Partition(int[] r, int first, int end) {
        int i = first;
        int j = end;
        while (i < j) {

            //右侧小的换到左侧
            while (i < j && r[i] <= r[j])
                j--;
            if (i < j) {
                int temp = r[i];
                r[i] = r[j];
                r[j] = temp;
                i++;
            }
            //左侧大的换到右侧
            while (i < j && r[i] <= r[j])
                i++;
            if (i < j) {
                int temp = r[i];
                r[i] = r[j];
                r[j] = temp;
                j--;
            }
        }
        return i;
    }

    public void QuickSort(int[] r, int first, int end) {
        if (first < end) {
            int pivot = Partition(r, first, end);
            QuickSort(r, first, pivot - 1);
            QuickSort(r, pivot + 1, end);
        }
    }


    //选择排序O(n²)
    public void SelectSort(int[] r) {
        for (int i = 1; i < r.length ; i++) {
            int index = i;
            for (int j = i + 1; j <= r.length - 1; j++) {
                if (r[j] < r[index]) {
                    index = j;
                }
            }
            if (index != i) {
                r[0] = r[index];
                r[index] = r[i];
                r[i] = r[0];
            }
        }
    }

}

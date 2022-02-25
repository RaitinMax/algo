import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr1[] = {45, 31, 24, 22, 102, 101, 14, 13, 9, 10};
        int arr2[] = {31, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        int arr3[] = {51, 30, 10, 9, 8, 7, 6, 5, 2, 1};
        printArray(arr1);
        Main ob = new Main();
        ob.SortUnsorted(arr1, 0, arr1.length - 1);
        printArray(arr1);
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private int[] SortUnsorted(int[] a, int lo, int hi) {

        if (hi == lo)
            return a;
        int mid = lo + (hi - lo) / 2;
        SortUnsorted(a, lo, mid);
        SortUnsorted(a, mid + 1, hi);

        int[] buf = Arrays.copyOf(a, a.length);

        for (int k = lo; k <= hi; k++)
            buf[k] = a[k];

        int i = lo, j = mid + 1;
        while (i < 5 && j < 5) {
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = buf[j];
                    j++;
                } else if (j > hi) {
                    a[k] = buf[i];
                    i++;
                } else if (buf[j] < buf[i]) {
                    a[k] = buf[j];
                    j++;
                } else {
                    a[k] = buf[i];
                    i++;
                }
            }
        }
        return buf;
    }
}

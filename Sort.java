import java.util.Arrays;

public class Sort {
    private int[] arr;

    public Sort(int[] arr) {
        this.arr = arr;
    }

    public int[] quick() {
        return quick(this.arr);
    }

    public int[] selection() {
        return selection(this.arr);
    }

    public int[] insertion() {
        return insertion(this.arr);
    }

    public static int[] quick(int[] arr) {
        if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                int[] ret = { arr[1], arr[0] };
                return ret;
            } else
                return arr;
        } else if (arr.length < 2)
            return arr;
        int pivot = arr[0];
        int[] arr1 = {};
        int[] arr2 = {};
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < pivot) {
                arr1 = Arrays.copyOf(arr1, arr1.length + 1);
                arr1[arr1.length - 1] = arr[i];
            } else if (arr[i] >= pivot) { // Hoping for stable
                arr2 = Arrays.copyOf(arr2, arr2.length + 1);
                arr2[arr2.length - 1] = arr[i];
            }
        }
        int[] sorted1 = quick(arr1);
        int[] sorted2 = quick(arr2);
        for (int i = 0; i < sorted1.length; i++) {
            arr[i] = sorted1[i];
        }
        arr[sorted1.length] = pivot;
        for (int i = 0; i < sorted2.length; i++) {
            arr[sorted1.length + i + 1] = sorted2[i];
        }
        return arr;
    }

    public static int[] selection(int[] arr) {
        int breakPoint = 0;
        while (breakPoint < arr.length) {
            swap(arr, smallestIndex(arr, breakPoint), breakPoint);
            breakPoint++;
        }
        return arr;
    }

    public static int[] insertion(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int index = i;
            while (index > 0 && current < arr[index - 1]) {
                arr[index] = arr[index - 1];
                index--;
            }
        }
        return arr;
    }

    private static int smallestIndex(int[] arr, int startIndex) {
        int smallest = startIndex;
        for (int i = startIndex + 1; i < arr.length; i++) {
            if (arr[i] < arr[smallest])
                smallest = i;
        }
        return smallest;
    }

    private static int smallestIndex(int[] arr) {
        int smallest = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[smallest])
                smallest = i;
        }
        return smallest;
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}

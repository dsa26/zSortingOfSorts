import java.util.Arrays;

public class Sort {
    private int[] arr;

    public Sort(int[] arr) {
        this.arr = arr;
    }

    public int[] quick() {
        return quick(this.arr);
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
}

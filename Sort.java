import java.util.Arrays;

public class Sort {
    private int[] arr;

    public Sort(int[] arr) {
        this.arr = arr;
    }

    public int[] quick() {
        return quick(this.arr);
    }

    public int[] inPlaceQuick() {
        return inPlaceQuick(this.arr);
    }

    public int[] selection() {
        return selection(this.arr);
    }

    public int[] insertion() {
        return insertion(this.arr);
    }

    public int[] merge() {
        return merge(this.arr);
    }

    public int[] merge(int[] arr) {
        if (arr.length < 2)
            return arr;
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        merge(left);
        merge(right);
        merge(arr, left, right);
        return arr;
    }

    public int[] merge(int[] arr, int[] left, int[] right) {
        int a = 0;
        int b = 0;
        int c = 0;

        while (a < left.length && b < right.length) {
            if (left[a] <= right[b]) {
                arr[c] = left[a];
                c++;
                a++;
            } else {
                arr[c] = right[b];
                c++;
                b++;
            }
        }

        while (a < left.length) {
            arr[c] = left[a];
            c++;
            a++;
        }

        while (b < right.length) {
            arr[c] = right[b];
            c++;
            b++;
        }

        return arr;
    }

    public static int[] inPlaceQuick(int[] arr) {
        return inPlaceQuick(arr, 0, arr.length);
    }

    public static int[] inPlaceQuick(int[] arr, int start, int end) {
        if ((end - start) == 2) {
            if (arr[start + 0] > arr[start + 1]) {
                swap(arr, start + 0, start + 1);
                return arr;
            } else
                return arr;
        } else if ((end - start) < 2)
            return arr;

        int pivot = arr[start + 0];
        int pivotIndex = start + 0;
        for (int i = start + 1; i < end; i++) {
            if (arr[i] < pivot) {
                moveToStart(arr, i, start);
                pivotIndex++;
            }
        }
        inPlaceQuick(arr, 0, pivotIndex);
        inPlaceQuick(arr, pivotIndex + 1, arr.length);
        return arr;
    }

    private static void moveToStart(int[] arr, int index, int start) {
        int temp = arr[index];
        for (int i = index; i > start + 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start + 0] = temp;
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

public class Main {
    public static void main(String[] args) {
        int[] array = { 2, 5, 1, 9, 0, 3, 5, 6, 7 };
        Sort sorter = new Sort(array);
        int[] sorted = sorter.quick();
        for (int num : sorted) {
            System.out.println(num);
        }
    }
}
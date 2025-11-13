public class Main {
    public static void main(String[] args) {
        int[] array = { 2, 5, 1, 9, 0, 3, 5, 6, 7 };
        Sort sorter = new Sort(array);
        int[] sorted = sorter.inPlaceQuick();
        for (int num : sorted) {
            System.out.println(num);
        }

        // String[] names = { "CAT", "BAT", "HAT", "LIGHT", "NIGHT", "DOG", "HOUSE",
        // "APPLE", "MAT", "RAT", "RIGHT",
        // "BELL", "MOUNTAIN", "RIVER", "LOG", "SIGHT", "CELL", "WELL", "FOG", "BOOK" };
        // Rhymer.sort(names);
        // for (String name : names) {
        // System.out.println(name);
        // }
    }
}
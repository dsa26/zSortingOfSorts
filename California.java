public class California {
    public static String[] sort(String[] names) {
        int breakPoint = 0;
        while (breakPoint < names.length) {
            int first = breakPoint;
            for (int i = breakPoint + 1; i < names.length; i++) {
                first = compare(names, first, i);
            }
            String temp = names[breakPoint];
            names[breakPoint] = names[first];
            names[first] = temp;
            breakPoint++;
        }
        return names;
    }

    // Returns index of "higher" or "first" element
    private static int compare(String[] arr, int index1, int index2) {
        // char[] order = { 'R', 'W', 'Q', 'O', 'J', 'M', 'V', 'A', 'H', 'B', 'S', 'G',
        // 'Z', 'X', 'N', 'T', 'C', 'I', 'E',
        // 'K', 'U', 'P', 'D', 'Y', 'F', 'L' };

        // Represents the (reverse) importance of each letter
        int[] order = { 7, 9, 16, 22, 18, 24, 11, 8, 17, 4, 19, 25, 5, 14, 3, 21, 2, 0, 10, 15, 20, 6, 1, 13, 23, 12 };

        String name1 = arr[index1];
        String name2 = arr[index2];
        int smallerLength = name1.length();
        if (name2.length() < smallerLength)
            smallerLength = name2.length();
        for (int i = 0; i < smallerLength; i++) {
            int order1 = order[name1.charAt(i) - 65]; // Assuming uppercase only
            int order2 = order[name2.charAt(i) - 65];
            if (order1 != order2) {
                if (order1 > order2) {
                    return index2; // Reverse because the order of "importance" is reverse
                } else {
                    return index1;
                }
            }
        }
        if (name1.length() > name2.length())
            return index2; // So that "JOHNS" would come before "JOHNSON" -- Arbitrary choice
        return index1;
    }
}

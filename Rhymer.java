public class Rhymer {
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
        String name1 = arr[index1];
        String name2 = arr[index2];
        int smallerLength = name1.length();
        int biggerLength = name2.length();
        if (name2.length() < smallerLength) {
            smallerLength = name2.length();
            biggerLength = name1.length();
        }
        for (int i = biggerLength; i > biggerLength - smallerLength; i--) {
            int order1 = name1.charAt(i - 1); // Assuming uppercase only
            int order2 = name2.charAt(i - 1);
            if (order1 != order2) {
                if (order1 > order2) {
                    return index2;
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

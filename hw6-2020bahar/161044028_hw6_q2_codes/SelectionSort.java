/**
 * Implements the selection sort algorithm.
 */
public class SelectionSort {
    /** Sort the array using selection sort algorithm.
     @param table The array to be sorted
     */
    public static void sort(Comparable[] table) {
        int n = table.length;
        int fill;
        for (fill = 0; fill < n-1 ; fill++) {
            int posMin = fill;
            for (int next = fill + 1; next < n; next++) {
                if (table[next].compareTo(table[posMin]) < 0) {
                    posMin = next;
                }
            }

            Comparable temp = table[fill];
            table[fill] = table[posMin];
            table[posMin] = temp;

        }

    }
}

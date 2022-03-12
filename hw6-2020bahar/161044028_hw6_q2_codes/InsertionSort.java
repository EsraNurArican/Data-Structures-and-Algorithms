public class InsertionSort {
    /** Sort the table using insertion sort algorithm.
     * @param table The array to be sorted
     */
    public static <T extends Comparable<T>> void sort(T[] table) {
        for (int nextPos = 1; nextPos < table.length; nextPos++) {

            insert(table, nextPos);
        } // End for.
    } // End sort.
    /** Insert the element at nextPos where it belongs
     in the array.
     @param table The array being sorted
     @param nextPos The position of the element to insert
     */
    private static <T extends Comparable<T>> void insert(T[] table,
                                                         int nextPos) {
        T nextVal = table[nextPos];

        while (nextPos > 0 && nextVal.compareTo(table
                [nextPos - 1]) < 0) {
            table[nextPos] = table[nextPos - 1];

            nextPos--;

        }

        table[nextPos] = nextVal;
    }
}

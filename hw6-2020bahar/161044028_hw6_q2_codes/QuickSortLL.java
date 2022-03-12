import java.util.LinkedList;

/**
 * Implements quick sort for linkedList.
 */
public class QuickSortLL {

        /** Sort the table using the quicksort algorithm.
         pre: table contains Comparable objects.
         post: table is sorted.
         @param table The array to be sorted
         */
        public static < T
                extends Comparable < T >> void sort(LinkedList<Comparable> table) {
            // Sort the whole table.
            quickSort(table, 0, table.size() - 1);
        }

        /** Sort a part of the table using the quicksort algorithm.
         post: The part of table from first through last is sorted.
         * @param table The array to be sorted
         * @param first The index of the low bound
         * @param last The index of the high bound
         */
        private static < T
                extends Comparable < T >> void quickSort(LinkedList<Comparable> table,
                                                         int first,
                                                         int last) {
            if (first < last) { // There is data to be sorted.
                // Partition the table.
                int pivIndex = partition(table, first, last);
                // Sort the left half.
                quickSort(table, first, pivIndex - 1);
                // Sort the right half.
                quickSort(table, pivIndex + 1, last);
            }
        }

        /** Partition the table so that values from first to pivIndex
         are less than or equal to the pivot value, and values from
         pivIndex to last are greater than the pivot value.
         @return The location of the pivot value
          * @param table The table to be partitioned
         * @param first The index of the low bound
         * @param last  The index of the high bound
         */
        private static < T
                extends Comparable < T >> int partition(LinkedList<Comparable> table,
                                                        int first,
                                                        int last) {
            // Select the first item as the pivot value.
            int pivot = (int) table.get(first);
            int up = first;
            int down = last;
            do {
         /* Invariant:
         All items in table[first . . . up - 1] <= pivot
         All items in table[down + 1 . . . last] > pivot
         */
                while ( (up < last) && (pivot >= (int)table.get(up))) {
                    up++;
                }
                // assert: up equals last or table[up] > pivot.
                while (pivot < (int)table.get(down)) {
                    down--;
                }
                // assert: down equals first or table[down] <= pivot.
                if (up < down) { // if up is to the left of down.
                    // Exchange table[up] and table[down].
                    swap(table, up, down);
                }
            }
            while (up < down); // Repeat while up is left of down.

            // Exchange table[first] and table[down] thus putting the
            // pivot value where it belongs.
            swap(table, first, down);

            // Return the index of the pivot value.
            return down;
        }

        /** Swap the items in table[i] and table[j].
         * @param table The array that contains the items
         * @param i The index of one item
         * @param j The index of the other item
         */
        private static < T
                extends Comparable < T >> void swap(LinkedList<Comparable> table,
                                                    int i, int j) {
            T temp = (T) table.get(i);
            table.set(i,table.get(j)) ;
            table.set(j,temp);
        }

        public static void main(String[] args) {
            //LinkedList<Comparable> ll= new LinkedList<>();
           LinkedList<Comparable> ll= CreateArrays.createRandomLL(15);


            ll.toString();

            sort(ll);
            ll.toString();
        }
    }


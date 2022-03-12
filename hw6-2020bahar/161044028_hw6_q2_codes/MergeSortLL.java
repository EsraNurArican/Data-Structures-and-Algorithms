
import java.util.LinkedList;

/**
 * Implements merge sort for linkedList.
 */
public class MergeSortLL {


    /**
     * Recursive sort method uses every part to sort given linked list for merge sort
     * @param list linked list
     * @return sorted linked list
     */
    public static LinkedList<Comparable> sort(LinkedList<Comparable> list) {
            if (list.size() == 1) {
                return list;
            }
            else {
                // dividing list in two parts,left and right
                LinkedList<Comparable> left = new LinkedList<>();
                LinkedList<Comparable> right = new LinkedList<>();
                for(int i=0; i<list.size()/2;i++)
                    left.add(list.get(i));

                for(int j=list.size()/2; j<list.size();j++)
                    right.add(list.get(j));

                //sorting left side and right side recursively
                left = sort(left);
                right = sort(right);

                // merge sorted parts
                merge(left, right, list);
                return list;

            }
        }

    /**
     * Merge method to merge divided parts
     * @param left left side linked list
     * @param right right side linked list
     * @param result merged list
     */
        private static void merge(LinkedList<Comparable> left, LinkedList<Comparable> right, LinkedList<Comparable> result) {
            int x = 0 , y = 0, z = 0,remIndex;
            LinkedList<Comparable> remaining;
            // iki dizide de eleman varken
            while (x < left.size() && y < right.size()) {
                if ((int)left.get(x) < (int)right.get(y)){
                    result.set(z,left.get(x));
                    x++;
                }
                else {
                    result.set(z,right.get(y));
                    y++;
                }
                z++;
            }


            if (x >= left.size()) {
                remaining = right;
                remIndex = y;
            }
            else {
                remaining = left;
                remIndex = x;
            }

            for (int i= remIndex; i<remaining.size(); i++) {
                result.set(z,remaining.get(i));
                z++;
            }
        }
    }








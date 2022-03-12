import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class includes methods to create random, sorted arrays and linked lists.
 * This class will be used for testing phase.
 */
public class CreateArrays {

    /**
     * Creates one random array with given size
     * @param size size parameter
     * @return random array
     */
    public static Integer[] createRandomArr(int size){
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            array[i]= ThreadLocalRandom.current().nextInt(0, size);
        }
        return array;
    }

    /**
     * Creates sorted array
     * @param size size parameter
     * @return sorted array
     */
    public static Integer[] createSortedArr(int size){
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            array[i]=i;
        }
        return array;
    }

    /**
     * Creates  20 random array for testing
     * @param size size parameter
     * @return 2D array
     */
    public static Integer[][] create20random(int size){
        Integer[][] arrays20 = new Integer[20][];
        for(int i=0; i<20;i++){
            Integer[] array = createRandomArr(size);
            arrays20[i]= array;
        }
        return arrays20;
    }

    /**
     * Creates random linked list with given size
     * @param size size of the linked list
     * @return random linked list
     */
    public static LinkedList<Comparable> createRandomLL(int size) {
        LinkedList<Comparable> ll = new LinkedList<>();
        for (int i = 0; i < size; i++)
            ll.add(ThreadLocalRandom.current().nextInt(0, size));
        return ll;
    }

    /**
     * Creates sorted linked list with given size
     * @param size size parameter
     * @return sorted linked list
     */
    public static LinkedList<Comparable> createSortedLL(int size){
        LinkedList<Comparable> ll = new LinkedList<>();
        for (int i = 0; i < size; i++)
            ll.add(i);
        return ll;
    }

    /**
     * Creates a copy of given 2D array
     * This method written to keep original random arrays kept in a 2D array
     * Because every sorting algorithm should use same random arrays.
     * @param size size of array
     * @param arr array to be copied
     * @return temp 2d array
     */
    public static Integer[][] createCopyTemp(int size,Integer[][] arr){
        Integer[][] arraysTemp ;
        arraysTemp = CreateArrays.create20random(size); // temp array to keep random created arrays
        for(int i=0; i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arraysTemp[i][j] = arr[i][j];
            }
        }
        return arraysTemp;
    }

    /**
     * Creates a copy of given array.
     * Copy will be used for sorting other algorithms after a sorting is done.
     * Because every sorting algorithm should use same random arrays.
     * @param size size of  array
     * @param arr  array to be copied
     * @return temp array
     */
    public static Integer[] createCopyTemp(int size,Integer[] arr){
        Integer[] arrTemp;
        arrTemp = CreateArrays.createSortedArr(size);
        for (int i = 0; i < arr.length; i++) {
            arrTemp[i] = arr[i];
        }
        return arrTemp;
    }

    /**
     * Prints the given array to the screen
     * @param arr - array to be printed
     */
    public static void printArray(Integer[] arr){
        for (int i=0; i<arr.length;i++){
            System.out.print(arr[i]+",  ");
        }
    }
}

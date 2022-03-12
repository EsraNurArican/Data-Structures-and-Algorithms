/**
 * Main class written for testing methods.
 * It includes static void method to run the program
 */
public class Main {
    /**
     *Static void main method tests linkedArrayList's methods
     * @param args String parameter
     */
    public static void main(String [] args){

        Integer[] arr1 = new Integer[]{1,2,3,4,5};
        Integer []arr2 =new Integer[]{6,7,null,null,null};
        Integer[]arr3 =new Integer[]{9,0,8,null,null};
        Integer[] arr4 = new Integer[]{11,12,13,14,15};
        Integer []arr5 =new Integer[]{1,7,null,5,null};
        Integer[]arr6 =new Integer[]{0,10,null,2,17};
        Integer[] arr7 = new Integer[]{1,6,8,4,5};
        LinkedArrayList<Integer> myList =new LinkedArrayList<Integer>();
        myList.add(arr1);
        myList.add(arr2);
        myList.add(arr3);
        System.out.println("Testing add method...");
        System.out.println(myList.toString());
        myList.add(2,arr4);
        System.out.println("Testing add method with index 2...");
        System.out.println(myList.toString());
        myList.add(3,arr5);
        System.out.println("Testing add method with index 3...");
        System.out.println(myList.toString());
        myList.add(4,arr6);
        System.out.println("Testing add method with index 4...");
        System.out.println(myList.toString());
        myList.add(5,arr7);
        System.out.println("Testing add method with index 5...");
        System.out.println(myList.toString());




    }
}

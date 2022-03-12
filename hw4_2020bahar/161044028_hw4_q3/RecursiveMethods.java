
/**
 * RecursiveMethods class includes the solutions of recursive methods and main method to test them
 */
public class RecursiveMethods {

    /**
     * Reversing a string
     * @param input String to be reversed
     * @return reversed String
     */
    public static String reverseString(String input) {

        //base case
        if (input.equals(""))
            return "";

        else{
            int index = input.length() - 1;
            while (!Character.isWhitespace(input.charAt(index))){
                if (index - 1 < 0)
                    break;
                index--;
            }
            String smallStr;
            if(Character.isWhitespace(input.charAt(index)))
                smallStr= input.substring(index+1)+" ";
            else
                smallStr= input.substring(index);

            //recursive call
            return smallStr + reverseString(input.substring(0,index));
        }
    }

    /**
     * Determining whether a word is elfish or not. A word is considered elfish if it contains
     * the letters: e, l, and f in it, in any order
     * @param input the word that will be controlled whether elfish or not
     * @param control e,l,f letters for this problem,but user can change it to control other situations
     * @param count counter that gives the number of letters which same as in control string
     * @return number of count + this method recursively
     */
    public static int IsWordElfish(String input, String control, int count) {

        //base case
        if(control.length() < 1)
            return 0;

        if(input.contains(control.substring(0, 1))){
            count = 1;
        }
        //recursive call
        return count + IsWordElfish(input, control.substring(1, control.length()), 0);
    }

    /**
     * Sorting an array of elements using selection sort algorithm.
     * @param array array of elements that will be sorted
     * @param startIndex starting index for sorting,it increases every recursive call
     */
    public static void selectionSort(int[] array, int startIndex)  {

        //base case
        if ( startIndex >= array.length - 1 )
            return;
        int minIndex = startIndex;
        for ( int index = startIndex + 1; index < array.length; index++ ) {
            if (array[index] < array[minIndex] )
                minIndex = index;
        }
        int temp = array[startIndex];
        array[startIndex] = array[minIndex];
        array[minIndex] = temp;
        //recursive call
        selectionSort(array, startIndex + 1);
    }

    /**
     * Prints the given 1D array to the screen
     * @param array array to be print
     */
    public static void print1DArray(int [] array){
        for(int i=0; i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.print("\n");
    }

    /**
     * Prints the given array to the screen
     * @param array array to be print
     */
    public static void print2DArray(int [][] array){
        for(int i=0; i<array.length;i++) {
            for (int j = 0; j < array[0].length; j++)
                System.out.print(array[i][j ] + " ");
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    /**
     * Prints the given matrix(2D array) in spiral form to the screen
     * @param matrix array that will be printed
     * @param rowStart row start index
     * @param colStart column start index
     * @param rowSize row size of the matrix
     * @param colSize column size of the matrix
     */
    public static void printMatrix(int[][] matrix, int rowStart, int colStart,int rowSize,int colSize){

            //printing the top  row left to right
            for (int i = rowStart; i <= colSize; i++) {
                System.out.print(matrix[rowStart][i] + " ");
            }
            //printing the right column up to down
            for (int i = rowStart+1; i <= rowSize; i++) {
                System.out.print(matrix[i][colSize] + " ");
            }

            //right to left
            if(rowStart+1 <= rowSize){
                for (int i = colSize-1; i >= colStart; i--) {
                    System.out.print(matrix[rowSize][i] + " ");
                }
            }

            //bottom to up
            if(colStart+1 <= colSize){
                for (int i = rowSize-1; i > rowStart; i--) {
                    System.out.print(matrix[i][colStart] + " ");
                }
            }

            //recursive call
            if(rowStart+1 <= rowSize-1 && colStart+1 <= colSize-1){
                printMatrix(matrix, rowStart+1, colStart+1, rowSize-1,colSize-1 );
            }
        }

    /**
     * main method tests all recursive methods inside
     * @param args String parameter
     */
    public static void main(String[] args) {

        System.out.println("---REVERSING STRING TEST---");
        String inputString= "this function writes the sentence in reverse";
        String inputString2= "Data Structures and Algorithms Lecture";
        String inputString3= "Making homework in quarantine";
        String outputString = reverseString(inputString);
        System.out.println("Input String : "+inputString);
        System.out.println("Output String : "+outputString);
        outputString = reverseString(inputString2);
        System.out.println("Input String : "+inputString2);
        System.out.println("Output String : "+outputString);
        outputString = reverseString(inputString3);
        System.out.println("Input String : "+inputString3);
        System.out.println("Output String : "+outputString);


        System.out.println("\n---CHECKING ELFISH WORD TEST---");
        String input = "waffle";
        String input2= "unfriendly";
        String input3= "another";
        String control = "elf"; //elfish word has to have e,l,f characters

        int count =IsWordElfish(input, control, 0);
        int count2 =IsWordElfish(input2,control,0);
        int count3 =IsWordElfish(input3,control,0);
        if(control.length()== count)
            System.out.println(input+" is elfish.");
        else
            System.out.println(input+" is not elfish!");

        if(control.length()== count2)
            System.out.println(input2+" is elfish.");
        else
            System.out.println(input2+" is not elfish!");

        if(control.length()== count3)
            System.out.println(input3+" is elfish.");
        else
            System.out.println(input3+" is not elfish!");

        System.out.println("\n---SELECTION SORT TEST---");
        int arr[] = {3, 1, 5, -2, 7, 0};
        int arr2[]= {5,1,11,15,3,9,20,33,12,21,2};

        System.out.println("Printing array1 before selection sort:");
        print1DArray(arr);
        selectionSort(arr, 0);
        System.out.println("Printing array1 after selection sort:");
        print1DArray(arr);

        System.out.println("Printing array2 before selection sort:");
        print1DArray(arr2);
        selectionSort(arr2, 0);
        System.out.println("Printing array2 after selection sort:");
        print1DArray(arr2);


        System.out.println("\n---PRINTING MATRIX SPIRAL FORM TEST---");
        int[][] matrix = {
                {1,4,7,10},
                {2,5,8,11},
                {3,6,9,10},
                {16,15,13,7}};

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15 ,16},
                {17, 18, 19 ,20}};

        System.out.println("\nTesting with 4*4 matrix");
        System.out.println("Printing matrix:");
        print2DArray(matrix);
        System.out.println("Printing matrix spiral form:");
        printMatrix(matrix,0,0,matrix.length-1,matrix[0].length-1);

        System.out.println("\n\nTesting with 5*4 matrix");
        System.out.println("Printing matrix:");
        print2DArray(matrix2);
        System.out.println("Printing matrix spiral form:");
        printMatrix(matrix2,0,0,matrix.length-1,matrix[0].length-1);

    }
}


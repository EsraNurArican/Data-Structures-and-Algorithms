import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

public class TestSortingMethods {
    public static void testSort(Integer[][] random20,Integer[] sorted,String sortType) throws IOException {

        Instant start, finish;
        long timeElapsed;

        //Buble Sort Testing
        if (sortType == "bubble") {
            FileWriter fileWriter = new FileWriter("BubbleRunTime.txt");
            fileWriter.write("Bubble Sort Run times for 20 random arrays with size of:" + random20[0].length + "\n");
            System.out.println("Bubble sort run times for 20 random arrays with size of:"+ random20[0].length);
            for (int i = 0; i < 20; i++) {
                start = Instant.now();
                BubbleSort.sort(random20[i]);
                finish = Instant.now();
                timeElapsed = Duration.between(start, finish).toMillis();
                fileWriter.write(timeElapsed + "ms ");
                System.out.println("random array "+ i+": "+timeElapsed +"ms");

            }

            fileWriter.write("\nBubble Sort Run times for sorted array with size of:" + random20[0].length + " \n");
            System.out.println("Bubble sort run times for sorted array with size of:"+ random20[0].length);
            start = Instant.now();
            BubbleSort.sort(sorted);
            finish = Instant.now();
            timeElapsed = Duration.between(start, finish).toMillis();
            fileWriter.write(timeElapsed + "ms ");
            System.out.print("sorted array time: "+ timeElapsed +"ms ,");
            System.out.println("Bubble sort testing finished for size: " + random20[0].length);
            fileWriter.close();
        }

        //Heap Sort Testing
        if (sortType == "heap") {
            FileWriter fileWriter = new FileWriter("HeapRunTime.txt");
            fileWriter.write("Heap Sort Run times for random arrays (" + random20[0].length + "element) : \n");
            System.out.println("Heap sort run times for 20 random arrays with size of:"+ random20[0].length);
            for (int i = 0; i < 20; i++) {
                start = Instant.now();
                HeapSort.sort(random20[i]);
                finish = Instant.now();
                timeElapsed = Duration.between(start, finish).toMillis();
                fileWriter.write(timeElapsed + "ms ");
                System.out.println("random array "+ i+": "+timeElapsed +"ms");

            }

            fileWriter.write("\nHeap Sort Run time for sorted array with size of:" + random20[0].length + "\n");
            System.out.println("Heap sort run times for sorted array with size of:"+ random20[0].length+"\n");
            start = Instant.now();
            HeapSort.sort(sorted);
            finish = Instant.now();
            timeElapsed = Duration.between(start, finish).toMillis();
            fileWriter.write(timeElapsed + "ms ");
            System.out.print("sorted array time: "+ timeElapsed +"ms ,");
            System.out.println("Heap sort testing finished for size:" + random20[0].length);
            fileWriter.close();
        }

        //Selection Sort Testing
        if (sortType == "selection") {
            FileWriter fileWriter = new FileWriter("SelectionSortRunTime.txt");
            fileWriter.write("Selection Sort Run times for random arrays (" + random20[0].length + "element) : \n");
            System.out.println("Selection sort run times for 20 random arrays with size of:"+ random20[0].length);
            for (int i = 0; i < 20; i++) {
                start = Instant.now();
                SelectionSort.sort(random20[i]);
                finish = Instant.now();
                timeElapsed = Duration.between(start, finish).toMillis();
                fileWriter.write(timeElapsed + "ms ");
                System.out.println("random array "+ i+": "+timeElapsed +"ms");

            }

            fileWriter.write("\nSelection Sort Run time for one  sorted array at size (" + random20[0].length + ": \n");
            start = Instant.now();
            SelectionSort.sort(sorted);
            finish = Instant.now();
            timeElapsed = Duration.between(start, finish).toMillis();
            fileWriter.write(timeElapsed + "ms ");
            System.out.print("sorted array time: "+ timeElapsed +"ms ,");
            System.out.println("Selection sort testing finished for size: " + random20[0].length);
            fileWriter.close();
        }
        //Insertion Sort Testing
        if (sortType == "insertion") {
            FileWriter fileWriter = new FileWriter("InsertionRunTime.txt");
            fileWriter.write("Insertion Sort Run times for random arrays (" + random20[0].length + "element) : \n");
            System.out.println("Insertion sort run times for 20 random arrays with size of:"+ random20[0].length);
            for (int i = 0; i < 20; i++) {
                start = Instant.now();
                InsertionSort.sort(random20[i]);
                finish = Instant.now();
                timeElapsed = Duration.between(start, finish).toMillis();
                fileWriter.write(timeElapsed + "ms ");
                System.out.println("random array "+ i+": "+timeElapsed +"ms");
            }

            fileWriter.write("\nInsertion Sort Run times for sorted array (" + random20[0].length + " element): \n");
            start = Instant.now();
            InsertionSort.sort(sorted);
            finish = Instant.now();
            timeElapsed = Duration.between(start, finish).toMillis();
            fileWriter.write(timeElapsed + "ms ");
            System.out.print("sorted array time: "+ timeElapsed +"ms ,");
            System.out.println("Insertion sort testing finished for size:" + random20[0].length);
            fileWriter.close();
        }
        //Shell Sort Testing
        if (sortType == "shell") {
            FileWriter fileWriter = new FileWriter("ShellSortRunTime.txt");
            fileWriter.write("Shell Sort Run times for random arrays (" + random20[0].length + "element) : \n");
            System.out.println("Shell sort run times for 20 random arrays with size of:"+ random20[0].length);
            for (int i = 0; i < 20; i++) {
                start = Instant.now();
                ShellSort.sort(random20[i]);
                finish = Instant.now();
                timeElapsed = Duration.between(start, finish).toMillis();
                fileWriter.write(timeElapsed + "ms ");
                System.out.println("random array "+ i+": "+timeElapsed +"ms");
            }

            fileWriter.write("\nShell Sort Run times for sorted array (" + random20[0].length + " element): \n");
            start = Instant.now();
            ShellSort.sort(sorted);
            finish = Instant.now();
            timeElapsed = Duration.between(start, finish).toMillis();
            fileWriter.write(timeElapsed + "ms ");
            System.out.print("sorted array time: "+ timeElapsed +"ms ,");
            System.out.println("Shell sort testing finished for size:" + random20[0].length);
            fileWriter.close();
        }
        //Merge Sort Testing
        if (sortType == "merge") {
            FileWriter fileWriter = new FileWriter("MergeSortRunTime.txt");
            fileWriter.write("Merge Sort Run times for random arrays (" + random20[0].length + "element) : \n");
            System.out.println("Merge sort run times for 20 random arrays with size of:"+ random20[0].length);
            for (int i = 0; i < 20; i++) {
                start = Instant.now();
                MergeSort.sort(random20[i]);
                finish = Instant.now();
                timeElapsed = Duration.between(start, finish).toMillis();
                fileWriter.write(timeElapsed + "ms ");
                System.out.println("random array "+ i+": "+timeElapsed +"ms");
            }

            fileWriter.write("\nMerge Sort Run times for sorted array (" + random20[0].length + " element): \n");
            start = Instant.now();
            MergeSort.sort(sorted);
            finish = Instant.now();
            timeElapsed = Duration.between(start, finish).toMillis();
            fileWriter.write(timeElapsed + "ms ");
            System.out.print("sorted array time: "+ timeElapsed +"ms ,");
            System.out.println("Merge sort testing finished for size:" + random20[0].length);
            fileWriter.close();
        }

        //Quick Sort Testing
        if (sortType == "quick") {
            FileWriter fileWriter = new FileWriter("QuickSortRunTime.txt");
            fileWriter.write("Quick Sort Run times for random arrays (" + random20[0].length + "element) : \n");
            System.out.println("Quick sort run times for 20 random arrays with size of:"+ random20[0].length);
            for (int i = 0; i < 20; i++) {
                start = Instant.now();
                QuickSort.sort(random20[i]);
                finish = Instant.now();
                timeElapsed = Duration.between(start, finish).toMillis();
                fileWriter.write(timeElapsed + "ms ");
                System.out.println("random array "+ i+": "+timeElapsed +"ms");
            }

            fileWriter.write("\nQuick Sort Run times for sorted array (" + random20[0].length + " element): \n");
            start = Instant.now();
            //QuickSort.sort(sorted);
            System.out.println("sortedda yorumda");
            finish = Instant.now();
            timeElapsed = Duration.between(start, finish).toMillis();
            fileWriter.write(timeElapsed + "ms ");
            System.out.print("sorted array time: "+ timeElapsed +"ms ,");
            System.out.println("Quick sort testing finished for size:" + random20[0].length);
            fileWriter.close();
        }


    }

    public static void testSortLL( LinkedList<Comparable> ll, String sortType) throws IOException{
        Instant start, finish;
        long timeElapsed;

        if(sortType=="mergeLL"){
            FileWriter fileWriter = new FileWriter("MergeSortLLRunTime.txt");
            fileWriter.write("Merge Sort with linkedList run times for random array (" + ll.size() + "element) : \n");
            start = Instant.now();
            MergeSortLL.sort(ll);
            finish = Instant.now();
            timeElapsed = Duration.between(start, finish).toMillis();
            fileWriter.write(timeElapsed + "ms ");
            System.out.println("Merge sort for linkedLists run time random array with size of:"+ ll.size()
                                +" is->" +timeElapsed +" ms ");
            fileWriter.close();
        }
        if(sortType=="quickLL"){
            FileWriter fileWriter = new FileWriter("QuickSortLLRunTime.txt");
            fileWriter.write("Quick Sort with linkedList run times for random array (" + ll.size() + "element) : \n");
            start = Instant.now();
            QuickSortLL.sort(ll);
            finish = Instant.now();
            timeElapsed = Duration.between(start, finish).toMillis();
            fileWriter.write(timeElapsed + "ms ");
            System.out.println("Quick sort for linkedLists run time random array with size of:"+ ll.size()
                    +" is->" +timeElapsed +" ms ");
            fileWriter.close();
        }


    }
}

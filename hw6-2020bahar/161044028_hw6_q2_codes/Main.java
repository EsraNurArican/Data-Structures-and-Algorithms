import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class includes main method to test the sort methods.
 */
public class Main {

    /**
     * Main method for test the sorting methods.
     * Creates arrays of 20 random and 1 sorted for each size
     * Creates linked lists 20 random and 1 sorted for each size
     * Creates copies for each array to keep original random values.
     * Calls sorting methods.
     * @param args String
     * @throws IOException throws exception if wrong input entered.
     */
    public static void main(String [] args) throws IOException {

        Integer[][] arrays20Random10k ; // 20 random array for size 10000
        Integer[][] arrays20Random40k ; // 20 random array for size 40000
        Integer[][] arrays20Random100k ; // 20 random array for size 100000
        Integer[][] arrays20Random150k ; // 20 random array for size 150000
        Integer[][] arrays20Random180k ; // 20 random array for size 180000

        Integer[] arrSorted = CreateArrays.createSortedArr(10000);//  sorted array for size 10000
        Integer[] arrSorted2 = CreateArrays.createSortedArr(40000);//  sorted array for size 40000
        Integer[] arrSorted3 = CreateArrays.createSortedArr(100000);//  sorted array for size 100000
        Integer[] arrSorted4 = CreateArrays.createSortedArr(150000);//  sorted array for size 150000
        Integer[] arrSorted5 = CreateArrays.createSortedArr(180000);//  sorted array for size 180000

        arrays20Random10k= CreateArrays.create20random(10000);
        arrays20Random40k= CreateArrays.create20random(40000);
        arrays20Random100k= CreateArrays.create20random(100000);
        arrays20Random150k= CreateArrays.create20random(150000);
        arrays20Random180k= CreateArrays.create20random(180000);

        Integer[][] temp10k = CreateArrays.createCopyTemp(10000,arrays20Random10k);
        Integer[][] temp40k = CreateArrays.createCopyTemp(40000,arrays20Random40k);
        Integer[][] temp100k = CreateArrays.createCopyTemp(100000,arrays20Random100k);
        Integer[][] temp150k = CreateArrays.createCopyTemp(150000,arrays20Random150k);
        Integer[][] temp180k = CreateArrays.createCopyTemp(180000,arrays20Random180k);


        TestSortingMethods.testSort(arrays20Random10k,arrSorted,"heap");
        TestSortingMethods.testSort(arrays20Random40k,arrSorted2,"heap");
        TestSortingMethods.testSort(arrays20Random100k,arrSorted3,"heap");
        TestSortingMethods.testSort(arrays20Random150k,arrSorted4,"heap");
        TestSortingMethods.testSort(arrays20Random180k,arrSorted5,"heap");


        arrays20Random10k= CreateArrays.createCopyTemp(10000,temp10k);
        arrays20Random40k= CreateArrays.createCopyTemp(40000,temp40k);
        arrays20Random100k= CreateArrays.createCopyTemp(100000,temp100k);
        arrays20Random150k= CreateArrays.createCopyTemp(150000,temp150k);
        arrays20Random180k= CreateArrays.createCopyTemp(180000,temp180k);

        TestSortingMethods.testSort(arrays20Random10k,arrSorted,"selection");
        TestSortingMethods.testSort(arrays20Random40k,arrSorted2,"selection");
        TestSortingMethods.testSort(arrays20Random100k,arrSorted3,"selection");
        TestSortingMethods.testSort(arrays20Random150k,arrSorted4,"selection");
        TestSortingMethods.testSort(arrays20Random180k,arrSorted5,"selection");

        arrays20Random10k= CreateArrays.createCopyTemp(10000,temp10k);
        arrays20Random40k= CreateArrays.createCopyTemp(40000,temp40k);
        arrays20Random100k= CreateArrays.createCopyTemp(100000,temp100k);
        arrays20Random150k= CreateArrays.createCopyTemp(150000,temp150k);
        arrays20Random180k= CreateArrays.createCopyTemp(180000,temp180k);

        TestSortingMethods.testSort(arrays20Random10k,arrSorted,"insertion");
        TestSortingMethods.testSort(arrays20Random40k,arrSorted2,"insertion");
        TestSortingMethods.testSort(arrays20Random100k,arrSorted3,"insertion");
        TestSortingMethods.testSort(arrays20Random150k,arrSorted4,"insertion");
        TestSortingMethods.testSort(arrays20Random180k,arrSorted5,"insertion");


        arrays20Random10k= CreateArrays.createCopyTemp(10000,temp10k);
        arrays20Random40k= CreateArrays.createCopyTemp(40000,temp40k);
        arrays20Random100k= CreateArrays.createCopyTemp(100000,temp100k);
        arrays20Random150k= CreateArrays.createCopyTemp(150000,temp150k);
        arrays20Random180k= CreateArrays.createCopyTemp(180000,temp180k);


        TestSortingMethods.testSort(arrays20Random10k,arrSorted,"shell");
        TestSortingMethods.testSort(arrays20Random40k,arrSorted2,"shell");
        TestSortingMethods.testSort(arrays20Random100k,arrSorted3,"shell");
        TestSortingMethods.testSort(arrays20Random150k,arrSorted4,"shell");
        TestSortingMethods.testSort(arrays20Random180k,arrSorted5,"shell");

        arrays20Random10k= CreateArrays.createCopyTemp(10000,temp10k);
        arrays20Random40k= CreateArrays.createCopyTemp(40000,temp40k);
        arrays20Random100k= CreateArrays.createCopyTemp(100000,temp100k);
        arrays20Random150k= CreateArrays.createCopyTemp(150000,temp150k);
        arrays20Random180k= CreateArrays.createCopyTemp(180000,temp180k);


        TestSortingMethods.testSort(arrays20Random10k,arrSorted,"merge");
        TestSortingMethods.testSort(arrays20Random40k,arrSorted2,"merge");
        TestSortingMethods.testSort(arrays20Random100k,arrSorted3,"merge");
        TestSortingMethods.testSort(arrays20Random150k,arrSorted4,"merge");
        TestSortingMethods.testSort(arrays20Random180k,arrSorted5,"merge");

        arrays20Random10k= CreateArrays.createCopyTemp(10000,temp10k);
        arrays20Random40k= CreateArrays.createCopyTemp(40000,temp40k);
        arrays20Random100k= CreateArrays.createCopyTemp(100000,temp100k);
        arrays20Random150k= CreateArrays.createCopyTemp(150000,temp150k);
        arrays20Random180k= CreateArrays.createCopyTemp(180000,temp180k);


        TestSortingMethods.testSort(arrays20Random10k,arrSorted,"quick");
        TestSortingMethods.testSort(arrays20Random40k,arrSorted2,"quick");
       TestSortingMethods.testSort(arrays20Random100k,arrSorted3,"quick");
        TestSortingMethods.testSort(arrays20Random150k,arrSorted4,"quick");
        TestSortingMethods.testSort(arrays20Random180k,arrSorted5,"quick");

         arrays20Random10k= CreateArrays.createCopyTemp(10000,temp10k);
        arrays20Random40k= CreateArrays.createCopyTemp(40000,temp40k);
        arrays20Random100k= CreateArrays.createCopyTemp(100000,temp100k);
        arrays20Random150k= CreateArrays.createCopyTemp(150000,temp150k);
        arrays20Random180k= CreateArrays.createCopyTemp(180000,temp180k);


        TestSortingMethods.testSort(arrays20Random10k,arrSorted,"bubble");
        TestSortingMethods.testSort(arrays20Random40k,arrSorted2,"bubble");
        TestSortingMethods.testSort(arrays20Random100k,arrSorted3,"bubble");
        TestSortingMethods.testSort(arrays20Random150k,arrSorted4,"bubble");
        TestSortingMethods.testSort(arrays20Random180k,arrSorted5,"bubble");

        //Creating 20 linked lists for random test
        LinkedList<Comparable> ll1 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll2 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll3 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll4 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll5 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll6 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll7 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll8 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll9 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll10 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll11= CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll12 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll13 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll14 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll15 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll16 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll17 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll18 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll19 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll20 = CreateArrays.createRandomLL(10000);
        LinkedList<Comparable> ll_sorted= CreateArrays.createSortedLL(10000);

        TestSortingMethods.testSortLL(ll1,"quickLL");
        TestSortingMethods.testSortLL(ll2,"quickLL");
        TestSortingMethods.testSortLL(ll3,"quickLL");
        TestSortingMethods.testSortLL(ll4,"quickLL");
        TestSortingMethods.testSortLL(ll5,"quickLL");
        TestSortingMethods.testSortLL(ll6,"quickLL");
        TestSortingMethods.testSortLL(ll7,"quickLL");
        TestSortingMethods.testSortLL(ll8,"quickLL");
        TestSortingMethods.testSortLL(ll9,"quickLL");
        TestSortingMethods.testSortLL(ll10,"quickLL");
        TestSortingMethods.testSortLL(ll11,"quickLL");
        TestSortingMethods.testSortLL(ll12,"quickLL");
        TestSortingMethods.testSortLL(ll13,"quickLL");
        TestSortingMethods.testSortLL(ll14,"quickLL");
        TestSortingMethods.testSortLL(ll15,"quickLL");
        TestSortingMethods.testSortLL(ll16,"quickLL");
        TestSortingMethods.testSortLL(ll17,"quickLL");
        TestSortingMethods.testSortLL(ll18,"quickLL");
        TestSortingMethods.testSortLL(ll19,"quickLL");
        TestSortingMethods.testSortLL(ll20,"quickLL");
        //TestSortingMethods.testSortLL(ll_sorted,"quickLL");

        LinkedList<Comparable> ll1_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll2_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll3_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll4_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll5_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll6_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll7_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll8_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll9_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll10_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll11_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll12_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll13_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll14_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll15_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll16_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll17_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll18_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll19_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll20_40k = CreateArrays.createRandomLL(40000);
        LinkedList<Comparable> ll_sorted_40k = CreateArrays.createSortedLL(40000);

        TestSortingMethods.testSortLL(ll1_40k,"quickLL");
        TestSortingMethods.testSortLL(ll2_40k,"quickLL");
        TestSortingMethods.testSortLL(ll3_40k,"quickLL");
        TestSortingMethods.testSortLL(ll4_40k,"quickLL");
        TestSortingMethods.testSortLL(ll5_40k,"quickLL");
        TestSortingMethods.testSortLL(ll6_40k,"quickLL");
        TestSortingMethods.testSortLL(ll7_40k,"quickLL");
        TestSortingMethods.testSortLL(ll8_40k,"quickLL");
        TestSortingMethods.testSortLL(ll9_40k,"quickLL");
        TestSortingMethods.testSortLL(ll10_40k,"quickLL");
        TestSortingMethods.testSortLL(ll11_40k,"quickLL");
        TestSortingMethods.testSortLL(ll12_40k,"quickLL");
        TestSortingMethods.testSortLL(ll13_40k,"quickLL");
        TestSortingMethods.testSortLL(ll14_40k,"quickLL");
        TestSortingMethods.testSortLL(ll15_40k,"quickLL");
        TestSortingMethods.testSortLL(ll16_40k,"quickLL");
        TestSortingMethods.testSortLL(ll17_40k,"quickLL");
        TestSortingMethods.testSortLL(ll18_40k,"quickLL");
        TestSortingMethods.testSortLL(ll19_40k,"quickLL");
        TestSortingMethods.testSortLL(ll20_40k,"quickLL");
        TestSortingMethods.testSortLL(ll_sorted_40k,"quickLL");

        LinkedList<Comparable> ll1_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll2_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll3_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll4_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll5_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll6_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll7_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll8_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll9_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll10_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll11_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll12_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll13_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll14_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll15_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll16_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll17_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll18_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll19_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll20_100k = CreateArrays.createRandomLL(100000);
        LinkedList<Comparable> ll_sorted_100k = CreateArrays.createSortedLL(100000);

        TestSortingMethods.testSortLL(ll1_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll2_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll3_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll4_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll5_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll6_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll7_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll8_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll9_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll10_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll11_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll12_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll13_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll14_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll15_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll16_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll17_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll18_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll19_100k,"mergeLL");
        TestSortingMethods.testSortLL(ll20_100k,"mergeLL");
        //TestSortingMethods.testSortLL(ll_sorted_100k,"mergeLL");

        LinkedList<Comparable> l1_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l2_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l3_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l4_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l5_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l6_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l7_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l8_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l9_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l10_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l11_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l12_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l13_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l14_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l15_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l16_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l17_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l18_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l19_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l20_150 = CreateArrays.createRandomLL(150000);
        LinkedList<Comparable> l_sorted_150 = CreateArrays.createSortedLL(150000);

        TestSortingMethods.testSortLL(l1_150,"mergeLL");
        TestSortingMethods.testSortLL(l2_150,"mergeLL");
        TestSortingMethods.testSortLL(l3_150,"mergeLL");
        TestSortingMethods.testSortLL(l4_150,"mergeLL");
        TestSortingMethods.testSortLL(l5_150,"mergeLL");
        TestSortingMethods.testSortLL(l6_150,"mergeLL");
        TestSortingMethods.testSortLL(l7_150,"mergeLL");
        TestSortingMethods.testSortLL(l8_150,"mergeLL");
        TestSortingMethods.testSortLL(l9_150,"mergeLL");
        TestSortingMethods.testSortLL(l10_150,"mergeLL");
        TestSortingMethods.testSortLL(l11_150,"mergeLL");
        TestSortingMethods.testSortLL(l12_150,"mergeLL");
        TestSortingMethods.testSortLL(l13_150,"mergeLL");
        TestSortingMethods.testSortLL(l14_150,"mergeLL");
        TestSortingMethods.testSortLL(l15_150,"mergeLL");
        TestSortingMethods.testSortLL(l16_150,"mergeLL");
        TestSortingMethods.testSortLL(l17_150,"mergeLL");
        TestSortingMethods.testSortLL(l18_150,"mergeLL");
        TestSortingMethods.testSortLL(l19_150,"mergeLL");
        TestSortingMethods.testSortLL(l20_150,"mergeLL");
        //TestSortingMethods.testSortLL(l_sorted_150,"mergeLL");

        LinkedList<Comparable> l1_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l2_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l3_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l4_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l5_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l6_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l7_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l8_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l9_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l10_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l11_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l12_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l13_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l14_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l15_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l16_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l17_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l18_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l19_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l20_180 = CreateArrays.createRandomLL(180000);
        LinkedList<Comparable> l_sorted_180 = CreateArrays.createSortedLL(180000);

        TestSortingMethods.testSortLL(l1_180,"mergeLL");
        TestSortingMethods.testSortLL(l2_180,"mergeLL");
        TestSortingMethods.testSortLL(l3_180,"mergeLL");
        TestSortingMethods.testSortLL(l4_180,"mergeLL");
        TestSortingMethods.testSortLL(l5_180,"mergeLL");
        TestSortingMethods.testSortLL(l6_180,"mergeLL");
        TestSortingMethods.testSortLL(l7_180,"mergeLL");
        TestSortingMethods.testSortLL(l8_180,"mergeLL");
        TestSortingMethods.testSortLL(l9_180,"mergeLL");
        TestSortingMethods.testSortLL(l10_180,"mergeLL");
        TestSortingMethods.testSortLL(l11_180,"mergeLL");
        TestSortingMethods.testSortLL(l12_180,"mergeLL");
        TestSortingMethods.testSortLL(l13_180,"mergeLL");
        TestSortingMethods.testSortLL(l14_180,"mergeLL");
        TestSortingMethods.testSortLL(l15_180,"mergeLL");
        TestSortingMethods.testSortLL(l16_180,"mergeLL");
        TestSortingMethods.testSortLL(l17_180,"mergeLL");
        TestSortingMethods.testSortLL(l18_180,"mergeLL");
        TestSortingMethods.testSortLL(l19_180,"mergeLL");
        TestSortingMethods.testSortLL(l20_180,"mergeLL");
        //TestSortingMethods.testSortLL(l_sorted_180,"mergeLL");

    }
}

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 * Main class to test the SimpleTextEditor class.
 * Includes static void main class to run the program.
 * Calls every method (with iterator or with loop)of SimpleTextEditor class
 * for ArrayList and LinkedList structures.
 * Measures the running time of each method.
 */
public class Main {
    /**
     * Static void main method calls every method in SimpleTextEditor class.
     * Testing every method for arrayList and linkedList.
     * Testing for iterator used versions and loop used versions.
     * All outputs written in a log file included execution time results.
     * @param args String argument
     */
    public static void main(String [] args){
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;
        //logger.setUseParentHandlers(false);
        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("MyLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        //Creating file object for reading text file
        File file = new File("input.txt");

        //Creating arrayList object and linkedList objects for testing scenarios
        List<Character> text=new ArrayList<Character>();
        List<Character> text2=new ArrayList<Character>();
        List<Character> text3=new LinkedList<Character>();
        List<Character> text4=new LinkedList<Character>();

        //Creating SimpleTextEditor object as arrayList and linkedList
        SimpleTextEditor object=new SimpleTextEditor(text);
        SimpleTextEditor object2=new SimpleTextEditor(text2);
        SimpleTextEditor object3=new SimpleTextEditor(text3);
        SimpleTextEditor object4=new SimpleTextEditor(text4);

        //TESTING METHODS
        logger.info("******TESTING FOR ARRAYLIST ITERATOR USED******");
        long millis_startTime = System.currentTimeMillis();
        object.readWithIter(file);
        long millis_endTime = System.currentTimeMillis();
        logger.info("Test read file method: \n"+ object.toString());
        logger.info("Execution time for read method in milli seconds: " + (millis_endTime - millis_startTime));

        String str="adding ";
        millis_startTime = System.currentTimeMillis();
        object.addWithIter(7,str);
        millis_endTime = System.currentTimeMillis();
        logger.info("Add method test: \n"+object.toString());
        logger.info("Execution time for add method in milli seconds: " +(millis_endTime - millis_startTime));

        logger.info("Find method test, -1 means no match,else index of first occurrence:");
        millis_startTime = System.currentTimeMillis();
        logger.info("Index for string \"esra\":  "+object2.findWithIter("esra"));
        logger.info("Index for string \"adding\": "+object2.findWithIter("adding"));
        millis_endTime = System.currentTimeMillis();
        logger.info(object.toString());
        logger.info("Execution time for find method in milli seconds: " + (millis_endTime - millis_startTime));

        logger.info("Replace method test:");
        millis_startTime = System.currentTimeMillis();
        object.replaceWithIter('d','D');
        logger.info("Replacing 'd' with 'D' :\n"+object.toString());
        millis_endTime = System.currentTimeMillis();
        logger.info("Execution time for replace method in milli seconds: " + (millis_endTime - millis_startTime));

        logger.info("\n******TESTING FOR ARRAYLIST LOOP USED******");
        millis_startTime = System.currentTimeMillis();
        object2.readWithLoop(file);
        millis_endTime = System.currentTimeMillis();
        logger.info("Test read file method:\n"+ object2.toString());
        logger.info("Execution time for read method in milli seconds: " + (millis_endTime - millis_startTime));

        millis_startTime = System.currentTimeMillis();
        object2.addWithLoop(7,str);
        millis_endTime = System.currentTimeMillis();
        logger.info("Add method test:\n"+object2.toString());
        logger.info("Execution time for add method in milli seconds: " + (millis_endTime - millis_startTime));

        logger.info("Find method test, -1 means no match,else index of firs occurrence:");
        millis_startTime = System.currentTimeMillis();
        logger.info("Index for string \"esra\":  "+object2.findWithLoop("esra"));
        logger.info("Index for string \"adding\": "+object2.findWithLoop("adding"));
        millis_endTime = System.currentTimeMillis();
        logger.info(object2.toString());
        logger.info("Execution time for find method in milli seconds: " + (millis_endTime - millis_startTime));

        logger.info("Replace method test:");
        millis_startTime = System.currentTimeMillis();
        object2.replaceWithLoop('d','D');
        logger.info("Replacing 'd' with 'D' : \n"+object2.toString());
        millis_endTime = System.currentTimeMillis();
        logger.info("Execution time for replace method in milli seconds: " + (millis_endTime - millis_startTime));

        logger.info("\n******TESTING FOR LINKEDLIST ITERATOR USED******");
        millis_startTime = System.currentTimeMillis();
        logger.info("Test read file method:\n"+object3.toString());
        object3.readWithIter(file);
        millis_endTime = System.currentTimeMillis();
        logger.info("Execution time for read method in milli seconds: " + (millis_endTime - millis_startTime));

        millis_startTime = System.currentTimeMillis();
        object3.addWithIter(7,str);
        millis_endTime = System.currentTimeMillis();
        logger.info("Add method test:\n"+object3.toString());
        logger.info("Execution time for add method in milli seconds: " + (millis_endTime - millis_startTime));

        logger.info("Find method test, -1 means no match,else index of firs occurrence:");
        millis_startTime = System.currentTimeMillis();

        logger.info("Index for string \"esra\":  "+object3.findWithIter("esra"));
        logger.info("Index for string \"adding\": "+object3.findWithIter("adding"));
        millis_endTime = System.currentTimeMillis();
        logger.info(object3.toString());
        logger.info("Execution time for find method in milli seconds: " + (millis_endTime - millis_startTime));

        logger.info("Replace method test:");
        millis_startTime = System.currentTimeMillis();
        object3.replaceWithIter('d','D');
        logger.info("Replacing 'd' with 'D' :\n"+object3.toString());
        millis_endTime = System.currentTimeMillis();
        logger.info("Execution time for replace method in milli seconds: " + (millis_endTime - millis_startTime));


        logger.info("\n******TESTING FOR LINKEDLIST LOOP USED******");
        millis_startTime = System.currentTimeMillis();
        object4.readWithLoop(file);
        millis_endTime = System.currentTimeMillis();
        logger.info("Test read file method:\n"+object4.toString());
        logger.info("Execution time for read method in milli seconds: " + (millis_endTime - millis_startTime));

        millis_startTime = System.currentTimeMillis();
        object4.addWithLoop(7,str);
        millis_endTime = System.currentTimeMillis();
        logger.info("Add method test:\n"+object4.toString());
        logger.info("Execution time for add method in milli seconds: " + (millis_endTime - millis_startTime));

        logger.info("Find method test, -1 means no match,else index of firs occurrence:");
        millis_startTime = System.currentTimeMillis();
        logger.info("Index for string \"esra\":  "+object4.findWithLoop("esra"));
        logger.info("Index for string \"adding\": "+object4.findWithLoop("adding"));
        millis_endTime = System.currentTimeMillis();
        logger.info(object4.toString());
        logger.info("Execution time for find method in milli seconds: " + (millis_endTime - millis_startTime));

        logger.info("Replace method test:");
        millis_startTime = System.currentTimeMillis();
        object4.replaceWithLoop('d','D');
        logger.info("Replacing 'd' with 'D' :\n"+object4.toString());
        millis_endTime = System.currentTimeMillis();
        logger.info("Execution time for replace method in milli seconds: " + (millis_endTime - millis_startTime));

    }//end of static main
}//end of Main class

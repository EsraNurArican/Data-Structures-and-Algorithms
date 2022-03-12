import java.io.*;
import java.util.*;

/**
 * SimpleTextEditor class provides the some of the edit functionality of a
 * text editor
 */
public class SimpleTextEditor {
    /**
     * Private data textList as list represents the text
     * List can be a linkedList or arrayList
     */
    private List<Character> textList ;
    /**
     * Private data iterList is an iterator of the list
     */
    private ListIterator<Character> iterList;


    /**
     * Constructor that takes arrayList object to construct the text
     * @param text ArrayList object
     */
    public SimpleTextEditor(ArrayList<Character> text) {
        this.textList = text;

    }
    /**
     * Constructor that takes linkedList object to construct the text
     * @param text linkedList object
     */
    public SimpleTextEditor(LinkedList<Character> text) {
        this.textList = text;
    }
    /**
     * Constructor that takes list object to construct the text
     * @param text list object
     */
    public SimpleTextEditor(List<Character> text) {
        this.textList = text;
    }

    /**
     * Getter method for list structure
     * @return textList which holds the text
     */
    public List<Character> getTextList() {
        return textList;
    }

    /**
     * Getter method for iterator
     * @return iterList
     */
    public ListIterator<Character> getIteratorList() {
        return iterList;
    }

    /**
     * Reads a given file and constructs the text
     * Uses iterator for reading
     * @param file File object
     */
    public void  readWithIter(File file){

        iterList=  textList.listIterator();
        if (!file.exists()) {
            System.out.println(file+ " does not exist.");
            return;
        }
        if (!(file.isFile() && file.canRead())) {
            System.out.println(file.getName() + " cannot be read from.");
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            char current;
            while (fis.available() > 0) {
                current = (char) fis.read();
                iterList.add(current);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads a given file and constructs the text
     * Uses loop for reading
     * @param file File object
     */
    public void  readWithLoop(File file){

        if (!file.exists()) {
            System.out.println(file+ " does not exist.");
            return;
        }
        if (!(file.isFile() && file.canRead())) {
            System.out.println(file.getName() + " cannot be read from.");
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            char current;
            while (fis.available() > 0) {
                current = (char) fis.read();
                textList.add(current);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Adds one or more characters given as string at specified position.
     * Uses iterator for adding
     * @param index int position to add new characters
     * @param toAdd string characters to add the text
     */
    public void addWithIter(int index,String toAdd){
        iterList=  textList.listIterator();
        int i=0;
        while(iterList.hasNext() && i<=index ){
            if(i==index) {
                for (int j = 0; j< toAdd.length(); j++) {
                    iterList.add(toAdd.charAt(j));
                }
            }
            i++;
            iterList.next();
        }
    }
    /**
     * Adds one or more characters given as string at specified position.
     * Uses loop for adding
     * @param index int position to add new characters
     * @param toAdd string characters to add the text
     */
    public void addWithLoop(int index,String toAdd){
        for (int i = 0; i< toAdd.length(); i++) {
            textList.add(index+i,toAdd.charAt(i));
        }
    }

    /**
     * Find method returns the start index of the first occurrence of the
     * searched group of characters.
     * Uses loop to find.
     * @param toFind String parameter for searched characters.
     * @return int start index of first occurrence.
     */
    public int findWithLoop(String toFind){
       int  counter =0;
        for(int i = 0 ; i< textList.size() && (i + toFind.length()) < textList.size(); i++){
            for (int j= 0; j< toFind.length() ; j++ ) {
                if(textList.get(i+j) == toFind.charAt(j))
                    counter++;
            }
            if(counter == toFind.length())
                return i;
            counter =0;
        }
        return -1;

    }

    /**
     * Find method returns the start index of the first occurrence of the
     * searched group of characters.
     * Uses iterator to find.
     * @param toFind String parameter for searched characters.
     * @return int start index of first occurrence.
     */
    public int findWithIter(String toFind){
        iterList=  textList.listIterator();
        int counter;
        for(int i = 0; iterList.hasNext(); i++){
            counter =0;
            for (int j= 0; j< toFind.length() && iterList.hasNext() ; j++ ) {
                char temp =iterList.next();
                if(temp == toFind.charAt(j)) {
                    counter++;
                }
            }
            if(counter == toFind.length())
                return i;

            for (int j = 1; j < toFind.length() && iterList.hasNext();  j++) {
                iterList.previous();
            }
        }
        return -1;
    }

    /**
     * Replace method that replaces all occurrences of a character wiht another character.
     * Uses loop to replace
     * @param toReplace char value to replace
     * @param replaceAs char value to be replaced as
     */
    public void replaceWithLoop(char toReplace,char replaceAs){
        int i=0,j=0;
        while(i<textList.size() ){
            if(textList.get(i)==toReplace){
                textList.set(i,replaceAs);
            }
            i++;
            j++;
        }
    }

    /**
     * Replace method that replaces all occurrences of a character wiht another character.
     * Uses iterator to replace
     * @param toReplace char value to replace
     * @param replaceAs char value to be replaced as
     */
    public void replaceWithIter(char toReplace,char replaceAs) {
        iterList=  textList.listIterator();
        int i=0,j=0;
        while(iterList.hasNext()  ){
            if(iterList.next()==toReplace ){
               iterList.set(replaceAs);
            }
        }
    }

    /**
     * Overridden toString method to show text in list structure
     * @return String value of textList
     */
    @Override
    public String toString() {
        return "SimpleTextEditor: " +"textList = " + textList ;
    }
}

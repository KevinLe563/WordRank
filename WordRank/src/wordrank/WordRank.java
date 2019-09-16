package wordrank;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.util.*;
public class WordRank {
    public static void main(String[] args) throws Exception{ //catches exception 
        Scanner input = new Scanner(System.in);
        HashMap<String, Integer> words = new HashMap<>(); //initiates a hasmap with key and value
        System.out.println("Enter a txt file.");
        String file = input.nextLine();
        System.out.println("Location:" + new File(file).getCanonicalPath()); //finds the place where it searches for the file
        String data = new String(Files.readAllBytes(Paths.get(file))); // reads file and turns it into string
        String[] datalist = data.split("[^A-Z|a-z|-|']+"); //splits string into an array of strings using regexr and ascii table
        for(int i=0; i<datalist.length; i++){
            datalist[i] =datalist[i].toLowerCase();
        }
        for(int i =0; i<datalist.length; i++){ // adds words and word count to the hashmap
            if(words.containsKey(datalist[i])){ // checks if the hashmap contains the word (key)
                words.put(datalist[i], words.get(datalist[i])+1); // increase the counter (word count)
            }else{
                words.put(datalist[i], 1); // adds it to the hashmap
            }
        }
        List<Map.Entry<String, Integer>> ranklist = new ArrayList<>(words.entrySet()); // list = [{"ham" : 3},{"worda" : 3}] Turns the map into a list of keys and values of type Map.Entry
        Collections.sort(ranklist, (a, b) -> b.getValue().compareTo(a.getValue())); // sorts the list descending according to the value
        for(int i = 0; i<ranklist.size(); i++){ //prints out the array list
            System.out.println("Word: "+ranklist.get(i).getKey()+"  Count: "+ranklist.get(i).getValue());
        }
    }   
}

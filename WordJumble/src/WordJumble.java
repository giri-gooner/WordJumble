import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class WordJumble {

	static Map<String, Boolean> dictionary;
	public static final String INPUT_FILE = "./src/Dictionary.txt";
	
	public static void main(String[] args) throws FileNotFoundException { 
		String INPUT_STRING ="abcd";// input string of which you need to get permutations of 
		buildDictionary(); 
		doFindPerms("", INPUT_STRING);
	}
	
	//recursive function to generate all permuations of a string 
	private static void doFindPerms(String prefix, String substring) {
		if ( dictionary.containsKey(prefix) && dictionary.get(prefix)==true ) {
			System.out.println(prefix);
		}
		
		for (int i=0; i< substring.length(); i++) {
			doFindPerms(prefix + substring.charAt(i), remove(substring, i));
	    }
	}
	
	//given a string and int, this function removes the character at that int position
	private static String remove(String s, int i){
		return s.substring(0,i) + s.substring(i+1,s.length()); 
	}
	
	//create hashmap of words from input file 
	private static void buildDictionary() throws FileNotFoundException {
		File file = new File(INPUT_FILE); // downloadewd from http://downloads.sourceforge.net/wordlist/ispell-enwl-3.1.20.zip
		Scanner input = new Scanner(file);
		dictionary = new HashMap<String, Boolean>();
		while(input.hasNext()) {
			dictionary.put(input.nextLine(), true);
		}
		input.close();
	}
}

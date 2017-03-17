package dictionary;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		Dictionary dictionary = new Dictionary();
		
		System.out.println("Insert abc");
		if(dictionary.insertWord("abc", "one")){
			System.out.println("Success");
		}
		
		System.out.println("Insert def");
		if(dictionary.insertWord("def", "two")){
			System.out.println("Success");
		}
		
		System.out.println("Insert fgh");
		if(dictionary.insertWord("fgh", "three")){
			System.out.println("Success");
		}
		
		System.out.println("Insert abcde");
		if(dictionary.insertWord("abcde", "four")){
			System.out.println("Success");
		}
		
		System.out.println("Insert abcdefgh");
		if(dictionary.insertWord("abcdefgh", "full")){
			System.out.println("Success");
		}
		
		System.out.println("Prefix ab");
		ArrayList<String> wordList = dictionary.prefixSearch("ab");
		for(String temp:wordList){
			System.out.println(temp);
		}
		
		System.out.println("Prefix d");
		wordList = dictionary.prefixSearch("d");
		for(String temp:wordList){
			System.out.println(temp);
		}
		
		System.out.println("Prefix e");
		wordList = dictionary.prefixSearch("e");
		for(String temp:wordList){
			System.out.println(temp);
		}
		
		System.out.println("Delete def");
		if(dictionary.deleteWord("def")){
			System.out.println("Success");
		}
		
		System.out.println("Delete abcde");
		if(dictionary.deleteWord("abcde")){
			System.out.println("Success");
		}
		// Should fail, does not exist
		System.out.println("Delete defg");
		if(!dictionary.deleteWord("defg")){
			System.out.println("Failure");
		}
		
		System.out.println("Prefix a");
		wordList = dictionary.prefixSearch("a");
		for(String temp:wordList){
			System.out.println(temp);
		}
		//Empty return, deleted def
		System.out.println("Prefix d");
		wordList = dictionary.prefixSearch("d");
		for(String temp:wordList){
			System.out.println(temp);
		}
		//Empty return
		System.out.println("Prefix f");
		wordList = dictionary.prefixSearch("f");
		for(String temp:wordList){
			System.out.println(temp);
		}
		
		System.out.println("Insert zabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd");
		if(dictionary.insertWord("zabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd", "Long word")){
			System.out.println("Success");
		}
		
		System.out.println("Prefix z");
		wordList = dictionary.prefixSearch("z");
		for(String temp:wordList){
			System.out.println(temp);
		}
		
		// Leading spaces are trimmed, should pass
		System.out.println("Insert ' abcd'");
		if(dictionary.insertWord(" abc", "one")){
			System.out.println("Success");
		}
		
		System.out.println("\nNegative Test Cases");
		
		// Should fail, empty string
		System.out.println("Insert 5 spaces");
		if(!dictionary.insertWord("     ", "one")){
			System.out.println("Failure");
		}
		
		// Should fail, invalid string
		System.out.println("Insert 'ab*dc'");
		if(!dictionary.insertWord("ab*dc", "one")){
			System.out.println("Failure");
		}
		
		// Should fail, invalid string
		System.out.println("Insert '*abdc'");
		if(!dictionary.insertWord("ab*dc", "one")){
			System.out.println("Failure");
		}
		
		// Should fail, invalid string
		System.out.println("Insert 'abdc*'");
		if(!dictionary.insertWord("ab*dc", "one")){
			System.out.println("Failure");
		}
		
	}

}

package dictionary;

import java.util.ArrayList;

public class Dictionary {
	
	private Node root;
	
	public Dictionary() {
		super();
		//Initialize the root
		this.root = new Node(null,(char)0);
	}
	
	public boolean insertWord(String word, String defn){
		//Clean the word and definition
		word = Utils.cleanWord(word);
		defn = Utils.cleanDefn(defn);
		//If invalid word or definition, return false
		if(word==null || defn ==null){
			return false;
		}
		//try catch in the rare case insert fails(memory full)
		try{
			Utils.insert(root, word, defn);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public ArrayList<String> prefixSearch(String word){
		
		ArrayList<String> emptyList = new ArrayList<>();
		ArrayList<String> wordList = new ArrayList<>();
		//Clean the word
		word = Utils.cleanWord(word);
		//If invalid word, return empty list
		if(word==null){
			return emptyList;
		}
		try{
			// search for prefix, node is the null that forms it
			Node node = Utils.search(root, word);
			if(node!=null){
			// output all words with parent at node
				Utils.display(wordList,node, word);	
				return wordList;
			}
		}catch(Exception e){
			return emptyList;
		}
		return emptyList;
	}
	
	public String getDefinition(String word){
		word = Utils.cleanWord(word);
		if(word==null){
			return null;
		}
		String definition = null;
		try{
			// search for node that has the word
			Node node = Utils.search(root, word);
			if(node!=null){
			//if found get definition
				definition = node.getDef();
				return definition;
			}
		}catch(Exception e){
			return null;
		}
		
		return null;	
	}
	
	public boolean deleteWord(String word){
		word = Utils.cleanWord(word);
		if(word==null){
			return false;
		}
		try{
			// search for node that has the word
			Node node = Utils.search(root, word);
			// delete if word found
			if(node!=null){
				// set definition to null
				node.setDef(null);
				//cleanup paths
				Utils.delete(root,node);
				return true;
			}
		}catch(Exception e){
			return false;
		}
		return false;	
	}
}

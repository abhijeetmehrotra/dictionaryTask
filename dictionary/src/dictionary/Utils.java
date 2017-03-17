package dictionary;

import java.util.ArrayList;

public class Utils {
	
	// Clean the word to be inserted in the dictionary
	static String cleanWord(String word){
		if(word==null){
			return null;
		}
		word = word.trim();
		if(word.length()==0){
			return null;
		}
		word = word.toLowerCase();
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			if(!(c>='a' && c<='z')){
				return null;
			}
		}
		return word;
	}
	
	// Clean the definition to be inserted in the dictionary
	static String cleanDefn(String word){
		if(word==null){
			return null;
		}
		word = word.trim();
		if(word.length()==0){
			return null;
		}
		word = word.toLowerCase();
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			if(!(c>='a' && c<='z')){
				if(c!=' '){
					return null;
				}
			}
		}
		return word;
	}
	
	//Insert the word into the dictionary passed to it
	static void insert(Node root, String word, String defn){
		Node node = root;
		
		for(int i=0;i<=word.length();i++){
			
			if(i==word.length()){
				node.setDef(defn);
				continue;
			}
			
			Node[] nodeArr = node.getArr();
			int c = word.charAt(i)-(int)'a';
			if(nodeArr!=null &&nodeArr[c]!=null){
				node = nodeArr[c];
			}else{
				if(nodeArr==null){
					nodeArr = new Node[26];
					node.setTerm(false);
				}
				nodeArr[c] = new Node(node,(char) ('a'+c));
				node.setArr(nodeArr);
				node = nodeArr[c];
			}
		}
	}
	
	//Insert all the words beyond the node passed to it, into the wordList
	//Words are formed by concatenating the prefix and the new characters found.
	static void display(ArrayList<String> wordList, Node root, String word){
		String def = root.getDef();
		if(def != null){
			wordList.add(word);
		}
		if(!root.isTerm()){
			Node[] nodeArr = root.getArr();
	// call the function recursively on each child to complete the sweep
			for(int i=0;i<26;i++){
				if(nodeArr[i]!=null){
					display(wordList, nodeArr[i], word+((char)((int)'a'+i)));
				}
			}
		}
	}
	
	//Search for the word in the dictionary passed to it
	static Node search(Node node, String word){
		for(int i=0;i<=word.length();i++){
			
			if(i==word.length()){
				return node;
			}
			int c = word.charAt(i)-(int)'a';
			Node[] nodeArr = node.getArr();
			if(nodeArr==null || nodeArr[c]==null){
				return null;
			}else{
				node = nodeArr[c];
			}
		}
		return null;	
	}
	
	// Delete the node in the dictionary(root) passed to it
	// Go bottom-up to delete any free paths
	static void delete(Node root, Node node){
	// Can't delete the node
		if(node==root || node.isTerm()==false || node.getDef()!=null){
			return;
		}
		else{
		
				// Delete the pointer in parent array
				Node parent = node.getParent();
				Node [] parentArr = parent.getArr();
				int c = node.getNodeChar()-(int)'a';
				parentArr[c] =  null;
				// check if parent has become terminal node and update
				boolean term = true;
				for(int i=0;i<26;i++){
					if(parentArr[i]!=null){
						term = false;
					}
				}
				parent.setTerm(term);
				parent.setArr(parentArr);
				node = null;
				// call recursively to go bottom up till exit condition makes it quit
				delete(root, parent);
			
			
		}
	}

}

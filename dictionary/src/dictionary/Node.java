package dictionary;

public class Node {
	
	private Node parent;
	private char nodeChar; // character the node represents
	private String def; // the definition of the word reached, if exists
	private Node[] arr; // array of pointers to the child nodes
	private boolean isTerm; // the current node is the leaf node(true) or not(false)
	
	public Node(Node parent, char isChar) {
		super();
		this.parent = parent;
		this.nodeChar = isChar;
		// all nodes are terminal till children added to it
		this.isTerm = true;
	}
	
	public boolean isTerm() {
		return isTerm;
	}

	public void setTerm(boolean isTerm) {
		this.isTerm = isTerm;
	}

	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public char getNodeChar() {
		return nodeChar;
	}
	public void setNodeChar(char isChar) {
		this.nodeChar = isChar;
	}
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	public Node[] getArr() {
		return arr;
	}
	public void setArr(Node[] arr) {
		this.arr = arr;
	}
	
}

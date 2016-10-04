import java.util.*;

public class Node {
	
	private Node father;
	private Dot savedDot;
	private ArrayList<Node> children;
	
	public Node(Node father, Dot savedDot) {
		this.father = father;
		this.savedDot = savedDot;
		children = new ArrayList<Node>();
	}
	
	public void setFather(Node father) {
		this.father = father;
	}
	
	public Node getFather() {
		return father;
	}
	
	public void setSavedDot(Dot savedDot) {
		this.savedDot = savedDot;
	}

	public Dot getSavedDot() {
		return savedDot;
	}
	
	public void setChildList(ArrayList<Node> children) {
		this.children = children;
	}

	public void addChild(Node neighborDot) {
		children.add(neighborDot);
	}

	public ArrayList<Node> getChildList() {
		return children;
	}
}

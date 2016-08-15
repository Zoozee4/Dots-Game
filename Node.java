import java.util.*;

public class Node {
	
	private boolean father;
	private boolean discovered;
	private Dots currentDot;
	private ArrayList<Node> children;

	public Node(Dots currentDot) {
		father = false;
		discovered = false;
		this.currentDot = currentDot;
		children = new ArrayList<Node>();
	}

	public void setCurrentDot(Dots currentDot) {
		this.currentDot = currentDot;
	}

	public Dots getCurrentDot() {
		return currentDot;
	}

	public void addChild(Node neighborDot) {
		children.add(neighborDot);
	}

	public ArrayList<Node> getChildList() {
		return this.children;
	}
	
	public void setFather (boolean setting) {
		this.father = setting;
	}
	
	public boolean getFather () {
		return father;
	}
	
	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
	}
	
	public boolean getDiscovered() {
		return discovered;
	}
	
	public boolean equals(Object object){
		if(object instanceof Node){
			Node node = (Node) object;
			if((this.getCurrentDot().getPosX()==node.getCurrentDot().getPosX())&&
					(this.getCurrentDot().getPosY()==node.getCurrentDot().getPosY()&&
							(this.getCurrentDot().getSymbol())==node.getCurrentDot().getSymbol()))
					return true;
		}
		return false;
	}
}

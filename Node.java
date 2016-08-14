import java.util.*;

public class Node {

	private Dots currentDot;
	private ArrayList<Node> children;

	public Node(Dots currentDot) {
		this.currentDot = currentDot;
		children = new ArrayList<Node>();
	}

	public void setCurrentDot(Dots currentDot) {
		this.currentDot = currentDot;
	}

	public Dots getCurrentDot() {
		return currentDot;
	}

	public void addChild(Dots neighborDot) {
		children.add(new Node(neighborDot));
	}

	public Node getChild(int level) {
		if (children.size() != 0)
			return children.get(level);
		else
			return null;
	}

	public void clearChildren() {
		if (children.size() != 0)
			children.clear();
	}
	
	public int getChildrenSize() {
		return children.size();
	}
}

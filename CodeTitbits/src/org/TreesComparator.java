import java.util.Arrays;

public class TreesComparator {
	Node root1, root2;
	
	/*
	 * Given two trees, return true if they are structurally identical
	 */
	boolean identicalTrees(Node a, Node b) {
		/* 1. both empty */
		boolean bool1 = true;
		if (a == null && b == null)
			return true;
		if (Arrays.equals(a.data, b.data)) {
			for(int i = 0; i < 10 ; i++) {
				if(a.nodeList[i] == null && b.nodeList[i] == null) {
					continue;
				} else if(a.nodeList[i] == null ^ b.nodeList[i] == null) {
					return false;
				} else {
					bool1 = bool1 && identicalTrees(a.nodeList[i], b.nodeList[i]);
				}
			}
		} else {
			return false;
		}
		
		//return (identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));
		/* 3. one empty, one not -> false */
		return bool1;
	}

	/* Driver program to test identicalTrees() function */
	public static void main(String[] args) {
		TreesComparator tree = new TreesComparator();
		int[] first = {1,2,3};
		int[] second = {1,2,3,4};
		
		tree.root1 = new Node(second);
		tree.root1.nodeList[0] = new Node(first);
		tree.root1.nodeList[1] = new Node(first);
		tree.root1.nodeList[0].nodeList[0] = new Node(second);
		tree.root1.nodeList[0].nodeList[1] = new Node(second);
		//tree.root1.nodeList[2] = new Node(first);

		tree.root2 = new Node(second);
		tree.root2.nodeList[0] = new Node(first);
		tree.root2.nodeList[1] = new Node(first);
		tree.root2.nodeList[0].nodeList[0] = new Node(second);
		tree.root2.nodeList[0].nodeList[1] = new Node(second);

		if (tree.identicalTrees(tree.root1, tree.root2))
			System.out.println("Both trees are identical");
		else
			System.out.println("Trees are not identical");

	}
}

class Node {
	int[] data;
	Node[] nodeList = new Node[10];

	Node(int[] item) {
		data = item;
		//nodeList = null;
		for(int i = 0;i<10;i++) {
			//nodeList[i] = new Node();
		}
	}
}

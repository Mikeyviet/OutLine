
/***********************************************************************
 * @name Tree
 * @category class
 * @details the BST class and Node class that contains the topic and subject
 ***********************************************************************/

/**
 * Class that stores the root Node and the primary methods of the tree
 */
public class Tree {
	private Node root;

	public Tree() {
		setRoot(null);
	}// end Tree constructor

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * The Node class is a private class that is used to create a node object tha
	 * contains a subtopic, topic, and a left and right node
	 */
	private static class Node {
		private String subject;
		private int count;
		private int height;

		private Node firstChild;
		private Node nextSibling;

		public Node() {
			this.subject = "";
			this.firstChild = null;
			this.nextSibling = null;

		}

		// This is a constructor for the Node class. It is setting the subject and
		// topic to the parameters passed in. It is also setting the left and right
		// Nodes to null.
		public Node(String topic, String subject) {
			this.subject = subject;
			this.firstChild = null;
			this.nextSibling = null;

		}// end of Node constructor

		// Overloaded Constructor
		public Node(String mainTopic){
			this.subject = mainTopic;
			this.firstChild = null;
			this.nextSibling = null;
		}

		/**
		 * This function returns the subject of the current object
		 * 
		 * @return The subject variable is being returned.
		 */
		public String getsubject() {
			return subject;
		}// end of getsubject

		public void setsubject(String subject) {
			this.subject = "    " + subject;
		}// end of setsubject

		public int getCount() {
			return count;
		}// end of getCount

		public void setCount(int count) {
			this.count = count;
		}// end of setCount

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public Node getfirstChild() {
			return firstChild;
		}// end of getLeft

		public void setfirstChild(Node child) {
			this.firstChild = child;
		}// end of setLeft

		public Node getnextSibling() {
			return nextSibling;
		}// end of getRight

		public void setnextSibling(Node sibling) {
			this.nextSibling = sibling;
		}// end of setRight

	}// end of Node class

	// public Node insert(Node current, String top, String sub) {

	// if (current == null) {
	// Node newNode = new Node(top, sub);
	// // print confirmation of addition
	// System.out.println("New Node added");
	// return newNode;
	// }
	// // if the new topic is less than or equal to topic
	// if (top.compareTo(current.getTopic()) <= 0) {
	// current.setLeft(insert(current.getLeft(), top, sub));
	// return current;
	// } else if (top.compareTo(current.getTopic()) >= 0) {
	// current.setRight(insert(current.getRight(), top, sub));
	// return current;
	// }

	// return current;

	// }// end insert(Node current, String top, String sub)

	/************************************************************************************************
	 * @name height
	 * @param node the node to be checked
	 * @return The height of the node.
	 * @description gets the total height of the tree or subtree
	 ************************************************************************************************/
	public int height(Node node) {
		if (node == null) {
			return 0;
		}
		return node.getHeight();
	}// end of getHeight

	/************************************************************************************************
	 * @name max
	 * @param x The first number to compare
	 * @param y The y coordinate of the point.
	 * @return The maximum value between x and y.
	 * @description the function takes two integers as input and returns the larger
	 *              of the two.
	 ************************************************************************************************/
	public int max(int x, int y) {
		if (x > y) {
			return x;
		} // end if
		else {
			return y;
		} // end else
	}// end of max

	/************************************************************************************************
	 * 
	 * @param year  the year of the car
	 * @param make  The make of the car
	 * @param model The model of the car
	 * @return A new node with the given year, make, and model.
	 * @description this function that helps in creating memory for new node and
	 *              sets the make, model, and year to the node. It also sets the
	 *              height of the node and count of node to 1. All pointers are set
	 *              to null
	 ************************************************************************************************/
	public Node newAvlNode(String subject) {

		Node avlNode = new Node(subject);
		avlNode.height = 1;
		avlNode.count = 1;

		return avlNode;

	}// end of newAvlNode

	/*************************************************************************************************
	 * @name rotateRight
	 * @param r1 the root of the tree
	 * @return The new root of the tree after the rotation.
	 * @description The right child of the root node becomes the new root node, and
	 *              the old root node
	 *              becomes the left child of the new root node
	 *************************************************************************************************/
	public Node rotateRight(Node r1) {
		Node r2 = r1.getfirstChild();
		Node subT2 = r2.getnextSibling();

		// starting the first rotation of tree
		r2.setnextSibling(r1);
		r1.setfirstChild(subT2);

		// perform update of the new height after the rotation
		r1.setHeight(max(height(r1.getfirstChild()), height(r1.getnextSibling()) + 1));
		r2.setHeight(max(height(r2.getfirstChild()), height(r2.getnextSibling()) + 1));

		// pass back new root after the rotation
		return r2;

	}// end of rotateRight

	/*************************************************************************************************
	 * @name rotateLeft
	 * @param r2 the root of the tree
	 * @return The new root of the tree after the rotation.
	 * @description The right child of the root node becomes the new root node, and
	 *              the old root node
	 *              becomes the left child of the new root node
	 */
	public Node rotateLeft(Node r2) {
		Node r1 = r2.getnextSibling();
		Node subT2 = r1.getfirstChild();

		// starting the first rotation of tree
		r1.setfirstChild(r2);
		r2.setnextSibling(subT2);

		// perform update of the new height after the rotation
		r2.setHeight(max(height(r2.getfirstChild()), height(r2.getnextSibling()) + 1));
		r1.setHeight(max(height(r1.getfirstChild()), height(r1.getnextSibling()) + 1));

		// pass back new root after the rotation
		return r1;

	}// end of rotateRight

	/*****************************************************************************************************
	 * @name balance
	 * @param node the node to be balanced
	 * @return The height of the left subtree minus the height of the right subtree.
	 * @description this function returns the difference between the height of the
	 *              left subtree and the
	 *              height of the right subtree
	 ****************************************************************************************************/
	public int balance(Node node) {
		if (node == null) {
			return 0;
		} // end if

		return height(node.getfirstChild()) - height(node.getnextSibling());

	}// end of balance

	// public void insert(String top, String sub) {
	// 	root = insert(root, top, sub);
	// }

	public void inOrderPrint(Node root) {
		if (root != null) {

			inOrderPrint(root.getfirstChild());
			System.out.println(root.getsubject());
			inOrderPrint(root.getnextSibling());
			System.out.print("    ");
			System.out.println(root.getsubject());
		}

	}// end inOrderPrint(Node root)

	// public Node insert(Node temp, String topic, String subject) {

	// 	// check for empty node
	// 	if (temp == null) {
	// 		temp = newAvlNode(topic, subject);
	// 		System.out.println("Node added successfully!");
	// 		// return new node with car info
	// 		return temp;

	// 	} // end if

	// 	// Start to compare values in the node and traverse down the tree
	// 	if (topic.compareTo(temp.getTopic()) == 0) {

	// 		if (temp.getnextSibling() != null) {
	// 			if (subject.compareTo(temp.getsubject()) < 0) {
	// 				insert(temp.getnextSibling(), topic, subject);
	// 			} else {
	// 				// temp.setfirstChild(newAvlNode(topic, subject));
	// 				addsubject(temp.getnextSibling(), subject, topic);
	// 				System.out.println("Node added successfully!");
	// 			}
	// 		} // end if(make.compareTo(node.getTopic()) <= 0)
	// 		else if (subject.compareTo(temp.getsubject()) == 0) {
	// 			if (temp.getnextSibling() != null) {
	// 				if (subject.compareTo(temp.getsubject()) < 0) {
	// 					insert(temp.getnextSibling(), topic, subject);
	// 				} else {
	// 					// temp.setnextSibling(newAvlNode(topic, subject));
	// 					addTopic(temp.getnextSibling(), topic, subject);
	// 					System.out.println("Node added successfully!");
	// 				}
	// 			} // end else

	// 		} // end if (subject.compareTo(temp.getsubject()) == 0)
	// 		else {
	// 			addTopic(temp.getfirstChild(), topic, subject);
	// 		}

	// 	} // end if (topic.compareTo(temp.getTopic()) == 0)
	// 	else {
	// 		addTopic(temp.getfirstChild(), topic, subject);
	// 	}

	// 	// THE FOLLOWING CODE MAKES THE PRINTOUT SKIP ELEMENTS
	// 	/***********************************************************************************
	// 	 * // // update the height of the nodes of ancestors
	// 	 * // temp.setHeight(1 + max(height(temp.getLeft()), height(temp.getRight())));
	// 	 * 
	// 	 * // // get the balance factor of the node
	// 	 * // int balance = balance(temp);
	// 	 * 
	// 	 * // // if the node is unbalanced then there are 4 cases
	// 	 * 
	// 	 * // // left left case
	// 	 * // if (balance > 1 && topic.compareTo(temp.getLeft().getTopic()) < 0) {
	// 	 * // return rotateRight(temp);
	// 	 * // } // end left left case
	// 	 * 
	// 	 * // // right right case
	// 	 * // if (balance < -1 && topic.compareTo(temp.getRight().getTopic()) > 0) {
	// 	 * // return rotateLeft(temp);
	// 	 * // } // end right right case
	// 	 * 
	// 	 * // // left right case
	// 	 * // if (balance > 1 && topic.compareTo(temp.getLeft().getTopic()) > 0) {
	// 	 * // temp.setLeft(rotateLeft(temp.getLeft()));
	// 	 * // return rotateRight(temp);
	// 	 * // } // end left right case
	// 	 * 
	// 	 * // // right left case
	// 	 * // if (balance < -1 && topic.compareTo(temp.getRight().getTopic()) < 0) {
	// 	 * // temp.setRight(rotateRight(temp.getRight()));
	// 	 * // return rotateLeft(temp);
	// 	 * // } // end right left case
	// 	 * 
	// 	 * // return the node
	// 	 ***********************************************************************************/
	// 	return temp;

	// }// end insert method

	public void insert(String subject){
		root = insert(root, subject);
	}


public Node insert(Node node, String subject){
		if(node == null){
			node = new Node(subject);
			return node;
		}

		// Traverse down left side of tree if topic is less than new node topic
		if(subject.compareTo(node.getsubject()) < 0){
			// insert(node.getfirstChild(),subject);
			node.setfirstChild(insert(node.getfirstChild(), subject));
			// addChild(node.getfirstChild(), subject);
			
		}else if(subject.compareTo(node.getsubject()) > 0){
			// insert(node.getnextSibling(), subject);
			node.setnextSibling(insert(node.getnextSibling(), subject));		
			// addSibling(node.getnextSibling(), subject);
		}
		
		return node;
	
}	
	public Node addSibling(Node node, String subject) {

		if (node == null) {
			return null;
		}

		while (node.getnextSibling() != null) {
			node = node.getnextSibling();
		}

		node.setnextSibling(new Node(subject));
		return (node.getnextSibling());
	}

	public Node addChild(Node node, String subject) {
		if (node == null) {
			return null;
		}
		if (node.getfirstChild() != null) {
			return (addSibling(node.getfirstChild(), "    " + subject));
		} else {
			node.setfirstChild(new Node("     " + subject));
			return (node.getfirstChild());

		}
	}

	public void printDFS(Node root){
		if(root == null){
			return;
		}
		while(root != null){
			System.out.println(root.getsubject());

			if(root.getfirstChild() != null){
				printDFS(root.getfirstChild());
		
				
			}

			root = root.getnextSibling();
		}
	}

	/*****************************************************************************************************
	 * @name autoCompare
	 * @param node the node that is being compared to the tree
	 * @description function compares the model, year, and make of the node to the
	 *              model, year, and make of the node's parent. If the model, year,
	 *              or make of the node is the same as the model, year, or make of
	 *              the node's parent, then the modelCnt, yearCnt, or makeCnt is
	 *              incremented
	 *****************************************************************************************************/
	// public boolean autoCompare(Node node, String topic2, String subject) {

	// 	boolean exists = false;
	// 	// if the make already exists in the tree then increment the makeCnt
	// 	if (topic2 == node.getTopic()) {
	// 		// SortAutosMN.Tree.Node.makeCnt++;

	// 		// sets exists flag to true do indicate make exists and for calling function to
	// 		// return.
	// 		exists = true;

	// 	}
	// 	// if the model already exists in the tree then increment the modelCnt
	// 	if (subject == node.getsubject()) {
	// 		// SortAutosMN.Tree.Node.modelCnt++;
	// 	}

	// 	return exists;

	// }// end of autoCompare

}// end of Tree class

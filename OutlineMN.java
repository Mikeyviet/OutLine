
/***********************************************************************
 * @name Michael Nguyen
 * @class COSC 2436
 * @assignment Program Set 3 Problem 1
 * @description This program will read in date from file and sort them by
 * topic and subtopic. It will then print out the data in alphabetical order
 ***********************************************************************/

import java.util.*;
import java.io.*;

public class OutlineMN {

	
	public static void main(String[] args) throws FileNotFoundException {

		Tree myTree = new Tree();

		
		// myTree.setRoot(myTree.newAvlNode("Anathem", "Characters"));
		// myTree.insert("Cryptonium", "WW2");
		// myTree.insert("avout", "sphere");
		// myTree.insert("Diamond Age", "nanotechnology");
		// myTree.insert("Characters", "Erasmus");
		// myTree.insert("Vocabulary", "avout");
		// public Node addTopic(Node node, String topic, String subTopic)
		// myTree.insert("Anathem", "Characters");
		// myTree.insert("Cryptonomicon", "WW2");
		// myTree.insert("avout", "sphere");
		// myTree.insert("Diamond Age", "nanotechnology");
		// myTree.insert("Characters", "Erasmus");
		// myTree.insert("avout", "bolt");
		// myTree.insert("Characters", "Jad");
		// myTree.insert("Vocabulary", "avout");
		// myTree.insert("Vocabulary", "concent");
		// myTree.insert("Characters", "Cord");
		// myTree.insert("avout", "cord");
		// myTree.insert("Characters", "Arsibalt");
		// myTree.insert("Cryptonomicon", "dot-com");
		// myTree.insert("Diamond Age", "Neo-Victorian");
		// myTree.insert("Anathem", "Vocabulary");
		
		myTree.insert("Anathem");
		myTree.insert("Characters");
		myTree.insert("Cryptonomicon");
		myTree.insert("WW2");
		myTree.insert("avout");
		myTree.insert("sphere");
		myTree.insert("Diamond Age");
		myTree.insert("nanotechnology");
		myTree.insert("Characters");
		myTree.insert("Erasmus");
		myTree.insert("avout");
		myTree.insert("bolt");
		myTree.insert("Characters");
		myTree.insert("Jad");
		myTree.insert("Vocabulary");
		myTree.insert("avout");
		myTree.insert("Baroque Cycle (3 books)");
		myTree.insert("TL;DR");
		myTree.insert("Vocabulary");
		myTree.insert("concent");
		myTree.insert("Characters");
		myTree.insert("Cord");
		myTree.insert("avout");
		myTree.insert("cord");
		myTree.insert("Characters");
		myTree.insert("Arsibalt");
		myTree.insert("Cryptonomicon");
		myTree.insert("dot-com");
		myTree.insert("Diamond Age");
		myTree.insert("Neo-Victorian");
		myTree.insert("Anathem");
		myTree.insert("Vocabulary");
		// myTree.addTopic(myTree.getRoot(), "Cryptonium", "WW2");
		// myTree.Node n1 = myTree.Nod.addSubTopic(myTree.getRoot(), "avout", "sphere");
		// myTree.insert("Diamond Age", "nanotechnology");
		// myTree.insert("Characters", "Erasmus");
		// myTree.insert("Vocabulary", "avout");
		
		// myTree.insert("Baroque Cycle (3 books)", "TL;DR");
		// myTree.inOrderPrint(myTree.getRoot());

		System.out.println("\n\n");
		
		myTree.printDFS(myTree.getRoot());

		
		

	}// end of main

}// end of OutlineMN

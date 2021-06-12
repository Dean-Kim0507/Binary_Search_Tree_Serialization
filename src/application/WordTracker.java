package application;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import utilities.BSTreeADT;
import utilities.Iterator;
import implementation.*;
/**
 * WordTracker.java - This word tracker tracks the all of the words in the text file and then store
 * to the binary tree. It will print all of the words in the binary tree with the line of node or the frequency
 * it depends on what user give a option.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version April 23, 2021
 */
public class WordTracker {

	public static void main(String[] args) throws IOException {
		//Attributes
		BSTreeADT<String> tree = new BSTReferencedBased<String>();
		
		String filename = null;
		String outputFile = null;
		String option;

		option = args[0];
		File file;
		int ch = 0;
		boolean isExists;

		FileInputStream fis;
		BufferedInputStream bis;
		ObjectInputStream in;
		
		// Get the binary tree from the repository.ser
		try {
			file = new File("./res/repository.ser");
			//Check if the binay file exists or not
			isExists = file.exists();
			
			if (isExists) {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				in = new ObjectInputStream(bis);
				tree = (BSTreeADT<String>) in.readObject();
				in.close();
			}
			// If the binary file doesn't exist, output the new binary file by reading the words in the text file. 
			else {
				try {
					filename = args[1];
					file = new File(filename);
					FileReader reader = new FileReader(file);
					while ((ch = reader.read()) != -1) {
						String letter = Character.toString((char) ch).replaceAll("[^a-zA-Z]", "");
						if (!(letter.equals("") || letter.equals(null))) {
							tree.add(Character.toString((char) ch));
						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (NullPointerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// store the binary file
				FileOutputStream fos = new FileOutputStream("res/repository.ser");
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream out = new ObjectOutputStream(bos);
				out.writeObject(tree);
				out.close();

				System.out.println("Serialization complete");
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		//Print part
		// Print all of the words in binary tree alphabetically
		if (option.equals("-pf")) {
			Iterator<String> treeIterator = tree.inorderIterator();
			while (treeIterator.hasNext()) {
				BSTreeNode inorderIterator = treeIterator.next();
				for (int i = 0; i < inorderIterator.getFrequency(); i++) {
					System.out.print(inorderIterator.getData());
				}
				System.out.print("\n");
			}
			// Print all of the words in binary tree alphabetically with the line of the each word
		} else if (option.equals("-pl")) {
			Iterator<String> treeIterator = tree.inorderIterator();
			while (treeIterator.hasNext()) {
				BSTreeNode inorderIterator = treeIterator.next();
				System.out.println(inorderIterator.getData());
				System.out.println("Height: " + inorderIterator.getHeight());
			}
			// Print all of the words in binary tree alphabetically with the frequency of the each word
		} else if (option.equals("-po")) {
			Iterator<String> treeIterator = tree.inorderIterator();
			while (treeIterator.hasNext()) {
				BSTreeNode inorderIterator = treeIterator.next();
				System.out.println(inorderIterator.getData());
				System.out.println("Frequency: " + inorderIterator.getFrequency());
			}
			//Redirect the report in the previous step to a file 
		} else if (option.equals("-f")) {
			try {
				filename = args[1];
				file = new File(filename);
				FileReader reader = new FileReader(file);
				while ((ch = reader.read()) != -1) {
					String letter = Character.toString((char) ch).replaceAll("[^a-zA-Z]", "");
					if (!(letter.equals("") || letter.equals(null))) {
						tree.add(Character.toString((char) ch));
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (NullPointerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			FileOutputStream fos = new FileOutputStream("res/repository.ser");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(tree);
			out.close();

			System.out.print("Serialization complete");
		}
		//If option is invalid, it will print
		else System.out.println("Invalid option Key");
	}
}

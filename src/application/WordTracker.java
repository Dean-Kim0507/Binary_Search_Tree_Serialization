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
import implementation.*;

public class WordTracker {

	public static void main(String[] args) throws IOException {
		BSTreeADT tree = new BSTReferencedBased<String>();

		String filename = null;
		String outputFile = null;
		String option;

		option = args[0];
		File file;
		int ch = 0;

		FileInputStream fis = new FileInputStream("res/repository.ser");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream in = new ObjectInputStream(bis);

		try {
			tree = (BSTreeADT) in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			try {
				filename = args[1];
				file = new File(filename);
				FileReader reader = new FileReader(file);
				while ((ch = reader.read()) != -1) {
					tree.add(Character.toString((char) ch));
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

		in.close();

		if (option == "-pf") {
			while (tree.inorderIterator().hasNext()) {
				System.out.print(tree.inorderIterator().next());
			}
		} else if (option == "-pl") {
			while (tree.inorderIterator().hasNext()) {
				System.out.print(tree.inorderIterator().next());
			}
			System.out.print(tree.getHeight());
		} else if (option == "-po") {
			while (tree.inorderIterator().hasNext()) {
				System.out.print(tree.inorderIterator().next());
			}
			System.out.print(tree.getHeight());
//			System.out.print(tree.getFrequency());
		} else if (option == "-f") {

			try {
				filename = args[1];
				file = new File(filename);
				FileReader reader = new FileReader(file);
				while ((ch = reader.read()) != -1) {
					tree.add(Character.toString((char) ch));
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
	}
}

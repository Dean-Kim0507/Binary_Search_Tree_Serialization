package implementation;

import exceptions.TreeException;
import utilities.BSTreeADT;
import utilities.Iterator;


/**
 * BSTReferencedBased.java - This class is the implementation 
 * of BSTreeADT.java 
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version April 15, 2021
 * @param <E> - Generic Object
 */
public class BSTReferencedBased<E extends Comparable<? super E>> implements BSTreeADT<E> {

	private static final long serialVersionUID = 1L;

	/**
	 * Root node of this BSTree
	 */
	private BSTreeNode<E> root;
	
	/**
	 * User defined constructor of this
	 * Binary Search Tree.
	 */
	public BSTReferencedBased() {
		this.root = null;
	}
	
	/**
	 * the count number, it will be the number of the lines of node
	 */
	
	private int count=0;
	
	/**
	 * The node at the root of the Binary Search Tree will be returned.
	 * @return node stored at the root of tree is returned
	 * @throws TreeException if the root is empty.
	 */
	@Override
	public BSTreeNode<E> getRoot() throws TreeException {
		return root;
	}

	/**
	 * This method mainly calls the height(root) method
	 * @return height - the height of the tree.
	 */
	@Override
	public int getHeight() {
		return height(root);
	}
	
	
	/**
	 * Determines the row height of the tree and returns that value as an
	 * integer value.
	 * @param node - the node of BST
	 * @return the height of the tree.
	 */
	public int height(BSTreeNode<E> node) {
		if (node == null)
			return 0;
		else {
			int leftH = height(node.getLeft());
			int rightH = height(node.getRight());
			
			if (leftH > rightH) 
				return (leftH + 1);
			else 
				return (rightH + 1);
		}
	}

	/**
	 * This method mainly calls the size(root) method.
	 * @return number of elements currently stored in tree.
	 */
	@Override
	public int size() {
		return size(root);
	}
	
	/**
	 * The number of elements currently stored in the tree is counted and
	 * the value is returned.
	 * @param node - the node of tree
	 * @return number of elements currently stored in tree.
	 */
	public int size(BSTreeNode<E> node) {
		if (node == null)
			return 0;
		else 
			return (size(node.getLeft()) + 1 + size(node.getRight()));
	}

	/**
	 * Checks if the tree is currently empty.
	 * @return returns boolean true if the tree is empty otherwise false.
	 */
	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	/**
	 * Clears all elements currently stored in tree and makes the tree empty.
	 */
	@Override
	public void clear() {
		root = null;
	}

	/**
	 * Checks the current tree to see if the element passed in is stored in
	 * the tree. If the element is found in the tree the method returns true
	 * and if the element is not in the tree the method returns false.
	 * @param entry the element to find in the tree
	 * @return returns boolean true if element is currently in the tree and
	 * false if the element is not found in the tree
	 * @throws TreeException if the tree is empty.
	 */
	@Override
	public boolean contains(E entry) throws TreeException {
		if (root == null) {
			
			throw new TreeException();
		}
		
		while (root != null) {
			
			if (root.getData().compareTo(entry) == 0) return true;
			
			else if (root.getData().compareTo(entry) > 0 ) {
				
				root = root.getLeft();
				
			} else {
				
				root = root.getRight();
			}
		}
		
		return false;

	}

	/**
	 * This method mainly calls the searchRec(BSTreeNode root, E entry)
	 * method.
	 * @return the node with the element located in tree, null if not found
	 * @param entry - Generic Object
	 * @throws TreeException if the tree is empty
	 */
	@Override
	public BSTreeNode<E> search(E entry) throws TreeException {
		
		 return root = searchRec(root, entry);
	}
	
	/**
	 * Retrieves a node from the tree given the object to search for.
	 * @param entry element object being searched
	 * @param root -Generic Objet
	 * @return the node with the element located in tree, null if not found
	 * @throws TreeException if the tree is empty
	 */
	public BSTreeNode<E> searchRec(BSTreeNode<E> root, E entry) throws TreeException {
		
		if (root == null || root.getData().compareTo(entry) == 0) return root;
			
		if (root.getData().compareTo(entry) < 0 ) 
			return searchRec(root.getLeft(), entry);
			
		if (root.getData().compareTo(entry) > 0 ) 
			return searchRec(root.getRight(), entry);
		
		return null;
	}

	/**
	 * This method mainly calls the addRec(BSTreeNode root, E newEntry)
	 * method. 
	 * @param newEntry the element being added to the tree
	 * @return a boolean true if the element is added successfully else false
	 * @throws NullPointerException if the element being added is null
	 */
	@Override
	public boolean add(E newEntry) throws NullPointerException {
		if (newEntry == null) {
			throw new NullPointerException("New entry can not be null");
		}
		try {
			
			root = addRec(root, newEntry);
			return true;
			
		} catch (NullPointerException e) {
			return false;
		}
		
	}
	
	
	/**
	 * Adds a new element to the tree according to the natural ordering
	 * established by the Comparable implementation.
	 * 
	 * @param root - root node of BST.
	 * @param newEntry - element beimg added.
	 * @return the node added to the BST.
	 */
	public BSTreeNode<E> addRec(BSTreeNode<E> root, E newEntry) {
		
		if (root == null) {
			root = new BSTreeNode<E>(newEntry);
			root.setHeight(count);
			count = 0;
			return root;
		}
		
		if (newEntry.compareTo(root.getData()) < 0) {
			count++;
			root.setLeft(addRec(root.getLeft(), newEntry));
			
		} else if (newEntry.compareTo(root.getData()) > 0) {
			count++;
			root.setRight(addRec(root.getRight(), newEntry));
			
		} else if (newEntry.compareTo(root.getData()) == 0) {
			
			root.setFrequency();
			count=0;
		} 
		return root;	
	}

	/**
	 * Generates an in-order iteration over the contents of the tree. Elements
	 * are in their natural order.
	 * @return an iterator with the elements in the natural order
	 */
	@Override
	public Iterator<E> inorderIterator() {
		return new BSTIteratorInOrder<E>(root);
	}

	/**
	 * Generates a pre-order iteration over the contents of the tree. Elements
	 * are order in such a way as the root element is first.
	 * @return an iterator with the elements in a root element first order
	 */
	@Override
	public Iterator<E> preorderIterator() {
		return new BSTIteratorPreOrder<E>(root);
	}

	/**
	 * Generates a post-order iteration over the contents of the tree. Elements
	 * are order in such a way as the root element is last.
	 * @return an iterator with the elements in a root element last order
	 */
	@Override
	public Iterator<E> postorderIterator() {
		return new BSTIteratorPostOrder<E>(root);
	}

}

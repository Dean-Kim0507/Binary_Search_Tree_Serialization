package implementation;

import java.util.NoSuchElementException;
import java.util.Stack;

import utilities.Iterator;

/**
 * BSTIteratorPreOrder.java - This iterator makes a copy of 
 * the collection of elements and performs a complete walk 
 * through the data structure, in pre-order  trasversal.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version April 15, 2021
 */
public class BSTIteratorPreOrder<E> implements Iterator<E> {

	/**
	 * Stack where Binary Search Tree is stored.
	 */
	private Stack<BSTreeNode<E>> stack;
	
	/**
	 * User defined constructor
	 * @param root - the object of BSTreeNode that has all of subtrees
	 */
	public BSTIteratorPreOrder (BSTreeNode<E> root) {
		stack = new Stack<BSTreeNode<E>>();
		
		if (root != null) {
			stack.push(root);
		}
	}
	
	/**
	 * Returns true if the iteration has more elements. (In other
	 * words, returns true if next() would return an
	 * element rather than throwing an exception.)
	 * 
	 * @return true if the iterator has more elements.
	 */
	@Override
	public boolean hasNext() {
		return !stack.isEmpty(); 
	}

	/**
	 * Returns the next element in the iteration.
	 * 
	 * @return The next element in the iteration.
	 * @throws NoSuchElementException If the iteration has no more elements.
	 */
	@Override
	public BSTreeNode next() throws NoSuchElementException {
		if (! hasNext()) {
		    throw new NoSuchElementException("No more elements.");
		}
		
		BSTreeNode<E> node = stack.pop();
		
		if (!node.getRight().equals(null)) stack.push(node.getRight());
				
		
		if (!node.getLeft().equals(null)) stack.push(node.getLeft());
			
		return node;
	}

}

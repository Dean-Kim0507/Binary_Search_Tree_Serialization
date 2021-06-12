package implementation;

import java.util.NoSuchElementException;
import java.util.Stack;

import utilities.Iterator;

/**
 * BSTIteratorPostOrder.java - This iterator makes a copy of 
 * the collection of elements and performs a complete walk 
 * through the data structure, in post-order  trasversal.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version April 15, 2021
 */
public class BSTIteratorPostOrder<E> implements Iterator<E> {

	/**
	 * Stack where Binary Search Tree is stored.
	 */
	private Stack<BSTreeNode<E>> stack;
	
	/**
	 * User defined constructor
	 * @param root - the object of BSTreeNode that has all of subtrees
	 */
	public BSTIteratorPostOrder (BSTreeNode<E> root) {
		stack = new Stack<BSTreeNode<E>>();
		
		while (root != null) {
			stack.push(root);
			
			if (!root.getLeft().equals(null)) {
				root = root.getLeft();
			} else {
				root = root.getRight();// what if the right is null?
			}
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
		
		if (!stack.isEmpty()) {
			
			BSTreeNode<E> top = stack.peek();
			
			if (node == top.getLeft()) {
				
				while (top != null) {
					stack.push(top);
					
					if (!top.getLeft().equals(null)) { 
						
						top = top.getLeft();
						
					} else {
						
						top = top.getRight();
					}
				}
			}
		}
		return null;
	}

}

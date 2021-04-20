package implementation;

import java.util.NoSuchElementException;
import java.util.Stack;

import utilities.Iterator;

/**
 * BSTIteratorPostOrder.java - This iterator makes a copy of 
 * the collection of elements and performs a complete walk 
 * through the data structure, in order  trasversal.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version April 15, 2021
 */
public class BSTIteratorInOrder<E> implements Iterator<E> {
	
	/**
	 * Stack where Binary Search Tree is stored.
	 */
	private Stack<BSTreeNode<E>> stack;
	private BSTreeNode<E> node;
	/**
	 * User defined constructor
	 * @param root
	 */
	public BSTIteratorInOrder (BSTreeNode<E> root) {
		stack = new Stack<BSTreeNode<E>>();
		while (root != null) {
			stack.push(root);
			root = root.getLeft();		
		}
//		node = root;

	}
	public E inOrder(BSTreeNode<E> root) {
        if(root != null) {
            inOrder(root.getLeft());
            E returnData = root.getData();
            inOrder(root.getRight());
            return returnData;
        }
        return null;
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
	public E next() throws NoSuchElementException {
		if (! hasNext()) {
		    throw new NoSuchElementException("No more elements.");
		}
		
		BSTreeNode<E> node = stack.pop();
			
			while (node.getRight() != null) {
				
				stack.push(node);
				
				node = node.getLeft();
			}
			
			System.out.println("pls");
		
		
			return node.getData();
//		return inOrder(node);
//		
	}
		
}

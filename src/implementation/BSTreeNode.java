package implementation;

import java.io.Serializable;

/**
 * BSTreeNode.java - Class implements a Binary Search Tree Node. This node
 * consists of an element containing left and right child of node and key value.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version April 15, 2021
 * @param <E> - Generic Object
 */
public class BSTreeNode<E> implements Serializable {

	/**
	 * Node's data
	 */
	private E data;

	/**
	 * Node to the left of current node
	 */
	private BSTreeNode<E> left;

	/**
	 * Node to the right of current node
	 */
	private BSTreeNode<E> right;

	/**
	 * The number of frequency
	 */
	private int frequency;
	
	/**
	 * the number of height
	 */
	private int height;

	/**
	 * User defined constructor of Binary Search Tree node.
	 * 
	 * @param data - data of the node.
	 */
	public BSTreeNode(E data) {
		this.data = data;
		left = null;
		right = null;
		frequency = 1;
		height=0;
	}

	/**
	 * User defined constructor of Binary Search Tree node.
	 * 
	 * @param data   - data of the node.
	 * @param left   - node to the left of this node
	 * @param right- node to the right of this node
	 */
	public BSTreeNode(E data, BSTreeNode<E> left, BSTreeNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
	 * Get the number of frequency
	 * 
	 * @return frequency - the number of frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * Set the number of frequency
	 * 
	 */
	public void setFrequency() {
		frequency++;
	}
	
	/**
	 * Get the number of Height
	 * 
	 * @return height - the number of height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Set the number of Height
	 * @param height - height in the binary tree
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Getter method of data.
	 * 
	 * @return data - data of node
	 */
	public E getData() {
		return data;
	}

	/**
	 * Setter method of data.
	 * 
	 * @param data - data of node
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Getter method of node to the left.
	 * 
	 * @return node to the left.
	 */
	public BSTreeNode<E> getLeft() {
		return left;
	}

	/**
	 * Setter method of left node.
	 * 
	 * @param left node.
	 */
	public void setLeft(BSTreeNode<E> left) {
		this.left = left;
	}

	/**
	 * Getter method of node to the right.
	 * 
	 * @return node to the right.
	 */
	public BSTreeNode<E> getRight() {
		return right;
	}

	/**
	 * Setter method of right node.
	 * 
	 * @param right node.
	 */
	public void setRight(BSTreeNode<E> right) {
		this.right = right;
	}

}

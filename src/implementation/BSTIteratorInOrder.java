package implementation;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

import utilities.Iterator;

/**
 * BSTIteratorInOrder.java - This iterator makes a copy of 
 * the collection of elements and performs a complete walk 
 * through the data structure, in in-order trasversal.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version April 15, 2021
 */
public class BSTIteratorInOrder<E> implements Iterator<E> {
   
   private Stack<BSTreeNode<E>> stack;
   
   
   /**
    * @param BSTreeNode<E> root
    */
   public BSTIteratorInOrder(BSTreeNode<E> root) {
       // Stack for the recursion simulation
        this.stack = new Stack<BSTreeNode<E>>();
        
        // with the root node as the input
        this.leftMostNode(root);
   }

   private void leftMostNode(BSTreeNode<E> root) {
        //add all the elements from left subtree for a given branch.
        while (root != null) {
            this.stack.push(root);
            root = root.getLeft();
        }
      
   }
   
     /**
    * @return the top most node
     */
    public BSTreeNode next() {
        
       BSTreeNode<E> topmostNode = this.stack.pop();  //top of the stack will be the current min
        
        if (topmostNode.getRight() != null) {     //Check if current min has right subtree.
            this.leftMostNode(topmostNode.getRight());
        }
        
        return topmostNode;    
    }


    /**
     * @return whether we have a next node
     */
    public boolean hasNext() {
        return this.stack.size() > 0;
    }
      
}
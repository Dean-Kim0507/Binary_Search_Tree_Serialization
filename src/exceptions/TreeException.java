package exceptions;
/**
 * TreeException.java - User defined exception when a Binary
 * Search Tree is empty.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version April 15, 2021
 */
public class TreeException extends Exception{

	private static final long serialVersionUID = -1401985415652457534L;

	public TreeException () {
		super();
	}
	
	public TreeException (String message) {
		super(message);
	}
}

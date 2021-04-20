//package test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//
//import java.util.ArrayList;
//import static org.junit.Assert.*;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import exceptions.TreeException;
//import implementation.BSTReferencedBased;
//import utilities.Iterator;
//
///**
// * Binary Search Tree Referenced Based Test class.
// * 
// * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
// * @version April 15, 2021
// */
//public class BSTReferencedBasedTest {
//	
//	/**
//	 * Binary Search Tree
//	 */
//	BSTReferencedBased<String> tree;
//
//	/**
//	 * @Before - Will execute the method before each test. 
//	 * 		This method can prepare the test environment (e.g. read input data, initialize the class). 
//	 * @throws java.lang.Exception
//	 */
//	@Before
//	public void setUp() throws Exception {
//		this.tree = new BSTReferencedBased<>();
//	}
//	
//	/**
//	 * @BeforeClass - Will execute the method once, before the start of all tests. 
//	 * 		This can be used to perform time intensive activities, for example to connect to a database. 
//	 * @throws java.lang.Exception
//	 */
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		
//	}
//
//	/**
//	 * @After - Will execute the method after each test. 
//	 * 		This method can cleanup the test environment (e.g. delete temporary data, restore defaults). 
//	 * @throws java.lang.Exception
//	 */
//	@After
//	public void tearDown() throws Exception {
//		this.tree = null;
//	}
//	
//	/**
//	 * @AfterClass - Will execute the method once, after all tests have finished. 
//	 * 		This can be used to perform clean-up activities, for example to disconnect from a database. 
//	 * @throws java.lang.Exception
//	 */
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//		
//	}
//
//	
//	/**
//	 * Test method for {@link BSTreeADT.BSTReferencedBased#getRoot()}.
//	 * The node at the root of the Binary Search Tree will be returned.
//	 * @throws TreeException
//	 */
//	@Test
//	public void testGetRoot() throws TreeException {
//		
//		tree.add("B");
//		tree.add("A");
//		tree.add("C");
//		
//		assertEquals(3, tree.size());
//		
//		assertEquals("B", tree.getRoot().getData());
//		
//	}
//
//	/**
//	 * Test method for {@link BSTreeADT.BSTReferencedBased#getHeight()}.
//	 * Determines the row height of the tree and returns that value as an
//	 * integer value.
//	 */
//	@Test
//	public void testGetHeight() {
//		tree.add("B");
//		tree.add("A");
//		tree.add("C");
//		
//		assertEquals(3, tree.size());
//		
//		assertEquals(2, tree.getHeight());
//		
//	}
//
//	/**
//	 * Test method for {@link BSTreeADT.BSTReferencedBased#size()}.
//	 * The number of elements currently stored in the tree is counted and
//	 * the value is returned.
//	 */
//	@Test
//	public void testSize() {
//		tree.add("A");
//		tree.add("B");
//		tree.add("C");
//		
//		assertEquals(3, tree.size());
//	}
//
//	/**
//	 * Test method for {@link BSTreeADT.BSTReferencedBased#isEmpty()}.
//	 * Checks if the tree is currently empty.
//	 */
//	@Test
//	public void testIsEmpty() {
//		tree.clear();
//		assertTrue(tree.isEmpty());
//	}
//
//	/**
//	 * Test method for {@link BSTreeADT.BSTReferencedBased#clear()}.
//	 * Clears all elements currently stored in tree and makes the tree empty.
//	 */
//	@Test
//	public void testClear() {
//		tree.clear();
//		assertTrue(tree.isEmpty());
//	}
//
//	/**
//	 * Test method for {@link BSTreeADT.BSTReferencedBased#contains(E)}.
//	 * Checks the current tree to see if the element passed in is stored in
//	 * the tree.
//	 */
//	@Test
//	public void testContains() {
//		try {
//			tree.add("A");
//			tree.add("B");
//			tree.add("C");
//			
//			assertFalse(tree.isEmpty());
//			assertEquals(3, tree.size());
//			assertEquals(true, tree.contains("A"));
//			assertEquals(true, tree.contains("B"));
//			assertEquals(true, tree.contains("C"));
//
//		} catch (TreeException e) {
//			
//			assertTrue(true);
//			
//		}
//	}
//	
//	/**
//	 * Test method for {@link BSTreeADT.BSTReferencedBased#contains(E)}.
//	 * Checks the current tree to see if the element passed in is stored in
//	 * the tree. TreeException expected.
//	 */
//	@Test
//	public void testContainsTreeException() {
//		try {
//			tree.clear();
//			
//			tree.contains("A");
//			
//			fail("TreeException thrown");
//
//		} catch (TreeException e) {
//			
//			assertTrue(true);
//			
//		}
//	}
//
//	/**
//	 * Test method for {@link BSTreeADT.BSTReferencedBased#search(E)}.
//	 * Retrieves a node from the tree given the object to search for.
//	 */
//	@Test
//	public void testSearch() {
//		try {
//			tree.add("D");
//			tree.add("C");
//			tree.add("A");
//			tree.add("B");
//
//			assertEquals("A", tree.search("A").getData());
//			assertEquals("B", tree.search("B").getData());
//			assertEquals("C", tree.search("C").getData());
//			assertEquals("D", tree.search("D").getData());
//			
//		} catch (TreeException e) {
//			assertTrue(true);
//		} catch (NullPointerException e) {
//			assertTrue(true);
//		}
//	}
//
//	/**
//	 * Test method for {@link BSTreeADT.BSTReferencedBased#add(E)}.
//	 * Adds a new element to the tree according to the natural ordering
//	 * established by the Comparable implementation.
//	 */
//	@Test
//	public void testAdd() {
//		try {
//			tree.add("A");
//			tree.add("B");
//			tree.add("C");
//			
//			assertFalse(tree.isEmpty());
//			assertEquals(3, tree.size());
//			
//			assertEquals(true, tree.contains("A"));
//			assertEquals(true, tree.contains("B"));
//			assertEquals(true, tree.contains("C"));
//
//		} catch (TreeException e) {
//			
//			assertTrue(true);
//			
//		}
//	}
//
//	/**
//	 * Test method for {@link BSTreeADT.BSTReferencedBased#inorderIterator()}.
//	 * Generates an in-order iteration over the contents of the tree.
//	 */
//	@Test
//	public void testInorderIterator() {
//		try {
//			
//			tree.add("P");
//			tree.add("C");
//			tree.add("F");
//			tree.add("D");
//			tree.add("T");
//			tree.add("L");
//			tree.add("R");
//			
//
//			Iterator<String> treeIterator = tree.inorderIterator();
//
//			while(treeIterator.hasNext()) {
//				assertEquals("C", treeIterator.next());
//				assertEquals("D", treeIterator.next());
//				assertEquals("F", treeIterator.next());
//				assertEquals("L", treeIterator.next());
//				assertEquals("P", treeIterator.next());
//				assertEquals("R", treeIterator.next());
//				assertEquals("T", treeIterator.next());
//			}
//
//		} catch (NullPointerException e) {
//			assertTrue(true);
//		}
//		
//	}
//
//	/**
//	 * Test method for {@link BSTreeADT.BSTReferencedBased#preorderIterator()}.
//	 * Generates a pre-order iteration over the contents of the tree.
//	 */
//	@Test
//	public void testPreorderIterator() {
//		try {
//			tree.add("C");
//			tree.add("B");
//			tree.add("F");
//			tree.add("R");
//			tree.add("L");
//			tree.add("T");
//
//			Iterator<String> treeIterator = tree.preorderIterator();
//
//			while(treeIterator.hasNext()) {
//				
//				assertEquals("C", treeIterator.next());
//				assertEquals("L", treeIterator.next());
//				assertEquals("F", treeIterator.next());
//				assertEquals("B", treeIterator.next());
//				assertEquals("R", treeIterator.next());
//				assertEquals("T", treeIterator.next());
//			}
//
//		} catch (NullPointerException e) {
//			assertTrue(true);
//		}
//	}
//
//	/**
//	 * Test method for {@link BSTreeADT.BSTReferencedBased#postorderIterator()}.
//	 * Generates a post-order iteration over the contents of the tree.
//	 */
//	@Test
//	public void testPostorderIterator() {
//		try {
//			tree.add("P");
//			tree.add("C");
//			tree.add("F");
//			tree.add("D");
//			tree.add("T");
//			tree.add("L");
//			tree.add("R");
//			
//			
//
//			Iterator<String> treeIterator = tree.postorderIterator();
//
//			while(treeIterator.hasNext()) {
//				
//				assertEquals("D", treeIterator.next());
//				assertEquals("C", treeIterator.next());
//				assertEquals("F", treeIterator.next());
//				assertEquals("P", treeIterator.next());
//				assertEquals("T", treeIterator.next());
//				assertEquals("R", treeIterator.next());
//				assertEquals("L", treeIterator.next());
//				
//			}
//
//		} catch (NullPointerException e) {
//			assertTrue(true);
//		}
//	}
//
//}

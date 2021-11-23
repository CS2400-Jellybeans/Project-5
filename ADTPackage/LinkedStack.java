package ADTPackage;

import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>
{
   private Node topNode; // References the first node in the chain

   public LinkedStack()
   {
      topNode = null;
   } // end constructor

   @Override
   /**
   * Adds a new entry to the top of the stack.
   * @param newEntry The item to add to the stack.
   */
   public void push(T newEntry)
   {
      Node newNode = new Node(newEntry, topNode);
      topNode = newNode;
   } // end push

   @Override
   /**
   * Removes the item at the top of the stack.
   * @return The item that was removed.
   */
   public T pop()
   {
      T top = peek(); // Might throw EmptyStackException

      // Assertion: topNode != null
      topNode = topNode.getNextNode();

      return top;
   } // end pop

   @Override
   /**
   * @throws EmptyStackException If the stack is empty.
   * @return The item currently at the top of the stack.
   */
   public T peek()
   {
      if (isEmpty())
         throw new EmptyStackException();
      else
         return topNode.getData();
   } // end peek

   @Override
   /**
   * Checks if the stack is currently empty.
   * @return True if the stack is empty. False otherwise.
   */
   public boolean isEmpty()
   {
      return topNode == null;
   } // end isEmpty

   @Override
   /**
   * Removes all items from the stack by removing the reference to the
   * first node and allowing the garbage collector to take care of the rest.
   */
   public void clear()
   {
      topNode = null;
   } // end clear

   // A class for each node in the linked stack chain.
	private class Node
	{
      private T    data; // Entry in stack
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         this(dataPortion, null);
      } // end constructor
      
      private Node(T dataPortion, Node linkPortion)
      {
         data = dataPortion;
         next = linkPortion;
      } // end constructor

      /**
      * @return The data in this node.
      */
      private T getData()
      {
         return data;
      } // end getData

      /**
      * Sets the data in this node.
      * @param setData The data to put in the node.
      */
      private void setData(T newData)
      {
         data = newData;
      } // end setData

      /**
      * @return The next node in the chain.
      */
      private Node getNextNode()
      {
         return next;
      } // end getNextNode

      /**
      * Sets the reference to the next node in the chain.
      * @param nextNode The node to set as the next in the chain.
      */
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
}
// end LinkedStack
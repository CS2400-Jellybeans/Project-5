package project5;

import ADTPackage.QueueInterface;
import ADTPackage.StackInterface;

public interface GraphInterface<T>
{
   /**
    * Gets the label of a vertex.
    * @param vertex The index of the vertex to get the label of.
    * @return The data contained in the specified vertex.
    */
   public T getLabel(int vertex);

   /**
    * Tests whether an edge exists between the specified vertices.
    * @param source The index of the first vertex.
    * @param target The index of the second vertex.
    * @return True if there is an edge between these two indexes. False otherwise.
    */
   public boolean isEdge(int source, int target);

   /**
    * Adds an edge between the specified vertices.
    * @param source The index of the first vertex.
    * @param target The index of the second vertex.
    */
   public void addEdge(int source, int target);

   /**
    * Gets the neighbors of the specified vertex.
    * @param vertex The index of the vertex to get the neighbors of.
    * @return An int array containing the indexes of the vertex's neighbors.
    */
   public int[] neighbors(int vertex);

   /**
    * Removes the edge between the specified verticies.
    * @param source The index of the first vertex.
    * @param target The index of the second vertex.
    */
   public void removeEdge(int source, int target);

   /**
    * Sets the label of the specified vertex.
    * @param vertex The index of the vertex to change the label of.
    * @param newLabel The new data to assign to the vertex.
    */
   public void setLabel(int vertex, T newLabel);
   
   /**
    * @return The number of vertices in this graph.
    */
   public int size();

   /**
    * Traverses a graph breadth-first.
    * @param origin The index to start traversing from.
    * @return A stack containing the order of the traversal.
    */
   public QueueInterface<T> getBreadthFirstTraversal(int origin);

   /**
    * Traverses a graph depth-first.
    * @param origin The index to start traversing from.
    * @return A queue containing the order of the traversal.
    */
   public QueueInterface<T> getDepthFirstTraversal(int origin);
}

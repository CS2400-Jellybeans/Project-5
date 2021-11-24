package project5;

import ADTPackage.QueueInterface;
import ADTPackage.StackInterface;

public interface GraphInterface<T>
{
   // Accessor method to get the label of a vertex of this Graph
   public T getLabel(int vertex);

   // Test whether an edge exists
   public boolean isEdge(int source, int target);

   // Add an edge
   public void addEdge(int source, int target);

   // Obtain a list of neighbors of a specified vertex of this Graph
   public int[] neighbors(int vertex);

   // Remove an edge
   public void removeEdge(int source, int target);

   // Change the label of a vertex of this Graph
   public void setLabel(int vertex, T newLabel);
   
   // Accessor method to determine the number of vertices in this Graph
   public int size();

   // Returns a stack with the breadth-first traversal.
   public StackInterface<T> getBreadthFirstTraversal(int origin);

   // Returns a queue with the depth-first traversal.
   public QueueInterface<T> getDepthFirstTraversal(int origin);
}

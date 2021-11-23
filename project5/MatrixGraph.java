package project5;

import ADTPackage.*;

public class MatrixGraph<T> implements GraphInterface<T>
{
   private boolean[][] edges; // edges[i][j] is true if there is a vertex from i to j
   private T[] labels; // labels[i] contains the label for vertex i

   public MatrixGraph(int n)
   {
      edges = new boolean[n][n]; // All values initially false
      labels = (T[]) new Object[n]; // All values initially null
   } // end constructor

   public QueueInterface<T> getDepthFirstTraversal (T origin)
   {
      QueueInterface<T> traversalOrder = new LinkedQueue<T>();
      StackInterface<T> vertexStack = new LinkedStack<>();
      
      return traversalOrder;
   }

   // Accessor method to get the label of a vertex of this Graph
   public T getLabel(int vertex)
   {
      return labels[vertex];
   }

   // Test whether an edge exists
   public boolean isEdge(int source, int target)
   {
      return edges[source][target];
   }

   // Add an edge
   public void addEdge(int source, int target)
   {
      edges[source][target] = true;
   }

   // Obtain a list of neighbors of a specified vertex of this Graph
   public int[] neighbors(int vertex)
   {
      int i;
      int count = 0;
      int[] answer;
      for (i = 0; i < labels.length; i++)
      {
         if (edges[vertex][i])
         count++;
      }
      answer = new int[count];
      count = 0;
      for (i = 0; i < labels.length; i++)
      {
         if (edges[vertex][i])
         answer[count++] = i;
      }
      return answer;
   }

   // Remove an edge
   public void removeEdge(int source, int target)
   {
      edges[source][target] = false;
   }

   // Change the label of a vertex of this Graph
   public void setLabel(int vertex, T newLabel)
   {
      labels[vertex] = newLabel;
   }
   
   // Accessor method to determine the number of vertices in this Graph
   public int size()
   {
      return labels.length;
   }
}
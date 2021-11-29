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

   /**
    * Traverses a graph breadth-first.
    * @param origin The index to start traversing from.
    * @return A stack containing the order of the traversal.
    */
   public StackInterface<T> getBreadthFirstTraversal (int origin)
   {
      QueueInterface<T> traversalOrder = new LinkedQueue<T>();
      QueueInterface<T> vertexQueue = new LinkedQueue<T>();
      BagInterface<Integer> visitedVertexes = new LinkedBag<>();

      visitedVertexes.add(origin);
      traversalOrder.enqueue(origin);
      vertexQueue.enqueue(origin);

      while(!vertexQueue.isEmpty()) {
        frontVertex = vertexQueue.dequeue();

        int[] currNeighbors = neighbors(topVertex);
        while(currNeighbors.length > 0) {
            int nextNeighbor = -1;
            for(int vert : currNeighbors) {
                nextNeighbor = vert;
                if(!vertexQueue.contains(nextNeighbor)) {
                    visitedVertexes.add(origin);
                    traversalOrder.enqueue(nextNeighbor);
                    vertexQueue.enque(nextNeighbor);
                }
            }
        }

      }
      return traversalOrder;
   }

   /**
    * Traverses a graph depth-first.
    * @param origin The index to start traversing from.
    * @return A queue containing the order of the traversal.
    */
   public QueueInterface<T> getDepthFirstTraversal (int origin)
   {
      if(origin >= labels.length)
      {
         throw new IllegalStateException("Attempted to traverse a graph using a starting point "
                                         + "greater than the graph's size of " + labels.length);
      }
      QueueInterface<T> traversalOrder = new LinkedQueue<T>();
      StackInterface<Integer> vertexStack = new LinkedStack<>();
      BagInterface<Integer> visitedVertexes = new LinkedBag<>();

      visitedVertexes.add(origin);
      traversalOrder.enqueue(labels[origin]);
      vertexStack.push(origin);

      while(!vertexStack.isEmpty())
      {
         int topVertex = vertexStack.peek();
         int[] currNeighbors = neighbors(topVertex);
         int nextNeighbor = -1;
         for(int vert : currNeighbors)
         {
            if(!visitedVertexes.contains(vert))
            {
               nextNeighbor = vert;
               visitedVertexes.add(nextNeighbor);
               traversalOrder.enqueue(labels[nextNeighbor]);
               vertexStack.push(nextNeighbor);
               break;
            }
         }
         if(nextNeighbor == -1)
         {
            vertexStack.pop();
         }
      }
      return traversalOrder;
   }

   /**
    * Gets the label of a vertex.
    * @param vertex The index of the vertex to get the label of.
    * @return The data contained in the specified vertex.
    */
   public T getLabel(int vertex)
   {
      return labels[vertex];
   }

   /**
    * Tests whether an edge exists between the specified vertices.
    * @param source The index of the first vertex.
    * @param target The index of the second vertex.
    * @return True if there is an edge between these two indexes. False otherwise.
    */
   public boolean isEdge(int source, int target)
   {
      return edges[source][target];
   }

   /**
    * Adds an edge between the specified vertices.
    * @param source The index of the first vertex.
    * @param target The index of the second vertex.
    */
   public void addEdge(int source, int target)
   {
      edges[source][target] = true;
   }

   /**
    * Gets the neighbors of the specified vertex.
    * @param vertex The index of the vertex to get the neighbors of.
    * @return An int array containing the indexes of the vertex's neighbors.
    */
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

   /**
    * Removes the edge between the specified verticies.
    * @param source The index of the first vertex.
    * @param target The index of the second vertex.
    */
   public void removeEdge(int source, int target)
   {
      edges[source][target] = false;
   }

   /**
    * Sets the label of the specified vertex.
    * @param vertex The index of the vertex to change the label of.
    * @param newLabel The new data to assign to the vertex.
    */
   public void setLabel(int vertex, T newLabel)
   {
      labels[vertex] = newLabel;
   }
   
   /**
    * @return The number of vertices in this graph.
    */
   public int size()
   {
      return labels.length;
   }
}

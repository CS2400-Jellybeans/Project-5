package project5;

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
}

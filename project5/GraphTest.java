package project5;

public class GraphTest
{
   public static void main(String[] args)
   {
      GraphInterface<String> graph1 = createGraph1();
   }
   public static GraphInterface<String> createGraph1()
   {
      String[] labels = new String[]{"A", "B", "C",
                                     "D", "E", "F",
                                     "G", "H", "I"};
      int[] edges = new int[]{0, 1, 0, 3, 0, 4, 1, 4,
                              3, 6, 4, 5, 4, 7, 6, 7,
                              5, 2, 5, 7, 7, 8, 2, 1,
                              8, 5};
      GraphInterface<String> newGraph = new MatrixGraph<>(9);
      for (int i = 0; i < labels.length; i++)
      {
         newGraph.setLabel(i, labels[i]);
      }
      for (int i = 0; i < edges.length; i += 2)
      {
         newGraph.addEdge(edges[i], edges[i + 1]);
      }
      return newGraph;
   }
}

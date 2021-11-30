package JUnit;

import org.junit.*;

import ADTPackage.QueueInterface;
import junit.framework.TestCase;
import project5.GraphInterface;
import project5.MatrixGraph;

import static org.junit.Assert.assertThrows;

public class GraphJUnit extends TestCase
{
   String expectedOutput;

   @Override
   protected void setUp() throws Exception
   {

   }

   // Should work when traversing from an origin other than 0
   @Test
   public void testDiffOrigin()
   {
      String[] labels = new String[]{"A", "B",
                                     "C", "D"};
      int[] edges = new int[]{0, 1, 0, 2, 1, 3, 3, 0, 3, 2};
      GraphInterface<String> newGraph = new MatrixGraph<>(4);
      for (int i = 0; i < labels.length; i++)
      {
         newGraph.setLabel(i, labels[i]);
      }
      for (int i = 0; i < edges.length; i += 2)
      {
         newGraph.addEdge(edges[i], edges[i + 1]);
      }
      QueueInterface<String> queue = newGraph.getDepthFirstTraversal(3);
      
      String result = "";
      while(!queue.isEmpty())
      {
         result += queue.dequeue().toString() + " ";
      }
      
      assertEquals("D A B C ", result);
      
      queue = newGraph.getBreadthFirstTraversal(3);
      
      result = "";
      while(!queue.isEmpty())
      {
         result += queue.dequeue().toString() + " ";
      }
      
      assertEquals("D A C B ", result);
   }

   // Should work even if the graph has no edges defined
   @Test
   public void testUnconnected()
   {
      String[] labels = new String[]{"A", "B",
                                     "C", "D"};
      int[] edges = new int[]{};
      GraphInterface<String> newGraph = new MatrixGraph<>(4);
      for (int i = 0; i < labels.length; i++)
      {
         newGraph.setLabel(i, labels[i]);
      }
      for (int i = 0; i < edges.length; i += 2)
      {
         newGraph.addEdge(edges[i], edges[i + 1]);
      }
      QueueInterface<String> queue = newGraph.getDepthFirstTraversal(0);
      
      String result = "";
      while(!queue.isEmpty())
      {
         result += queue.dequeue().toString() + " ";
      }
      
      assertEquals("A ", result);
      
      queue = newGraph.getBreadthFirstTraversal(0);
      
      result = "";
      while(!queue.isEmpty())
      {
         result += queue.dequeue().toString() + " ";
      }
      
      assertEquals("A ", result);
   }

   // Should throw an illegal state exception if attempting to traverse a graph from a point outside the graph
   @Test
   public void testExceed()
   {
      GraphInterface<Integer> newGraph = new MatrixGraph<>(3);
      assertThrows(IllegalStateException.class, () -> {newGraph.getDepthFirstTraversal(5);});
      assertThrows(IllegalStateException.class, () -> {newGraph.getBreadthFirstTraversal(5);});
   }
   
   // Should throw an illegal state exception if attempting to traverse an empty graph
   @Test
   public void testEmpty()
   {
      GraphInterface<Integer> newGraph = new MatrixGraph<>(0);
      assertThrows(IllegalStateException.class, () -> {newGraph.getDepthFirstTraversal(0);});
      assertThrows(IllegalStateException.class, () -> {newGraph.getBreadthFirstTraversal(0);});
   }
}
   
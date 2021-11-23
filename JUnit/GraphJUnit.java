package JUnit;

import org.junit.*;

import junit.framework.TestCase;
import project5.GraphInterface;
import project5.MatrixGraph;

public class GraphJUnit extends TestCase
{
   String expectedOutput;

   @Override
   protected void setUp() throws Exception
   {

   }

   @Test
   public void testEmpty()
   {
      GraphInterface<Integer> newGraph = new MatrixGraph<>(0);
   }
}
   
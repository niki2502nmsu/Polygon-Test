import org.junit.*;
public class BlackboxTests
{
   private Polygon testee1,testee2;
   private int a[] = {2,5,7,2,3};

@Before public void setup()
{
   Point p4, p5, p6,p7;
   Point p1, p2, p3;
   p1 = new Point(4,4);
   p2 = new Point(8,1);
   p3 = new Point(8,7);
   p4 = new Point(2,4);
   p5 = new Point(5,6);
   p6 = new Point(5,4);
   p7 = new Point(9,1);
   System.out.println("\nTest starting...");
   testee1 = new Polygon(p1,p2,p3);
   testee2 = new Polygon(p4,p5,p6,p7);
}

@After public void teardown()
{
   System.out.println("\nTest finished.");
}


/***********************************************************************************************************/

//Test case to check whether polygon it is convex or not (This testcase is a polygon)
@Test public void  IsConvex()
{
   boolean s;
   s = testee1.isConvex();
   Assert.assertTrue(s);
}



/***********************************************************************************************************/

//Test case to check whether polygon it is convex or not(This testcase is not polygon)
@Test public void IsNotConvex()
{
   boolean s;
   s = testee2.isConvex();
   Assert.assertFalse(s);
}

/***********************************************************************************************************/
//Test case 1 to check whether point is in bound or not(This testcase is not in bound)
@Test public void IsNotInBoundingbox1()
{
   Point p; 
   boolean s;
   p = new Point(6,9);
   s = testee1.inBoundingBox(p);
   Assert.assertFalse(s);
}

/***********************************************************************************************************/

//Test case 1 to check whether point is in bound or not(This testcase is in bound)
@Test public void IsInBoundingbox1()
{
   Point p; 
   boolean s;
   p = new Point(8,7);
   s = testee1.inBoundingBox(p);
   Assert.assertTrue(s);
}


/***********************************************************************************************************/

//Test case 1 to check whether point is inside polygon(This testcase is inside polygon)
@Test public void IsInPolygon1()
{
   Point p; 
   boolean s;
   p = new Point(7,4);
   s = testee1.inPolygon(p);
   Assert.assertTrue(s);
}

/***********************************************************************************************************/

//Test case 1 to check whether point is inside polygon(This testcase is not inside polygon)
@Test public void IsNotInPolygon1()
{
   Point p; 
   boolean s;
   p = new Point(2,3);
   s = testee1.inPolygon(p);
   Assert.assertFalse(s);
}


/**************************************************************************************************/

//Test case to add vertex after existing point
@Test public void addVertexTest1()
{
   Point p1,p2; boolean s;
   p1 = new Point(10,1);
   p2=new Point(8,1);
   s = testee1.addVertex(p1,p2);
   Assert.assertTrue(s);
}

//Test case to add vertex after a non-existing point
@Test public void addVertexTest2()
{
   Point p1,p2; boolean s;
   p1 = new Point(8,7);
   p2=new Point(8,10);
   s = testee1.addVertex(p1,p2);
   Assert.assertFalse(s);
}

/*********************************************************************************************************/
//Test case to make a concave polygon convex
@Test public void makeConvexTest()
{
   int s;
   s = testee2.makeConvex();
   Assert.assertEquals(s,1);
}



/***********************************************************************************************************/
//Test case to check if a point is away from the point given
@Test public void verticesListTest1()
{
  
   Point p=new Point(9,1);
   Point[] pList=testee1.vertices(p);
  
       if(pList[0].x==4 && pList[0].y==4 && pList[1].x==8 && pList[1].y==1 && pList[2].x==8 && pList[2].y==7 ){
       Assert.assertTrue(true);

   }
   else{

      Assert.assertFalse(false);
   }   
}

}


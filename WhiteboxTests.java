import org.junit.*;
public class WhiteboxTests
{
   private Polygon testee1,testee2;
   private int a[] = {2,5,7,2,3};
   

@Test public void polymain(){
   String[] arguments=new String[]{"1","2","3","4","5","6"};
   Poly.main(arguments);
   String[] arguments1=new String[]{"1"};
   Poly.main(arguments1);
   String[] arguments2 = new String[]{"1","2","3","4","5","6*"};
   Poly.main(arguments);
   String[] arguments3=new String[]{"1","2","3","4","5","6"};
   Poly.main(arguments3);
   


}	
   

@Before public void setup()
{
   Point p1, p2, p3,p4;
   p1 = new Point(1,2);
   p2 = new Point(3,4);
   p3 = new Point(5,6);
  // p4 = new Point(11,1);
   System.out.println("\nTest starting...");
   testee1 = new Polygon(p1,p2,p3);
   //testee2 = new Polygon(p1,p2,p3,p4);
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

//Test case to check whether polygon it is convex or not (This testcase is not a polygon)
@Test public void IsNotConvex()
{
   boolean s;
   s = testee1.isConvex();
   Assert.assertFalse(s);
}


/***********************************************************************************************************/
//Test case 1 to check whether point is in bound or not(This testcase is not in bound)
@Test public void IsNotInBoundingbox1()
{
   Point p; 
   boolean s;
   p = new Point(6,5);
   s = testee1.inBoundingBox(p);
   Assert.assertFalse(s);
}


/***********************************************************************************************************/

//Test case 1 to check whether point is in bound or not(This testcase is in bound)
@Test public void IsInBoundingbox1()
{
   Point p; 
   boolean s;
   p = new Point(2,4);
   s = testee1.inBoundingBox(p);
   Assert.assertTrue(s);
}


/***********************************************************************************************************/

//Test case 1 to check whether point is inside polygon(This testcase is inside polygon)
@Test public void IsInPolygon1()
{
   Point p; 
   boolean s;
   p = new Point(3,4);
   s = testee2.inPolygon(p);
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
   p1 = new Point(6,1);
   p2=new Point(3,4);
   s = testee1.addVertex(p1,p2);
   Assert.assertTrue(s);
}

/*********************************************************************************************************/
//Test case to make a concave polygon convex
@Test public void makeConvexTest()
{
   int s;
   s = testee1.makeConvex();
   Assert.assertEquals(s,1);
}



/***********************************************************************************************************/
//Test case to check if a point is away from the point is given
@Test public void verticesListTest1()
{
  
   Point p=new Point(7,8);
   Point[] pList=testee1.vertices(p);
  
       if(pList[0].x==1 && pList[0].y==2 && pList[1].x==3 && pList[1].y==4 && pList[2].x==5 && pList[2].y==6 ){

       Assert.assertTrue(true);

   }
   else{

      Assert.assertFalse(false);
   }   
}

}


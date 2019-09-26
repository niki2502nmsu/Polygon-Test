
import java.util.Arrays;

public class Poly
{

public static void main(String args[])
{
   Point input[], pt;
   input = new Point[3];
   if (args != null && args.length != 6)
   {
      System.out.println("Error: supply three points!");
      return;
   }
   try {
      for (int i=0; i < 3; i++) {
         input[i] = new Point();
         input[i].x = Integer.parseInt(args[i*2]);
         input[i].y = Integer.parseInt(args[i*2+1]);
         System.out.println("Point created: "+input[i]);
      }
   } catch (Exception e) {
      System.out.println("Error in arguments! ("+e+")");
      return;
   };
   Polygon p = new Polygon(input[0], input[1], input[2]);
   System.out.println("We created a polygon!");
   pt = new Point(5,4);
   System.out.println("add vertex: " + 
         p.addVertex(pt, input[1]));
   System.out.println("is convex: " + p.isConvex());
   pt.x = 7; pt.y = 2;
   System.out.println("in BB: " + p.inBoundingBox(pt));
   System.out.println("is polygon: " + p.inPolygon(pt));
   System.out.println("make convex: " + p.makeConvex());
   System.out.println("vertices: " + Arrays.toString(p.vertices(pt)));
}

}


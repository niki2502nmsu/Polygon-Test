import java.util.ArrayList;
import java.util.Arrays;
public class Polygon 
{
	private ArrayList<Point> points;
	
	 private int sign(int i){
		if(i==points.size()-1){
			int x1=points.get(0).x-points.get(i).x;
			int x2=points.get(1).x-points.get(0).x;
			int y1=points.get(0).y-points.get(i).y;
			int y2=points.get(1).y-points.get(0).y;
			int x= x1*y2 -y1*x2;
		return x;
       }
		else if(i==points.size()-2){
			int x1=points.get(i+1).x-points.get(i).x;
			int x2=points.get(0).x-points.get(i+1).x;
			int y1=points.get(i+1).y-points.get(0).y;
			int y2=points.get(0).y-points.get(i+1).y;
			int x=x1*y2-y1*x2;
			return x;
		}
		else{

			int x1=points.get(i+1).x-points.get(i).x;
			int x2=points.get(i+2).x-points.get(i+1).x;
			int y1=points.get(i+1).y-points.get(i).y;
			int y2=points.get(i+2).y-points.get(i+1).y;
			int x=x1*y2-y1*x2;
		return x;
	  }
	}

	public Polygon(Point p1, Point p2, Point p3) 
	{
        points=new ArrayList<Point>(); //Create an empty arraylist
		points.add(p1);                //Use add() method of ArrayList to add all elements
		points.add(p2);
		points.add(p3);
	}
    public Polygon(Point p1, Point p2, Point p3,Point p4) //To produce 100% branch coverage i created this constructor.with 3 points,we cannot make a polygon
	{
        points=new ArrayList<Point>(); //Create an empty arraylist
		points.add(p1);                //Use add() method of ArrayList to add all elements
		points.add(p2);
		points.add(p3);
        points.add(p4);
	}
	public boolean addVertex(Point p, Point after) 
	{
		  int f=0,n=0,i=0;
		  while(i< points.size())   //checks whether already the Point exists
		   {
		       if(points.get(i).x == p.x && points.get(i).y == p.y)
		             f = i;             //if it exists then find the index of the point in the arraylist
		       else
		             f = -1;
				 i=i+1;
		   }
		   if(f!=-1)
		   {
			   //System.out.println("The point already exists in the arraylist");
			   return false;
		   }
		   while(i<points.size())
		   {
			  if(points.get(i).x == after.x && points.get(i).y == after.y)
		             n = i;            //if it exists then find the index of the point in the arraylist
		       else
		             n = -1;
			 i=i+1;
		   }
		   if(n==-1)
		   {
			  //System.out.println("The point is not in the arraylist,so we cannot add the after point");  
			  return false;
		   }
		   else
			   points.add(n+1,p);
		   return true;
		
	}
	

	public Point[] vertices(Point startNear) 
	{
		float x,y,distance,minD=1000;
		int s = points.size();   //get the size of the list
		int index1=0,index2=0;
		Point[] list = new Point[s]; //create a list 
	    for (int i=0;i < s; i++)    //As distance formula is sqrt(x2-x1)^2 -(y2-y1)^2
	    {
		     x = points.get(i).x - startNear.x;      //x distance         
		     y = points.get(i).y - startNear.y;      //y distance
		     distance= (float)Math.sqrt((x*x)+(y*y));
		     if (distance < minD) {
		             minD = distance;
		             index1 = i;     //get the index of the point which is nearby to the given point
		      }
		 }
		 for (int i=index1; i < s; i++) {     
		         list[index2] = points.get(i);   //add all the points from the nearby point to the list
		         index2=index2+1;
		 }
		 for (int i=0; i < index1; i++) {
		         list[index2] = points.get(i);
		         index2=index2+1;
		 }
		return list;
	}

	public boolean isConvex() //Some part of this code is referred from external link
	{
		boolean gotNegative=false;
		boolean gotPositive=false;
		int numPoints=points.size(); //number of points in arraylist
		for(int i=0;i<numPoints;i++)
		{
			int j=(i+1)%numPoints;
			int k=(j+1)%numPoints;
			int crossProduct =
	                    crossProductLength(
	                            points.get(i).x, points.get(i).y,
	                            points.get(j).x, points.get(j).y,
	                            points.get(k).x, points.get(k).y);
	          if (crossProduct < 0) {
	                gotNegative = true;
	          }
	          else if (crossProduct > 0) {
	                gotPositive = true;
	          }
	          if (gotNegative && gotPositive) {  // if the crossProduct doesn't have the same sign, then it's concave polygon
	                return false;
	          }
	       }
		return true;
	}
	 
	public boolean inBoundingBox(Point p) 
	{
		Point pnew = points.get(points.size()-1);
		pnew.toString();
		Point lx=pnew,ly=pnew,hx=pnew,hy=pnew;
		for(int i=0;i<points.size();i=i+1)
		{
			if(points.get(i).x < lx.x)
				lx=points.get(i);
			if(points.get(i).y < ly.y)
				ly=points.get(i);
			
			if(points.get(i).x > hx.x)
				hx=points.get(i);
			if(points.get(i).y > hy.y)
				hy=points.get(i);			
		}
                if(p.x > hx.x || p.x < lx.x || p.y > hy.y || p.y < ly.y)
                       return false;
                else
			return true;
	}
         private int crossProductLength(int Ax, int Ay, int Bx, int By, int Cx, int Cy)
	 {
	        int ABx = Bx - Ax;
	        int ABy = By - Ay;
	        int ACx = Cx - Ax;
	        int ACy = Cy - Ay;
	        return ABx * ACy - ABy * ACx;
	 }

	public boolean inPolygon(Point p) 
	{
		   int x=points.size();
                   int i1,j1;
		   boolean result=false;
                   int i2=points.get(points.size()-1).x; int j2=points.get(points.size()-1).y;
		   for (int i = 0; i < x ;i2=i1,j2=j1,++i )
		   {
		      i1=points.get(i).x;
                      j1=points.get(i).y;
if(((j1<p.y) && (j2>=p.y))|| ((j2>=p.y) && (j2< p.y))){
                         if((p.y-j1)/(j2-j1) *(i2-i1)<(p.x-i1))
result=!result;
}

		   }
		     return result;
		
	}
	public int makeConvex() {
		int sign, p=0, n=0;
	        int a;
		boolean convex=false;
		for (int i = 0; i < points.size(); i++)
		 {
		    sign =sign(i);
		    if (sign >= 0)
		          p++;
		    else
		         n++;
		 }
		 if(n==points.size() || p==points.size()){
		        convex=true;
		        return 0;
		 }
		 a = 0;
		for (int i = 0; i < points.size(); i++)
		{
		     sign = sign(i);
		     if ((convex && sign < 0) || (!convex && sign >= 0)) {
		             points.remove((i));
		             a=a+1;
		     }
	       }
		     
	     return a;
	}

}

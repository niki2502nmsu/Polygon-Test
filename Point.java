/**
* Simple data structure for a point (uses public data fields)
**/

public class Point {

public int x;
public int y; 

public Point() {}

public Point(int ix, int iy)
{
   x = ix;
   y = iy;
}

public String toString()
{
   return "("+x+","+y+")";
}

}



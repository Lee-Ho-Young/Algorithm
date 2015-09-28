import java.util.ArrayList;
import java.util.Scanner;

class Point
{
	double x;
	double y;
	
	Point(double x, double y)
	{
		this.x = x; this.y = y;
	}
	
	double getDistance(Point p)
	{
		double delta_x = this.x - p.x;
		double delta_y = this.y - p.y;
		
		return Math.sqrt((delta_x * delta_x) + (delta_y * delta_y));
	}
}

public class Arctic 
{
	static ArrayList<Point> list = new ArrayList<Point>();
	static ArrayList<Point> primList = new ArrayList<Point>();
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int cases = Integer.parseInt(sc.nextLine());
		String temp;
		
		while(cases-- > 0)
		{
			int base = Integer.parseInt(sc.nextLine());
			for(int i=0; i<base; i++)
			{
				temp = sc.nextLine();
				String[] string_arr = new String[2];
				string_arr = temp.split(" ");
				list.add(new Point(Double.parseDouble(string_arr[0]), Double.parseDouble(string_arr[1])));
			}
			
			double distance = makeList();
			System.out.println(distance);			
		}
	}
	
	static double makeList()
	{
		double distance;
		int candidate = 0;
		double result = Double.MIN_VALUE;
		
		while(!list.isEmpty())
		{
			double min = Double.MAX_VALUE;
			primList.add(list.remove(candidate));
		
			for(int i=0; i<primList.size(); i++)
			{
				Point p1 = primList.get(i);
				
				for(int j=0; j<list.size(); j++)
				{
					Point p2 = list.get(j);
					distance = p1.getDistance(p2);
					if(distance < min)
					{
						min = distance;
						candidate = j;
					}
				}
			}
			
			if(result < min)
			{
				result = min;
			}
		}
		
		return result;
	}
}

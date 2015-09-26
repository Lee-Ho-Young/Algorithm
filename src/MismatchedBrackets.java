import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Scanner;

public class MismatchedBrackets 
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int count = Integer.parseInt(scanner.nextLine()); // store the number of test
				
		while(count-- > 0)
		{	
			String brackets = scanner.nextLine();
			
			long before = System.currentTimeMillis(); // for time measure
			
			int index = 0;
			boolean flag = true;
			Stack<Character> stack = new Stack<Character>();
		
			while(index < (brackets.length())) //index starts from 0
			{
				if(brackets.charAt(index) == ')')
				{
					try{
						if(stack.pop() != '(')
						{
							flag = false;
							break;
						}
					}
					catch(EmptyStackException e)
					{
						flag = false;
					}
				}
				else if(brackets.charAt(index) == '}')
				{
					try{
						if(stack.pop() != '{')
						{
							flag = false;
							break;
						}
					}
					catch(EmptyStackException e)
					{
						flag = false;
					}
				}
				else if(brackets.charAt(index) == ']')
				{	
					try{
						if(stack.pop() != '[')
						{
							flag = false;
							break;
						}
					}
					catch(EmptyStackException e)
					{
						flag = false;
					}
				}
				else
				{
					stack.push(brackets.charAt(index));
				}
				
				index++;
			}
		
			if(stack.empty() && flag)
				System.out.println("Yes");
			else
				System.out.println("No");
			
			long after = System.currentTimeMillis();
			long processingTime = after - before;
			System.out.println("Time elapsed : " + processingTime + " ms");
		
		}	
		
	}
}

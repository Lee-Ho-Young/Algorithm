import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Scanner;

public class MismatchedBrackets 
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int count; // counting the test cases
		count = Integer.parseInt(scanner.nextLine()); // store the number of test
		
		
		if(count >= 1 && count <= 100){} //if count value is valid then, do nothing
		else
		{
			System.out.println("Wrong input");
			return;
		}
			
		while(count > 0)
		{
			count--;
			
			String brackets = scanner.nextLine();
			int index = 0;
			boolean flag = true;
			Stack<Character> stack = new Stack<Character>();
		
			while(index <= (brackets.length()-1)) //index starts from 0
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
			
			if(!stack.empty())
				flag = false;
			
			if(flag)
				System.out.println("Yes");	
			else
				System.out.println("No");
		
		}	
	}
}

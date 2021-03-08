package algo.problem.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon10828 {

	public static int[] stack;
	public static int size = 0;
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String command = "";
		int data = 0;
		
		stack = new int[Integer.parseInt(s)];
		for(int i=0; i<Integer.parseInt(s); i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			command = st.nextToken();
			
			if(command.equals("push"))
				data = Integer.parseInt(st.nextToken());
			
			switch(command) {
			case "push":
				push(data);
				break;
			case "pop":
				sb.append(pop()).append('\n');
				break;
			case "size":
				sb.append(size()).append('\n');
				break;
			case "empty":
				sb.append(empty()).append('\n');
				break;
			case "top":
				sb.append(top()).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}
	
	public static void push(int data) {
		stack[size] = data;
		size++;
	}
	
	public static int pop() {
		if(size == 0) {
			return -1;
		} else {
			int resp = stack[size-1];
			stack[size-1] = 0; //필요없지 않을까?
			size--;
			return resp;
		}
	}
	
	public static int size() {
		return size;
	}
	
	public static int empty() {
		if(size == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int top() {
		if(size == 0) {
			return -1;
		} else {
			return stack[size-1];
		}
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClockSync {

	 static int button[][] = new int[][]{
         {0, 1, 2},
         {3, 7, 9, 11},
         {4, 10, 14, 15},
         {0, 4, 5, 6, 7},
         {6, 7, 8, 10, 12},
         {0, 2, 14, 15},
         {3, 14, 15},
         {4, 5, 7, 14, 15},
         {1, 2, 3, 4, 5},
         {3, 4, 5, 9, 13}
	 };

	 static int clock[] = new int[16];
	 
	 static int solveFlow[] = {1,4,2,9,3,7,8,0,5,6};
	 static int solveClockFlow[][] = {
			 {1},
			 {11},
			 {10},
			 {6},
			 {8,12},
			 {0,2},
			 {3,14,15},
			 {7},
			 {4,5},
			 {9,13}
	 };
	 
	 
	public static void main(String[] args) throws FileNotFoundException {
		
		//Scanner sc = new Scanner(System.in);
		File file = new File("C:/Develop/workspace/Algorithm/resource/ClocksyncExample.txt");
		Scanner sc = new Scanner(file);
		int C = sc.nextInt();
		
		while(C-- > 0) {
		
			int cnt = 0;
			
			for(int i=0; i<16; i++) {
				clock[i] = sc.nextInt();
			}
			
			//if the initial clock state is perfect then, no btn press need
			if(isSolved()) {
				System.out.println(cnt);
				continue;
			}
	
			for(int i=0; i<10; i++) {
				if(solve(i) == -1) {
					cnt = -1;
					break;
				} else {
					cnt += solve(i);
				}
				
				if(isSolved()) {
					break;
				}
				
			}

			System.out.println(cnt);
		}
		
	}
	
	// Adjust each clock
	public static int solve(int flow) {
	
		//1. check the clock that affected by the button
		boolean check = true;	
		for(int i=0; i<solveClockFlow[solveFlow[flow]].length; i++) {
				if (clock[solveClockFlow[solveFlow[flow]][i]] != 12)
					check = false;
			}		
		if(check)
			return 0;
		
		//2. press the button if the initial state is false
		for(int i=0; i<3; i++) {
			push(solveFlow[flow]);
			
			check = true;
			for(int j=0; j<solveClockFlow[solveFlow[flow]].length; j++) {
				if (clock[solveClockFlow[solveFlow[flow]][j]] != 12)
					//System.out.println("Log1 : " + clock[solveClockFlow[solveFlow[flow]][j]]);
					check = false;
			}
			
			if(check) {
				System.out.println("Log1 : " + i+1);
				return i+1;
			}
		}
		
		//3. it still not returned then, it means it cannot be solved
		return -1;
	}
	
	public static boolean isSolved() {
		
		for(int i=0; i<16; i++) {
			if(clock[i] != 12)
				return false;
		}
		
		return true;
	}
	
	public static void push(int btnNum) {
		
		for(int i=0; i<button[btnNum].length; i++) {
			clock[button[btnNum][i]] += 3;
			if(clock[button[btnNum][i]] == 15)
				clock[button[btnNum][i]] = 3;
		}
	}
}

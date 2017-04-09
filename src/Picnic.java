import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Picnic {

	static boolean[][] relation;
	static boolean[][][] possibleCoupleList;
	
	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("C:/Develop/workspace/Algorithm/resource/picnicExample.txt");
		Scanner sc = new Scanner(file);
	
		int C = sc.nextInt(); //Number of Test Cases
		while(C-- > 0) {
		
			sc.nextLine(); //To remove line-feed
			
			int studentsNumber = sc.nextInt();
			relation = new boolean[studentsNumber][studentsNumber];
			
/*			//initialize the relation of students as false at first
			for(int i=0; i<studentsNumber; i++)
				for(int j=0; j<studentsNumber; j++) 
					relation[i][j] = false;*/
			
			
			int coupleNumber = sc.nextInt();
			sc.nextLine(); //To remove line-feed
			
			//Set the relation of students
			for(int i=0; i<coupleNumber; i++) {
				int student1 = sc.nextInt();
				int student2 = sc.nextInt();
				
				relation[student1][student2] = true;
				relation[student2][student1] = true;
			}
			
			solve(studentsNumber); 
		}
	}
	
	public static void solve(int studentsNumber) {
		
		//The first Dimension of below Array means a possible way of coupling
		//We set the Maximum number of coupling to "studentsNumber combination 2" which is
		//  the case of all the students can be coupled
		
		int max_cnt = cal(studentsNumber);
		//System.out.println("Log 1 : max_cnt : " + max_cnt);
		possibleCoupleList = new boolean[max_cnt][studentsNumber][studentsNumber];
		//false is the default value of boolean array, so we don't have to initialize
		
		//cnt means the possible number of coupling
		int max = -1;
		for(int i=0; i<studentsNumber; i++) 
			for(int j=0; j<studentsNumber; j++) {
				for(int cnt=0; cnt<max_cnt; cnt++) {
					
					if(max < cnt)
						max = cnt;
					
					if(relation[i][j] == true) {
						//in case of True
						//set True, if its row and column don't have any True
						boolean check = searchTrue(i,j,studentsNumber, cnt);
						
						if(check) {
							continue; //already exist case so, we set another case
						} else {
							possibleCoupleList[cnt][i][j] = true;
							possibleCoupleList[cnt][j][i] = true;
							continue;
						}
					} else {
						break;
					}
				}
			}
		
		System.out.println(max+1);
		
		
/*		for(int i=0; i<max_cnt; i++) {
			System.out.println("Log 2 : 학생수 :" + studentsNumber + ", cnt:" + i + " 케이스");
			for(int j=0; j<studentsNumber; j++) {
				for(int k=0; k<studentsNumber; k++) {
					System.out.print(possibleCoupleList[i][j][k] + " ");
				}
				System.out.println("");
			}
		}*/
	}
	
	public static boolean searchTrue(int i, int j, int studentsNumber, int cnt) {
		
		if(possibleCoupleList[cnt][i][j]) //해당 자리가 T인 경우는 이미 세어진 것이기에 다음 케이스로
			return false;
		
		for(int k=0; k<studentsNumber; k++)
			if(possibleCoupleList[cnt][i][k] || possibleCoupleList[cnt][k][j])
				return true; 
		
		return false;
	}
	
	//factorial function
	public static int cal(int studentsNumber) {
		if(studentsNumber > 2) {
			return ((studentsNumber-1) * cal(studentsNumber-2));
		} else {
			return 1;
		}
			
	}
}

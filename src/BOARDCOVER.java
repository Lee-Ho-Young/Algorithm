import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class BOARDCOVER {
	
	static boolean[][] board;
	static int row;
	static int col;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		//File file = new File("C:/Develop/workspace/Algorithm/resource/boardCoverExample.txt");
		//Scanner sc = new Scanner(file);
		
		Scanner sc = new Scanner(System.in);
		int CASE = sc.nextInt();
		while(CASE-- > 0) {
			
			row = sc.nextInt();
			col = sc.nextInt();
			sc.nextLine(); // to remove lien-feed
			
			board = new boolean[row][col]; //default setting is fault!
			
			//board input setting
			for(int i=0; i<row; i++) {
				String oneRow = sc.nextLine();
				
				for(int j=0; j<col; j++) {
					if(oneRow.charAt(j) == '#') {
						board[i][j] = true; //이미 채워진 칸을  true세팅
					}
				}
			}
			
			int result = 0; // 알고리즘의 최종 결과
			int count = 0; // 블록이 들어갈 수 있는 칸의 갯수
			
			//초기에 남은 칸의 갯수가 3의 배수인지 아닌지 확인
			for(int i=0; i<row; i++) 
				for(int j=0; j<col; j++) {
					if(!board[i][j])
						count++;
				}
			
			//System.out.println("Log1 : empty block count = " + count);
			
			if(count == 0) {
				result = 0;
			} else if((count % 3)==0) {
				result = solve(board, 0, 0);
			} else {
				result = 0;
			}
 				
			System.out.println(result);
		}
	}

	public static int solve(boolean[][] board, int x, int y) {
		//여기서 4개의 케이스를 넣어주면서 다시 재귀함수
		int returnValue = 0;
		//돌고 있는 열의 마지막에 도달하면 다음 행으로
		if(x == col) {
			returnValue += solve(board, 0, y+1);
			return returnValue;
		} 
		//보드 전체를 돌았을 경우
		else if(y == row) {
			return 1;
		}
		//현재 확인하는 칸이 이미 채워져 있으면 다음 열로 이동
		else if(board[y][x]) {
			returnValue += solve(board, x+1, y);
			return returnValue;
		}
		
		//현재 행열의 마지막에 도달하지도 않고, 현재 보는 칸이 이미 채워져 있지 않을 경우
		//4개의 블록모양 케이스에 대해 board를 변경한 후 각 케이스에 대해서 재귀호출
		//재귀호출 후에는 지속적인 board재사용을 위해 board 원상복구
		
		//Case1 : ㄱ -> (0,0), (0,1), (1,1)
		for(int i=0; i<1; i++) {
			
			if((x+1 >= col) || (y+1 >= row))
				break;
			
			if((board[y][x+1]==true) || (board[y+1][x+1]==true))
				break;
			board[y][x] = true;
			board[y][x+1] = true;
			board[y+1][x+1] = true;
			
			returnValue += solve(board, x+1, y);
			
			board[y][x] = false;
			board[y][x+1] = false;
			board[y+1][x+1] = false;
		}
		
		//Case2 : ㄴ -> (0,0), (1,0), (1,1)
		for(int i=0; i<1; i++) {
			
			if((x+1 >= col) || (y+1 >= row))
				break;
			
			if((board[y+1][x]==true) || (board[y+1][x+1]==true))
				break;
			
			board[y][x] = true;
			board[y+1][x] = true;
			board[y+1][x+1] = true;
			
			returnValue += solve(board, x+1, y);
			
			board[y][x] = false;
			board[y+1][x] = false;
			board[y+1][x+1] = false;
		}
		
		//Case3 : ㄱ좌우반전 -> (0,0), (0,1), (1,0)
		for(int i=0; i<1; i++) {
			
			if((x+1 >= col) || (y+1 >= row))
				break;
						
			if((board[y][x+1]==true) || (board[y+1][x]==true))
				break;
			
			board[y][x] = true;
			board[y][x+1] = true;
			board[y+1][x] = true;
			
			returnValue += solve(board, x+1, y);
			
			board[y][x] = false;
			board[y][x+1] = false;
			board[y+1][x] = false;
		}
		
		//Case4 : ㄴ좌우반전 -> (0,0), (1,0), (1,-1)
		for(int i=0; i<1; i++) {
			
			if((x-1 < 0) || (y+1 >= row))
				break;
			
			if((board[y+1][x]==true) || (board[y+1][x-1]==true))
				break;
						
			board[y][x] = true;
			board[y+1][x] = true;
			board[y+1][x-1] = true;
			
			returnValue += solve(board, x+1, y);
			
			board[y][x] = false;
			board[y+1][x] = false;
			board[y+1][x-1] = false;
		}
			
		return returnValue;
		
	}
	
}

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
						board[i][j] = true; //�̹� ä���� ĭ��  true����
					}
				}
			}
			
			int result = 0; // �˰����� ���� ���
			int count = 0; // ����� �� �� �ִ� ĭ�� ����
			
			//�ʱ⿡ ���� ĭ�� ������ 3�� ������� �ƴ��� Ȯ��
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
		//���⼭ 4���� ���̽��� �־��ָ鼭 �ٽ� ����Լ�
		int returnValue = 0;
		//���� �ִ� ���� �������� �����ϸ� ���� ������
		if(x == col) {
			returnValue += solve(board, 0, y+1);
			return returnValue;
		} 
		//���� ��ü�� ������ ���
		else if(y == row) {
			return 1;
		}
		//���� Ȯ���ϴ� ĭ�� �̹� ä���� ������ ���� ���� �̵�
		else if(board[y][x]) {
			returnValue += solve(board, x+1, y);
			return returnValue;
		}
		
		//���� �࿭�� �������� ���������� �ʰ�, ���� ���� ĭ�� �̹� ä���� ���� ���� ���
		//4���� ��ϸ�� ���̽��� ���� board�� ������ �� �� ���̽��� ���ؼ� ���ȣ��
		//���ȣ�� �Ŀ��� �������� board������ ���� board ���󺹱�
		
		//Case1 : �� -> (0,0), (0,1), (1,1)
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
		
		//Case2 : �� -> (0,0), (1,0), (1,1)
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
		
		//Case3 : ���¿���� -> (0,0), (0,1), (1,0)
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
		
		//Case4 : ���¿���� -> (0,0), (1,0), (1,-1)
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

import java.util.LinkedList;
import java.util.Scanner;

public class Boggle2 {
	
	static Scanner sc = new Scanner(System.in);
	static int C; // Number of TestCases
	static char[][] board; // boggle board in char
	static Tile[][] tileArray; // boggle board in Tile
	static LinkedList<Tile>[] startSet; // Array of 26 LinkedLists and each means alphabet 
	static int N; // Number of Words that should be searched on boggle
	static String[] wordArray;
	static String word;
	
	static int[] xValue = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] yValue = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) {
		
		C = sc.nextInt();
		sc.nextLine(); // get rid of line-feed
		
		//Each loop means each TestCase
		while(C-- > 0) {
			
			//Set the boggle board in char
			board = new char[5][5];
			
			for(int i=0; i<5; i++) {
				word = sc.nextLine();
				for(int j=0; j<5; j++) {
					board[i][j] = word.charAt(j);
				}
			}
			
			/*1. Set the boggle board in Tile class*/
			tileArray = new Tile[5][5];
			
				/*1) Set the tileArray with Tiles that only contain letter not neighbors*/	
			for(int i=0; i<5; i++) 
				for(int j=0; j<5; j++)
					tileArray[i][j] = new Tile(board[i][j]);
					
					
				/*2) Set neighbors within Tiles on tileArray : '5*5'�� �� Ÿ�Ͽ� ������ Ÿ���� ���ĺ�(8���� ���̽�)��  neighbor�� ����*/
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					for(int k=0; k<8; k++) {
						
						int x = i + xValue[k];
						int y = j + yValue[k];
						
						//when adjacent Tile is within the board
						if(x>=0 && y>=0 && x<5 && y<5) {
							Tile neighbor = tileArray[x][y];
							tileArray[i][j].neighbors[neighbor.letter - 'A'].add(neighbor);
							//System.out.println("Log 0 : i =" + i + " j = " + j + " neighbor = " + neighbor.letter);
						}
							
						
					}
				}
			}
			
			/*2. Set the StartSet*/
			startSet = new LinkedList[26]; //each LinkedList in the startSet means Alphabet
			
			for(int i=0; i<26; i++)
				startSet[i] = new LinkedList<Tile>();
				
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					char tempLetter = tileArray[i][j].letter; 
					//5*5 tileArray�� �� Ÿ�ϵ��� ���ĺ� ��ġ�� �ٿ���
					startSet[tempLetter - 'A'].add(tileArray[i][j]);
				}
			}
			
			N = sc.nextInt(); //�Է¹��� �ܾ��� ����
			sc.nextLine(); // To get rid of line-feed
			
			wordArray = new String[N];
			for(int i=0; i<N; i++)
				wordArray[i] = sc.nextLine();
			
			/*3. Find each word from the boggle board*/
			for(int i=0; i<N; i++) {
				
				if(solve(wordArray[i])) {
					System.out.println(wordArray[i] + " YES");
				} else {
					System.out.println(wordArray[i] + " NO");
				}
			}			
		}
	}
	
	public static boolean solve(String currWord) {
		
		LinkedList<Tile> currSet = startSet[currWord.charAt(0) - 'A']; //���� ���ĺ��� ������ Ÿ�ϵ�
		LinkedList<Tile> nextSet = new LinkedList<Tile>(); // ������ ã�� ���ĺ��� ������ Ÿ�ϵ�
		
		/*1) ù��° �ܾ �����ǿ��� ã�� �� ������ false*/
		if(currSet.isEmpty())
			return false;

		/*2) ���� ���ĺ��� ������ Ÿ�ϵ��� �ѷ��� �༮�� ��, ���� ���ĺ��� ������ nextSet�� ����*/
		for(int i=1; i<currWord.length(); i++) {
				//System.out.println("Log1 : " + currWord + " index : " + i);
			char nextChar = currWord.charAt(i);
				//System.out.println("Log2 : " + currWord.charAt(i));
			for(Tile currTile : currSet)
				for(Tile nextTile : currTile.neighbors[nextChar - 'A']) 
					if(!nextSet.contains(nextTile)) {
						nextSet.add(nextTile);
						//System.out.println("Log3 : nextSet.contains(nextTile) " + nextSet.contains(nextTile) );
					}
			
			currSet = nextSet;
			nextSet = new LinkedList<>();
		}
		
		/*3) ������ ���ĺ����� for���� ��������, ������ Ÿ�Ͽ��� ���� ���ĺ��� ã�� �� ���� ��� currSet�� ������� ��*/
		if(currSet.isEmpty())
			return false;
		else 
			return true;
	}
	
}

class Tile {
	final char letter;
	final LinkedList<Tile>[] neighbors = new LinkedList[26];
	
	Tile(char letter) {
		this.letter = letter;
		for(int i=0; i<26; i++)
			neighbors[i] = new LinkedList<>();

	}
}

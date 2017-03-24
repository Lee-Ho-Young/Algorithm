import java.util.Scanner;

public class Boggle {
	
	static char[][] boggle = new char[5][5];
	static int[] xValue = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] yValue = {-1, -1, -1, 0, 1, 1, 1, 0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//set the number of cases
		int cases = sc.nextInt();
		sc.nextLine();
		
		while(cases-- > 0) {
					
			//set the boggle board
			for(int i=0 ; i<5; i++) {
				String boggleString = sc.nextLine();
				for(int j=0; j<5; j++) {
					boggle[i][j] = boggleString.charAt(j);
				}
			}
			
			//set the words that should be found
			int numberOfWord = sc.nextInt();
			sc.nextLine(); // to erase lineFeed in Input Stream
			
			String[] words = new String[numberOfWord];
			for(int i=0; i<numberOfWord; i++)
				words[i] = sc.nextLine();
			
	
			// find words in the boggle board
			for(int i=0; i<numberOfWord; i++) {
				
				boolean result = false;
				
				for(int j=0; j<5; j++) {
					for(int k=0; k<5; k++) {
						//if the word is found, escape the for loop
						result = hasWord(j, k, words[i]);
						//System.out.println("Log2 : " + result);
						if(result) 
							break;
						
					}
					
					//if the word is found, escape the upper for loop
					if(result)
						break;
				}
				
				if(result) {
					System.out.println(words[i] + " YES");
				} else {
					System.out.println(words[i] + " NO");
				}
			}
		}
	}
	
	public static boolean hasWord(int i, int j, String word) {
		
		//System.out.println("Log1 " + i + " " + j + " " + word);
		if(i<0 || i>4 || j<0 || j>4) 
			return false;
		
		if(boggle[i][j] != word.charAt(0)) 
			return false;
		
		if(word.length() == 1)
			return true;
		
		//8 cases of boggle game
		for(int x=0; x<8; x++)
			if(hasWord(i+xValue[x], j+yValue[x], word.substring(1)))
				return true;
			
		return false;
	}

}

import java.util.Scanner;

public class BoggleMine {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		//for delete line feed
		sc.nextLine();
		
		while(cases-- > 0) {
			
			char[][] boggle = new char[5][5];
			
			for(int i=0; i<5; i++) {
				
				String boggleInput = sc.nextLine();
				
				//Set the Boggle
				for(int j=0; j<5; j++) 
					boggle[i][j] = boggleInput.charAt(j);
			}
			
			//words that should be checked
			int wordsCount = sc.nextInt();
			sc.nextLine();
			String[] stringWordsArray = new String[wordsCount];
			for(int i=0; i<wordsCount; i++)
				stringWordsArray[i] = sc.nextLine();
			
			for(int i=0; i<wordsCount; i++) {
				
				boolean isWordInIt = checkWord(boggle, stringWordsArray[i]);
				if(isWordInIt) {
					System.out.println(stringWordsArray[i] + " YES");
				} else {
					System.out.println(stringWordsArray[i] + " NO");
				}
			}
		}
	}
	
	public static boolean checkWord(char[][] boggle, String word) {
		
		boolean isWordInIt = false;
		
		//단어의 각 알파벳들의 좌표를 표현해줄 int형 변수들
		int[] boggleX = new int[50];
		int[] boggleY = new int[50];
		int count = 0;
		
		//단어의 첫번째 위치 발견
		for(int i=0; i<5; i++) 
			for(int j=0; j<5; j++)
				if(boggle[i][j] == word.charAt(0)) {
					boggleX[count] = i;
					boggleY[count] = j;
					count++;
				}
		// Return when the first character not found
		if(count == 0)
			return false;
		
		
		
		
		
		for(int i=0; i<count; i++) {
			
			for(int wordLength=1; wordLength < word.length(); wordLength++) {
				
				if(boggleX[i] == 0) {
					
					if(boggleY[i] == 0) {
						if(word.charAt(wordLength) == boggle[1][0]) {
							continue;
						}
					} else if(0 < boggleY[i] && boggleY[i] < 4) {
						
					} else { // when boggleY[i] == 4
						
					}
					
				} else if(0 < boggleX[i] && boggleX[i] < 4) {
					
					if(boggleY[i] == 0) {
						
					} else if(0 < boggleY[i] && boggleY[i] < 4) {
						
					} else { // when boggleY[i] == 4
						
					}
					
				} else { // when boggleX[i] == 4 
					
					if(boggleY[i] == 0) {
						
					} else if(0 < boggleY[i] && boggleY[i] < 4) {
						
					} else { // when boggleY[i] == 4
						
					}
				}
			}
			
			
			
			
			
		}
		
		return false;
	}

}

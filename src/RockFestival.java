import java.util.Scanner;

public class RockFestival {
	
	static int[] cost = new int[1000];
	static int N = 0;
	static double avgCost = Double.MAX_VALUE;
	
	public static void main(String[] args) {
		
		/*사용할 변수 정의*/
		int cases = 0; // testCase 갯수
		
		/*입력을 받아들일  Scanner 변수*/
		Scanner sc = new Scanner(System.in);
		
		/*입력받은 Case의 갯수만큼 돌리겠다*/
		cases = sc.nextInt();
		
		for(int i = 0; i < cases; i++ ) {
			
			/*set variable*/
			N = sc.nextInt(); //대여 가격을 알고 있는 N일
			int L = sc.nextInt(); //대여기간 동안의 하루평균 대여가격을 확인해 봐야할 최소 대여기간 L
			
			for(int j=0; j<N; j++)
				cost[j] = sc.nextInt();	
				
			// 체크해야 할 최소 대여일과 주어진 최대일 사이에서의 가격 체크
			double minAvgCost = Double.MAX_VALUE;
			
			for(int j=L; j<=N; j++)
				minAvgCost = Math.min(minAvgCost, average_cost(j, 0, 0));
						
			System.out.println(minAvgCost);
		}	
	}
	
	// 최소 평균대여비용 구하기
	public static double average_cost(int days, int index, double sum) {
		
		if(index > N - days) {
			return Double.MAX_VALUE;
		} else if(index > 0) {
			sum = sum - cost[index-1] + cost[index+days-1];
		} else { // when index equals 0
			for(int i=0; i<days; i++) {
				sum += cost[i];
			}
		}
		
		avgCost = sum / days;
		//System.out.println("Log1 : " + avgCost);
		return avgCost = Math.min(avgCost, average_cost(days, index+1, sum));
	}
}

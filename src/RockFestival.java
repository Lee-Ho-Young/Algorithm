import java.util.Scanner;

public class RockFestival {
	
	public static void main(String[] args) {
		
		/*사용할 변수 정의*/
		int cases = 0; // testCase 갯수
		
		/*입력을 받아들일  Scanner 변수*/
		Scanner sc = new Scanner(System.in);
		
		/*입력받은 Case의 갯수만큼 돌리겠다*/
		cases = sc.nextInt();
		
		for(int i = 0; i < cases; i++ ) {
			
			/*set variable*/
			int N = sc.nextInt(); //대여 가격을 알고 있는 N일
			int L = sc.nextInt(); //대여기간 동안의 하루평균 대여가격을 확인해 봐야할 최소 대여기간 L
			int[] cost = new int[N];
			
			for(int j=0; j<N; j++)
				cost[j] = sc.nextInt();	
				
			// 체크해야 할 최소 대여일과 주어진 최대일 사이에서의 가격 체크
			double minAvgCost = Double.MAX_VALUE;
			
			for(int j=L; j<=N; j++)
				minAvgCost = Math.min(minAvgCost, average_cost(j, cost));
						
			System.out.println(minAvgCost);
		}	
	}
	
	// 최소 평균대여비용 구하기
	public static double average_cost(int days, int[] cost) {

		double avgCost = Double.MAX_VALUE;
		
		//몇 번의 계산을 해야 하는지 알아보자
		for(int i=0; i<(cost.length-days+1); i++) {
			double sum = 0;
			double minTemp = 0;
			
			for(int j=i; j<i+days; j++) 
				sum += cost[j];
			
			minTemp = sum / days;
			avgCost = Math.min(avgCost, minTemp);
			}
		
		return avgCost;
	}
}

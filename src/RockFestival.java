import java.util.Scanner;

public class RockFestival {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String temp1;
		int temp2;
		String[] temp3;
		
		// Case의 갯수만큼 돌리겠다.
		temp2 = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < temp2; i++ ) {
			
			temp1 = sc.nextLine();
			temp3 = temp1.split(" ");
			
			// 대여 가격을 알고 있는 N일
			int N = Integer.parseInt(temp3[0]);
			
			// 대여기간 동안의 하루평균 대여가격을 확인해 봐야할 최소 대여기간 L
			int L = Integer.parseInt(temp3[1]);
			
			temp1 = sc.nextLine();
			temp3 = temp1.split(" ");
			int[] cost = new int[temp3.length];
			
			// N일 동안의 하루대여 가격을 costs 배열에 저장
			for(int j=0; j<cost.length; j++) {	
				cost[j] = Integer.parseInt(temp3[j]);
			}
				
			// 체크해야 할 최소 대여일과 주어진 최대일 사이에서의 가격 체크
			double minAvgCost = Double.MAX_VALUE;
			double temp4;
			for(int j=L; j<=N; j++) {
				
				temp4 = average_cost(j, cost);
				
				//System.out.println("Log level2 : " + temp4);
				
				if(temp4 < minAvgCost)
					minAvgCost = temp4;
			}	
			
			System.out.println(minAvgCost);
		}	
	}
	
	// 최소 평균대여비용 구하기
	public static double average_cost(int days, int[] cost) {

		double avgCost = Double.MAX_VALUE;
		
		//몇 번의 계산을 해야 하는지 알아보자
		for(int i=0; i<(cost.length-days+1); i++) {
			double sum = 0.0;
			double temp1 = 0.0;
			
			for(int j=i; j<i+days; j++) {
				sum += cost[j];
			}
			
			temp1 = sum / days;
			//System.out.println("Log level1 : " + temp1);
			if(temp1 < avgCost)
				avgCost = temp1;
		}
		
		return avgCost;
	}
}

import java.util.Scanner;

public class RockFestival {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String temp1;
		int temp2;
		String[] temp3;
		
		// Case�� ������ŭ �����ڴ�.
		temp2 = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < temp2; i++ ) {
			
			temp1 = sc.nextLine();
			temp3 = temp1.split(" ");
			
			// �뿩 ������ �˰� �ִ� N��
			int N = Integer.parseInt(temp3[0]);
			
			// �뿩�Ⱓ ������ �Ϸ���� �뿩������ Ȯ���� ������ �ּ� �뿩�Ⱓ L
			int L = Integer.parseInt(temp3[1]);
			
			temp1 = sc.nextLine();
			temp3 = temp1.split(" ");
			int[] cost = new int[temp3.length];
			
			// N�� ������ �Ϸ�뿩 ������ costs �迭�� ����
			for(int j=0; j<cost.length; j++) {	
				cost[j] = Integer.parseInt(temp3[j]);
			}
				
			// üũ�ؾ� �� �ּ� �뿩�ϰ� �־��� �ִ��� ���̿����� ���� üũ
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
	
	// �ּ� ��մ뿩��� ���ϱ�
	public static double average_cost(int days, int[] cost) {

		double avgCost = Double.MAX_VALUE;
		
		//�� ���� ����� �ؾ� �ϴ��� �˾ƺ���
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

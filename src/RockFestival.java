import java.util.Scanner;

public class RockFestival {
	
	public static void main(String[] args) {
		
		/*����� ���� ����*/
		int cases = 0; // testCase ����
		
		/*�Է��� �޾Ƶ���  Scanner ����*/
		Scanner sc = new Scanner(System.in);
		
		/*�Է¹��� Case�� ������ŭ �����ڴ�*/
		cases = sc.nextInt();
		
		for(int i = 0; i < cases; i++ ) {
			
			/*set variable*/
			int N = sc.nextInt(); //�뿩 ������ �˰� �ִ� N��
			int L = sc.nextInt(); //�뿩�Ⱓ ������ �Ϸ���� �뿩������ Ȯ���� ������ �ּ� �뿩�Ⱓ L
			int[] cost = new int[N];
			
			for(int j=0; j<N; j++)
				cost[j] = sc.nextInt();	
				
			// üũ�ؾ� �� �ּ� �뿩�ϰ� �־��� �ִ��� ���̿����� ���� üũ
			double minAvgCost = Double.MAX_VALUE;
			
			for(int j=L; j<=N; j++)
				minAvgCost = Math.min(minAvgCost, average_cost(j, cost));
						
			System.out.println(minAvgCost);
		}	
	}
	
	// �ּ� ��մ뿩��� ���ϱ�
	public static double average_cost(int days, int[] cost) {

		double avgCost = Double.MAX_VALUE;
		
		//�� ���� ����� �ؾ� �ϴ��� �˾ƺ���
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

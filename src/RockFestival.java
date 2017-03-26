import java.util.Scanner;

public class RockFestival {
	
	static int[] cost = new int[1000];
	static int N = 0;
	static double avgCost = Double.MAX_VALUE;
	
	public static void main(String[] args) {
		
		/*����� ���� ����*/
		int cases = 0; // testCase ����
		
		/*�Է��� �޾Ƶ���  Scanner ����*/
		Scanner sc = new Scanner(System.in);
		
		/*�Է¹��� Case�� ������ŭ �����ڴ�*/
		cases = sc.nextInt();
		
		for(int i = 0; i < cases; i++ ) {
			
			/*set variable*/
			N = sc.nextInt(); //�뿩 ������ �˰� �ִ� N��
			int L = sc.nextInt(); //�뿩�Ⱓ ������ �Ϸ���� �뿩������ Ȯ���� ������ �ּ� �뿩�Ⱓ L
			
			for(int j=0; j<N; j++)
				cost[j] = sc.nextInt();	
				
			// üũ�ؾ� �� �ּ� �뿩�ϰ� �־��� �ִ��� ���̿����� ���� üũ
			double minAvgCost = Double.MAX_VALUE;
			
			for(int j=L; j<=N; j++)
				minAvgCost = Math.min(minAvgCost, average_cost(j, 0, 0));
						
			System.out.println(minAvgCost);
		}	
	}
	
	// �ּ� ��մ뿩��� ���ϱ�
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

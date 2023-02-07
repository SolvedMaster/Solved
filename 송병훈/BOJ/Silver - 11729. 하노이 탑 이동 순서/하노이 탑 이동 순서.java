import java.util.Scanner;

public class Main {
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoi(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}

	private static void hanoi(int n, int start, int tmp, int end) {
		
		if (n <= 0) return;
		
		hanoi(n-1, start, end, tmp);
		cnt += 1;
		sb.append(start + " " + end + "\n");
		hanoi(n-1, tmp, start, end);
	}
}

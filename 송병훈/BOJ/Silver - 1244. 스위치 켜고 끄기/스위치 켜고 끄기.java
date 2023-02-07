import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S;		// 스위치 수, 학생 수 -> 고정
	static int[] switchs;	// 스위치 상태 -> 변함
	static int gender, num;	// 성별, 번호 -> 입력 받을 때마다 덮어씌울 예정
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		switchs = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		
		S = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken()); // 성별
			num = Integer.parseInt(st.nextToken());	// 번호
			
			// switchs는 static이라 안 넘겨도 된다. 성별은 메소드를 특정했으니 상관없다.
			if (gender == 1) manChange(num);	
			else womanChange(num-1, 0);		// 스위치의 번호는 0이 아니라, 1부터 시작하므로 index를 하나 감소시켜 넘긴다.
		}
		
		//20줄씩 출력해야 한다.
		for (int i = 0; i < switchs.length; i++) {
			sb.append(switchs[i]).append(" ");
			if ((i+1) % 20 == 0) sb.append('\n');	// 스위치의 번호는 0이 아니라, 1부터 시작하므로 i+1 을 나눈다.
		}
		
		System.out.println(sb);
	}
	
	// 결과를 반환할 필요없이, switchs를 변경하기만 하면 된다.
	/**
	 * 남자 : 자기 번호의 배수인 스위치의 상태를 뒤집는다.
	 * @param num - 자기 번호
	 */
	private static void manChange(int num) {
		for (int i = 0; i < switchs.length; i++) {
			if ((i+1) % num == 0) {	// 스위치의 번호는 0이 아니라, 1부터 시작하므로 i+1 을 나눈다.
				change(i);
			}
		}
	}

	/**
	 * 여자 : 자기 번호를 중심으로, 대칭이 되는 범위만큼 상태를 뒤집는다.
	 * @param num - 자기 번호
	 */
	private static void womanChange(int num, int cnt) {
		if (num - cnt < 0 || num + cnt >= switchs.length) return;	// index가 범위를 벗어나면 종료
		
		if (switchs[num + cnt] != switchs[num - cnt]) {		// 대칭이 아니라면 종료
			return;
		} else {
			// 대칭이라면 바꾼다. 단, cnt가 0이라면 한번만 바꾼다.
			if (cnt == 0) {
				change(num);	
			} else {
				change(num + cnt);	
				change(num - cnt);	
			}
		}
		womanChange(num, cnt+1);
	}

	/**
	 * 0이면 1로, 1이면 0으로 바꾸는 메소드
	 * @param index
	 */
	private static void change(int index) {
		if (switchs[index] == 0) 
			switchs[index] = 1;
		else 
			switchs[index] = 0;
	}
}

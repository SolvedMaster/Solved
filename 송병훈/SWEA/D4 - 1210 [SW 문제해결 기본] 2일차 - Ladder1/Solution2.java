import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1210 {
	static int startIndex, test_case;	// 시작위치, 테스트케이스
	static int[][] map;
	static final int MAX = 100;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[MAX][MAX];	// 어차피 덮어씌워짐
		
		// 10번 반복하는 테스트 케이스
		for (int t = 1; t <= 10; t++) {
			// 입력받기
			test_case = Integer.parseInt(br.readLine());
			for (int i = 0; i < MAX; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()); // 100행 입력받음
				for (int j = 0; j < MAX; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 시작점 따로 저장 0행에서 1인 부분을 찾아서 저장해볼까?
			List<Integer> starts = new ArrayList<>();
			for (int i = 0; i < MAX; i++) {
				if (map[0][i] == 1) {
					starts.add(i);
				}
			}
			// 찾은 시작점에서 내려가볼까?
			for (int start : starts) {
				startIndex = start;	// 시작점 최신화 및 저장
				if (move(0, startIndex)) break;
			}
		}// test_case
	}
	
	/**
	 * 1. 내려가면서 좌,우에 1이 있는지 확인한다 (확인하는 범위는 0~99 사이로만)
	 * 2. 좌, 우에 1이 있다면 찾은 방향으로 0을 찾을 때까지 이동한다. j++, j--
	 * 3. 0을 만나면 0으로는 이동하지 않고, 아래로 다시 내려간다. (99행까지만 내려가면 됨)
	 * 4. 좌우에 1이 없다면 아래로 내려간다 : i++
	 */
	private static boolean move(int i, int j) {
		// ----- 기저조건 -----
		// 99번째 행까지 내려왔을 때, 그 수가 2이면 startIdx를 출력한다.
		if (i >= MAX) {		
			if (map[MAX-1][j] == 2) {
				System.out.printf("#%d %d\n", test_case, startIndex);
				return true;
			}
			return false;
		}
		// ----- 실행문 -----
		// 내려가다가 우측에 1이 있다면
		if (j+1 < MAX && map[i][j+1] == 1) {		
			// 우측으로 이동
			while(j+1 < MAX && map[i][j+1] == 1) {
				j += 1;
			}
		} 
		// 내려가다가 좌측에 1이 있다면
		else if (j-1 >= 0 && map[i][j-1] == 1) {
			// 좌측으로 이동
			while(j-1 >= 0 && map[i][j-1] == 1) {
				j -= 1;
			}
		}
		// 좌우로 다 이동하거나, 좌우로 이동할 수 없는 상황이면 아래로 i+1;
		// 재귀호출한다.
		return move(i+1, j);
	}
	
}

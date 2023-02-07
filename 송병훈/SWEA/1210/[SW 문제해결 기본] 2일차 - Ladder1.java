import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int result;	// 정답으로 출력할 시작위치
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("data/input1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[100][100];	// 어차피 덮어씌워짐
		
		// 10번 반복하는 테스트 케이스
		for (int t = 1; t <= 10; t++) {
			
			int test_case = Integer.parseInt(br.readLine());

			result = -1;
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()); // 100행 입력받음
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			// 0행에서 1인 부분을 찾아서 저장해볼까?
			List<Integer> start = new ArrayList<>();
			for (int i = 0; i < 100; i++) {
				if (map[0][i] == 1) {
					start.add(i);
				}
			}
			
			// 찾은 시작점에서 내려가볼까?
			for (int i = 0; i < start.size(); i++) {
				int startIndex = start.get(i);	// 시작점
				search(startIndex, map);
				if (result != -1) break;
			}
			
			System.out.printf("#%d %d\n", t, result);
			
		}// test_case
	}
	
	private static void search(int startIndex, int[][] map) {
		
		/* 
		 * 0. 시작점은 0행의 startIndex의 위치다.
		 * 1. 내려가면서 좌,우에 1이 있는지 확인한다 (확인하는 범위는 0~99 사이로만)
		 * 2. 좌, 우에 1이 있다면 찾은 방향으로 0을 찾을 때까지 이동한다.
		 * 3. 0을 만나면 0으로는 이동하지 않고, 아래로 다시 내려간다. (99행까지만 내려가면 됨)
		 */ 
		int i = 0;
		int j = startIndex;
		while (i < 100) {
			// 0~99 사이에 있고, 좌우에 1이 없다면 i를 증가시켜 아래로 이동한다.
//			if (j-1 >= 0 && j+1 < 100 && map[i][j+1] != 1 && map[i][j-1] != 1) {
//				i++;
//				continue;
//			} else 
			if (j+1 < 100 && map[i][j+1] == 1) {
				while(j + 1 < 100 && map[i][j+1] == 1) {
					j++;
				}
				i++;
				continue;
			} else if (j-1 >= 0 && map[i][j-1] == 1) {
				while(j-1 >= 0 && map[i][j-1] == 1) {
					j--;
				}
				i++;
				continue;
			}
			i++;
		}
		
		// 99번째 행까지 내려왔을 때, 그 수가 2이면 startIdx를 result에 저장한다.
		if (map[99][j] == 2) {
			result = startIndex;
		}
		
	}
}

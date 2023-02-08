package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			// String으로 Key값을 입력받으며, Value 부분은 1로 통일한다.
			map.put(br.readLine(), 1);
		}
		
		int cnt = 0;	// 듣도보도 못한 사람의 수
		List<String> name = new ArrayList<>();	// 원소의 개수를 알 수 없으므로 List 사용
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			// getOrDefault() :  
			// map에 첫번째 인자가 있으면 그에 해당하는 value를 반환하고	-> 1 반환 
			// 없으면 두번째 인자를 반환한다.						-> 0 반환
			if (map.getOrDefault(tmp, 0) == 1) {	// 이미 있어서 1을 반환하면
				cnt++;			// 이미 있으므로 개수를 세고
				name.add(tmp);	// name이라는 List에 넣는다.
			}
		}
		Collections.sort(name);	// 사전순 출력을 위해 정렬한다.
		
		sb.append(cnt).append('\n');		// 빠른 출력을 위해 StringBuilder에 삽입
		for(String result : name) {
			sb.append(result).append('\n');	// 빠른 출력을 위해 StringBuilder에 삽입
		}
		System.out.println(sb);				// 한 번만 출력함
	}
}

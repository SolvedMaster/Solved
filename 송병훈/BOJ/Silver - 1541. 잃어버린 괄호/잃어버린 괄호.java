import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		//빼기를 기준으로 자르면, 빼기만 하면 된다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split("-");
		int[] results = new int[inputs.length];
		// 입력받은 값에 + 가 있다면 그 문자열을 계산해주는 메소드를 호출함
    // 그리고 inputs에 저장된 문자열들을 숫자로 변환하여 results에 저장한다.
    for (int i = 0; i < inputs.length; i++) {
			if (inputs[i].contains("+")) {
				results[i] = change(inputs[i]);
			} else {
				results[i] = Integer.parseInt(inputs[i]);
			}
		}
    		// results[0] 에서 뒤의 수들을 뺀 값이 최솟값이 된다.
    		// 빼는 이유는 - 를 기준으로 나눴기 때문이다.
		int result = results[0];
		if (results.length > 1) {
			for (int i = 1; i < results.length; i++) {
				result -= results[i];
			}
		}
		System.out.println(result);
	}
  	// + 를 기준으로 다시 구분하여, 각 원소를 더하는 메소드 -> 더한 값을 반환한다.
	private static int change(String input) {
		String[] tmp = input.split("\\+");  // + 를 구분자로 사용할 때는 // 를 앞에 넣어줘야 한다.
		int sum = 0;
		for (String str : tmp) {
			sum += Integer.parseInt(str);
		}
		return sum;
	}
}

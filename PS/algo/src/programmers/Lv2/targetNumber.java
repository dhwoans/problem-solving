package programmers.Lv2;

/**
 * @packageName : programmers.Lv2
 * @fileName : targetNumber
 * @date : 2022-01-12
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class targetNumber {
    static int count;

    public  int solution(int[] numbers, int target) {
        int answer = 0;
        count = 0;
        Dfs(0, numbers.length , target, 0, numbers);
        answer = count;
        return answer;
    }

    private void Dfs(int start, int len, int target, int sum, int[] numbers) {
        if (start == len) {
            if (target == sum) {
                count++;
            }
            return;
        }
        int plus = sum + numbers[start];
        Dfs(start+1, len, target, plus, numbers);
        int min = sum - numbers[start];
        Dfs(start+1, len, target, min, numbers);

    }
}

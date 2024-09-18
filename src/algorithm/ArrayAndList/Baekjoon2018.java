package algorithm.ArrayAndList;

import java.util.Scanner;

//여기서의 투포인터 이동 원칙
/*sum > N: sum = sum - start_index; start_index++;
sum < N: end_index++; sum = sum + end_index;
sum == N: end_index++; sum = sum + end_index; count++;*/
public class Baekjoon2018 {
    public static void main(String[] args) {
        //투포인터 문제
        //연속된 자연수의 합 구하기
        /*
        * 어떠한 자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
        * 당신은 어떤 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 알고 싶다.
        * 이때 사용하는 자연수는 N이어야 한다.
        * 연속된 수로 이뤄저야 한다는 점!
        * 예를 들어, 10이라면 10, 1+2+3+4
        * */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int start_index =  1;
        int end_index = 1;
        int sum = 1;

        while(end_index != N) {
            if(sum==N){
                count++; end_index++; sum = sum + end_index;
            } else if(sum > N){
                sum = sum - start_index;
                start_index++;
            } else{
                end_index++; sum = sum + end_index;
            }
        }
        System.out.println(count);

    }
}

package algorithm.ArrayAndList;

import java.util.Scanner;
//총합 * 100 / 최고점수 / 과목의 수
public class Baekjoon1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //과목의 개수
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt(); //과목의 점수를 입력받음
        }
        long sum = 0;
        long max = 0;

        for (int i = 0; i < N; i++) {
            if(A[i] > max) max = A[i];
            sum += A[i]; //총합 구하기
        }
        System.out.println(sum*100.0/max/N);
    }
}

package algorithm.sorting;

import java.util.Scanner;

public class Baekjoon2750 {
    public static void main(String[] args) {
        //N개의 수가 주어졌을 때 오름차 순으로 정렬하는 프로그램을 작성하시오.
        //1번째 줄에 수의 개수 N, 2번째 줄부터 N개의 줄에 숫자가 주어진다.
        //이 수는 절댓값이 1000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
        // 이 문제를 버블정렬로 풀어보자
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt(); //배열에다가 정렬되지 않은 데이터들을 저장하는 과정
        }
        //버블 정렬을 구현하는 영역
        for(int i=0; i< N-1; i++){
            for(int j=0; j < N-1-i; j++){
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        for(int i=0; i<N; i++){
            System.out.println(A[i]);
        }

    }
}

package algorithm.sorting;

import java.util.Scanner;

public class Baekjoon1427 {
    public static void main(String[] args) {
        //선택정렬로 문제 풀어보기
        //배열을 정렬하는 것은 쉽다. 수가 주어지면 그 수의 각 자릿수를 내림차순으로 정렬하시오.
        //1번째 정렬할 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int A[] = new int[str.length()];
        for(int i =0; i<str.length(); i++){
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }
        //선택정렬
        for(int i =0; i<str.length(); i++){
            int Max = i;
            for(int j= i+1; j < str.length(); j++){
                if(A[j] > A[Max]){
                    Max = j; //최댓값을 찾는 과정!!
                }
            }
            if(A[i] < A[Max]){
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        for(int i=0; i < str.length(); i++){
            System.out.print(A[i]);
        }
    }
}

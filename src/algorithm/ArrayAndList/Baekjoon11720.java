package algorithm.ArrayAndList;

import java.util.Scanner;

public class Baekjoon11720 {
    //N개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.
    // 1번째 줄에 숫자의 개수 N(1에서 100까지), 2번째 줄에 숫자 N개가
    // 공백없이 주어진다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //스캐너로, 숫자의 개수 입력받기
        String sNum = sc.next(); // 나열된 숫자들 입력받기
        // String으로 받는 이유는 int,long으로는 받을 수 없음
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(int i=0; i<cNum.length; i++){
            sum += cNum[i] - '0';
            // - '0'의 의미는 - 48의 의미이다.
        }
        System.out.println(sum);

    }

}

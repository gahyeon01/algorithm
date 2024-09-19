package algorithm.ArrayAndList;
//슬라이딩 윈도우
//: 2개의 포인터로 범위를 지정한 다음, 범위를 유지한 채로 이동하며 문제를 해결함.
//O(n)으로 시간복잡도가 좋음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12891 {
    static int myArr[]; //전역변수로 선언
    static int checkArr[];
    static int checkSecret;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()); //한줄 읽은 거
        int S = Integer.parseInt(st.nextToken()); //문자열의 크기
        int P = Integer.parseInt(st.nextToken()); //부분문자열의 길이
        int Result =0;
        checkArr = new int[4];
        myArr = new int[4];
        char A[] = new char[S];
        checkSecret = 0;

        A = bf.readLine().toCharArray(); //DNA
        st = new StringTokenizer(bf.readLine()); // ACGT의 만족 개수들(수)
        for(int i = 0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0){ //checkSecret이 4가 되도록 만족시켜야 하는데,
                // checkArr[i] == 0이면 벌써 만족시켰다는 의미이므로,
                // 1+를 시켜주어서 달성률을 수정하는 느낌
                checkSecret++;
            }
        }

        for(int i=0; i<P; i++){ //부분문자열 처음 봤을 때 세팅
            Add(A[i]);
        }

        if(checkSecret == 4) Result++;

        //슬라이딩 윈도우
        for(int i=P; i<S; i++){ //i가 포인터의 오른쪽, j가 포인터의 왼쪽
            int j= i-P;
            Add(A[i]); //추가
            Remove(A[j]); //삭제
            if(checkSecret == 4) Result++;
        }

        System.out.println(Result);
        bf.close();


    }

    private static void Remove(char c) {
        switch(c){
            case'A':
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case'C':
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case'G':
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case'T':
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch(c){
            case'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecret++;
                break;
            case'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
            case'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}

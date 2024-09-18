package algorithm.ArrayAndList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//주몽의 명령
//갑옷의 경우, 2가지 재료의 고유한 번호를 합쳐서 만들어진다고 한다.
/*1번째 줄에 재료의 개수 N
2번째 줄에 갑옷을 만드는 데 필요한 수 M
3번째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어짐.*/
public class Baekjoon1940 {
    public static void main(String[] args) throws IOException {
        //재료의 개수
        //갑옷이 완성되는 번호의 합
        //재료들(한번쓰면 없어지는)
        //여기서의 투포인트 이동 원칙
        //번호의 합이 M보다 크므로 큰 번호 index를 내린다.
        //A[i] + A[j] > M: j--;
        //번호의 합이 M보다 작으므로 작은 번호를 index를 올린다.
        //A[i] + A[j] < M: i++;
        //양쪽 포인터를 모두 이동시키고 count를 증가시킨다.
        //A[i] + A[j] == M: i++; j++; count++;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); //오릉차순으로 배열 정리 메소드
        int count = 0;
        int i = 0; // A[0] -> Min
        int j = N-1; // A[N-1] -> Max
        while(i < j){
            if(A[i]+A[j] < M){
                i++;
            } else if (A[i]+A[j] > M) {
                j--;
            }else{
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);

    }
}

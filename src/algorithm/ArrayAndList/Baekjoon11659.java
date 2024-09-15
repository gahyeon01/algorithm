package algorithm.ArrayAndList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하는 프로그램을 작성하시오.
* 1번째 줄에 수의 개수 N, 합을 구해야 하는 횟수 M,
* 2번째 줄에 N개의 수가 주어진다. 각 수는 1,000보다 작거나 같은 자연수이다.
* 3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다.
*
* */
public class Baekjoon11659 {
    public static void main(String[] args) throws IOException {
    //합 배열 공식과 구간 합 공식 이용하기!
        //받는 데이터가 많을 때는 스캐너보다 버퍼리더가 더 좋음(빠르기 때문에)
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
    //StringTokenizer클래스는 문자열을 우리가 지정한 구분자로 문자열을 쪼개주는 클래스다.
    // 그렇게 쪼개어진 문자열을 토큰(token)이라고 부른다.
    //생성자 constructor
        //StringTokenizer(String str);
        //절달된 매개변수 str을 기본(default) delim으로 분리한다. 기본 delimiter는 공백 문자들인 " \t\n\r\t"이다.
        //StringTokenizer(String str,String delim);
        //특정 delim으로 문자열을 분리한다.
        //StringTokenizer(String str,String delim,boolean returnDelims);
        //str을 특정 delim으로 분리시키는데 그 delim까지 token으로 포함할지를 결정한다. 그 매개변수가 returnDelims로 true일시 포함, false일땐 포함하지 않는다.
        //int countTokens()
        //남아있는 token의 개수를 반환합니다. 전체 token의 갯수가 아닌 현재 남아있는 token 개수입니다.
        //boolean hasMoreElements(), boolean hasMoreTokens()
        //다음의 token을 반환합니다. StringTokenizer는 내부적으로 어떤 위치의 토큰을 사용하였는지 기억하고 있고 그 위치를 다음으로 옮깁니다. 두가지 메소드는 모두 같은 값을 반환합니다.
        //Object nextElement(), String nextToken()
        //이 두가지 메소드는 다음의 토큰을 반환합니다. 두가지 메소드는 같은 객체를 반환하는데 반환형은 다르네요. nextElement는 Object를, nextToken은 String을 반환하고 있습니다.

        StringTokenizer stringTokenizer =
                new StringTokenizer(bufferedReader.readLine()); //한줄을 버퍼드 리더에서 가져올 수 있도록
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int qizNo = Integer.parseInt(stringTokenizer.nextToken());

        long[] S = new long[suNo+1]; //인덱스 0자리를 1번째 자리로 인식하고 싶어서 +1
        stringTokenizer =
                new StringTokenizer(bufferedReader.readLine()); //위에서 readline해서 읽은 줄 말고 그 다음 줄을 갖고 오게됨!
        for(int i=1; i<=suNo; i++){
            //합배열 공식을 이용해서 합배열 바로바로 만들어 놓기
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for(int q=0; q < qizNo; q++){
            stringTokenizer =
                    new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }

    }
}

package algorithm.StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//절대값 힙 구현하기
/* 절댓값 힙이라는 다음과 같은 연산을 지원하는 자료구조가 있다고 하자.
(1) 배열에 정수 x(0은 아님)을 넣는다.
(2) 배열에서 절댓값이 가장 작은 값을 출력한 후 그 값을 배열에서 제거한다.
절댓값이 가장 작은 값이 여러 개일 경우에는 그중 가장 작은 수를 출력하고, 그 값을 배열에서
제거한다.

데이터가 새로 삽입될 때마다 절댓값과 관련된 정렬이 필요하므로 우선순위 큐로 문제를 쉽게
해결할 수 있다. 하지만 절댓값 정렬이 필요하므로 우선순위 큐의 정렬 기준을 직접 정의해야 한다.
* */
public class Baekjoon11286 {
    public static void main(String[] args) throws IOException {
        //우선순위 큐에 대한 알고리즘 문제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //우선순위 큐 선언하기
        //선언만 한 경우
//        PriorityQueue<Integer> myQueue = new PriorityQueue<>();
        //선언과 정렬 기준까지 정하는 방법
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1,o2)->{
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs){ //절댓값이 같은 경우 음수 우선
                return o1 > o2 ? 1 : -1;
            }
            return first_abs - second_abs; // 절댓값 작은 데이터 우선
            //return에서 절댓값들이 크냐 작냐에 따라 스왑을 하는가 하지 않는가를 정하기 위한 로직이라고 보면 된다.
            //이에 대한 설명을 덧붙이자면,
            //정렬 기준을 바꾸기 위해서는 compareTo 메서드 오버라이딩이 있을 수 있지만,
            //지금 사용된 방법으로는, 이와 비슷한데 이것은 람다식으로 표현한 것이다.
            //일단 return하는 것이 음수(현재 객체가 다른 객체보다 작으면),
            // 양수(현재 객체가 다른 객체보다 크면),
            // 0(같다)
        });

        for(int i=0; i<N; i++){
            int request = Integer.parseInt(br.readLine());
            if(request == 0) {
                if(myQueue.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(myQueue.poll());
                }
            }else{
                myQueue.add(request);
            }
        }

    }
}

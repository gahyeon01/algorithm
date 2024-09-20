package algorithm.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2164 {
    public static void main(String[] args) {
        //큐 자료구조 이용하기
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();
        for(int i=1; i <= N; i++){
            myQueue.add(i);
        }

        while(myQueue.size() > 1){
            myQueue.poll(); //버리기
            int temp = myQueue.poll(); //뽑고
            myQueue.add(temp); //맨뒤에 넣어주기
        }
        System.out.println(myQueue.poll());
    }
}

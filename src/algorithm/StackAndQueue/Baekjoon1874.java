package algorithm.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

/*
* 1부터 N까지 오름차순으로 스택에 push를 진행하면서 필요할 때마다 pop을 하여
* 주어진 임의의 수열을 출력할 수 있는지에 대한 문제이다.
* */
public class Baekjoon1874 {
    /*
     * 1번째 줄에 수열의 개수 n이 주어진다. 2번째 줄에서 n개의 줄에는 수열을 이루는
     * 1이상 n 이하의 정수가 1개씩 순서대로 주어진다. 이때 같은 정수가 두번 이상 나오지는 않는다.
     *
     * 오름차순 수열을 만들기 위한 연산 순서를 출력한다. push 연산은 +, pop 연산은 -로 출력하고,
     * 불가능 할 때는 NO를 출력한다.
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for(int i=0; i<A.length; i++){
            int su = A[i];
            if( su >= num){
                while (su>=num){
                    stack.push(num++); //넣어주고 증가
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }else{
                int n = stack.pop();
                if(n > su){
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }
        if(result){
            System.out.println(bf.toString());
        }
    }

}
